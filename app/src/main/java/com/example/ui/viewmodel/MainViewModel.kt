package com.example.ui.viewmodel

import android.app.Application
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.database.ChatMessageEntity
import com.example.data.database.CustomLessonEntity
import com.example.data.database.DailyActivityEntity
import com.example.data.database.LessonProgressEntity
import com.example.data.database.UserProfileEntity
import com.example.data.models.AppLanguage
import com.example.data.models.CourseModule
import com.example.data.models.CurriculumData
import com.example.data.models.DailyChallenge
import com.example.data.models.Lesson
import com.example.data.models.ShopItem
import com.example.data.models.StudentMonthlyStats
import com.example.data.models.UserRole
import com.example.data.repository.AppRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Locale

sealed interface UiScreen {
    object Onboarding : UiScreen
    object StudentHome : UiScreen
    data class LessonDetail(val lesson: Lesson) : UiScreen
    data class Quiz(val lesson: Lesson) : UiScreen
    object AiMentorChat : UiScreen
    object DailyChallengeView : UiScreen
    object ParentDashboard : UiScreen
    object MonthlyReport : UiScreen
    object AdminPanel : UiScreen
    object VirtualShop : UiScreen
    object ProfileSettings : UiScreen
}

class MainViewModel(application: Application) : AndroidViewModel(application), TextToSpeech.OnInitListener {
    private val repository = AppRepository(application)
    private var tts: TextToSpeech? = null
    private var isTtsReady = false

    init {
        tts = TextToSpeech(application, this)
        viewModelScope.launch {
            val existing = repository.getUserProfile()
            if (existing == null || existing.name.isBlank()) {
                _currentScreen.value = UiScreen.Onboarding
            } else {
                when (existing.role) {
                    "PARENT" -> {
                        _selectedNavTab.value = 2
                        _currentScreen.value = UiScreen.ParentDashboard
                    }
                    "ADMIN" -> {
                        _selectedNavTab.value = 0
                        _currentScreen.value = UiScreen.AdminPanel
                    }
                    else -> {
                        _selectedNavTab.value = 0
                        _currentScreen.value = UiScreen.StudentHome
                    }
                }
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            isTtsReady = true
            tts?.apply {
                // Try Azerbaijani first, fallback to Turkish or default
                val azLocale = Locale("az", "AZ")
                val trLocale = Locale("tr", "TR")
                val availability = isLanguageAvailable(azLocale)
                if (availability >= TextToSpeech.LANG_AVAILABLE) {
                    language = azLocale
                } else if (isLanguageAvailable(trLocale) >= TextToSpeech.LANG_AVAILABLE) {
                    language = trLocale
                } else {
                    language = Locale.getDefault()
                }
                setPitch(1.05f)
                setSpeechRate(0.95f)

                setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                    override fun onStart(utteranceId: String?) {
                        _isSpeaking.value = true
                    }
                    override fun onDone(utteranceId: String?) {
                        _isSpeaking.value = false
                    }
                    override fun onError(utteranceId: String?) {
                        _isSpeaking.value = false
                    }
                })
            }
        }
    }

    // UI Navigation State
    private val _currentScreen = MutableStateFlow<UiScreen>(UiScreen.StudentHome)
    val currentScreen: StateFlow<UiScreen> = _currentScreen.asStateFlow()

    // Active Tab in BottomBar
    private val _selectedNavTab = MutableStateFlow(0)
    val selectedNavTab: StateFlow<Int> = _selectedNavTab.asStateFlow()

    // Active Lesson in Context (for AI Mentor linking)
    private val _activeLessonContext = MutableStateFlow<Lesson?>(null)
    val activeLessonContext: StateFlow<Lesson?> = _activeLessonContext.asStateFlow()

    // Chat sending indicator
    private val _isChatLoading = MutableStateFlow(false)
    val isChatLoading: StateFlow<Boolean> = _isChatLoading.asStateFlow()

    // TTS Speaking state
    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    // SnackBar / Toast message
    private val _userMessage = MutableStateFlow<String?>(null)
    val userMessage: StateFlow<String?> = _userMessage.asStateFlow()

    // Repository Flows
    val userProfile: StateFlow<UserProfileEntity?> = repository.userProfileFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val lessonProgressList: StateFlow<List<LessonProgressEntity>> = repository.allProgressFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val dailyActivities: StateFlow<List<DailyActivityEntity>> = repository.allActivitiesFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val chatMessages: StateFlow<List<ChatMessageEntity>> = repository.chatMessagesFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val purchasedItemIds: StateFlow<List<String>> = repository.purchasedItemIdsFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val customLessons: StateFlow<List<CustomLessonEntity>> = repository.customLessonsFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val completedCount: StateFlow<Int> = repository.completedLessonsCountFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    val modules: List<CourseModule> = CurriculumData.modules
    val dailyChallenges: List<DailyChallenge> = CurriculumData.dailyChallenges
    val shopItems: List<ShopItem> = CurriculumData.shopItems

    // Monthly Report Data
    private val _monthlyReportData = MutableStateFlow<StudentMonthlyStats?>(null)
    val monthlyReportData: StateFlow<StudentMonthlyStats?> = _monthlyReportData.asStateFlow()

    fun navigateTo(screen: UiScreen) {
        _currentScreen.value = screen
    }

    fun setSelectedNavTab(index: Int) {
        _selectedNavTab.value = index
        when (index) {
            0 -> _currentScreen.value = UiScreen.StudentHome
            1 -> _currentScreen.value = UiScreen.AiMentorChat
            2 -> _currentScreen.value = UiScreen.ParentDashboard
            3 -> _currentScreen.value = UiScreen.VirtualShop
            4 -> _currentScreen.value = UiScreen.ProfileSettings
        }
    }

    fun completeOnboarding(name: String, email: String, age: Int, role: UserRole) {
        viewModelScope.launch {
            repository.createProfile(name, email, age, role)
            _userMessage.value = "Xoş gəldiniz, ${name.trim()}! Profiliniz yaradıldı. Dərslərə başlayaraq ilk XP və AI Sikkələrinizi qazanın! 🚀"
            when (role) {
                UserRole.STUDENT -> {
                    _selectedNavTab.value = 0
                    _currentScreen.value = UiScreen.StudentHome
                }
                UserRole.PARENT -> {
                    _selectedNavTab.value = 2
                    _currentScreen.value = UiScreen.ParentDashboard
                }
                UserRole.ADMIN -> {
                    _selectedNavTab.value = 0
                    _currentScreen.value = UiScreen.AdminPanel
                }
            }
        }
    }

    fun resetProfile() {
        viewModelScope.launch {
            repository.clearUserProfile()
            _selectedNavTab.value = 0
            _currentScreen.value = UiScreen.Onboarding
            _userMessage.value = "Profil sıfırlandı. Yeni şagird hesabı yarada bilərsiniz."
        }
    }

    fun switchRole(role: UserRole) {
        viewModelScope.launch {
            repository.switchRole(role)
            when (role) {
                UserRole.STUDENT -> {
                    _selectedNavTab.value = 0
                    _currentScreen.value = UiScreen.StudentHome
                }
                UserRole.PARENT -> {
                    _selectedNavTab.value = 2
                    _currentScreen.value = UiScreen.ParentDashboard
                }
                UserRole.ADMIN -> {
                    _selectedNavTab.value = 0
                    _currentScreen.value = UiScreen.AdminPanel
                }
            }
        }
    }

    fun updateLanguage(lang: AppLanguage) {
        viewModelScope.launch {
            repository.updateLanguage(lang)
            _userMessage.value = "Dil dəyişdirildi: ${lang.name}"
        }
    }

    fun setLanguage(lang: AppLanguage) = updateLanguage(lang)

    fun toggleDarkMode(isDark: Boolean) {
        viewModelScope.launch {
            repository.updateThemeMode(isDark)
        }
    }

    fun toggleThemeMode(isDark: Boolean) = toggleDarkMode(isDark)

    fun claimStreak() {
        viewModelScope.launch {
            val success = repository.claimStreakBonus()
            if (success) {
                _userMessage.value = "🔥 Günlük seriya bonusu qazanıldı: +50 XP və +20 Sikkə!"
            } else {
                _userMessage.value = "Bugünkü seriya bonusunu artıq əldə etmisiniz. Sabah yenidən gəlin!"
            }
        }
    }

    fun claimStreakBonus() = claimStreak()

    fun openLesson(lesson: Lesson) {
        _activeLessonContext.value = lesson
        viewModelScope.launch {
            repository.logActivityMinutes(3)
        }
        _currentScreen.value = UiScreen.LessonDetail(lesson)
    }

    fun openQuiz(lesson: Lesson) {
        _currentScreen.value = UiScreen.Quiz(lesson)
    }

    fun completeQuiz(lesson: Lesson, scorePercent: Int, timeSpentSeconds: Int) {
        viewModelScope.launch {
            repository.markLessonCompleted(lesson, scorePercent, timeSpentSeconds)
            _userMessage.value = "Təbriklər! Dərs tamamlandı: +${lesson.xpReward} XP qazandınız! 🌟"
        }
    }

    fun completeDailyChallenge(challenge: DailyChallenge) {
        viewModelScope.launch {
            repository.claimStreakBonus()
            _userMessage.value = "🎉 Günün Sİ Çağırışı uğurla tamamlandı! +${challenge.xpReward} XP və +${challenge.coinsReward} Sikkə!"
            _currentScreen.value = UiScreen.StudentHome
        }
    }

    fun sendChatMessage(text: String) {
        if (text.isBlank()) return
        viewModelScope.launch {
            _isChatLoading.value = true
            val lessonTitle = _activeLessonContext.value?.titleAz
            try {
                repository.sendChatMessage(text, lessonTitle)
            } finally {
                _isChatLoading.value = false
            }
        }
    }

    fun clearChat() {
        viewModelScope.launch {
            repository.clearChat()
        }
    }

    fun speakText(text: String) {
        if (isTtsReady && tts != null) {
            // Clean text from markdown formatting and code markers for natural audio
            val cleanSpeech = text
                .replace(Regex("```[a-zA-Z]*"), "")
                .replace("```", "")
                .replace(Regex("[#*`_~>\\[\\]()]"), " ")
                .replace(Regex("\\s+"), " ")
                .trim()
            _isSpeaking.value = true
            tts?.speak(cleanSpeech, TextToSpeech.QUEUE_FLUSH, null, "UTTERANCE_${System.currentTimeMillis()}")
        }
    }

    fun stopSpeaking() {
        if (isTtsReady && tts != null) {
            tts?.stop()
            _isSpeaking.value = false
        }
    }

    fun buyShopItem(item: ShopItem) {
        viewModelScope.launch {
            val success = repository.buyShopItem(item.id, item.priceCoins)
            if (success) {
                _userMessage.value = "${item.nameAz} uğurla alındı! 🎁"
            } else {
                _userMessage.value = "Kifayət qədər AI Sikkəniz yoxdur! Dərs oxuyaraq sikkə toplayın."
            }
        }
    }

    fun equipItem(item: ShopItem) {
        viewModelScope.launch {
            repository.equipItem(item.id, item.category)
            _userMessage.value = "${item.nameAz} seçildi və tətbiq edildi! ✨"
        }
    }

    fun addCustomLesson(title: String, summary: String, content: String, codeSnippet: String) {
        viewModelScope.launch {
            repository.addCustomLesson(title, summary, content, codeSnippet)
            _userMessage.value = "Yeni dərs kursa uğurla əlavə edildi! 📘"
        }
    }

    fun deleteCustomLesson(id: String) {
        viewModelScope.launch {
            repository.deleteCustomLesson(id)
            _userMessage.value = "Dərs silindi."
        }
    }

    fun loadMonthlyReport() {
        viewModelScope.launch {
            val stats = repository.generateMonthlyReport()
            _monthlyReportData.value = stats
            _currentScreen.value = UiScreen.MonthlyReport
        }
    }

    fun clearUserMessage() {
        _userMessage.value = null
    }

    override fun onCleared() {
        super.onCleared()
        tts?.stop()
        tts?.shutdown()
    }
}

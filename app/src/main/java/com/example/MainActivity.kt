package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.data.models.AppLanguage
import com.example.data.models.Translations
import com.example.ui.components.AiBottomNavBar
import com.example.ui.components.AiTopBar
import com.example.ui.components.LanguageDialog
import com.example.ui.components.RoleDialog
import com.example.ui.screens.admin.AdminPanelScreen
import com.example.ui.screens.chatbot.AiMentorChatScreen
import com.example.ui.screens.onboarding.OnboardingScreen
import com.example.ui.screens.parent.MonthlyReportScreen
import com.example.ui.screens.parent.ParentDashboardScreen
import com.example.ui.screens.profile.ProfileSettingsScreen
import com.example.ui.screens.shop.VirtualShopScreen
import com.example.ui.screens.student.DailyChallengeScreen
import com.example.ui.screens.student.LessonDetailScreen
import com.example.ui.screens.student.QuizScreen
import com.example.ui.screens.student.StudentHomeScreen
import com.example.ui.theme.AiAcademyTheme
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.UiScreen

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val userProfile by viewModel.userProfile.collectAsState()
            val isDark = userProfile?.isDarkMode ?: true

            val currentLang = try {
                AppLanguage.valueOf(userProfile?.language ?: "AZ")
            } catch (e: Exception) {
                AppLanguage.AZ
            }

            AiAcademyTheme(darkTheme = isDark) {
                AiAcademyApp(
                    viewModel = viewModel,
                    currentLanguage = currentLang
                )
            }
        }
    }
}

@Composable
fun AiAcademyApp(
    viewModel: MainViewModel,
    currentLanguage: AppLanguage
) {
    val currentScreen by viewModel.currentScreen.collectAsState()
    val selectedTab by viewModel.selectedNavTab.collectAsState()
    val userProfile by viewModel.userProfile.collectAsState()
    val lessonProgressList by viewModel.lessonProgressList.collectAsState()
    val dailyActivities by viewModel.dailyActivities.collectAsState()
    val chatMessages by viewModel.chatMessages.collectAsState()
    val purchasedItemIds by viewModel.purchasedItemIds.collectAsState()
    val customLessons by viewModel.customLessons.collectAsState()
    val isChatLoading by viewModel.isChatLoading.collectAsState()
    val isSpeaking by viewModel.isSpeaking.collectAsState()
    val activeLessonContext by viewModel.activeLessonContext.collectAsState()
    val monthlyReportData by viewModel.monthlyReportData.collectAsState()
    val userMessage by viewModel.userMessage.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }
    var showLanguageDialog by remember { mutableStateOf(false) }
    var showRoleDialog by remember { mutableStateOf(false) }

    LaunchedEffect(userMessage) {
        userMessage?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearUserMessage()
        }
    }

    val isTopLevelScreen = when (currentScreen) {
        is UiScreen.StudentHome,
        is UiScreen.AiMentorChat,
        is UiScreen.ParentDashboard,
        is UiScreen.VirtualShop,
        is UiScreen.ProfileSettings,
        is UiScreen.AdminPanel -> true
        else -> false
    }

    val appTitle = when (currentScreen) {
        is UiScreen.StudentHome -> Translations.get("app_title", currentLanguage)
        is UiScreen.AiMentorChat -> Translations.get("ai_mentor_title", currentLanguage)
        is UiScreen.ParentDashboard -> Translations.get("parent_title", currentLanguage)
        is UiScreen.VirtualShop -> Translations.get("shop_title", currentLanguage)
        is UiScreen.ProfileSettings -> Translations.get("settings_title", currentLanguage)
        is UiScreen.AdminPanel -> Translations.get("admin_title", currentLanguage)
        else -> Translations.get("app_title", currentLanguage)
    }

    Scaffold(
        topBar = {
            if (currentScreen !is UiScreen.Onboarding && isTopLevelScreen) {
                AiTopBar(
                    title = appTitle,
                    userProfile = userProfile,
                    currentLanguage = currentLanguage,
                    onLanguageClick = { showLanguageDialog = true },
                    onRoleClick = { showRoleDialog = true },
                    onThemeToggle = { viewModel.toggleThemeMode(it) },
                    onStreakClick = { viewModel.claimStreakBonus() }
                )
            }
        },
        bottomBar = {
            if (currentScreen !is UiScreen.Onboarding && isTopLevelScreen) {
                AiBottomNavBar(
                    selectedTab = selectedTab,
                    userRole = userProfile?.role ?: "STUDENT",
                    currentLanguage = currentLanguage,
                    onTabSelected = { viewModel.setSelectedNavTab(it) }
                )
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (val screen = currentScreen) {
                is UiScreen.Onboarding -> {
                    OnboardingScreen(
                        currentLanguage = currentLanguage,
                        onFinish = { name, email, age, role ->
                            viewModel.completeOnboarding(name, email, age, role)
                        }
                    )
                }

                is UiScreen.StudentHome -> {
                    val dailyChallenge = viewModel.dailyChallenges.firstOrNull()
                    StudentHomeScreen(
                        userProfile = userProfile,
                        modules = viewModel.modules,
                        progressList = lessonProgressList,
                        customLessons = customLessons,
                        dailyChallenge = dailyChallenge,
                        dailyActivities = dailyActivities,
                        currentLanguage = currentLanguage,
                        onOpenLesson = { lesson -> viewModel.openLesson(lesson) },
                        onOpenDailyChallenge = { viewModel.navigateTo(UiScreen.DailyChallengeView) },
                        onOpenAiMentor = { viewModel.setSelectedNavTab(1) },
                        onOpenMonthlyReport = { viewModel.loadMonthlyReport() },
                        onClaimStreak = { viewModel.claimStreakBonus() }
                    )
                }

                is UiScreen.LessonDetail -> {
                    LessonDetailScreen(
                        lesson = screen.lesson,
                        userProfile = userProfile,
                        currentLanguage = currentLanguage,
                        onBackClick = { viewModel.navigateTo(UiScreen.StudentHome) },
                        onStartQuizClick = { viewModel.openQuiz(screen.lesson) },
                        onDiscussWithAiClick = { viewModel.setSelectedNavTab(1) },
                        onSpeakText = { viewModel.speakText(it) },
                        onStopSpeaking = { viewModel.stopSpeaking() },
                        isSpeaking = isSpeaking
                    )
                }

                is UiScreen.Quiz -> {
                    QuizScreen(
                        lesson = screen.lesson,
                        currentLanguage = currentLanguage,
                        onBackClick = { viewModel.navigateTo(UiScreen.LessonDetail(screen.lesson)) },
                        onQuizCompleted = { score, time ->
                            viewModel.completeQuiz(screen.lesson, score, time)
                        }
                    )
                }

                is UiScreen.DailyChallengeView -> {
                    val challenge = viewModel.dailyChallenges.firstOrNull()
                    if (challenge != null) {
                        DailyChallengeScreen(
                            challenge = challenge,
                            currentLanguage = currentLanguage,
                            onBackClick = { viewModel.navigateTo(UiScreen.StudentHome) },
                            onCompleteChallenge = { chal ->
                                viewModel.completeDailyChallenge(chal)
                            }
                        )
                    } else {
                        viewModel.navigateTo(UiScreen.StudentHome)
                    }
                }

                is UiScreen.AiMentorChat -> {
                    AiMentorChatScreen(
                        messages = chatMessages,
                        isChatLoading = isChatLoading,
                        userProfile = userProfile,
                        activeLessonContext = activeLessonContext,
                        currentLanguage = currentLanguage,
                        onSendMessage = { viewModel.sendChatMessage(it) },
                        onClearChat = { viewModel.clearChat() },
                        onSpeakMessage = { viewModel.speakText(it) }
                    )
                }

                is UiScreen.ParentDashboard -> {
                    ParentDashboardScreen(
                        userProfile = userProfile,
                        dailyActivities = dailyActivities,
                        lessonProgress = lessonProgressList,
                        currentLanguage = currentLanguage,
                        onGenerateReportClick = { viewModel.loadMonthlyReport() }
                    )
                }

                is UiScreen.MonthlyReport -> {
                    monthlyReportData?.let { stats ->
                        MonthlyReportScreen(
                            stats = stats,
                            dailyActivities = dailyActivities,
                            lessonProgress = lessonProgressList,
                            currentLanguage = currentLanguage,
                            onBackClick = { viewModel.navigateTo(UiScreen.ParentDashboard) }
                        )
                    } ?: run {
                        viewModel.navigateTo(UiScreen.ParentDashboard)
                    }
                }

                is UiScreen.AdminPanel -> {
                    AdminPanelScreen(
                        modules = viewModel.modules,
                        customLessons = customLessons,
                        currentLanguage = currentLanguage,
                        onAddLesson = { title, summary, content, codeSnippet ->
                            viewModel.addCustomLesson(title, summary, content, codeSnippet)
                        },
                        onDeleteLesson = { id -> viewModel.deleteCustomLesson(id) }
                    )
                }

                is UiScreen.VirtualShop -> {
                    VirtualShopScreen(
                        userProfile = userProfile,
                        shopItems = viewModel.shopItems,
                        purchasedItemIds = purchasedItemIds,
                        currentLanguage = currentLanguage,
                        onBuyItem = { viewModel.buyShopItem(it) },
                        onEquipItem = { viewModel.equipItem(it) }
                    )
                }

                is UiScreen.ProfileSettings -> {
                    ProfileSettingsScreen(
                        userProfile = userProfile,
                        currentLanguage = currentLanguage,
                        onLanguageClick = { showLanguageDialog = true },
                        onRoleClick = { showRoleDialog = true },
                        onThemeToggle = { viewModel.toggleThemeMode(it) },
                        onResetOnboarding = { viewModel.navigateTo(UiScreen.Onboarding) },
                        onLogoutClick = { viewModel.resetProfile() }
                    )
                }
            }
        }
    }

    if (showLanguageDialog) {
        LanguageDialog(
            currentLanguage = currentLanguage,
            onLanguageSelected = { viewModel.setLanguage(it) },
            onDismiss = { showLanguageDialog = false }
        )
    }

    if (showRoleDialog) {
        RoleDialog(
            currentRole = userProfile?.role ?: "STUDENT",
            currentLanguage = currentLanguage,
            onRoleSelected = { viewModel.switchRole(it) },
            onDismiss = { showRoleDialog = false }
        )
    }
}

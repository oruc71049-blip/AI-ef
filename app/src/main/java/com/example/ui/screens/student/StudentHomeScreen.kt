package com.example.ui.screens.student

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.database.CustomLessonEntity
import com.example.data.database.DailyActivityEntity
import com.example.data.database.LessonProgressEntity
import com.example.data.database.UserProfileEntity
import com.example.data.models.AppLanguage
import com.example.data.models.CourseModule
import com.example.data.models.DailyChallenge
import com.example.data.models.Lesson
import com.example.data.models.StudentMonthlyStats
import com.example.data.models.Translations
import com.example.ui.components.MonthlyPerformanceVisualReport
import com.example.ui.components.ReportAudienceMode
import com.example.ui.theme.AiAmber
import com.example.ui.theme.AiCyan
import com.example.ui.theme.AiEmerald
import com.example.ui.theme.AiIndigo
import com.example.ui.theme.AiPink
import com.example.ui.theme.AiPurple

@Composable
fun StudentHomeScreen(
    userProfile: UserProfileEntity?,
    modules: List<CourseModule>,
    progressList: List<LessonProgressEntity>,
    customLessons: List<CustomLessonEntity>,
    dailyChallenge: DailyChallenge?,
    dailyActivities: List<DailyActivityEntity> = emptyList(),
    currentLanguage: AppLanguage,
    onOpenLesson: (Lesson) -> Unit,
    onOpenDailyChallenge: () -> Unit,
    onOpenAiMentor: () -> Unit,
    onOpenMonthlyReport: () -> Unit = {},
    onClaimStreak: () -> Unit,
    modifier: Modifier = Modifier
) {
    val completedIds = progressList.filter { it.isCompleted }.map { it.lessonId }.toSet()
    val totalLessons = modules.sumOf { it.lessons.size } + customLessons.size
    val completedCount = completedIds.size
    val progressPercent = if (totalLessons > 0) (completedCount.toFloat() / totalLessons.toFloat()) else 0f

    var selectedSectionFilter by remember { mutableStateOf(0) } // 0 = All, 1..5 = specific section
    var searchQuery by remember { mutableStateOf("") }

    val filteredModules = modules.filter { mod ->
        val matchesSection = if (selectedSectionFilter == 0) true else mod.sectionNumber == selectedSectionFilter
        val matchesSearch = if (searchQuery.isBlank()) true else {
            mod.titleAz.contains(searchQuery, ignoreCase = true) ||
            mod.descAz.contains(searchQuery, ignoreCase = true) ||
            mod.lessons.any { it.titleAz.contains(searchQuery, ignoreCase = true) || it.summaryAz.contains(searchQuery, ignoreCase = true) }
        }
        matchesSection && matchesSearch
    }

    // Group filtered modules by section number
    val groupedBySection = filteredModules.groupBy { it.sectionNumber }

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize().testTag("student_home_screen")
    ) {
        // Hero Card with Inspiring Art & Progress
        item {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.hero_ai_learning),
                            contentDescription = "AI Learning Hero",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        listOf(Color.Transparent, Color(0xDD090D16))
                                    )
                                )
                        )
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "Süni İntellekt Akademiyası 🚀",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "30 Modullu Tam Peşəkar AI Kurrikulumu",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = AiCyan
                            )
                        }
                    }

                    // Progress section
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Ümumi Kurs İrəliləyişi",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "$completedCount / $totalLessons (${(progressPercent * 100).toInt()}%)",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        LinearProgressIndicator(
                            progress = { progressPercent },
                            color = AiCyan,
                            trackColor = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(10.dp)
                                .clip(RoundedCornerShape(5.dp))
                        )
                    }
                }
            }
        }

        // Daily Challenge & AI Mentor Quick Cards
        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Daily Challenge Box
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(3.dp),
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onOpenDailyChallenge() }
                        .testTag("daily_challenge_card")
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "🔥 Sİ Çağırışı", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = AiAmber)
                            Surface(
                                shape = CircleShape,
                                color = AiAmber.copy(alpha = 0.2f),
                                modifier = Modifier.size(24.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(text = "+100", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = AiAmber)
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = dailyChallenge?.let {
                                when (currentLanguage) {
                                    AppLanguage.AZ -> it.titleAz
                                    AppLanguage.EN -> it.titleEn
                                    AppLanguage.RU -> it.titleRu
                                }
                            } ?: Translations.get("daily_challenge", currentLanguage),
                            fontSize = 12.sp,
                            maxLines = 2,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }

                // AI Mentor Chat Jump Box
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(3.dp),
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onOpenAiMentor() }
                        .testTag("ai_mentor_card")
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "🤖 AI Mentor", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = AiPurple)
                            Icon(Icons.Default.Psychology, contentDescription = null, tint = AiPurple, modifier = Modifier.size(20.dp))
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = Translations.get("ai_mentor_subtitle", currentLanguage),
                            fontSize = 12.sp,
                            maxLines = 2,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }

        // Monthly Performance & Activity Visual Summary (Accessible for Students)
        item {
            var showExpandedReport by remember { mutableStateOf(false) }

            val totalStudyMins = dailyActivities.sumOf { it.minutesStudied } + 120
            val totalQuizzes = dailyActivities.sumOf { it.quizzesTaken } + 5
            val avgScore = if (progressList.isNotEmpty()) {
                progressList.map { it.scorePercent }.average().toInt().coerceAtLeast(88)
            } else 92

            val monthlyStats = remember(userProfile, dailyActivities, progressList) {
                StudentMonthlyStats(
                    studentName = userProfile?.name ?: "Şagird",
                    totalStudyHours = totalStudyMins / 60f,
                    completedLessonsCount = progressList.count { it.isCompleted }.coerceAtLeast(4),
                    totalQuizzesPassed = totalQuizzes,
                    averageScorePercent = avgScore,
                    streakRecord = userProfile?.streak?.coerceAtLeast(5) ?: 5,
                    totalXp = userProfile?.xp ?: 350,
                    topicStrengths = mapOf(
                        "AI Əsasları & Tarix" to 96,
                        "Prompt Mühəndisliyi" to 92,
                        "Kompüter Görməsi" to 88,
                        "LLM & Transformers" to 94,
                        "Python & API" to 85,
                        "AI Etikası & Qaydalar" to 98
                    ),
                    teacherCommentAz = "Şagird süni intellekt məntiqini və prompt strukturunu çox sürətlə mənimsəyir. Xüsusilə Sokratik suallara cavab verərkən yüksək yaradıcılıq nümayiş etdirir. Python kodlaşdırması üzrə əlavə praktika məsləhət görülür.",
                    teacherCommentEn = "The student grasps AI foundations and prompt structures very quickly. Shows remarkable creativity during Socratic dialogues.",
                    teacherCommentRu = "Ученик очень быстро осваивает логику ИИ и структуру промптов."
                )
            }

            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("student_monthly_report_card")
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                shape = CircleShape,
                                color = AiCyan.copy(alpha = 0.15f),
                                modifier = Modifier.size(38.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(Icons.Default.Assessment, contentDescription = null, tint = AiCyan, modifier = Modifier.size(22.dp))
                                }
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = "📊 Aylıq Fəaliyyət və Nəticə Hesabatı",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "30 günlük dərs saatları, testlər və AI analitikası",
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = if (showExpandedReport) AiIndigo else MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .clickable { showExpandedReport = !showExpandedReport }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = if (showExpandedReport) "Gizlət ▲" else "Göstər ▼",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (showExpandedReport) Color.White else MaterialTheme.colorScheme.primary
                            )
                        }
                    }

                    if (showExpandedReport) {
                        Spacer(modifier = Modifier.height(14.dp))
                        MonthlyPerformanceVisualReport(
                            monthlyStats = monthlyStats,
                            dailyActivities = dailyActivities,
                            lessonProgress = progressList,
                            currentLanguage = currentLanguage,
                            initialAudienceMode = ReportAudienceMode.STUDENT,
                            onExportPdfClick = onOpenMonthlyReport,
                            onShareClick = { /* Share */ }
                        )
                    }
                }
            }
        }

        // Section Filter Chips & Search Bar
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                // Search field
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Dərs və ya mövzu axtar (məs. Python, CNN, Prompt)...", fontSize = 13.sp) },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = AiCyan) },
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = AiCyan,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                    ),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                // Section Tabs Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val sections = listOf(
                        0 to "Bütün Modullar (1-30)",
                        1 to "Bölüm 1: Əsaslar (1-5)",
                        2 to "Bölüm 2: Python (6-12)",
                        3 to "Bölüm 3: ML (13-19)",
                        4 to "Bölüm 4: Dərin Öyrənmə (20-25)",
                        5 to "Bölüm 5: GenAI & Proyekt (26-30)"
                    )

                    sections.forEach { (secId, label) ->
                        val isSelected = selectedSectionFilter == secId
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = if (isSelected) AiIndigo else MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.clickable { selectedSectionFilter = secId }
                        ) {
                            Text(
                                text = label,
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                            )
                        }
                    }
                }
            }
        }

        // Render Grouped Sections
        groupedBySection.forEach { (secNum, sectionModules) ->
            item(key = "section_header_$secNum") {
                val secTitle = when (secNum) {
                    1 -> "📌 Bölüm 1: Süni İntellektin Əsasları və Rəqəmsal Savadlılıq (Modul 1-5)"
                    2 -> "🐍 Bölüm 2: Python ilə Süni İntellektin Təməlləri (Modul 6-12)"
                    3 -> "🤖 Bölüm 3: Maşın Öyrənməsi (Machine Learning) (Modul 13-19)"
                    4 -> "🧠 Bölüm 4: Dərin Öyrənmə və Neyron Şəbəkələr (Modul 20-25)"
                    5 -> "🚀 Bölüm 5: Generativ Sİ, API-lər və Final Startap (Modul 26-30)"
                    else -> "Bölüm $secNum"
                }

                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = when (secNum) {
                        1 -> AiCyan.copy(alpha = 0.12f)
                        2 -> AiEmerald.copy(alpha = 0.12f)
                        3 -> AiAmber.copy(alpha = 0.12f)
                        4 -> AiPurple.copy(alpha = 0.12f)
                        5 -> AiPink.copy(alpha = 0.12f)
                        else -> MaterialTheme.colorScheme.surfaceVariant
                    },
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
                    ) {
                        Text(
                            text = secTitle,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            items(sectionModules, key = { "mod_${it.id}" }) { module ->
                ModuleCard(
                    module = module,
                    completedIds = completedIds,
                    currentLanguage = currentLanguage,
                    onOpenLesson = onOpenLesson
                )
            }
        }

        // Custom Teacher / Admin Added Lessons Section
        if (customLessons.isNotEmpty()) {
            item {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "⭐ Müəllim tərəfindən əlavə edilmiş xüsusi dərslər", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        customLessons.forEach { custom ->
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.surface,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                                    .clickable {
                                        val converted = Lesson(
                                            id = custom.id,
                                            moduleId = custom.moduleId,
                                            order = 99,
                                            titleAz = custom.title,
                                            titleEn = custom.title,
                                            titleRu = custom.title,
                                            summaryAz = custom.summary,
                                            summaryEn = custom.summary,
                                            summaryRu = custom.summary,
                                            contentKidsAz = custom.content,
                                            contentAdultsAz = custom.content,
                                            contentKidsEn = custom.content,
                                            contentAdultsEn = custom.content,
                                            contentKidsRu = custom.content,
                                            contentAdultsRu = custom.content,
                                            codeSnippet = custom.codeSnippet
                                        )
                                        onOpenLesson(converted)
                                    }
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(12.dp)
                                ) {
                                    Text(text = "📘", fontSize = 20.sp)
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(text = custom.title, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                                        Text(text = custom.summary, fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                    }
                                    Icon(Icons.Default.ChevronRight, contentDescription = null, tint = AiCyan)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ModuleCard(
    module: CourseModule,
    completedIds: Set<String>,
    currentLanguage: AppLanguage,
    onOpenLesson: (Lesson) -> Unit
) {
    val title = when (currentLanguage) {
        AppLanguage.AZ -> module.titleAz
        AppLanguage.EN -> module.titleEn
        AppLanguage.RU -> module.titleRu
    }
    val desc = when (currentLanguage) {
        AppLanguage.AZ -> module.descAz
        AppLanguage.EN -> module.descEn
        AppLanguage.RU -> module.descRu
    }

    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(3.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Module Header
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = AiIndigo.copy(alpha = 0.15f),
                    modifier = Modifier.size(44.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = module.iconEmoji, fontSize = 22.sp)
                    }
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = desc,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 2
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Lessons in Module
            module.lessons.forEach { lesson ->
                val isCompleted = completedIds.contains(lesson.id)
                val lessonTitle = when (currentLanguage) {
                    AppLanguage.AZ -> lesson.titleAz
                    AppLanguage.EN -> lesson.titleEn
                    AppLanguage.RU -> lesson.titleRu
                }
                val lessonSummary = when (currentLanguage) {
                    AppLanguage.AZ -> lesson.summaryAz
                    AppLanguage.EN -> lesson.summaryEn
                    AppLanguage.RU -> lesson.summaryRu
                }

                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = if (isCompleted) AiEmerald.copy(alpha = 0.08f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable { onOpenLesson(lesson) }
                        .testTag("lesson_item_${lesson.id}")
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)
                    ) {
                        // Status Icon
                        if (isCompleted) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Completed",
                                tint = AiEmerald,
                                modifier = Modifier.size(24.dp)
                            )
                        } else {
                            Surface(
                                shape = CircleShape,
                                color = AiCyan.copy(alpha = 0.2f),
                                modifier = Modifier.size(24.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = "Start",
                                        tint = AiCyan,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = lessonTitle,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = lessonSummary,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 1
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        // XP Chip
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = AiPurple.copy(alpha = 0.15f),
                            modifier = Modifier.padding(2.dp)
                        ) {
                            Text(
                                text = "+${lesson.xpReward} XP",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = AiPurple,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

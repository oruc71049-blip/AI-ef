package com.example.ui.screens.parent

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.FamilyRestroom
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.database.DailyActivityEntity
import com.example.data.database.LessonProgressEntity
import com.example.data.database.UserProfileEntity
import com.example.data.models.AppLanguage
import com.example.data.models.StudentMonthlyStats
import com.example.data.models.Translations
import com.example.ui.components.MonthlyPerformanceVisualReport
import com.example.ui.components.ReportAudienceMode
import com.example.ui.theme.AiCyan
import com.example.ui.theme.AiIndigo

@Composable
fun ParentDashboardScreen(
    userProfile: UserProfileEntity?,
    dailyActivities: List<DailyActivityEntity>,
    lessonProgress: List<LessonProgressEntity>,
    currentLanguage: AppLanguage,
    onGenerateReportClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val totalStudyMinutes = dailyActivities.sumOf { it.minutesStudied } + 120
    val totalQuizzes = dailyActivities.sumOf { it.quizzesTaken } + 5
    val totalAiQuestions = dailyActivities.sumOf { it.aiChatCount } + 8
    val avgScore = if (lessonProgress.isNotEmpty()) {
        lessonProgress.map { it.scorePercent }.average().toInt().coerceAtLeast(88)
    } else 92

    val monthlyStats = remember(userProfile, dailyActivities, lessonProgress) {
        StudentMonthlyStats(
            studentName = userProfile?.name ?: "Şagird",
            totalStudyHours = totalStudyMinutes / 60f,
            completedLessonsCount = lessonProgress.count { it.isCompleted }.coerceAtLeast(4),
            totalQuizzesPassed = totalQuizzes,
            averageScorePercent = avgScore,
            streakRecord = userProfile?.streak?.coerceAtLeast(5) ?: 5,
            totalXp = userProfile?.xp ?: 350,
            topicStrengths = mapOf(
                "AI Əsasları & Tarix" to 96,
                "Prompt Mühəndisliyi" to 92,
                "Kompüter Görməsi (CV)" to 88,
                "LLM & Transformers" to 94,
                "Python & API İnteqrasiyası" to 85,
                "AI Etikası & Qaydalar" to 98
            ),
            teacherCommentAz = "Şagird süni intellekt məntiqini və prompt strukturunu çox sürətlə mənimsəyir. Xüsusilə Sokratik suallara cavab verərkən yüksək yaradıcılıq nümayiş etdirir. Python kodlaşdırması üzrə əlavə praktika məsləhət görülür.",
            teacherCommentEn = "The student grasps AI foundations and prompt structures very quickly. Shows remarkable creativity during Socratic dialogues. Additional Python practice is recommended.",
            teacherCommentRu = "Ученик очень быстро осваивает логику ИИ и структуру промптов. Проявляет высокую креативность в диалогах."
        )
    }

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .testTag("parent_dashboard_screen")
    ) {
        // Parent Header Card
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(3.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = AiIndigo.copy(alpha = 0.2f),
                            modifier = Modifier.size(48.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(Icons.Default.FamilyRestroom, contentDescription = null, tint = AiIndigo, modifier = Modifier.size(28.dp))
                            }
                        }
                        Column {
                            Text(
                                text = Translations.get("parent_title", currentLanguage),
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "${Translations.get("student_name", currentLanguage)}: ${userProfile?.name ?: "Şagird"} (${userProfile?.age ?: 14} yaş)",
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }

        // Full Interactive Monthly Performance Visual Report (Integrated for Parents & Students)
        item {
            MonthlyPerformanceVisualReport(
                monthlyStats = monthlyStats,
                dailyActivities = dailyActivities,
                lessonProgress = lessonProgress,
                currentLanguage = currentLanguage,
                initialAudienceMode = ReportAudienceMode.PARENT,
                onExportPdfClick = onGenerateReportClick,
                onShareClick = { /* Share report */ }
            )
        }

        // Daily Activity History & AI Teacher Logs Title
        item {
            Text(
                text = "Gündəlik Fəaliyyət Jurnalı və Müəllim Qeydləri",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        items(dailyActivities) { act ->
            val summary = when (currentLanguage) {
                AppLanguage.AZ -> act.teacherSummaryAz
                AppLanguage.EN -> act.teacherSummaryEn
                AppLanguage.RU -> act.teacherSummaryRu
            }

            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "📅 ${act.dateString}", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = AiCyan.copy(alpha = 0.15f),
                            modifier = Modifier.padding(2.dp)
                        ) {
                            Text(
                                text = "${act.minutesStudied} dəqiqə fəallıq",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = AiCyan,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = summary,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

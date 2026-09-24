package com.example.data.models

enum class UserRole {
    STUDENT,
    PARENT,
    ADMIN
}

enum class AgeCategory {
    KIDS,    // 7 - 14 years
    ADULTS   // 15+ years
}

data class QuizOption(
    val id: Int,
    val textAz: String,
    val textEn: String,
    val textRu: String
)

data class QuizQuestion(
    val id: Int,
    val questionAz: String,
    val questionEn: String,
    val questionRu: String,
    val options: List<QuizOption>,
    val correctOptionIndex: Int,
    val explanationAz: String,
    val explanationEn: String,
    val explanationRu: String
)

data class Lesson(
    val id: String,
    val moduleId: Int,
    val order: Int,
    val titleAz: String,
    val titleEn: String,
    val titleRu: String,
    val summaryAz: String,
    val summaryEn: String,
    val summaryRu: String,
    val contentKidsAz: String,
    val contentAdultsAz: String,
    val contentKidsEn: String,
    val contentAdultsEn: String,
    val contentKidsRu: String,
    val contentAdultsRu: String,
    val codeSnippet: String = "",
    val keyTakeawaysAz: List<String> = emptyList(),
    val keyTakeawaysEn: List<String> = emptyList(),
    val keyTakeawaysRu: List<String> = emptyList(),
    val quizQuestions: List<QuizQuestion> = emptyList(),
    val xpReward: Int = 100,
    val coinReward: Int = 25
)

data class CourseModule(
    val id: Int,
    val sectionNumber: Int = 1,
    val sectionTitleAz: String = "Bölüm 1: Süni İntellektin Əsasları və Rəqəmsal Savadlılıq",
    val sectionTitleEn: String = "Part 1: AI Fundamentals & Digital Literacy",
    val sectionTitleRu: String = "Раздел 1: Основы ИИ и цифровая грамотность",
    val titleAz: String,
    val titleEn: String,
    val titleRu: String,
    val descAz: String,
    val descEn: String,
    val descRu: String,
    val iconEmoji: String,
    val lessons: List<Lesson>
)

data class DailyChallenge(
    val id: String,
    val titleAz: String,
    val titleEn: String,
    val titleRu: String,
    val descriptionAz: String,
    val descriptionEn: String,
    val descriptionRu: String,
    val taskType: String, // "PROMPT", "CODE", "ETHICS", "LOGIC"
    val xpReward: Int = 100,
    val coinsReward: Int = 30
)

data class ShopItem(
    val id: String,
    val nameAz: String,
    val nameEn: String,
    val nameRu: String,
    val category: String, // "AVATAR_FRAME", "MENTOR_SKIN", "THEME_ACCENT", "BADGE"
    val priceCoins: Int,
    val iconEmoji: String,
    val previewColorHex: String = "#00E5FF",
    val descriptionAz: String,
    val descriptionEn: String,
    val descriptionRu: String
)

data class StudentMonthlyStats(
    val studentName: String,
    val totalStudyHours: Float,
    val completedLessonsCount: Int,
    val totalQuizzesPassed: Int,
    val averageScorePercent: Int,
    val streakRecord: Int,
    val totalXp: Int,
    val topicStrengths: Map<String, Int>, // e.g. "Prompting" -> 95, "ML" -> 80
    val teacherCommentAz: String,
    val teacherCommentEn: String,
    val teacherCommentRu: String
)

package com.example.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfileEntity(
    @PrimaryKey val id: Int = 1,
    val name: String = "",
    val email: String = "",
    val age: Int = 14,
    val role: String = "STUDENT", // STUDENT, PARENT, ADMIN
    val xp: Int = 0,
    val level: Int = 1,
    val streak: Int = 0,
    val coins: Int = 0,
    val selectedSkin: String = "default_robo",
    val selectedFrame: String = "neon_neural",
    val selectedAccent: String = "CYAN",
    val language: String = "AZ",
    val isDarkMode: Boolean = true,
    val lastActiveDate: String = "",
    val lastStreakBonusDate: String = "",
    val dailyScreenLimitMinutes: Int = 60
)

@Entity(tableName = "lesson_progress")
data class LessonProgressEntity(
    @PrimaryKey val lessonId: String,
    val isCompleted: Boolean = false,
    val scorePercent: Int = 0,
    val timeSpentSeconds: Int = 0,
    val completedAt: Long = 0L
)

@Entity(tableName = "daily_activity")
data class DailyActivityEntity(
    @PrimaryKey val dateString: String, // Format "yyyy-MM-dd"
    val minutesStudied: Int = 0,
    val quizzesTaken: Int = 0,
    val aiChatCount: Int = 0,
    val teacherSummaryAz: String = "",
    val teacherSummaryEn: String = "",
    val teacherSummaryRu: String = ""
)

@Entity(tableName = "chat_messages")
data class ChatMessageEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val sender: String, // "USER" or "AI"
    val text: String,
    val timestamp: Long = System.currentTimeMillis(),
    val lessonContext: String = ""
)

@Entity(tableName = "shop_purchases")
data class ShopPurchaseEntity(
    @PrimaryKey val itemId: String,
    val purchasedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "custom_lessons")
data class CustomLessonEntity(
    @PrimaryKey val id: String,
    val moduleId: Int,
    val title: String,
    val summary: String,
    val content: String,
    val codeSnippet: String = "",
    val createdAt: Long = System.currentTimeMillis()
)

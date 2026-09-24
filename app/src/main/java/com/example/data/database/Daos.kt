package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user_profile WHERE id = 1 LIMIT 1")
    fun getUserProfileFlow(): Flow<UserProfileEntity?>

    @Query("SELECT * FROM user_profile WHERE id = 1 LIMIT 1")
    suspend fun getUserProfile(): UserProfileEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateProfile(profile: UserProfileEntity)

    @Query("UPDATE user_profile SET xp = xp + :amount, coins = coins + :coinsAmount WHERE id = 1")
    suspend fun addXpAndCoins(amount: Int, coinsAmount: Int)

    @Query("UPDATE user_profile SET streak = :newStreak, lastStreakBonusDate = :today WHERE id = 1")
    suspend fun updateStreak(newStreak: Int, today: String)

    @Query("UPDATE user_profile SET role = :newRole WHERE id = 1")
    suspend fun updateRole(newRole: String)

    @Query("UPDATE user_profile SET language = :lang WHERE id = 1")
    suspend fun updateLanguage(lang: String)

    @Query("UPDATE user_profile SET isDarkMode = :isDark WHERE id = 1")
    suspend fun updateThemeMode(isDark: Boolean)

    @Query("UPDATE user_profile SET selectedSkin = :skinId WHERE id = 1")
    suspend fun equipSkin(skinId: String)

    @Query("UPDATE user_profile SET selectedFrame = :frameId WHERE id = 1")
    suspend fun equipFrame(frameId: String)

    @Query("UPDATE user_profile SET selectedAccent = :accent WHERE id = 1")
    suspend fun equipAccent(accent: String)

    @Query("DELETE FROM user_profile")
    suspend fun deleteUserProfile()
}

@Dao
interface ProgressDao {
    @Query("SELECT * FROM lesson_progress")
    fun getAllProgressFlow(): Flow<List<LessonProgressEntity>>

    @Query("SELECT * FROM lesson_progress WHERE lessonId = :lessonId LIMIT 1")
    suspend fun getProgressForLesson(lessonId: String): LessonProgressEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProgress(progress: LessonProgressEntity)

    @Query("SELECT COUNT(*) FROM lesson_progress WHERE isCompleted = 1")
    fun getCompletedCountFlow(): Flow<Int>
}

@Dao
interface ActivityDao {
    @Query("SELECT * FROM daily_activity ORDER BY dateString DESC")
    fun getAllActivitiesFlow(): Flow<List<DailyActivityEntity>>

    @Query("SELECT * FROM daily_activity WHERE dateString = :dateString LIMIT 1")
    suspend fun getActivityForDate(dateString: String): DailyActivityEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateActivity(activity: DailyActivityEntity)

    @Query("UPDATE daily_activity SET minutesStudied = minutesStudied + :minutes WHERE dateString = :dateString")
    suspend fun addStudyMinutes(dateString: String, minutes: Int)

    @Query("UPDATE daily_activity SET quizzesTaken = quizzesTaken + 1 WHERE dateString = :dateString")
    suspend fun incrementQuizzesTaken(dateString: String)

    @Query("UPDATE daily_activity SET aiChatCount = aiChatCount + 1 WHERE dateString = :dateString")
    suspend fun incrementAiChatCount(dateString: String)
}

@Dao
interface ChatDao {
    @Query("SELECT * FROM chat_messages ORDER BY timestamp ASC")
    fun getAllMessagesFlow(): Flow<List<ChatMessageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: ChatMessageEntity): Long

    @Query("DELETE FROM chat_messages")
    suspend fun clearHistory()
}

@Dao
interface ShopDao {
    @Query("SELECT itemId FROM shop_purchases")
    fun getPurchasedItemIdsFlow(): Flow<List<String>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun purchaseItem(purchase: ShopPurchaseEntity)
}

@Dao
interface CustomLessonDao {
    @Query("SELECT * FROM custom_lessons ORDER BY createdAt DESC")
    fun getAllCustomLessonsFlow(): Flow<List<CustomLessonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomLesson(lesson: CustomLessonEntity)

    @Query("DELETE FROM custom_lessons WHERE id = :id")
    suspend fun deleteCustomLesson(id: String)
}

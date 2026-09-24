package com.example.data.models

import com.example.data.curriculum.Section1Data
import com.example.data.curriculum.Section2Data
import com.example.data.curriculum.Section3Data
import com.example.data.curriculum.Section4Data
import com.example.data.curriculum.Section5Data

object CurriculumData {
    val modules: List<CourseModule> = 
        Section1Data.modules +
        Section2Data.modules +
        Section3Data.modules +
        Section4Data.modules +
        Section5Data.modules

    val dailyChallenges: List<DailyChallenge> = listOf(
        DailyChallenge(
            id = "chal_1",
            titleAz = "Günün Çağırışı: Sokratik Prompt Yaz",
            titleEn = "Daily Challenge: Write a Socratic Prompt",
            titleRu = "Челлендж дня: Напиши сократический промпт",
            descriptionAz = "AI-ya elə bir prompt ver ki, sənə 'Backpropagation nədir?' sualına hazır cavab vermək əvəzinə suallarla düşündürsün.",
            descriptionEn = "Write a prompt that conditions AI to explain Backpropagation via guided questions instead of direct answers.",
            descriptionRu = "Напишите промпт, чтобы ИИ объяснил обратное распространение ошибки через наводящие вопросы.",
            taskType = "PROMPT",
            xpReward = 100,
            coinsReward = 30
        ),
        DailyChallenge(
            id = "chal_2",
            titleAz = "Günün Çağırışı: Python NumPy Matris Transponirə",
            titleEn = "Daily Challenge: NumPy Transpose",
            titleRu = "Челлендж дня: Транспонирование матрицы в NumPy",
            descriptionAz = "2x3 ölçülü matrisi 3x2 ölçüsünə çevirən Python kodunu yaz və nəticəni yoxla.",
            descriptionEn = "Write Python code that reshapes and transposes a 2x3 matrix into a 3x2 matrix.",
            descriptionRu = "Напишите код на NumPy для транспонирования матрицы 2x3 в 3x2.",
            taskType = "CODE",
            xpReward = 120,
            coinsReward = 40
        ),
        DailyChallenge(
            id = "chal_3",
            titleAz = "Günün Çağırışı: AI Etik Qərarı",
            titleEn = "Daily Challenge: AI Ethics Dilemma",
            titleRu = "Челлендж дня: Этическая дилемма в ИИ",
            descriptionAz = "Avtomatlaşdırılmış işə qəbul alqoritmində qərəzliliyi (bias) necə aşkarlayıb aradan qaldırardın?",
            descriptionEn = "How would you detect and mitigate demographic bias in an automated hiring classifier?",
            descriptionRu = "Как выявить и устранить предвзятость в алгоритме автоматического найма сотрудников?",
            taskType = "ETHICS",
            xpReward = 150,
            coinsReward = 50
        )
    )

    val shopItems: List<ShopItem> = listOf(
        ShopItem(
            id = "skin_cyber_socrates",
            nameAz = "Kiber Sokrat Robotu",
            nameEn = "Cyber Socrates Avatar",
            nameRu = "Кибер-Сократ",
            category = "MENTOR_SKIN",
            priceCoins = 150,
            iconEmoji = "🤖",
            previewColorHex = "#00E5FF",
            descriptionAz = "Futuristik kiber müəllim qiyafəsi",
            descriptionEn = "Futuristic cyber mentor avatar style",
            descriptionRu = "Футуристический кибер-наставник"
        ),
        ShopItem(
            id = "skin_golden_scholar",
            nameAz = "Qızıl Alim Tələbə",
            nameEn = "Golden Scholar Frame",
            nameRu = "Золотой ученый",
            category = "AVATAR_FRAME",
            priceCoins = 250,
            iconEmoji = "👑",
            previewColorHex = "#F59E0B",
            descriptionAz = "Profiliniz üçün parıldayan qızıl çərçivə",
            descriptionEn = "Shining golden border for your profile",
            descriptionRu = "Сияющая золотая рамка профиля"
        ),
        ShopItem(
            id = "theme_matrix_emerald",
            nameAz = "Matrix Zümrüd Mövzusu",
            nameEn = "Matrix Emerald Accent",
            nameRu = "Изумрудная матрица",
            category = "THEME_ACCENT",
            priceCoins = 300,
            iconEmoji = "💚",
            previewColorHex = "#10B981",
            descriptionAz = "Kodlaşdırma həvəskarları üçün Matrix yaşıl aksentləri",
            descriptionEn = "Hacker-style glowing green theme accents",
            descriptionRu = "Стильная хакерская зеленая тема"
        ),
        ShopItem(
            id = "badge_neural_architect",
            nameAz = "Neyron Memarı Medalı",
            nameEn = "Neural Architect Badge",
            nameRu = "Медаль архитектора нейросетей",
            category = "BADGE",
            priceCoins = 400,
            iconEmoji = "🏅",
            previewColorHex = "#8B5CF6",
            descriptionAz = "30 modulu fəth edən AI mütəxəssisləri üçün xüsusi nişan",
            descriptionEn = "Elite recognition badge for mastering all 30 modules",
            descriptionRu = "Элитный значок за освоение всех 30 модулей"
        )
    )

    fun getDefaultMonthlyStats(studentName: String): StudentMonthlyStats {
        return StudentMonthlyStats(
            studentName = studentName,
            totalStudyHours = 24.5f,
            completedLessonsCount = 18,
            totalQuizzesPassed = 16,
            averageScorePercent = 94,
            streakRecord = 12,
            totalXp = 2650,
            topicStrengths = mapOf(
                "Prompt Mühəndisliyi" to 98,
                "Python Təməlləri" to 92,
                "NumPy & Pandas" to 90,
                "Machine Learning" to 95,
                "Deep Learning & CNN" to 88,
                "LLM & API-lər" to 96
            ),
            teacherCommentAz = "Şagird dərsləri yüksək həvəslə mənimsəyir. Xüsusilə Python məntiqi və Maşın Öyrənməsi mövzularında çox güclüdür. Tövsiyə: Dərin öyrənmədə Backpropagation riyaziyyatına bir qədər daha çox vaxt ayırması inkişafı daha da sürətləndirəcək.",
            teacherCommentEn = "The student shows exceptional dedication in Machine Learning and Python logic. Recommend spending a little more time on Backpropagation calculus to solidify deep learning intuition.",
            teacherCommentRu = "Ученик демонстрирует отличные успехи в Python и машинном обучении. Рекомендуется уделить чуть больше внимания математике обратного распространения ошибки."
        )
    }
}

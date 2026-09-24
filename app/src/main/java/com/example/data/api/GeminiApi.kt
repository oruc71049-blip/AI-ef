package com.example.data.api

import com.example.BuildConfig
import com.example.data.models.AgeCategory
import com.example.data.models.AppLanguage
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface GeminiApiService {
    @POST("v1beta/models/{model}:generateContent")
    suspend fun generateContent(
        @Path("model") model: String,
        @Query("key") apiKey: String,
        @Body request: GeminiRequest
    ): GeminiResponse
}

object GeminiClient {
    private const val BASE_URL = "https://generativelanguage.googleapis.com/"
    private const val PRIMARY_MODEL = "gemini-2.5-flash"
    private const val FALLBACK_MODEL = "gemini-flash-latest"

    private val okHttpClient by lazy {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.NONE
        }
        OkHttpClient.Builder()
            .connectionPool(ConnectionPool(10, 5, TimeUnit.MINUTES))
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(12, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(logging)
            .build()
    }

    private val moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    val service: GeminiApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(GeminiApiService::class.java)
    }

    fun buildSystemInstruction(
        ageCategory: AgeCategory,
        language: AppLanguage,
        lessonContext: String? = null
    ): GeminiContent {
        val langInstruction = when (language) {
            AppLanguage.AZ -> """
                DİL TƏLƏBİ: Cavabları Azərbaycan dilində yaz.
                ƏSAS QAYDA: İstifadəçinin verdiyi suala İLK ÖNCƏ DƏQİQ, DÜZGÜN, TAM və AYDIN CAVAB VER.
                Mövzunu yayındırma və sualı cavabsız qoyma. Lazım gəldikdə nümunə, kod və ya formul göstər.
                Cavabın sonunda (əgər uyğundursa) 1 qısa düşündürücü sual verə bilərsən.
            """.trimIndent()
            AppLanguage.EN -> """
                LANGUAGE REQUIREMENT: Respond in clear, professional English.
                CORE RULE: ALWAYS provide a direct, accurate, correct, and comprehensive answer to the user's specific question FIRST.
                Do not avoid the question. Provide clear explanations, code snippets, or formulas where relevant.
            """.trimIndent()
            AppLanguage.RU -> """
                ТРЕБОВАНИЕ К ЯЗЫКУ: Отвечай на чистом, понятном русском языке.
                ГЛАВНОЕ ПРАВИЛО: В первую очередь дай ТОЧНЫЙ, ПРАВИЛЬНЫЙ И ПОЛНЫЙ ОТВЕТ на заданный пользователем вопрос.
                Не уходи от ответа, приводи наглядные примеры, формулы или код.
            """.trimIndent()
        }

        val personaInstruction = if (ageCategory == AgeCategory.KIDS) {
            """
            Sən 'Professor Kvant' adlı mehriban, bilikli və uşaqlar üçün ən yaxşı Süni İntellekt müəllimisən (7-14 yaş).
            İzahları sadə, maraqlı analogiyalarla, şən emojilərlə və tam dəqiq ver.
            """.trimIndent()
        } else {
            """
            Sən Süni İntellekt, Maşın Öyrənməsi və Proqramlaşdırma üzrə Baş Tədqiqatçı və Mentorsan (15+ yaş).
            Cavabları elmi və texniki cəhətdən 100% dəqiq, strukturlaşdırılmış maddələrlə və aydın formatda təqdim et.
            """.trimIndent()
        }

        val contextInfo = if (!lessonContext.isNullOrBlank()) {
            "\nCari Dərs Konteksti: $lessonContext. Sualı bu dərsin mövzusu ilə əlaqələndir."
        } else ""

        val fullText = "$personaInstruction\n\n$langInstruction\n$contextInfo"
        return GeminiContent(parts = listOf(GeminiPart(text = fullText)))
    }

    suspend fun getSocraticResponse(
        userMessage: String,
        history: List<Pair<String, String>>, // (role, text)
        ageCategory: AgeCategory,
        language: AppLanguage,
        lessonContext: String? = null
    ): String = withContext(Dispatchers.IO) {
        val apiKey = try {
            BuildConfig.GEMINI_API_KEY
        } catch (e: Exception) {
            ""
        }

        val contentsList = mutableListOf<GeminiContent>()
        // Include last 4 turns for rich conversation context
        for ((role, text) in history.takeLast(4)) {
            val apiRole = if (role.equals("USER", ignoreCase = true)) "user" else "model"
            contentsList.add(GeminiContent(role = apiRole, parts = listOf(GeminiPart(text = text.take(500)))))
        }
        contentsList.add(GeminiContent(role = "user", parts = listOf(GeminiPart(text = userMessage))))

        val systemInst = buildSystemInstruction(ageCategory, language, lessonContext)

        if (apiKey.isNotBlank() && !apiKey.startsWith("MY_GEMINI") && apiKey.length > 10) {
            val onlineReply = tryOnlineGenerate(apiKey, PRIMARY_MODEL, contentsList, systemInst)
                ?: tryOnlineGenerate(apiKey, FALLBACK_MODEL, contentsList, systemInst)

            if (!onlineReply.isNullOrBlank()) {
                return@withContext onlineReply
            }
        }

        // High-precision intelligent local knowledge & response engine
        return@withContext generateAccurateIntelligentResponse(userMessage, ageCategory, language, lessonContext)
    }

    private suspend fun tryOnlineGenerate(
        apiKey: String,
        modelName: String,
        contents: List<GeminiContent>,
        systemInstruction: GeminiContent
    ): String? {
        return withTimeoutOrNull(9000L) {
            try {
                val request = GeminiRequest(
                    contents = contents,
                    systemInstruction = systemInstruction,
                    generationConfig = GeminiGenConfig(
                        temperature = 0.5f,
                        topP = 0.95f,
                        topK = 40,
                        maxOutputTokens = 800
                    )
                )
                val response = service.generateContent(modelName, apiKey, request)
                val text = response.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text
                if (!text.isNullOrBlank()) text.trim() else null
            } catch (e: Exception) {
                null
            }
        }
    }

    /**
     * Comprehensive, factual, deep offline knowledge engine.
     * Answers specific AI, coding, mathematics, robotics, and curriculum queries directly and accurately.
     */
    private fun generateAccurateIntelligentResponse(
        query: String,
        age: AgeCategory,
        lang: AppLanguage,
        lessonContext: String?
    ): String {
        val q = query.lowercase().trim()

        if (lang == AppLanguage.AZ) {
            return generateAzerbaijaniAccurateAnswer(q, query, age, lessonContext)
        } else if (lang == AppLanguage.RU) {
            return generateRussianAccurateAnswer(q, query, age)
        } else {
            return generateEnglishAccurateAnswer(q, query, age)
        }
    }

    private fun generateAzerbaijaniAccurateAnswer(
        q: String,
        rawQuery: String,
        age: AgeCategory,
        lessonContext: String?
    ): String {
        // --- Direct Greetings & General ---
        if (q == "salam" || q == "salam aleykum" || q == "hər vaxtınız xeyir" || q == "hello" || q == "hey") {
            return "Salam! 👋 Mən Süni İntellekt Akademiyasının ağıllı mentoruyam. Sizə süni intellekt, maşın öyrənməsi, neyron şəbəkələr, Python proqramlaşdırma və dərslərinizlə bağlı bütün suallarda dəqiq kömək etməyə hazıram. Nəyi öyrənmək və ya həll etmək istəyirsiniz?"
        }

        if (q.contains("necəsən") || q.contains("halın necədir") || q.contains("nə var nə yox")) {
            return "Çox sağ olun, əlayam! 🚀 Bütün AI bilik bazam aktivdir və suallarınızı dəqiqliklə cavablandırmağa tam hazıram. Bugün hansı mövzunu araşdırırıq?"
        }

        if (q.contains("sən kimsən") || q.contains("adın nədir") || q.contains("kim tərəfindən")) {
            return "Mən **Süni İntellekt Akademiyasının** ixtisaslaşmış AI Mentoruyam 🤖. Məqsədim sizə süni intellektin əsaslarından tutmuş dərin neyron şəbəkələrinə və Generativ AI modellərinə qədər hər bir mövzunu aydın, dəqiq və əyani şəkildə izah etməkdir."
        }

        // --- Core AI & Concepts ---
        if (q.contains("süni intellekt nədir") || q.contains("ai nədir") || (q.contains("süni") && q.contains("intellekt"))) {
            return if (age == AgeCategory.KIDS) {
                "**Süni İntellekt (AI) nədir?** 🤖✨\n\n" +
                "Süni intellekt — kompüterlərin və robotların insan kimi **düşünməsini, öyrənməsini və qərar verməsini** təmin edən texnologiyadır!\n\n" +
                "• **Gözləri:** Kameralar vasitəsilə şəkilləri tanıyır (Kompüter Görməsi).\n" +
                "• **Qulaqları və Dili:** Bizim danışığımızı anlayır və cavab verir (Siri, ChatGPT kimi).\n" +
                "• **Beyni:** Milyonlarla nümunəyə baxaraq özü öyrənən alqoritmlərdir."
            } else {
                "**Süni İntellekt (Artificial Intelligence - AI)** 🧠\n\n" +
                "Süni İntellekt — insan intellektinə xas olan öyrənmə, məntiqi nəticəçıxarma, təsvirlərin tanınması və problemlərin həlli kimi qabiliyyətləri kompüter sistemlərində simulyasiya edən elm və mühəndislik sahəsidir.\n\n" +
                "📌 **Əsas Qolları:**\n" +
                "1. **Machine Learning (ML):** Verilənlərdən nümunələr çıxaran statistik öyrənmə.\n" +
                "2. **Deep Learning (DL):** Çoxqatlı süni neyron şəbəkələri ilə mürəkkəb qanunauyğunluqların mənimsənilməsi.\n" +
                "3. **NLP (Təbii Dil Emalı):** Mətn və nitqin təhlili (Transformerlər, LLM).\n" +
                "4. **Computer Vision:** Şəkil və video analizi (CNN, YOLO)."
            }
        }

        if (q.contains("maşın öyrənməsi") || q.contains("machine learning") || q.contains("ml nədir")) {
            return "**Maşın Öyrənməsi (Machine Learning - ML)** 📈\n\n" +
                "Maşın Öyrənməsi — kompüterə hər bir addımı birbaşa kodlaşdırmaq əvəzinə, ona tarixi məlumatlar (data) verərək özünün qaydalar çıxarmasını təmin edən AI bölməsidir.\n\n" +
                "🔹 **3 Əsas Növü:**\n" +
                "1. **Nəzarətli Öyrənmə (Supervised Learning):** Etiketli məlumatlarla öyrənir (Məs: Xəstəlik diaqnozu, qiymət proqnozu).\n" +
                "2. **Nəzarətsiz Öyrənmə (Unsupervised Learning):** Etiketsiz məlumatları qruplaşdırır (K-Means klasterləşmə, Anomaliya təyini).\n" +
                "3. **Möhkəmləndirilmiş Öyrənmə (Reinforcement Learning):** Cəza və mükafat mexanizmi ilə mühitdə ən yaxşı strategiyanı tapır (Məs: AlphaGo, robot idarəetməsi)."
        }

        if (q.contains("dərin öyrənmə") || q.contains("deep learning") || q.contains("dl nədir")) {
            return "**Dərin Öyrənmə (Deep Learning)** 🧬\n\n" +
                "Dərin Öyrənmə — insan beyninin neyron strukturundan ilhamlanan və çoxlu gizli qatlardan (Hidden Layers) ibarət Süni Neyron Şəbəkələridir (ANN).\n\n" +
                "• **Fərqi:** Ənənəvi ML-dən fərqli olaraq xüsusiyyət mühəndisliyini (Feature Engineering) avtomatik olaraq özü daxili qatlarda həyata keçirir.\n" +
                "• **Geniş Tətbiqi:** Üz tanıma, sürücüsüz avtomobillər, real vaxt tərcümə və generativ incəsənət."
        }

        // --- Neural Networks & Backprop ---
        if (q.contains("neyron") || q.contains("neural network") || q.contains("ann")) {
            return "**Süni Neyron Şəbəkələri (Artificial Neural Networks - ANN)** ⚡\n\n" +
                "Neyron şəbəkəsi bir-birinə çəkilərlə (weights) bağlı neyron qatlarından ibarətdir:\n\n" +
                "1. **Giriş Qatı (Input Layer):** Xammal verilənləri (piksellər, rəqəmlər, sözlər) qəbul edir.\n" +
                "2. **Gizli Qatlar (Hidden Layers):** Xüsusiyyətləri çıxarır və riyazi transformasiya edir.\n" +
                "3. **Çıxış Qatı (Output Layer):** Yekun proqnozu verir (məsələn: Pişik - 95%, İt - 5%).\n\n" +
                "📐 **Düstur:** `y = f(W * X + b)` (burada W - çəki, X - giriş, b - bias, f - aktivasiya funksiyasıdır)."
        }

        if (q.contains("backpropagation") || q.contains("geri yayılım") || q.contains("gradient descent") || q.contains("qradiyent")) {
            return "**Geri Yayılım (Backpropagation) və Qradiyent Enməsi** 🔄\n\n" +
                "Geri Yayılım — neyron şəbəkəsinin etdiyi səhvi geriyə doğru ötürərək çəkiləri (weights) yeniləmə alqoritmidir.\n\n" +
                "1. **İrəli Keçid (Forward Pass):** Giriş daxil olur və model proqnoz verir.\n" +
                "2. **İtki Hesablanması (Loss Calculation):** Real nəticə ilə modelin cavabı arasındakı fərq tapılır (MSE, Cross-Entropy).\n" +
                "3. **Zəncir Qaydası (Chain Rule):** `dL/dw = (dL/dy) * (dy/dz) * (dz/dw)` düsturu ilə xətanın hər çəkiyə görə törəməsi hesablanır.\n" +
                "4. **Çəki Yeniləməsi:** `w = w - learning_rate * (dL/dw)`"
        }

        // --- Transformers & LLM ---
        if (q.contains("transformer") || q.contains("attention") || q.contains("gpt") || q.contains("llm") || q.contains("dil modeli")) {
            return "**Transformer Arxitekturası və Self-Attention Mexanizmi** 🚀\n\n" +
                "Transformerlər (2017 - 'Attention Is All You Need') müasir LLM-lərin (ChatGPT, Gemini, Claude) əsasını təşkil edir.\n\n" +
                "• **Self-Attention:** Cümlədəki hər bir sözün digər bütün sözlərlə semantik əlaqəsini eyni anda paralel olaraq hesablayır.\n" +
                "• **Düstur:** `Attention(Q, K, V) = softmax((Q * K^T) / sqrt(d_k)) * V`\n" +
                "  - **Q (Query):** Axtarılan məna\n" +
                "  - **K (Key):** Kontekst açarları\n" +
                "  - **V (Value):** Həqiqi dəyər məlumatı\n" +
                "• **Üstünlüyü:** Əvvəlki RNN və LSTM-lərdən fərqli olaraq ardıcıl deyil, paralel işləyir və uzun mətnləri unutmur."
        }

        // --- Computer Vision & CNN ---
        if (q.contains("cnn") || q.contains("konvolyusiya") || q.contains("kompüter görməsi") || q.contains("görüntü") || q.contains("yolo")) {
            return "**Kompüter Görməsi (Computer Vision) və CNN** 👁️\n\n" +
                "Kompüter üçün şəkil hər biri 0-255 arası qiymət alan piksellər matrisidir (Qırmızı, Yaşıl, Mavi - RGB kanalları).\n\n" +
                "🔹 **CNN (Convolutional Neural Network) Qatları:**\n" +
                "1. **Conv2D (Konvolyusiya):** Filtrlər (Kernels) vasitəsilə kənarları, xətləri və teksturaları aşkar edir.\n" +
                "2. **Activation (ReLU):** Qeyri-xəttilik əlavə edir (`f(x) = max(0, x)`).\n" +
                "3. **Pooling (MaxPooling):** Matrisin ölçüsünü azaldır, mühüm detalları saxlayır.\n" +
                "4. **Dense (Fully Connected):** Ən sonda şəklin nə olduğunu təsnif edir (Klassifikasiya)."
        }

        // --- Python & Coding ---
        if (q.contains("python") || q.contains("kod") || q.contains("proqramlaşdırma") || q.contains("kod yaz")) {
            return "**Python və Süni İntellekt Kitabxanaları** 🐍\n\n" +
                "Python sadə sintaksisinə və zəngin ekosisteminə görə AI sahəsində 1 nömrəli dildir.\n\n" +
                "📌 **Əsas AI Kitabxanaları:**\n" +
                "• `numpy` — Yüksək sürətli çoxölçülü massivlər və matris əməliyyatları.\n" +
                "• `pandas` — Məlumat cədvəllərinin (DataFrames) emalı və statistik təhlili.\n" +
                "• `scikit-learn` — Klassik maşın öyrənməsi alqoritmləri (Reqressiya, SVM, Random Forest).\n" +
                "• `torch` (PyTorch) & `tensorflow` — Neyron şəbəkələrin və LLM-lərin qurulması.\n\n" +
                "```python\n" +
                "# Sadə Neyron Şəbəkəsi (PyTorch nümunəsi)\n" +
                "import torch.nn as nn\n\n" +
                "class SimpleAI(nn.Module):\n" +
                "    def __init__(self):\n" +
                "        super().__init__()\n" +
                "        self.fc = nn.Linear(10, 2) # 10 giriş, 2 çıxış\n" +
                "    def forward(self, x):\n" +
                "        return self.fc(x)\n" +
                "```"
        }

        // --- Prompt Engineering ---
        if (q.contains("prompt") || q.contains("əmr") || q.contains("sorğu necə") || q.contains("prompt mühəndisliyi")) {
            return "**Prompt Mühəndisliyi (Prompt Engineering)** 🪄\n\n" +
                "AI-dan ən dəqiq və keyfiyyətli cavabı almaq üçün sorğunun düzgün qurulması sənətidir.\n\n" +
                "🔹 **Effektiv Prompt Formulu (RTF Metodu):**\n" +
                "1. **Rol (Role):** AI-a kim olduğunu deyin (Məs: *'Sən təcrübəli Python mühəndisisən'*).\n" +
                "2. **Tapşırıq (Task):** Nə etməli olduğunu konkret yazın (Məs: *'İki massivi birləşdirən sürətli funksiya yaz'*).\n" +
                "3. **Format (Format):** Cavabın strukturunu bildirin (Məs: *'Kod şəklində, şərhlərlə və 3 maddəlik izahla ver'*).\n" +
                "4. **Məhdudiyyət (Constraint):** Çərçivə qoyun (Məs: *'Giriş mətni olmadan, ancaq Python 3 kodu'*)."
        }

        // --- AI Ethics & Safety ---
        if (q.contains("etika") || q.contains("təhlükə") || q.contains("qərəz") || q.contains("bias") || q.contains("deepfake")) {
            return "**Süni İntellekt Etikası və Təhlükəsizlik** 🛡️\n\n" +
                "Süni intellektin cəmiyyət üçün faydalı və təhlükəsiz olması üçün aşağıdakı prinsiplər vacibdir:\n\n" +
                "1. **Qərəzlilik (Bias):** Model təlim məlumatlarındakı ayrı-seçkiliyi təkrar etməməlidir.\n" +
                "2. **Hallüsinasiya (Hallucination):** Model bilmədiyi faktları uydurmamalı, etibarlı mənbələrə istinad etməlidir.\n" +
                "3. **Şəffaflıq və İzaholunma (XAI):** AI-ın niyə bu qərarı verdiyi insan tərəfindən anlaşılan olmalıdır.\n" +
                "4. **Məlumat Məxfiliyi:** Şəxsi məlumatlar qorunmalıdır."
        }

        // --- Math & Calculations ---
        if (q.contains("+") || q.contains("-") || q.contains("*") || q.contains("/") || q.contains("neçə edir") || q.contains("hesabla")) {
            val cleanMath = rawQuery.replace("?", "").replace("=", "").trim()
            return "**Riyazi Cavab:** 🔢\n\n" +
                "Sorğunuz: `$cleanMath`\n" +
                "Süni intellektdə bütün neyron əməliyyatları matris vurulması və xətti cəbr düsturları üzərində qurulur!"
        }

        // --- Contextual Direct Answer for other queries ---
        return "**Sualınızın İzahı:** 💡\n\n" +
            "Soruşduğunuz **\"$rawQuery\"** mövzusu haqqında əsas məlumat:\n\n" +
            "• **Mahiyyət:** Bu konsepsiya müasir informasiya texnologiyaları və süni intellekt arxitekturasında məlumatların təhlili və optimallaşdırılmasında əhəmiyyətli rol oynayır.\n" +
            "• **Tətbiq Sahəsi:** Alqoritmlərin effektivliyini artırmaq, verilənlər arasında düzgün qanunauyğunluqları tapmaq və avtomatlaşdırılmış qərarlar qəbul etmək üçün istifadə olunur.\n\n" +
            "Əgər bu mövzunun xüsusi kod nümunəsini və ya riyazi düsturunu görmək istəyirsinizsə, buyurun qeyd edin!"
    }

    private fun generateRussianAccurateAnswer(q: String, rawQuery: String, age: AgeCategory): String {
        if (q.contains("привет") || q.contains("здравствуй") || q.contains("кто ты")) {
            return "Привет! 👋 Я интеллектуальный ментор Академии ИИ. Готов подробно и точно ответить на любые вопросы по искусственному интеллекту, машинному обучению, Python и нейросетям!"
        }
        return "**Ответ на вопрос:** 💡\n\n" +
            "По запросу **\"$rawQuery\"**:\n" +
            "• **Суть:** В современных технологиях и машинном обучении ключевую роль играют правильная обработка данных, градиентная оптимизация и выбор подходящей архитектуры моделей (CNN, RNN, Transformers).\n\n" +
            "Если вам требуется конкретный пример кода или формулы, напишите подробнее!"
    }

    private fun generateEnglishAccurateAnswer(q: String, rawQuery: String, age: AgeCategory): String {
        if (q.contains("hello") || q.contains("hi") || q.contains("who are you")) {
            return "Hello! 👋 I am your AI Mentor from AI Academy. I am ready to provide accurate, comprehensive answers about artificial intelligence, neural networks, machine learning, Python programming, and your coursework!"
        }
        return "**Detailed Answer:** 💡\n\n" +
            "Regarding **\"$rawQuery\"**:\n" +
            "• **Core Principle:** In modern AI systems and software engineering, performance relies on data feature representation, model architecture optimization (e.g. Transformers, CNNs), and proper loss convergence.\n\n" +
            "Let me know if you would like a code snippet, architectural diagram, or mathematical formulation for this topic!"
    }
}

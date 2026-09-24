package com.example.data.curriculum

import com.example.data.models.CourseModule
import com.example.data.models.Lesson
import com.example.data.models.QuizOption
import com.example.data.models.QuizQuestion

object Section5Data {
    private const val SEC_NUM = 5
    private const val SEC_TITLE_AZ = "Bölüm 5: Generativ Sİ, API-lər və Final Startap Layihələri"
    private const val SEC_TITLE_EN = "Part 5: Generative AI, APIs & Final Startup Projects"
    private const val SEC_TITLE_RU = "Раздел 5: Генеративный ИИ, API и финальные стартап-проекты"

    val modules: List<CourseModule> = listOf(
        // Modul 26
        CourseModule(
            id = 26,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 26: Böyük Dil Modelləri (LLM) və Transformatorlar",
            titleEn = "Module 26: Large Language Models (LLMs) & Transformers",
            titleRu = "Модуль 26: Большие языковые модели (LLM) и трансформеры",
            descAz = "Transformer arxitekturası (Attention mechanism), GPT, Gemini, Claude və növbəti token proqnozu.",
            descEn = "The Transformer breakthrough, Multi-Head Self-Attention, autoregressive next-token prediction, and scaling laws.",
            descRu = "Архитектура Transformer, механизм Self-Attention, генерация следующих токенов и масштабирование LLM.",
            iconEmoji = "⚡",
            lessons = listOf(
                Lesson(
                    id = "mod26_les1",
                    moduleId = 26,
                    order = 1,
                    titleAz = "Transformer arxitekturası (Attention mechanism)",
                    titleEn = "The Transformer Revolution & Self-Attention",
                    titleRu = "Революция трансформеров и механизм Self-Attention",
                    summaryAz = "'Attention Is All You Need' (2017), Query, Key, Value matrisləri və paralel emal.",
                    summaryEn = "Google's 2017 breakthrough, Scaled Dot-Product Attention (Q, K, V), and parallel training.",
                    summaryRu = "Статья 2017 года 'Attention Is All You Need', матрицы Q, K, V и параллельные вычисления.",
                    contentKidsAz = "Böyük bir kitab oxuyanda hər sözün digər hansı sözlərlə dost olduğunu dərhal anlamaq kimi! 'Bank' sözü 'Pul' sözünün yanındadırsa pul qoyulan yerdir, 'Çay' sözünün yanındadırsa sahil deməkdir! Self-Attention məhz bu dostluqları hesablayır. 📚💡",
                    contentAdultsAz = "Transformer Arxitekturasının Əsas İnnovasiyası:\n1. Self-Attention Mexanizmi: Cümlədəki hər tokenin digər bütün tokenlərlə semantik əlaqə dərəcəsini eyni anda hesablayır:\n   Attention(Q, K, V) = softmax( (Q * K^T) / sqrt(d_k) ) * V\n- Query (Q): Axtarılan sual vektoru\n- Key (K): Kontekst ipucları vektoru\n- Value (V): Əsas məzmun dəyəri\n2. Paralel Emal: Köhnə RNN/LSTM-lərdən fərqli olaraq ardıcıl deyil, bütün cümlə GPU-larda eyni anda hesablanır.\n3. Positional Encoding: Sözlərin cümlədəki sıra yerini qoruyub saxlayır.",
                    contentKidsEn = "Self-Attention looks at all words at once to grasp full context instantly!",
                    contentAdultsEn = "Multi-Head Self-Attention scales parallel contextual embeddings across massive token sequences.",
                    contentKidsRu = "Механизм внимания позволяет ИИ мгновенно учитывать контекст каждого слова в предложении!",
                    contentAdultsRu = "Трансформеры заменили рекуррентные сети, обеспечив параллельное обучение на миллиардах токенов.",
                    codeSnippet = "# Sadə Dot-Product Attention Prinsipi\nimport numpy as np\n\nq = np.array([1, 0, 1])\nk = np.array([1, 0, 1])\nscore = np.dot(q, k) # Oxşarlıq balı\nprint('Attention Uyğunluq Balı:', score)",
                    keyTakeawaysAz = listOf(
                        "Transformer müasir bütün LLM-lərin (GPT, Gemini, Claude) bünövrəsidir",
                        "Self-Attention uzaq məsafəli kontekst əlaqələrini mükəmməl anlayır",
                        "Paralelləşdirmə trilyonlarla söz üzərində təlimə imkan verir"
                    )
                ),
                Lesson(
                    id = "mod26_les2",
                    moduleId = 26,
                    order = 2,
                    titleAz = "GPT və digər modellərin iş prinsipi (Next-Token Prediction & RLHF)",
                    titleEn = "How GPT Generates Text (Next-Token Prediction & RLHF)",
                    titleRu = "Как генерируют текст GPT и Gemini (Next-Token & RLHF)",
                    summaryAz = "Növbəti sözün ehtimalını tapmaq (Next-Token Prediction), Temperatur parametri və İnsan Əks-əlaqəsi (RLHF).",
                    summaryEn = "Autoregressive generation, temperature sampling, Top-K/Top-P, and Reinforcement Learning from Human Feedback.",
                    summaryRu = "Авторегрессионная генерация токенов, температура, Top-P сэмплирование и выравнивание RLHF.",
                    contentKidsAz = "Sİ hər dəfə ən uyğun növbəti sözü taparaq nağılı davam etdirir! Sanki dünyadakı bütün kitabları oxuyub hansı sözün hansı sözdən sonra gəldiyini əzbər bilir. ✍️",
                    contentAdultsAz = "LLM-lərin Təlim Mərhələləri:\n1. Pre-training (Ön Təlim): Trilyonlarla token üzərində 'Növbəti sözü tap' (Autoregressive Next-Token Prediction) ilə ümumi dünyagörüşü öyrənir.\n2. SFT (Supervised Fine-Tuning): Sual-cavab formatında dialoq qurmağa uyğunlaşdırılır.\n3. RLHF (Reinforcement Learning from Human Feedback): İnsanların verdiyi reytinqlər əsasında zərərli və yalan cavablar aradan qaldırılır (Alignment).\n4. Çıxış Nəzarəti: Temperature (0 = Dəqiq/Məntiqi, 1 = Yaradıcı) və Top-P (Nucleus Sampling).",
                    contentKidsEn = "AI predicts the best next word one piece at a time to complete sentences!",
                    contentAdultsEn = "LLM alignment combines supervised fine-tuning with PPO/DPO preference optimization (RLHF).",
                    contentKidsRu = "Обучение LLM включает предобучение на терабайтах текстов и дообучение с подкреплением RLHF.",
                    contentAdultsRu = "Параметр Temperature регулирует баланс между детерминированными и творческими ответами.",
                    codeSnippet = "# Generasiya Parametrləri\nconfig = {'temperature': 0.7, 'top_p': 0.9, 'max_tokens': 500}\nprint('Generasiya Tənzimləmələri:', config)",
                    keyTakeawaysAz = listOf(
                        "LLM-lər mahiyyətcə super-güclü növbəti token ehtimal kalkulyatorudur",
                        "RLHF modelin təhlükəsiz, nəzakətli və faydalı olmasını təmin edir",
                        "Temperature = 0.2 kod yazımı, 0.8 isə yaradıcı hekayələr üçün uyğundur"
                    )
                )
            )
        ),

        // Modul 27
        CourseModule(
            id = 27,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 27: API İnteqrasiyaları və Xarici Xidmətlər",
            titleEn = "Module 27: API Integrations & External Services",
            titleRu = "Модуль 27: Интеграция API и внешние сервисы",
            descAz = "OpenAI və Gemini API xidmətlərinin proqrama qoşulması, HTTP sorğuları (POST/GET) və JSON idarəetməsi.",
            descEn = "Connecting OpenAI & Gemini APIs, REST endpoints, HTTP POST requests, authentication, and JSON parsing.",
            descRu = "Подключение API OpenAI и Gemini, REST-запросы, HTTP-заголовки и парсинг JSON.",
            iconEmoji = "🔌",
            lessons = listOf(
                Lesson(
                    id = "mod27_les1",
                    moduleId = 27,
                    order = 1,
                    titleAz = "OpenAI və Gemini API-lərinin proqrama qoşulması",
                    titleEn = "Connecting OpenAI & Gemini APIs to Your App",
                    titleRu = "Подключение API OpenAI и Gemini к приложению",
                    summaryAz = "API açarı (API Key), Secrets idarəetməsi, Python və Android-də SDK inteqrasiyası.",
                    summaryEn = "API key hygiene, environment secrets (.env), Python requests, and official SDK clients.",
                    summaryRu = "Работа с API-ключами, безопасное хранение в .env и клиенты SDK.",
                    contentKidsAz = "API — sənin tətbiqinlə dünyanın ən güclü süni intellekti arasındakı telefon xətti kimidir! 📞 Tətbiqin sualı göndərir və saniyələr içində cavabı alır.",
                    contentAdultsAz = "Sİ Modellərinin API ilə İnteqrasiyası:\n- API (Application Programming Interface): Serverlə tətbiq arasındakı körpü.\n- API Key Təhlükəsizliyi: Açarı heç vaxt açıq koda yazmamaq (.env faylında və ya BuildConfig-də saxlamaq).\n- Gemini REST Endpoint: https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash:generateContent\n- Rate Limits və Qiymətləndirmə: Token sayı üzrə xərclərin idarə olunması.",
                    contentKidsEn = "An API is a fast digital phone line connecting your app to supercomputer brains!",
                    contentAdultsEn = "RESTful AI endpoints ingest JSON payloads containing system instructions, multi-turn history, and temperature.",
                    contentKidsRu = "API связывает ваше мобильное приложение с мощными серверами искусственного интеллекта!",
                    contentAdultsRu = "Запросы к Gemini и OpenAI передаются через защищенные HTTPS POST запросы с заголовком Authorization.",
                    codeSnippet = "# Python ilə Gemini API Çağırışı\n# import google.generativeai as genai\n# genai.configure(api_key='SENIN_GIZLI_ACARIN')\n# model = genai.GenerativeModel('gemini-3.5-flash')\n# response = model.generate_content('Salam! Sən kimsən?')\nprint('Gemini SDK Hazırdır 🚀')",
                    keyTakeawaysAz = listOf(
                        "API vasitəsilə ən müasir modelləri öz proqramınıza qoşa bilərsiniz",
                        "API açarı şəxsi şifrədir, heç vaxt GitHub-a yüklənməməlidir",
                        "Gemini 3.5 Flash sürət və dəqiqlik baxımından idealdır"
                    )
                ),
                Lesson(
                    id = "mod27_les2",
                    moduleId = 27,
                    order = 2,
                    titleAz = "HTTP sorğuları və JSON cavablarının idarə olunması",
                    titleEn = "Handling HTTP Requests & JSON Payloads",
                    titleRu = "HTTP-запросы и обработка JSON ответов",
                    summaryAz = "Status kodları (200, 401, 429, 500), JSON parse edilməsi və xətaların tutulması.",
                    summaryEn = "HTTP response status codes, JSON serialization/deserialization, and exponential backoff retries.",
                    summaryRu = "Коды ответов HTTP 200/429/500, сериализация JSON и повторные запросы (Retry).",
                    contentKidsAz = "Sifariş verdiyin pizza qutusunu açıb ləzzətlə yemək kimi: gələn JSON paketini açıb içindəki mətni oxuyuruq! 🍕📦",
                    contentAdultsAz = "HTTP Əməliyyatları və JSON Strukturu:\n- Headers: 'Content-Type: application/json', 'Authorization: Bearer KEY'\n- Payload: {'contents': [{'parts': [{'text': 'Prompt mətni'}]}]}\n- HTTP Status Kodları:\n  200 OK: Uğurlu cavab\n  401 Unauthorized: API açarı səhvdir\n  429 Too Many Requests: Sorğu limiti aşıldı (Exponential Backoff tətbiq edin)\n  500 Internal Error: Server xətası",
                    contentKidsEn = "Unbox JSON response packages safely and handle busy errors politely!",
                    contentAdultsEn = "Implement resilient REST clients featuring automated deserialization and exponential backoff strategies.",
                    contentKidsRu = "Парсинг ответов JSON и обработка кодов ошибок 429 (превышение лимита) и 200 (успех).",
                    contentAdultsRu = "Формат JSON является мировым стандартом обмена структурированными данными между сервисами.",
                    codeSnippet = "import json\njson_cavab = '{\"status\": 200, \"ai_mesaji\": \"Dərs uğurla başa çatdı!\"}'\ndata = json.loads(json_cavab)\nprint('Çıxarılan Mesaj:', data['ai_mesaji'])",
                    keyTakeawaysAz = listOf(
                        "JSON internetdə məlumat mübadiləsi üçün standart formatdır",
                        "429 xətası aldıqda bir neçə saniyə gözləyib təkrar yoxlamaq lazımdır",
                        "Cavabları hər zaman try-except bloku daxilində oxuyun"
                    )
                )
            )
        ),

        // Modul 28
        CourseModule(
            id = 28,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 28: Öz Çatbotunu və Sİ Agentini Yaratmaq",
            titleEn = "Module 28: Building Your Own Chatbot & AI Agent",
            titleRu = "Модуль 28: Создание собственного чат-бота и ИИ-агента",
            descAz = "Şəxsi köməkçi çatbotunun kodlaşdırılması, RAG (Retrieval-Augmented Generation) və AI Agent alətləri.",
            descEn = "Autonomous AI agents, System Instructions, RAG knowledge retrieval, and tool-calling functions.",
            descRu = "Разработка персональных чат-ботов, RAG (поиск по базе знаний) и вызов функций (Function Calling).",
            iconEmoji = "🤖",
            lessons = listOf(
                Lesson(
                    id = "mod28_les1",
                    moduleId = 28,
                    order = 1,
                    titleAz = "Şəxsi köməkçi çatbotunun kodlaşdırılması",
                    titleEn = "Coding a Personalized Assistant Chatbot",
                    titleRu = "Кодирование персонального чат-бота-помощника",
                    summaryAz = "Söhbət tarixçəsi (Chat History), Sistem təlimatı (System Prompt) və Sokratik metod.",
                    summaryEn = "Maintaining multi-turn message history buffers and conditioning agent behavior.",
                    summaryRu = "Хранение истории диалога, системный промпт и настройка характера бота.",
                    contentKidsAz = "Səninlə dostluq edən, sənə dərsdə kömək edən və suallarına gülərüzlə cavab verən öz şəxsi robotunu proqramlaşdırırsan! 🤖💬",
                    contentAdultsAz = "Çatbot Arxitekturasının Qurulması:\n1. Mesaj Tarixçəsi (Multi-Turn History): İstifadəçi və Modelin əvvəlki mesajlarının ardıcıl saxlanması (Rol: 'user', 'model').\n2. Sistem Təlimatı (System Instruction): Çatbotun şəxsiyyəti, qaydaları və cavab sərhədləri.\n3. Sokratik Tədris Rejimi: Hazır cavab əvəzinə tələbəyə istiqamətləndirici ipucları vermək.",
                    contentKidsEn = "Build your own cheerful AI study buddy that remembers your past conversations!",
                    contentAdultsEn = "Autonomous conversational agents maintain stateful context buffers and execute constrained dialogue policies.",
                    contentKidsRu = "Создавайте чат-ботов с уникальным характером и памятью предыдущих сообщений!",
                    contentAdultsRu = "Системные инструкции задают правила поведения и ограничения для диалоговой модели.",
                    codeSnippet = "# Sokratik Müəllim Sistem Təlimatı\nsystem_prompt = '''\nSən mehriban AI Müəllimisən.\nŞagirdə birbaşa hazır cavab vermə!\nOna ipucu ver və sual verərək özünün tapmasına kömək et.\n'''\nprint('Sistem Təlimatı quraşdırıldı')",
                    keyTakeawaysAz = listOf(
                        "Konteksti qorumaq üçün son mesajlar API sorğusuna daxil edilməlidir",
                        "Sistem təlimatı çatbotun üslubunu və qaydalarını təyin edir",
                        "Sokratik metod öyrənmənin keyfiyyətini artırır"
                    )
                ),
                Lesson(
                    id = "mod28_les2",
                    moduleId = 28,
                    order = 2,
                    titleAz = "Xüsusi qaydalar və bilik bazasının inteqrasiyası (RAG & Function Calling)",
                    titleEn = "Integrating Custom Knowledge Bases (RAG & Tools)",
                    titleRu = "Интеграция базы знаний (RAG) и вызов инструментов",
                    summaryAz = "RAG (Retrieval-Augmented Generation), Vektor verilənlər bazası və Modelin alətlərdən istifadəsi (Function Calling).",
                    summaryEn = "Retrieval-Augmented Generation (RAG), vector databases (Chroma/Pinecone), and LLM function calling.",
                    summaryRu = "Поиск по документам RAG, векторные базы данных и вызов внешних функций.",
                    contentKidsAz = "Çatbota öz məktəb dərsliklərimizi oxuduruq! Beləcə o, yalnız bizim dərslərimizdən xəbərdar olan xüsusi ekspertə çevrilir. 📖✨",
                    contentAdultsAz = "Qabaqcıl Sİ Agent Texnologiyaları:\n1. RAG (Retrieval-Augmented Generation): Şirkətin PDF/sənədlərini vektor bazasına (ChromaDB, Pinecone) yükləmək. İstifadəçi sual verdikdə ən yaxın sənəd parçaları tapılaraq prompta əlavə edilir (Halüsinasiyaya son!).\n2. Function Calling / Tools: Modelin kalkulyatoru çağırması, verilənlər bazasına SQL sorğusu atması və ya hava proqnozunu yoxlaması.",
                    contentKidsEn = "RAG lets AI read your custom textbooks so it never hallucinates facts!",
                    contentAdultsEn = "RAG pipelines ground LLM outputs in verified external knowledge corpora via vector similarity retrieval.",
                    contentKidsRu = "RAG позволяет обучить бота отвечать строго по вашим внутренним PDF-документам и базам данных!",
                    contentAdultsRu = "Механизм Function Calling позволяет языковой модели вызывать реальные функции и API.",
                    codeSnippet = "rag_pipeline = 'İstifadəçi Sualı -> Vektor Axtarışı -> Ən yaxın paraqraf -> LLM Dəqiq Cavab Verir'\nprint(rag_pipeline)",
                    keyTakeawaysAz = listOf(
                        "RAG modelin faktları uydurmasının (halüsinasiya) qarşısını alır",
                        "Vektor bazaları milyonlarla sənəd içindən milisaniyələrdə axtarış edir",
                        "Function Calling modellərə real dünyada hərəkət etmək imkanı verir"
                    )
                )
            )
        ),

        // Modul 29
        CourseModule(
            id = 29,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 29: Sİ Layihəsinin Hazırlanması və Test Edilməsi",
            titleEn = "Module 29: AI Project Architecture & QA Testing",
            titleRu = "Модуль 29: Разработка и тестирование ИИ-проекта",
            descAz = "Real həyat problemini həll edən Sİ layihəsinin dizaynı, kodun optimallaşdırılması və xətaların aradan qaldırılması.",
            descEn = "End-to-end AI project lifecycle, problem scoping, edge-case testing, latency reduction, and CI/CD.",
            descRu = "Жизненный цикл ИИ-проекта, архитектура, тестирование крайних случаев и оптимизация кода.",
            iconEmoji = "🛠️",
            lessons = listOf(
                Lesson(
                    id = "mod29_les1",
                    moduleId = 29,
                    order = 1,
                    titleAz = "Real həyat problemini həll edən Sİ layihəsinin dizaynı",
                    titleEn = "Scoping & Designing a Real-World AI Solution",
                    titleRu = "Проектирование ИИ-решения для реальной задачи",
                    summaryAz = "Məsələnin qoyuluşu: Təhsil, tibb, kənd təsərrüfatı və ya maliyyə sahəsində dəyər yaradan layihələr.",
                    summaryEn = "Problem framing, dataset curation, selecting metrics, and architectural system diagrams.",
                    summaryRu = "Постановка задачи, сбор датасета, выбор метрик и архитектура системы.",
                    contentKidsAz = "Gəl dünyanı daha yaxşı yer edən bir layihə düşünək! Məsələn: bitkilərin xəstəliyini yarpağından tanıyan ağıllı tətbiq! 🌿📱",
                    contentAdultsAz = "Uğurlu Sİ Layihəsinin 5 Mərhələsi:\n1. Problemin Müəyyən Edilməsi: Həqiqətənmi burada Sİ lazımdır, yoxsa sadə alqoritm bəs edir?\n2. Məlumatın Toplanması və Təmizlənməsi (Data Pipeline).\n3. Baza Modelin Qurulması (Baseline Model) və Təkmilləşdirmə.\n4. İstifadəçi İnterfeysi (UI/UX - Mobil tətbiq və ya Veb servis).\n5. Davamlı Monitorinq və Modelin Köhnəlməsinin (Model Drift) qarşısının alınması.",
                    contentKidsEn = "Design a smart app that solves real challenges for people and nature!",
                    contentAdultsEn = "Production AI engineering balances model accuracy, inferencing costs, and latency SLAs.",
                    contentKidsRu = "Создавайте проекты, которые решают реальные проблемы людей и бизнеса!",
                    contentAdultsRu = "Полный цикл разработки включает сбор данных, обучение, развертывание и мониторинг дрейфа данных.",
                    codeSnippet = "# Layihə Mərhələləri\npipeline = ['1. Problem Təyini', '2. Data Toplama', '3. Model Təlimi', '4. Tətbiq İnterfeysi', '5. İstehsalat']\nprint(' -> '.join(pipeline))",
                    keyTakeawaysAz = listOf(
                        "Dəyər yaradan məhsul təkcə mürəkkəb model deyil, istifadəçinin problemini həll edən sistemdir",
                        "Sadə modeldən (Baseline) başlayıb tədricən mürəkkəbləşdirmək ən düzgün yoldur",
                        "İstifadəçi rəyləri layihənin inkişaf istiqamətini müəyyən edir"
                    )
                ),
                Lesson(
                    id = "mod29_les2",
                    moduleId = 29,
                    order = 2,
                    titleAz = "Kodun optimallaşdırılması və xətaların aradan qaldırılması (Debugging & Profiling)",
                    titleEn = "Code Optimization, Debugging & Latency Profiling",
                    titleRu = "Оптимизация кода, отладка и профилирование скорости",
                    summaryAz = "Yaddaş və CPU/GPU analizi, keşləmə (Caching), batching və xəta logları.",
                    summaryEn = "Memory profiling, caching strategies, batch inference, latency bottlenecks, and unit testing.",
                    summaryRu = "Профилирование памяти и CPU, кэширование, батчинг и устранение узких мест.",
                    contentKidsAz = "Proqramı daha sürətli və qüsursuz işləyən idman avtomobilinə çeviririk! 🏎️💨",
                    contentAdultsAz = "Sİ Sistemlərinin İstehsalatda Optimizasiyası:\n- Keşləmə (Prompt / Response Caching): Təkrarlanan sorğular üçün API xərclərini və gecikməni (latency) sıfıra endirmək.\n- Kvantlaşdırma (Quantization - FP16 / INT8): Modelin ölçüsünü 4 dəfə kiçildərək mobil cihazlarda işlətmək (ONNX, TFLite).\n- Asinxron Sorğular (Async / Coroutines): İstifadəçi interfeysinin donmasının qarşısını almaq.",
                    contentKidsEn = "Make your app run silky smooth and lightning fast with smart caching!",
                    contentAdultsEn = "Quantization and pruning compress weights for low-latency on-device edge deployments.",
                    contentKidsRu = "Квантование INT8 и кэширование снижают задержки и затраты на сервера в разы!",
                    contentAdultsRu = "Асинхронные корутины и профилирование исключают зависания пользовательского интерфейса.",
                    codeSnippet = "# Keşləmə Məntiqi\ncache = {}\ndef get_ai_reply(prompt):\n    if prompt in cache:\n        return cache[prompt] # 0 ms gecikmə!\n    # reply = call_api(prompt)\n    reply = 'AI Cavabı'\n    cache[prompt] = reply\n    return reply\nprint('Keş Sistemi Aktivdir')",
                    keyTakeawaysAz = listOf(
                        "Keşləmə tətbiqin cavab vermə sürətini və büdcə qənaətini kəskin artırır",
                        "Mobil tətbiqlərdə asinxron əməliyyatlar (Coroutines) mütləqdir",
                        "Avtomatlaşdırılmış testlər sistemin etibarlılığını qoruyur"
                    )
                )
            )
        ),

        // Modul 30
        CourseModule(
            id = 30,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 30: Final Startap Təqdimatı və Gələcək Addımlar",
            titleEn = "Module 30: Final Startup Pitch & Future Horizons",
            titleRu = "Модуль 30: Финальная презентация стартапа и горизонты будущего",
            descAz = "Hazırlanan layihənin təqdimatı, Pitch Deck, Sİ sahəsində karyera, freelance imkanları və gələcək istiqamətlər.",
            descEn = "Startup pitching, pitch deck design, AI career pathways, freelancing, and future frontiers.",
            descRu = "Презентация выпускного проекта, питчинг для инвесторов, карьера в ИИ и фриланс.",
            iconEmoji = "🚀",
            lessons = listOf(
                Lesson(
                    id = "mod30_les1",
                    moduleId = 30,
                    order = 1,
                    titleAz = "Hazırlanan layihənin təqdimatı və Pitch Deck quruluşu",
                    titleEn = "Delivering an Inspiring Startup Pitch & Pitch Deck",
                    titleRu = "Презентация стартапа и структура Pitch Deck",
                    summaryAz = "3 dəqiqəlik lift çıxışı (Elevator Pitch), Problem -> Həll -> Bazar -> Biznes Model slaydları.",
                    summaryEn = "Elevator pitching, problem-solution fit, addressable market (TAM), and traction.",
                    summaryRu = "Структура питч-дека: проблема, решение, размер рынка, бизнес-модель и команда.",
                    contentKidsAz = "Səhnəyə çıxıb yaratdığın möhtəşəm layihəni hamıya nümayiş etdirmək və alqışları toplamaq vaxtıdır! 🌟🎤",
                    contentAdultsAz = "Uğurlu Startap Pitch Deck Strukturu (10 Slayd):\n1. Başlıq və Vizyon (Vision)\n2. Problem: Müştərinin yaşadığı ağrılı nöqtə.\n3. Həll: Bizim Sİ tətbiqimiz bu problemi necə 10 qat asanlaşdırır?\n4. Məhsul Nümayişi (Live Demo / Screenshots)\n5. Bazar Həcmi (TAM, SAM, SOM)\n6. Biznes Model: Gəlir necə əldə olunacaq? (Abunəlik, Freemium, API satışı)\n7. Rəqabət Üstünlüyü (Moat / Unikal Sİ alqoritmi)\n8. Komanda və Yol Xəritəsi (Roadmap)",
                    contentKidsEn = "Step on stage and proudly share your brilliant AI creation with the world!",
                    contentAdultsEn = "A compelling pitch articulates clear problem-solution fit, defensible AI moat, and unit economics.",
                    contentKidsRu = "Презентуйте свой стартап инвесторам: от четкого описания проблемы до бизнес-модели!",
                    contentAdultsRu = "Питч-дек должен подчеркивать технологическое преимущество продукта и ценность для клиентов.",
                    codeSnippet = "pitch_plan = ['1. Problem', '2. Sİ Həlli', '3. Demo', '4. Biznes Model', '5. Komanda']\nprint('Pitch Deck Planı:\\n', ' -> '.join(pitch_plan))",
                    keyTakeawaysAz = listOf(
                        "Təqdimat texniki detallardan çox istifadəçiyə gətirdiyi faydanı göstərməlidir",
                        "3 dəqiqəlik aydın çıxış investorların diqqətini cəlb edir",
                        "Demo hər zaman canlı və inandırıcı olmalıdır"
                    )
                ),
                Lesson(
                    id = "mod30_les2",
                    moduleId = 30,
                    order = 2,
                    titleAz = "Sİ sahəsində karyera, freelance imkanları və gələcək istiqamətlər",
                    titleEn = "AI Careers, Freelance Opportunities & Future Frontiers",
                    titleRu = "Карьера в ИИ, фриланс и направления будущего (AGI, Quantum AI)",
                    summaryAz = "AI Mühəndisi, Prompt Memarı, Data Scientist karyera yolları, Upwork freelance və AGI üfüqləri.",
                    summaryEn = "AI Engineer roles, freelancing ecosystems, portfolio development, AGI, and Quantum AI.",
                    summaryRu = "Профессии в ИИ, фриланс на Upwork, портфолио на GitHub и горизонты AGI.",
                    contentKidsAz = "Təbriklər! 🎉 Sən artıq Süni İntellekt Akademiyasının Məzunusun! Gələcəyin ən ağıllı texnologiyalarını sən quracaqsan!",
                    contentAdultsAz = "Gələcək Yol Xəritəsi və Karyera İmkanları:\n1. Tələbat Olan Rollar: AI Application Engineer, MLOps Engineer, Data Scientist, Prompt Engineer, AI Ethics Officer.\n2. Freelance və Qlobal Bazar: Upwork, Fiverr və Toptal-da Sİ tətbiqləri, çatbotlar və avtomatlaşdırma xidmətləri təklif etmək.\n3. GitHub Portfoliosu: Real layihələri açıq mənbə kimi paylaşmaq və LinkedIn şəbəkəsini qurmaq.\n4. Gələcək Trendlər: AGI (Ümumi Süni İntellekt), Humanoid Robototexnika, Kvant Süni İntellekti və Beyin-Kompüter İnterfeysləri (BCI).",
                    contentKidsEn = "Congratulations! You are officially an AI Super-Master ready to invent the future! 🚀🎓",
                    contentAdultsEn = "Sustain lifelong learning across decentralized AI, multimodal agents, and neuromorphic architectures.",
                    contentKidsRu = "Поздравляем с окончанием полного курса! Впереди создание великих технологий!",
                    contentAdultsRu = "Портфолио на GitHub и реальные проекты — ключ к международной карьере в индустрии ИИ.",
                    codeSnippet = "# Məzuniyyət Təbriki\nprint('🎓 TƏBRİKLƏR! Siz 30 Modulu Uğurla Tamamlayaraq AI Master Oldunuz! 🌟')",
                    keyTakeawaysAz = listOf(
                        "Sİ sahəsində davamlı öyrənmək və praktika etmək ən vacib vərdişdir",
                        "GitHub-da canlı layihələr diplomdan daha böyük üstünlük verir",
                        "Gələcək Süni İntellekti anlayan və onunla quranlarındır!"
                    )
                )
            )
        )
    )
}

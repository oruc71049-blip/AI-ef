package com.example.data.curriculum

import com.example.data.models.CourseModule
import com.example.data.models.Lesson
import com.example.data.models.QuizOption
import com.example.data.models.QuizQuestion

object Section1Data {
    private const val SEC_NUM = 1
    private const val SEC_TITLE_AZ = "Bölüm 1: Süni İntellektin Əsasları və Rəqəmsal Savadlılıq"
    private const val SEC_TITLE_EN = "Part 1: AI Fundamentals & Digital Literacy"
    private const val SEC_TITLE_RU = "Раздел 1: Основы ИИ и цифровая грамотность"

    val modules: List<CourseModule> = listOf(
        // Modul 1
        CourseModule(
            id = 1,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 1: Süni İntellektə Giriş və Tarixçə",
            titleEn = "Module 1: Introduction to AI & History",
            titleRu = "Модуль 1: Введение в ИИ и история",
            descAz = "Turing testindən müasir dövrə, neyron şəbəkələrə ilkin baxış, etika və rəqəmsal məsuliyyət.",
            descEn = "From the Turing test to modern era, neural network overview, ethics and digital responsibility.",
            descRu = "От теста Тьюринга до наших дней, обзор нейросетей, этика и безопасность.",
            iconEmoji = "🏛️",
            lessons = listOf(
                Lesson(
                    id = "mod1_les1",
                    moduleId = 1,
                    order = 1,
                    titleAz = "Sİ nədir və həyatımızı necə dəyişir? (Turing testindən müasir dövrə)",
                    titleEn = "What is AI & How it Changes Life (From Turing Test to Modern Era)",
                    titleRu = "Что такое ИИ и как он меняет мир (От теста Тьюринга до наших дней)",
                    summaryAz = "Süni İntellektin tərifi, Alan Turing-in 1950-ci il testi, dar (Narrow) və ümumi (AGI) Sİ fərqləri.",
                    summaryEn = "Definition of AI, Turing test, Narrow AI vs AGI.",
                    summaryRu = "Определение ИИ, тест Тьюринга, узкий ИИ и AGI.",
                    contentKidsAz = "Süni İntellekt (Sİ) — kompüterlərin insan kimi düşünməyi, görməyi və qərar verməyi öyrənməsidir! 🤖\n\n1950-ci ildə böyük alim Alan Turing bir sual verdi: 'Maşınlar düşünə bilərmi?'. O, Turing Testini yaratdı: Əgər bir kompüterlə yazışanda onun insan, yoxsa robot olduğunu anlaya bilmirsənsə, deməli o maşın ağıllıdır! Bu gün telefonundakı Siri, YouTube-un sənə sevdiyin videoları göstərməsi məhz Süni İntellektdir.",
                    contentAdultsAz = "Süni İntellekt (Artificial Intelligence) — insan zəkasını təqlid edən alqoritm və sistemlər toplusudur.\n\nƏsas İnkişaf Mərhələləri:\n1. 1950 — Alan Turing 'Computing Machinery and Intelligence' məqaləsində məşhur İmitasiya Oyununu (Turing Test) təklif etdi.\n2. 1956 — Dartmouth Konfransında Con Makkarti ilk dəfə 'Artificial Intelligence' terminini rəsmi işlətdi.\n3. Qaydalara əsaslanan sistemlərdən (Symbolic AI) böyük verilənlər və maşın öyrənməsinə keçid.\n4. Dar Sİ (ANI - Narrow AI): Konkret bir işi görən sistemlər (məsələn şahmat oynamaq, üz tanımaq).\n5. Ümumi Sİ (AGI): İnsan zəkası kimi hər sahədə müstəqil öyrənən gələcək konsept.",
                    contentKidsEn = "AI is how computers learn to think and help us in everyday life like smart games and robots!",
                    contentAdultsEn = "AI encompasses computational models simulating cognitive functions: from Alan Turing's 1950 foundational test to Modern Artificial General Intelligence (AGI) research.",
                    contentKidsRu = "Искусственный интеллект помогает компьютерам понимать мир, узнавать лица и советовать интересные видео!",
                    contentAdultsRu = "Искусственный интеллект прошел путь от символических экспертных систем и теста Тьюринга 1950 года до современных глубоких нейросетей.",
                    codeSnippet = "# Sadə Turing Test Məntiqi\ndef turing_test_check(human_guess, actual_entity):\n    if human_guess != actual_entity:\n        return 'Maşın Turing Testini keçdi! 🎯'\n    return 'İstifadəçi fərqi anladı.'\n\nprint(turing_test_check('İnsan', 'AI_Model'))",
                    keyTakeawaysAz = listOf(
                        "Süni İntellekt insan idrakını təqlid edən hesablama sistemidir",
                        "Turing Testi maşının düşünmə qabiliyyətini yoxlayan ilk meyardır",
                        "Müasir tətbiqlərin hamısı hazırda Dar Sİ (Narrow AI) kateqoriyasındadır"
                    ),
                    quizQuestions = listOf(
                        QuizQuestion(
                            id = 1,
                            questionAz = "Turing Testinin əsas məqsədi nədir?",
                            questionEn = "What is the primary purpose of the Turing Test?",
                            questionRu = "Какова главная цель теста Тьюринга?",
                            options = listOf(
                                QuizOption(0, "Maşının insan kimi intellektual ünsiyyət qura bilməsini yoxlamaq", "To determine if a machine can exhibit human-like intelligence", "Проверить способность машины мыслить как человек"),
                                QuizOption(1, "Prosessorun sürətini ölçmək", "Measure CPU speed", "Измерить скорость процессора"),
                                QuizOption(2, "İnternet bağlantısını yoxlamaq", "Test internet speed", "Проверить интернет"),
                                QuizOption(3, "Kompüterin batareya ömrünü bilmək", "Check battery life", "Проверить батарею")
                            ),
                            correctOptionIndex = 0,
                            explanationAz = "Turing testi kompüterin insanla bərabər dərəcədə təbii ünsiyyət qura bilməsini ölçür.",
                            explanationEn = "The Turing Test benchmarks if a machine can exhibit indistinguishable human conversation.",
                            explanationRu = "Тест Тьюринга определяет способность машины вести неотличимый от человеческого диалог."
                        )
                    )
                ),
                Lesson(
                    id = "mod1_les2",
                    moduleId = 1,
                    order = 2,
                    titleAz = "Neyron şəbəkələrə ilkin baxış",
                    titleEn = "Overview of Neural Networks",
                    titleRu = "Первое знакомство с нейросетями",
                    summaryAz = "Bioloji beyin hüceyrələrindən süni riyazi neyronlara keçid.",
                    summaryEn = "From biological neurons to artificial mathematical perceptrons.",
                    summaryRu = "От биологических нейронов к искусственным перцептронам.",
                    contentKidsAz = "Beynimizdə milyardlarla kiçik qığılcım saçan neyron var! Süni neyron şəbəkəsi də eynilə kompüterin beynində qurulmuş dostlar zənciridir. Bir neyron şəklin rənginə baxır, o biri formasına baxır, axırda birləşib 'Bu sevimli pişikdir!' deyirlər. 🐱",
                    contentAdultsAz = "Süni Neyron Şəbəkələri (ANN) insan beyninin bioloji neyronlarından ilhamlanmış riyazi modellərdir.\n\nƏsas komponentlər:\n1. Giriş qatı (Input Layer): Piksellər, rəqəmlər və ya sözlər daxil olur.\n2. Gizli qatlar (Hidden Layers): Çəkilər (Weights) və meyllər (Biases) vasitəsilə mürəkkəb xüsusiyyətlər aşkarlanır.\n3. Çıxış qatı (Output Layer): Yekun təsnifat və ya ehtimal proqnozu verilir.\n4. Aktivasiya funksiyası: Qeyri-xətti əlaqələri modelləşdirmək üçün istifadə olunur (məs. ReLU, Sigmoid).",
                    contentKidsEn = "Neural networks work like a team of detectives piecing together clues to solve puzzles!",
                    contentAdultsEn = "ANNs map inputs to outputs via layered linear transformations followed by non-linear activation functions.",
                    contentKidsRu = "Нейросеть устроена как цепочка друзей, которые по очереди передают и проверяют информацию!",
                    contentAdultsRu = "Искусственные нейросети состоят из входного, скрытых и выходного слоев, настраивая веса для решения задач.",
                    codeSnippet = "# Sadə süni neyron\ndef artificial_neuron(inputs, weights, bias):\n    total = sum(i * w for i, w in zip(inputs, weights)) + bias\n    return 1 if total > 0 else 0\n\nprint('Neyron Aktivləşməsi:', artificial_neuron([1.0, 0.5], [0.8, -0.4], 0.1))",
                    keyTakeawaysAz = listOf(
                        "Süni neyron girişləri çəkilərə vurur və meyl (bias) əlavə edir",
                        "Gizli laylar dərin xüsusiyyətləri aşkar edir",
                        "Dərin öyrənmə məhz çoxsaylı gizli laylardan ibarət şəbəkələrdir"
                    )
                ),
                Lesson(
                    id = "mod1_les3",
                    moduleId = 1,
                    order = 3,
                    titleAz = "Etika, təhlükəsizlik və rəqəmsal məsuliyyət",
                    titleEn = "AI Ethics, Safety & Digital Responsibility",
                    titleRu = "Этика ИИ, безопасность и цифровая ответственность",
                    summaryAz = "Qərəzlilik (Bias), şəxsi məlumatların qorunması, Deepfake təhlükələri və məsuliyyətli Sİ.",
                    summaryEn = "Algorithmic bias, privacy, deepfakes, and ethical AI stewardship.",
                    summaryRu = "Алгоритмическая предвзятость, приватность данных, дипфейки и этика.",
                    contentKidsAz = "Süni İntellekt böyük bir super-gücdür! 🦸 Amma super-qəhrəmanlar hər zaman məsuliyyətli olmalıdır. Sİ-dən başqalarını aldatmaq, saxta videolar (deepfake) düzəltmək və ya başqasının şəxsi sirrini yaymaq üçün istifadə etmək olmaz. Həmişə yaxşılıq və öyrənmək üçün istifadə etməliyik!",
                    contentAdultsAz = "Süni İntellekt Etikası dörd əsas sütun üzərində qurulur:\n\n1. Qərəzsizlik (Fairness & Anti-Bias): Təlim datasındakı sosial və irqi qərəzlərin modellərə keçməsinin qarşısını almaq.\n2. Şəffaflıq və İzaholunma (Explainable AI - XAI): Modelin niyə bu qərarı verdiyini izah edə bilməsi.\n3. Məlumat Məxfiliyi (Data Privacy & GDPR): İstifadəçi məlumatlarının icazəsiz model təlimində istifadəsinin yolverilməzliyi.\n4. Süni Media və Deepfake Təhlükəsizliyi: C2PA və rəqəmsal su nişanları (Watermarking) ilə saxta kontentin qarşısının alınması.",
                    contentKidsEn = "Always use AI to create good things, never to cheat or spread fake news!",
                    contentAdultsEn = "Ethical AI mandates algorithmic transparency, bias mitigation, robust data privacy, and mitigation of deepfakes.",
                    contentKidsRu = "ИИ — мощный инструмент, который нужно использовать ответственно и честно!",
                    contentAdultsRu = "Этика ИИ требует прозрачности решений, защиты персональных данных и борьбы с дипфейками.",
                    codeSnippet = "# Etik Qərəzlilik Yoxlaması Simulyasiyası\ndef fairness_audit(selection_rate_group_a, selection_rate_group_b):\n    disparity = abs(selection_rate_group_a - selection_rate_group_b)\n    return 'Qərəzsiz' if disparity < 0.05 else 'Qərəzlilik Riski Aşkarladı ⚠️'\n\nprint(fairness_audit(0.85, 0.83))",
                    keyTakeawaysAz = listOf(
                        "AI modelləri təlim edildiyi məlumatlardakı qərəzləri təkrarlaya bilər",
                        "Deepfake və saxta kontentə qarşı rəqəmsal savadlılıq vacibdir",
                        "Məlumatların məxfiliyi qanunla qorunmalıdır"
                    )
                )
            )
        ),

        // Modul 2
        CourseModule(
            id = 2,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 2: Prompt Mühəndisliyinin Sənəti və Elmi",
            titleEn = "Module 2: The Art & Science of Prompt Engineering",
            titleRu = "Модуль 2: Искусство и наука промпт-инжиниринга",
            descAz = "ChatGPT, Claude və Gemini ilə işləməyin incəlikləri, Rol-oyun, Chain of Thought və prompt zəncirləri.",
            descEn = "ChatGPT, Claude, Gemini intricacies, Role-play, Chain of Thought, and complex prompt chaining.",
            descRu = "Тонкости работы с ChatGPT, Claude и Gemini, Chain of Thought и цепочки промптов.",
            iconEmoji = "🪄",
            lessons = listOf(
                Lesson(
                    id = "mod2_les1",
                    moduleId = 2,
                    order = 1,
                    titleAz = "ChatGPT, Claude və Gemini ilə işləməyin incəlikləri",
                    titleEn = "Working with ChatGPT, Claude & Gemini",
                    titleRu = "Тонкости работы с ChatGPT, Claude и Gemini",
                    summaryAz = "LLM modellərinin fərqləri, kontekst pəncərəsi (Context Window) və effektiv sorğu strukturu.",
                    summaryEn = "Differences between LLMs, context windows, and effective prompt architecture.",
                    summaryRu = "Различия LLM, контекстное окно и эффективная структура промпта.",
                    contentKidsAz = "Prompt — Sİ-yə verdiyin sehrli göstərişdir! 🪄 Əgər robota sadəcə 'Hekayə yaz' desən, o adi bir şey yazacaq. Amma desən ki: 'Sən kosmik səyahətçisən, Marsda yaşayan sevimli robot haqqında 3 cümləlik gülməli hekayə yaz', o sənə möhtəşəm cavab verəcək!",
                    contentAdultsAz = "Prompt Mühəndisliyi — Böyük Dil Modellərindən (LLM) ən dəqiq və keyfiyyətli nəticə almaq üçün təlimatların strukturlaşdırılması elmidir.\n\nƏsas Modellərin Güclü Tərəfləri:\n- Gemini: Multimodal qabiliyyət, Google axtarış və böyük kontekst pəncərəsi (1M+ token).\n- Claude: Məntiqi arqumentasiya, uzun analitik mətnlər və kod yazımı.\n- GPT-4o: Geniş ümumi bilik və sürətli interaktiv cavablar.\n\nEffektiv Promptun 4 Əsas Elementi:\n1. Rol (Role): 'Sən baş AI memarısan...'\n2. Məzmun və Kontekst (Context): 'Müştərimiz üçün mobil tətbiq qururuq...'\n3. Tapşırıq (Task): '3 səhifəlik arxitektura planı hazırla...'\n4. Məhdudiyyət və Format (Constraints): 'Cədvəl şəklində və texniki terminlərlə yaz.'",
                    contentKidsEn = "A prompt is like a clear instruction you give to an assistant robot!",
                    contentAdultsEn = "Structured prompt engineering involves Role, Context, Task, and Constraints, leveraging model-specific capabilities.",
                    contentKidsRu = "Промпт — это четкая и понятная инструкция для искусственного интеллекта!",
                    contentAdultsRu = "Промпт-инжиниринг оптимизирует запросы к LLM через контекст, роль, задачу и форматирование вывода.",
                    codeSnippet = "# Strukturlaşdırılmış Prompt Nümunəsi\nsystem_prompt = '''\nROL: Təcrübəli Data Scientist\nKONTEKST: Yeni başlayan tələbələr üçün seminar\nTAPŞIRIQ: 'Overfitting' anlayışını 3 bənddə izah et\nFORMAT: Markdown bəndləri və real həyat nümunəsi\n'''\nprint(system_prompt)",
                    keyTakeawaysAz = listOf(
                        "Prompt nə qədər detallı və aydın olarsa, cavab o qədər dəqiq olar",
                        "Rol, kontekst, tapşırıq və format açar sütunlardır",
                        "Gemini, Claude və GPT müxtəlif tapşırıqlarda fərqli üstünlüklərə malikdir"
                    )
                ),
                Lesson(
                    id = "mod2_les2",
                    moduleId = 2,
                    order = 2,
                    titleAz = "Rol-oyun və zəncirvari düşüncə (Chain of Thought) promptları",
                    titleEn = "Role-Play & Chain of Thought (CoT) Prompting",
                    titleRu = "Ролевые промпты и цепочка рассуждений (Chain of Thought)",
                    summaryAz = "Düşüncə zənciri (CoT), Few-Shot öyrənmə və personaj rolları ilə mürəkkəb məsələlərin həlli.",
                    summaryEn = "Chain of Thought, Few-Shot learning, and persona conditioning.",
                    summaryRu = "Метод Chain of Thought, Few-Shot обучение и ролевое моделирование.",
                    contentKidsAz = "Çətin bir riyaziyyat məsələsini həll edəndə necə addım-addım düşünürsən? Sİ-yə də 'Gəl addım-addım düşünək' dedikdə o heç vaxt tələsmir və səhv etmir! 🧠",
                    contentAdultsAz = "Qabaqcıl Prompt Texnikaları:\n\n1. Chain of Thought (CoT): Modelə 'Let's think step by step' təlimatı verməklə məntiqi ardıcıllığı təmin etmək və halüsinasiyanı kəskin azaltmaq.\n2. Few-Shot Prompting: Modelə tapşırıqdan əvvəl 2-3 nümunə (Giriş -> Çıxış) vermək.\n3. Rol-Oyun (Persona Conditioning): Modelə müəyyən bir mütəxəssis şəxsiyyəti (məs. Kibertəhlükəsizlik Auditoru) verərək cavabın tonunu və dərinliyini tənzimləmək.\n4. ReAct (Reasoning + Acting): Modelin əvvəlcə düşünməsi, sonra hərəkət etməsi prinsipi.",
                    contentKidsEn = "Step-by-step thinking helps AI solve big problems accurately!",
                    contentAdultsEn = "Chain of Thought (CoT) and Few-Shot conditioning substantially improve multi-step reasoning accuracy.",
                    contentKidsRu = "Пошаговое рассуждение позволяет ИИ избегать ошибок в сложных задачах!",
                    contentAdultsRu = "Метод Chain of Thought стимулирует последовательные логические выкладки перед выводом ответа.",
                    codeSnippet = "cot_prompt = '''\nMəsələ: Əgər mağazada 15 alma varsa, 4-ü satıldı və 3-ü xarab oldu, neçə alma qaldı?\nAddım-addım həll:\n1) İlkin say = 15\n2) Satılan = 4 -> Qaldı: 15 - 4 = 11\n3) Xarab olan = 3 -> Qaldı: 11 - 3 = 8\nYekun cavab: 8 alma.\n'''\nprint(cot_prompt)",
                    keyTakeawaysAz = listOf(
                        "Zəncirvari düşüncə (CoT) mürəkkəb məntiqi suallarda dəqiqliyi 40%+ artırır",
                        "Nümunələr vermək (Few-Shot) modelin çıxış formatını dəqiq sabitləyir",
                        "Addım-addım izah səhvlərin aşkarlanmasını asanlaşdırır"
                    )
                ),
                Lesson(
                    id = "mod2_les3",
                    moduleId = 2,
                    order = 3,
                    titleAz = "Kompleks məsələlərin həlli üçün prompt zəncirləri",
                    titleEn = "Prompt Chaining for Complex Problems",
                    titleRu = "Цепочки промптов для комплексных задач",
                    summaryAz = "Böyük tapşırıqları alt-mərhələlərə bölərək bir çıxışı digərinin girişinə yönləndirmək.",
                    summaryEn = "Decomposing multi-phase tasks into chained pipelines.",
                    summaryRu = "Разбиение масштабных задач на последовательные цепочки промптов.",
                    contentKidsAz = "Böyük bir qala tikmək istəyəndə əvvəlcə təməlini qoyursan, sonra divarları, ən axırda bayrağı sancırsan! Prompt zənciri də böyük işləri belə asanlaşdırır! 🏰",
                    contentAdultsAz = "Prompt Chaining (Zəncirvari Sorğular) — bir promptun çıxışını növbəti prompt üçün giriş kimi istifadə edən avtomatlaşdırılmış boru xəttidir (pipeline).\n\nMərhələlər:\n1. Mərhələ 1 (Beyin Fırtınası): Mövzu üzrə 5 innovativ ideya yarat.\n2. Mərhələ 2 (Filtrasiya): İdeyalar arasından texniki cəhətdən ən uyğun 1 dənəsini seç.\n3. Mərhələ 3 (Struktur): Seçilən ideyanın texniki arxitekturasını yaz.\n4. Mərhələ 4 (Tənqid və Yoxlama): Arxitekturadakı 3 zəif nöqtəni tap və təkmilləşdir.",
                    contentKidsEn = "Prompt chains break huge goals into friendly little steps!",
                    contentAdultsEn = "Prompt chaining executes complex workflows sequentially, feeding outputs into downstream prompts.",
                    contentKidsRu = "Цепочки промптов превращают сложные задачи в цепочку понятных шагов!",
                    contentAdultsRu = "Пайплайны из промптов передают результаты одного шага на вход следующему для надежной генерации.",
                    codeSnippet = "pipeline = [\n    'Addım 1: Xülasə çıxar',\n    'Addım 2: Açar sözləri tap',\n    'Addım 3: Sosial media postuna çevir'\n]\nprint(' -> '.join(pipeline))",
                    keyTakeawaysAz = listOf(
                        "Tək bir böyük prompt yerinə bir neçə kiçik zəncirvari prompt daha stabil işləyir",
                        "Hər addımda nəticəni tənqid və redaktə etmək mümkündür",
                        "AI Agentlərinin iş prinsipi prompt zəncirləri üzərində qurulub"
                    )
                )
            )
        ),

        // Modul 3
        CourseModule(
            id = 3,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 3: Sİ ilə Mətn və Kontent Yaradılması",
            titleEn = "Module 3: Text & Content Generation with AI",
            titleRu = "Модуль 3: Создание текста и контента с помощью ИИ",
            descAz = "Məqalə, hekayə, skript və marketinq mətnləri, tərcümə, redaktə, üslub və analitik təhlil.",
            descEn = "Articles, stories, marketing copy, translation, editing, style transfer, and analytical text review.",
            descRu = "Статьи, сценарии, маркетинг, перевод, редактура и аналитический анализ текстов.",
            iconEmoji = "✍️",
            lessons = listOf(
                Lesson(
                    id = "mod3_les1",
                    moduleId = 3,
                    order = 1,
                    titleAz = "Məqalə, hekayə, skript və marketinq mətnlərinin yazılması",
                    titleEn = "Writing Articles, Stories, Scripts & Marketing Copy",
                    titleRu = "Написание статей, историй, сценариев и маркетинговых текстов",
                    summaryAz = "AIDA və PAS marketinq modelləri, hekayə quruculuğu və cəlbedici başlıqlar.",
                    summaryEn = "AIDA and PAS marketing frameworks, narrative structuring, and compelling copy.",
                    summaryRu = "Маркетинговые модели AIDA и PAS, сторителлинг и продающие тексты.",
                    contentKidsAz = "Sİ ilə sən nağıllar yaza, komikslər üçün qəhrəmanlar uydura və maraqlı video ssenariləri qura bilərsən! 📖",
                    contentAdultsAz = "Sİ ilə peşəkar mətn yaradılmasında istifadə olunan formullar:\n- AIDA Modeli: Attention (Diqqət) -> Interest (Maraq) -> Desire (Arzu) -> Action (Hərəkət).\n- PAS Modeli: Problem (Problem) -> Agitate (Gərginləşdirmə) -> Solution (Həll).\n- SEO Məqalə Strukturu: H1, H2 alt başlıqları, açar sözlərin təbii paylanması və oxunaqlılıq indeksi.",
                    contentKidsEn = "Unleash your creativity by writing magical stories and scripts with AI!",
                    contentAdultsEn = "Leverage proven copy frameworks like AIDA and PAS to generate high-converting articles and scripts.",
                    contentKidsRu = "Создавай увлекательные истории и сценарии вместе с искусственным интеллектом!",
                    contentAdultsRu = "Используйте проверенные копирайтинг-фреймворки AIDA и PAS для генерации текстов.",
                    codeSnippet = "copy_framework = 'AIDA: Diqqət çək -> Maraq yarat -> Arzu oyat -> Fəaliyyətə çağır'\nprint(copy_framework)",
                    keyTakeawaysAz = listOf(
                        "Marketinq mətnlərində konkret çərçivələrdən (AIDA, PAS) istifadə edin",
                        "Hədəf auditoriyanın dilinə və maraqlarına uyğun ton seçin",
                        "Sİ-nin yaratdığı mətnləri həmişə insan faktoru ilə redaktə edin"
                    )
                ),
                Lesson(
                    id = "mod3_les2",
                    moduleId = 3,
                    order = 2,
                    titleAz = "Sİ ilə tərcümə, redaktə və üslub dəyişikliyi",
                    titleEn = "AI Translation, Editing & Style Transfer",
                    titleRu = "Перевод, редактура и адаптация стиля с помощью ИИ",
                    summaryAz = "Mətnin rəsmi, akademik, bədii və ya yumoristik üsluba çevrilməsi.",
                    summaryEn = "Transforming texts across formal, academic, creative, and humorous styles.",
                    summaryRu = "Адаптация тональности текста под деловой, научный или творческий стиль.",
                    contentKidsAz = "Eyni cümləni həm bir kral kimi ciddiyyətlə, həm də bir pirat kimi zarafatla dedirtmək olar! 🏴‍☠️👑",
                    contentAdultsAz = "Üslub Transferi (Style Transfer) — mətndəki faktiki məzmunu saxlayaraq onun leksik və qrammatik tonunu dəyişdirməkdir. Məsələn: Mürəkkəb tibbi hesabatı 12 yaşlı uşağın anlayacağı sadə dildə xülasə etmək.",
                    contentKidsEn = "Turn simple words into pirate talk or royal speeches instantly!",
                    contentAdultsEn = "Style transfer adapts syntactic and tonal registers while strictly preserving core factual content.",
                    contentKidsRu = "Меняй стиль любого текста: от научного до разговорного за секунды!",
                    contentAdultsRu = "Перевод и стилизация сохраняют смысловую нагрузку при смене регистра общения.",
                    codeSnippet = "tone_prompt = 'Bu rəsmi qanun mətnini sadə və aydın xalq dilinə çevir.'\nprint(tone_prompt)",
                    keyTakeawaysAz = listOf(
                        "Sİ sadəcə tərcümə etmir, həm də kontekst və mədəni çalarları uyğunlaşdırır",
                        "Üslub dəyişməsi mürəkkəb elmi biliklərin asan mənimsənilməsini təmin edir",
                        "Grammar və orfoqrafiya yoxlamasında LLM-lər ən yüksək dəqiqliyə malikdir"
                    )
                ),
                Lesson(
                    id = "mod3_les3",
                    moduleId = 3,
                    order = 3,
                    titleAz = "Korrektə və analitik mətn təhlili",
                    titleEn = "Proofreading & Analytical Text Review",
                    titleRu = "Корректура и аналитический разбор текстов",
                    summaryAz = "Məntiqi ziddiyyətlərin aşkarlanması, arqumentasiya gücü və xülasələndirmə.",
                    summaryEn = "Detecting logical fallacies, argumentative strength, and executive summarization.",
                    summaryRu = "Поиск логических противоречий, анализ аргументов и саммаризация.",
                    contentKidsAz = "Yazdığın inşanı Sİ-yə göstər, o sənə harada hərfi səhv etdiyini və hansı cümləni daha gözəl edə biləcəyini göstərsin! 🔍",
                    contentAdultsAz = "Analitik Mətn Təhlili metodları:\n1. Ekstraktiv və Abstraktiv Xülasələndirmə (Summarization).\n2. Məntiqi ziddiyyətlərin və boşluqların (Logical fallacies) aşkarlanması.\n3. Fakt yoxlaması (Fact-checking) və istinadların düzgünlüyü.",
                    contentKidsEn = "Let AI be your friendly homework editor and grammar helper!",
                    contentAdultsEn = "Analytical text evaluation identifies cognitive biases, structural weak spots, and summarizes key insights.",
                    contentKidsRu = "Используй ИИ как персонального корректора и редактора!",
                    contentAdultsRu = "Аналитический разбор выявляет логические несоответствия и формирует выжимки.",
                    codeSnippet = "review_prompt = 'Bu mətndəki 3 ən zəif arqumenti tap və necə gücləndirəcəyimi göstər.'\nprint(review_prompt)",
                    keyTakeawaysAz = listOf(
                        "Korrektə zamanı təkcə orfoqrafiya deyil, cümlə axını və ritmi də yaxşılaşır",
                        "Xülasələndirmə vaxta 80%-dək qənaət etməyə imkan verir",
                        "Tənqidi təhlil arqumentlərin inandırıcılığını artırır"
                    )
                )
            )
        ),

        // Modul 4
        CourseModule(
            id = 4,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 4: Vizual Sİ və Şəkil Generasiyası",
            titleEn = "Module 4: Visual AI & Image Generation",
            titleRu = "Модуль 4: Визуальный ИИ и генерация изображений",
            descAz = "Midjourney, DALL-E və Stable Diffusion əsasları, professional vizual promptlar, inpainting və outpainting.",
            descEn = "Midjourney, DALL-E, Stable Diffusion, professional visual prompting, inpainting and outpainting.",
            descRu = "Основы Midjourney, DALL-E и Stable Diffusion, промпты для артов, inpainting и outpainting.",
            iconEmoji = "🎨",
            lessons = listOf(
                Lesson(
                    id = "mod4_les1",
                    moduleId = 4,
                    order = 1,
                    titleAz = "Midjourney, DALL-E və Stable Diffusion əsasları",
                    titleEn = "Foundations of Midjourney, DALL-E & Stable Diffusion",
                    titleRu = "Основы Midjourney, DALL-E и Stable Diffusion",
                    summaryAz = "Diffuziya modellərinin (Diffusion Models) iş prinsipi və mətndən şəkil yaradılması.",
                    summaryEn = "Diffusion models, denoising process, and text-to-image synthesis.",
                    summaryRu = "Принцип работы диффузионных моделей и синтез картинок по тексту.",
                    contentKidsAz = "Diffuziya modeli sehrli bir rəssam kimidir! 🎨 O, əvvəlcə ekrandakı rəngli qığılcımları və nöqtələri (səs-küyü) görür, sonra addım-addım təmizləyərək sənin istədiyin möhtəşəm rəsmi çəkir!",
                    contentAdultsAz = "Diffuziya Modelləri (Diffusion Models) iki mərhələdən ibarətdir:\n1. İrəli Diffuziya (Forward Diffusion): Şəkilə tədricən Qauss səs-küyü (Gaussian Noise) əlavə edilir.\n2. Əks Diffuziya (Reverse Denoising): Neyron şəbəkə həmin səs-küyü mətn təsviri (CLIP / T5 Embeddings) əsasında addım-addım təmizləyərək yeni və unikal görüntü yaradır.",
                    contentKidsEn = "AI cleans up colorful pixels step by step to create your dream masterpiece!",
                    contentAdultsEn = "Diffusion models iteratively denoise latent representations guided by multimodal text embeddings.",
                    contentKidsRu = "Диффузионные нейросети превращают цифровой шум в детализированные картины!",
                    contentAdultsRu = "Диффузионный процесс восстанавливает осмысленное изображение из гауссова шума.",
                    codeSnippet = "diffusion_steps = 'Səs-küy əlavə et -> Mətnlə yönləndir -> Təmizlə -> Şəkil hazırdır!'\nprint(diffusion_steps)",
                    keyTakeawaysAz = listOf(
                        "Diffuziya modelləri mətndən şəkil generasiyasının əsas texnologiyasıdır",
                        "Midjourney bədii keyfiyyət, DALL-E dəqiqlik, Stable Diffusion isə açıq mənbəli idarəetmə üstünlüyünə malikdir",
                        "CLIP modeli mətn ilə şəkil arasındakı semantik körpünü qurur"
                    )
                ),
                Lesson(
                    id = "mod4_les2",
                    moduleId = 4,
                    order = 2,
                    titleAz = "Professional vizuallar, dizaynlar və rəsm promptları yazmaq",
                    titleEn = "Crafting Professional Visuals & Art Prompts",
                    titleRu = "Создание профессиональных визуалов и арт-промптов",
                    summaryAz = "Kamera bucaqları, işıqlandırma, sənət üslubları və parametr tənzimləmələri.",
                    summaryEn = "Camera angles, lighting, artistic styles, and aspect ratio parameters.",
                    summaryRu = "Параметры освещения, ракурсы камеры, художественные стили и соотношение сторон.",
                    contentKidsAz = "Rəsm promptunda rəngləri, işığı (məsələn gün batımı 🌅) və hansı cizgi filmi stilində olacağını desən, şəkil bir o qədər möcüzəli olar!",
                    contentAdultsAz = "Professional Vizual Promptun Anatomiyası:\n1. Əsas Mövzu (Subject): 'Cyberpunk humanoid robot'\n2. Mühit və Fon (Environment): 'Neon-lit futuristic Tokyo street, rain reflections'\n3. İşıqlandırma (Lighting): 'Volumetric cinematic rim lighting, golden hour'\n4. Kamera və Texnika (Camera): '85mm lens, f/1.4 depth of field, 8k octane render'\n5. Parametrlər: '--ar 16:9 --v 6.0 --style raw'",
                    contentKidsEn = "Add cinematic lighting and vivid colors to your image prompts for epic results!",
                    contentAdultsEn = "Visual prompting demands precise specification of subject, setting, lighting, focal depth, and render engine aesthetics.",
                    contentKidsRu = "Описывай освещение, ракурс и стиль для создания кинематографичных артов!",
                    contentAdultsRu = "Структурированный промпт для артов включает свет, оптику, окружение и стилевые модификаторы.",
                    codeSnippet = "midjourney_prompt = '/imagine prompt: futuristic robotic teacher in glass classroom, volumetric lighting, unreal engine 5, 8k --ar 16:9'\nprint(midjourney_prompt)",
                    keyTakeawaysAz = listOf(
                        "İşıqlandırma və kamera detalları vizualın keyfiyyətini kəskin artırır",
                        "Mənfi promptlar (Negative Prompts) arzuolunmaz detalları təmizləyir",
                        "Aspekt nisbəti (--ar) platformaya uyğun seçilməlidir (məs. 9:16 Reels üçün)"
                    )
                ),
                Lesson(
                    id = "mod4_les3",
                    moduleId = 4,
                    order = 3,
                    titleAz = "Şəkillərin redaktəsi və Sİ ilə genişləndirilməsi (Inpainting/Outpainting)",
                    titleEn = "Image Editing & Expansion (Inpainting / Outpainting)",
                    titleRu = "Редактирование и расширение изображений (Inpainting / Outpainting)",
                    summaryAz = "Mövcud şəklin daxilini dəyişdirmək (Inpainting) və kənarlarını genişləndirmək (Outpainting).",
                    summaryEn = "Modifying internal regions (inpainting) and extending canvas boundaries (outpainting).",
                    summaryRu = "Замена деталей на изображении (inpainting) и расширение границ холста (outpainting).",
                    contentKidsAz = "Təsəvvür et ki, çəkdiyin şəkildəki pişiyin başına sehrli şlyapa qoymaq istəyirsən! Inpainting ilə şəkli pozmadan sadəcə istədiyin yeri dəyişə bilərsən! 🎩",
                    contentAdultsAz = "Qabaqcıl Vizual Sİ Texnologiyaları:\n- Inpainting: Şəklin müəyyən bir maskalanmış sahəsini kontekstə uyğun yeni obyektlə əvəz etmək.\n- Outpainting: Şəklin sərhədlərindən kənara çıxaraq ətraf mənzərəni tam tamamlamaq.\n- ControlNet: Şəklin pozasını (pose), dərinlik xəritəsini (depth map) və xətlərini (canny edge) dəqiq qorumaq.",
                    contentKidsEn = "Inpainting lets you swap objects seamlessly like magic scissors and glue!",
                    contentAdultsEn = "Inpainting and Outpainting leverage masked latent diffusion to modify or extend canvases without stylistic rupture.",
                    contentKidsRu = "Inpainting и outpainting позволяют бесшовно редактировать и дорисовывать любые изображения!",
                    contentAdultsRu = "Маскированная диффузия позволяет точечно редактировать объекты и достраивать фон.",
                    codeSnippet = "edit_pipeline = 'Maskala -> Yeni prompt yaz -> Sİ kontekstə uyğun birləşdirsin'\nprint(edit_pipeline)",
                    keyTakeawaysAz = listOf(
                        "Inpainting orijinal üslubu qoruyaraq elementləri dəyişdirir",
                        "Outpainting kətanı istənilən istiqamətə genişləndirir",
                        "ControlNet obrazın pozasını və proporsiyalarını sabit saxlayır"
                    )
                )
            )
        ),

        // Modul 5
        CourseModule(
            id = 5,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 5: Səs, Musiqi və Video İstehsalı",
            titleEn = "Module 5: Audio, Music & Video Generation",
            titleRu = "Модуль 5: Генерация аудио, музыки и видео",
            descAz = "Səs klonlanması və səsləndirmə (Voiceover), musiqi və səs effektləri, Sİ video generatorları ilə qısa kliplər.",
            descEn = "Voice cloning, realistic voiceovers, AI music synthesis, and text-to-video clip generation.",
            descRu = "Клонирование голоса, озвучка, генерация музыки и видеороликов с помощью ИИ.",
            iconEmoji = "🎬",
            lessons = listOf(
                Lesson(
                    id = "mod5_les1",
                    moduleId = 5,
                    order = 1,
                    titleAz = "Sİ vasitəsilə səs klonlanması və səsləndirmə (Voiceover)",
                    titleEn = "AI Voice Cloning & Voiceovers",
                    titleRu = "Клонирование голоса и озвучка с помощью ИИ",
                    summaryAz = "ElevenLabs kimi neyron TTS modelləri, emosional səs tonları və səs klonlama texnologiyası.",
                    summaryEn = "Neural TTS systems, ElevenLabs, emotional inflection, and zero-shot voice cloning.",
                    summaryRu = "Нейросетевой TTS, ElevenLabs, эмоциональная выразительность и клонирование голоса.",
                    contentKidsAz = "Sİ bir neçə saniyəlik səs qeydinə qulaq asaraq sevimli cizgi film qəhrəmanının səsi ilə nağıllar oxuya bilər! 🎙️",
                    contentAdultsAz = "Neyron Səs Sintezi (Neural Text-to-Speech) və Səs Klonlanması:\n1. Zero-shot Voice Cloning: Cəmi 10-30 saniyəlik audio nümunəsindən tembr və intonasiyanın çıxarılması.\n2. Fonem və Spektroqram analizi: Mətnin akustik dalğalara (Mel-Spectrogram) çevrilməsi və Vocoder vasitəsilə təbii səsə çevrilməsi.\n3. Emosional tənzimləmə: Həyəcan, kədər, rəsmiyyət dərəcəsinin idarə olunması.",
                    contentKidsEn = "AI can read stories using super fun character voices in seconds!",
                    contentAdultsEn = "Neural TTS converts text into mel-spectrograms synthesized via vocoders with customizable prosody.",
                    contentKidsRu = "ИИ способен озвучивать любой текст голосами любимых персонажей!",
                    contentAdultsRu = "Нейросети синтезируют естественную речь с передачей интонаций и тембра.",
                    codeSnippet = "# TTS Parametrləri\ntts_config = {'stability': 0.75, 'similarity_boost': 0.85, 'style': 0.4}\nprint('Səs Tənzimləmələri:', tts_config)",
                    keyTakeawaysAz = listOf(
                        "Müasir Sİ insan səsindən fərqlənməyən nitq yaradır",
                        "Səs klonlanmasından istifadə edərkən şəxsin razılığı mütləqdir (Etik qayda)",
                        "Çoxdilli modellər eyni səsi xarici dillərdə də danışdıra bilir"
                    )
                ),
                Lesson(
                    id = "mod5_les2",
                    moduleId = 5,
                    order = 2,
                    titleAz = "Musiqi və səs effektlərinin yaradılması",
                    titleEn = "AI Music & Sound FX Synthesis",
                    titleRu = "Генерация музыки и звуковых эффектов с помощью ИИ",
                    summaryAz = "Suno və Udio platformaları, janrlar, alətlər və vokallı tam mahnıların bəstələnməsi.",
                    summaryEn = "Suno, Udio, genre blending, instrumentation, and complete vocal song generation.",
                    summaryRu = "Создание треков на Suno и Udio, смешение жанров и вокал.",
                    contentKidsAz = "Sən sadəcə 'Kainatda uçan balaca ulduz haqqında şən mahnı' yazırsan və Sİ saniyələr içində əsl musiqi bəstələyir! 🎵",
                    contentAdultsAz = "Generativ Musiqi Modelləri (Suno, Udio, MusicLM):\n- Mətndən musiqiyə (Text-to-Music): Janr, BPM (temp), alət tərkibi və əhval-ruhiyyənin təyini.\n- Vokal və söz inteqrasiyası: Bənd, nəqarət (Verse, Chorus, Bridge) strukturlarının harmonik sintezi.\n- Səs effektləri (SFX): Oyunlar və filmlər üçün unikal atmosfer səsləri.",
                    contentKidsEn = "Write your own songs and let AI compose the background beat and vocals!",
                    contentAdultsEn = "Audio transformers generate multi-track audio compositions with coherent harmonic structures and vocals.",
                    contentKidsRu = "Сочиняй полноценные песни и биты с помощью текстовых подсказок!",
                    contentAdultsRu = "Генераторы музыки создают треки с вокалом, ударными и гармонией по текстовому описанию.",
                    codeSnippet = "song_prompt = '[Verse 1] Neon işıqlar altında gələcəyi yazırıq... [Chorus] AI ilə zirvələrə doğru!'\nprint(song_prompt)",
                    keyTakeawaysAz = listOf(
                        "Suno və Udio peşəkar studiya keyfiyyətində mahnılar bəstələyir",
                        "Promptda janr (məs. Synthwave, Rock) və struktur qeyd olunmalıdır",
                        "Kontent istehsalında müəllif hüququsuz musiqi ehtiyacını tam ödəyir"
                    )
                ),
                Lesson(
                    id = "mod5_les3",
                    moduleId = 5,
                    order = 3,
                    titleAz = "Sİ video generatorları ilə qısa kliplərin hazırlanması",
                    titleEn = "Short Video Clips with AI Video Generators",
                    titleRu = "Создание видеороликов с помощью видеогенераторов ИИ",
                    summaryAz = "Runway Gen-3, Luma Dream Machine, Kling və Sora ilə mətndən video istehsalı.",
                    summaryEn = "Runway Gen-3, Luma, Kling, and Sora text-to-video dynamics and motion control.",
                    summaryRu = "Генерация видео на Runway Gen-3, Luma, Kling и Sora, контроль движения камеры.",
                    contentKidsAz = "Sənin xəyal etdiyin şəkillər artıq hərəkət edir və əsl cizgi filminə çevrilir! 🎥",
                    contentAdultsAz = "Video Generasiya Modellərinin Əsasları:\n- Text-to-Video və Image-to-Video: Statik görüntünü fizika qanunlarına uyğun dinamik hərəkətə gətirmək.\n- Kamera Hərəkətləri: Pan, Tilt, Zoom, Orbit və dinamik sürət tənzimləmələri.\n- Ardıcıllıq və Davamlılıq (Temporal Consistency): Kadrlar arasında obyektin formasının sabit qalması.",
                    contentKidsEn = "Turn your imagination into real moving movie clips with AI!",
                    contentAdultsEn = "Video diffusion models maintain temporal coherence across frames with simulated physical dynamics.",
                    contentKidsRu = "Оживляй статичные картинки и создавай кинематографичные видеоролики!",
                    contentAdultsRu = "Диффузионные видеомодели рассчитывают траектории движения объектов и камеры.",
                    codeSnippet = "video_prompt = 'Cinematic drone shot moving forward over futuristic smart city, 4k, smooth 60fps'\nprint(video_prompt)",
                    keyTakeawaysAz = listOf(
                        "Image-to-Video mətndən video yaratmaqdan daha sabit nəticə verir",
                        "Kamera hərəkət parametrləri peşəkar kinematoqrafik effekt qatır",
                        "Sora və Kling kimi yeni modellər fiziki dünyanı daha dərindən simulyasiya edir"
                    )
                )
            )
        )
    )
}

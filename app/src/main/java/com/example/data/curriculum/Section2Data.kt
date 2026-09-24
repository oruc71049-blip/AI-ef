package com.example.data.curriculum

import com.example.data.models.CourseModule
import com.example.data.models.Lesson
import com.example.data.models.QuizOption
import com.example.data.models.QuizQuestion

object Section2Data {
    private const val SEC_NUM = 2
    private const val SEC_TITLE_AZ = "Bölüm 2: Proqramlaşdırma və Məlumat Elmi Təməlləri"
    private const val SEC_TITLE_EN = "Part 2: Programming & Data Science Foundations"
    private const val SEC_TITLE_RU = "Раздел 2: Программирование и основы науки о данных"

    val modules: List<CourseModule> = listOf(
        // Modul 6
        CourseModule(
            id = 6,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 6: Python-a Giriş (Sİ üçün İlk Addım)",
            titleEn = "Module 6: Introduction to Python for AI",
            titleRu = "Модуль 6: Введение в Python для ИИ",
            descAz = "Python nədir, necə quraşdırılır, dəyişənlər və tiplər, if-else şərtləri, for və while dövrləri.",
            descEn = "Python syntax, variable types, conditional logic (if-else), and loops (for, while).",
            descRu = "Синтаксис Python, переменные, условные конструкции if-else, циклы for и while.",
            iconEmoji = "🐍",
            lessons = listOf(
                Lesson(
                    id = "mod6_les1",
                    moduleId = 6,
                    order = 1,
                    titleAz = "Python dili nədir, necə quraşdırılır? Dəyişənlər və tiplər",
                    titleEn = "What is Python? Setup, Variables & Data Types",
                    titleRu = "Что такое Python? Установка, переменные и типы данных",
                    summaryAz = "Sİ-nin ana dili olan Python, int, float, str, bool tipləri və dəyişənlər.",
                    summaryEn = "Core Python data types: int, float, string, boolean.",
                    summaryRu = "Базовые типы данных Python: int, float, str, bool.",
                    contentKidsAz = "Python — kompüterlə danışmaq üçün ən asan və sevimli dildir! 🐍 Dəyişən isə sevimli oyuncaqlarını saxladığın qutudur. Məsələn: yas = 14 dedikdə, kompüter 'yas' adlı qutuya 14 rəqəmini qoyur.",
                    contentAdultsAz = "Python sadə sintaksisi, geniş elmi ekosistemi (NumPy, PyTorch, Scikit-learn) və güclü icması sayəsində Süni İntellektin 1 nömrəli dilidir.\n\nƏsas Məlumat Tipləri:\n- int: Tam ədədlər (məs. 42)\n- float: Kəsr ədədlər (məs. 3.14)\n- str: Mətnlər (məs. 'Süni İntellekt')\n- bool: Məntiqi dəyərlər (True / False)\n- Dinamik tipləşdirmə: Dəyişənin tipi avtomatik təyin olunur.",
                    contentKidsEn = "Python is the friendly language computers use to understand smart instructions!",
                    contentAdultsEn = "Python's dynamic typing and scientific stack make it the industry standard for AI and Machine Learning.",
                    contentKidsRu = "Python — это простой и понятный язык программирования для создания умных программ!",
                    contentAdultsRu = "Python является основным языком в машинном обучении благодаря богатому набору библиотек.",
                    codeSnippet = "# Python-da dəyişənlər\nad = 'Pərvaz'\nyas = 15\nai_heveskari = True\nbal = 98.5\n\nprint(f'{ad} ({yas} yaş) - Bal: {bal}')",
                    keyTakeawaysAz = listOf(
                        "Python oxunaqlı və güclü proqramlaşdırma dilidir",
                        "Dəyişənlər məlumatları yaddaşda saxlamaq üçündür",
                        "type() funksiyası dəyişənin tipini öyrənməyə kömək edir"
                    )
                ),
                Lesson(
                    id = "mod6_les2",
                    moduleId = 6,
                    order = 2,
                    titleAz = "Şərt blokları (If-Else) və məntiqi əməliyyatlar",
                    titleEn = "Conditional Statements (If-Else) & Logical Operators",
                    titleRu = "Условные блоки (If-Else) и логические операции",
                    summaryAz = "Qərar qəbuletmə məntiqi, if, elif, else blokları və müqayisə operatorları.",
                    summaryEn = "Decision-making logic, if, elif, else constructs, and Boolean comparisons.",
                    summaryRu = "Условия if, elif, else и логические операторы сравнения.",
                    contentKidsAz = "Hər gün qərar verirsən: 'Əgər yağış yağırsa, çətir götür, yoxsa gün eynəyi tax!' ☔ Kompüter də if-else ilə eynilə belə ağıllı qərarlar verir.",
                    contentAdultsAz = "Şərt Blokları (Control Flow) alqoritmlərdə budaqlanma və qərar qəbul etmək üçün istifadə olunur.\n\nSintaksis:\nif sert_1:\n    # Blok 1\nelif sert_2:\n    # Blok 2\nelse:\n    # Əks halda\n\nMəntiqi Operatorlar: and, or, not, ==, !=, >, <, >=, <=",
                    contentKidsEn = "If-Else helps your code make smart decisions based on conditions!",
                    contentAdultsEn = "Conditional branching orchestrates control flow via Boolean logic evaluations.",
                    contentKidsRu = "Условия If-Else помогают программе выбирать правильное действие!",
                    contentAdultsRu = "Конструкции if-elif-else управляют ходом выполнения программы на основе булевой логики.",
                    codeSnippet = "bal = 85\nif bal >= 90:\n    netice = 'Əla (A)'\nelif bal >= 70:\n    netice = 'Yaxşı (B)'\nelse:\n    netice = 'Daha çox çalışmaq lazımdır'\nprint('Nəticə:', netice)",
                    keyTakeawaysAz = listOf(
                        "if şərtin doğruluğunu (True) yoxlayır",
                        "elif əlavə şərtlər üçün, else isə qalan bütün hallar üçündür",
                        "Python-da boşluqlar (indentation) blokların daxilini müəyyən edir"
                    )
                ),
                Lesson(
                    id = "mod6_les3",
                    moduleId = 6,
                    order = 3,
                    titleAz = "Dövrlər (For, While) və praktiki tətbiqlər",
                    titleEn = "Loops (For, While) & Practical Applications",
                    titleRu = "Циклы (For, While) и их практическое применение",
                    summaryAz = "Təkrarlanan əməliyyatların avtomatlaşdırılması, range() və dövr idarəetməsi.",
                    summaryEn = "Iterating with for and while loops, range() generator, break, and continue.",
                    summaryRu = "Циклы for и while, итерации по диапазонам и коллекциям.",
                    contentKidsAz = "Əgər 10 dəfə tullanmaq istəyirsənsə, hər dəfə kodu təkrar yazmırsan. Sadəcə robota '10 dəfə tullan' deyirsən və o for dövrü ilə bunu edir! 🦘",
                    contentAdultsAz = "Dövrlər (Loops) təkrarlanan əməliyyatları səmərəli idarə etməyə imkan verir:\n- for dövrü: Siyahı, sətir və ya range(n) üzərində addım-addım hərəkət edir.\n- while dövrü: Müəyyən şərt True olduğu müddətcə işləyir.\n- break və continue: Dövrü vaxtından əvvəl dayandırmaq və ya növbəti addıma keçmək.",
                    contentKidsEn = "Loops repeat actions automatically without typing code over and over!",
                    contentAdultsEn = "Loops automate repetitive data processing over iterables and conditional execution states.",
                    contentKidsRu = "Циклы позволяют повторять нужные действия без дублирования кода!",
                    contentAdultsRu = "Циклы for и while автоматизируют обработку элементов коллекций и потоков данных.",
                    codeSnippet = "# 1-dən 5-ə qədər kvadratları tap\nkvadratlar = []\nfor i in range(1, 6):\n    kvadratlar.append(i ** 2)\nprint('Kvadratlar:', kvadratlar)",
                    keyTakeawaysAz = listOf(
                        "for dövrü məlum sayda təkrarlanmalar üçün idealdır",
                        "while dövrü şərt əsasında sonsuz təkrarlana bilər",
                        "range(start, stop, step) ədəd ardıcıllığı yaradır"
                    )
                )
            )
        ),

        // Modul 7
        CourseModule(
            id = 7,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 7: Python-da Funksiyalar və Məlumat Strukturları",
            titleEn = "Module 7: Functions & Data Structures in Python",
            titleRu = "Модуль 7: Функции и структуры данных в Python",
            descAz = "Funksiyaların yazılması, siyahılar (Lists), lüğətlər (Dictionaries), kortəjlər (Tuples) və try-except.",
            descEn = "Custom functions, modular programming, Lists, Dictionaries, Tuples, and exception handling.",
            descRu = "Пользовательские функции, списки, словари, кортежи и обработка ошибок try-except.",
            iconEmoji = "📦",
            lessons = listOf(
                Lesson(
                    id = "mod7_les1",
                    moduleId = 7,
                    order = 1,
                    titleAz = "Funksiyaların yazılması və modul strukturu",
                    titleEn = "Defining Functions & Modular Structure",
                    titleRu = "Создание функций и модульная структура кода",
                    summaryAz = "def açar sözü, parametrlər, return qaytarma dəyəri və təkrar istifadə olunan kod.",
                    summaryEn = "Function definitions (def), parameters, return values, and code modularity.",
                    summaryRu = "Определение функций def, параметры, возврат значений return.",
                    contentKidsAz = "Funksiya — xüsusi bir resept kimidir! 🥞 Bir dəfə 'Pankeyk Bişir' reseptini yazırsan, sonra nə vaxt istəsən həmin resepti çağırıb ləzzətli yemək hazırlayırsan.",
                    contentAdultsAz = "Funksiyalar (Functions) kodun təkrar istifadəsini, modulluğunu və təmizliyini (Clean Code) təmin edir.\n\nƏsas Xüsusiyyətlər:\n- def funksiya_adi(parametr1, parametr2):\n- return deyer: Nəticəni proqrama geri qaytarır.\n- Default arqumentlər və *args, **kwargs elastikliyi.\n- Modullar: import math və ya import os vasitəsilə xarici faylları koda qoşmaq.",
                    contentKidsEn = "Functions are reusable recipes for your computer to follow!",
                    contentAdultsEn = "Functions encapsulate procedural logic with parameterized inputs and return values for DRY architecture.",
                    contentKidsRu = "Функции упаковывают полезные команды в удобные переиспользуемые блоки!",
                    contentAdultsRu = "Функции структурируют код, исключают дублирование и принимают гибкие аргументы.",
                    codeSnippet = "def ai_tovsiye(bal):\n    if bal > 80:\n        return 'Dərin Öyrənməyə keçə bilərsiniz 🚀'\n    return 'Python praktikasını davam etdirin 📘'\n\nprint(ai_tovsiye(92))",
                    keyTakeawaysAz = listOf(
                        "def açar sözü ilə funksiya elan edilir",
                        "return nəticəni geri qaytarır və funksiyanı tamamlayır",
                        "Funksiyalar böyük layihələri kiçik idarəolunan hissələrə bölür"
                    )
                ),
                Lesson(
                    id = "mod7_les2",
                    moduleId = 7,
                    order = 2,
                    titleAz = "Siyahılar (Lists), Lüğətlər (Dictionaries), Kortəclər (Tuples)",
                    titleEn = "Lists, Dictionaries, Sets & Tuples",
                    titleRu = "Списки (Lists), Словари (Dictionaries) и Кортежи (Tuples)",
                    summaryAz = "Məlumat kolleksiyaları, indeksləmə, açar-dəyər (key-value) cütləri və metodlar.",
                    summaryEn = "Python data collections, indexing, slicing, and key-value mapping.",
                    summaryRu = "Коллекции данных: списки, словари key-value и кортежи.",
                    contentKidsAz = "Siyahı (List) — alış-veriş siyahısı kimidir ['alma', 'banan']. Lüğət (Dictionary) isə söz və onun mənasıdır: {'robot': 'ağıllı köməkçi'}! 🍎🤖",
                    contentAdultsAz = "Python-un Əsas Məlumat Strukturları:\n1. List (Siyahı): Dəyişdirilə bilən (mutable), nizamlı kolleksiya: [1, 2, 3]\n2. Tuple (Kortəc): Dəyişdirilə bilməyən (immutable) nizamlı kolleksiya: (1920, 1080)\n3. Dictionary (Lüğət): Açar-Dəyər (Key-Value) cütlüyü ilə sürətli axtarış: {'ad': 'Ali', 'yas': 20}\n4. Set (Çoxluq): Təkrarlanmayan unikal elementlər toplusu: {1, 2, 3}",
                    contentKidsEn = "Lists hold your items, and dictionaries map words to definitions!",
                    contentAdultsEn = "Mastering Lists, Dicts, Tuples, and Sets is fundamental for feature storage and data pipelines.",
                    contentKidsRu = "Списки хранят последовательности, а словари связывают ключи со значениями!",
                    contentAdultsRu = "Структуры данных Python обеспечивают хранение и быстрый доступ к признакам в ML.",
                    codeSnippet = "# Tələbə Məlumat Bazası (Dictionary)\ntelebe = {\n    'ad': 'Aysel',\n    'kurslar': ['Python', 'Machine Learning'],\n    'orta_bal': 94.2\n}\nprint(f\"{telebe['ad']} - Kurs sayı: {len(telebe['kurslar'])}\")",
                    keyTakeawaysAz = listOf(
                        "Listlər [] kvadrat mötərizə ilə yazılır və dəyişdirilə bilir",
                        "Dictionary {} açar vasitəsilə anında dəyəri tapır",
                        "Tuples () dəyişdirilməz sabit dəyərləri qorumaq üçündür"
                    )
                ),
                Lesson(
                    id = "mod7_les3",
                    moduleId = 7,
                    order = 3,
                    titleAz = "Xətələrin idarə olunması (Try-Except)",
                    titleEn = "Error Handling with Try-Except",
                    titleRu = "Обработка исключений и ошибок (Try-Except)",
                    summaryAz = "Proqramın çökməsinin qarşısını almaq, ZeroDivisionError, ValueError və xəta logları.",
                    summaryEn = "Handling runtime exceptions gracefully to ensure fault-tolerant applications.",
                    summaryRu = "Перехват исключений и предотвращение сбоев программы через try-except.",
                    contentKidsAz = "Velosiped sürəndə dizlik taxdığın kimi, try-except də proqramın xəta edəndə yıxılıb sınmasının qarşısını alır! 🚴",
                    contentAdultsAz = "İstisna və Xətaların İdarə Edilməsi (Exception Handling):\n\ntry:\n    # Xəta ehtimalı olan kod\n    reqem = int(input())\n    netice = 100 / reqem\nexcept ZeroDivisionError:\n    # Sıfıra bölmə xətası\n    print('Sıfıra bölmək olmaz!')\nexcept ValueError:\n    print('Yalnız rəqəm daxil edin!')\nfinally:\n    # Hər zaman icra olunan blok\n    print('Əməliyyat başa çatdı.')",
                    contentKidsEn = "Try-Except acts like safety gear for your code so it never crashes!",
                    contentAdultsEn = "Robust error handling prevents pipeline halts during data ingestion and model inferences.",
                    contentKidsRu = "Блок try-except защищает приложение от аварийных завершений при ошибках!",
                    contentAdultsRu = "Обработка исключений гарантирует стабильность конвейеров данных в продакшене.",
                    codeSnippet = "try:\n    deyer = int('AI')\nexcept ValueError:\n    deyer = 0\n    print('Mətn ədədə çevrilə bilmədi, standart 0 təyin olundu.')\nprint('Dəyər:', deyer)",
                    keyTakeawaysAz = listOf(
                        "try bloku potensial riskli kodu əhatə edir",
                        "except xətanı tutur və alternativ təhlükəsiz həll tətbiq edir",
                        "finally hər bir halda (xəta olsa da, olmasa da) işləyir"
                    )
                )
            )
        ),

        // Modul 8
        CourseModule(
            id = 8,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 8: Sİ üçün Riyaziyyat və Statistika",
            titleEn = "Module 8: Mathematics & Statistics for AI",
            titleRu = "Модуль 8: Математика и статистика для ИИ",
            descAz = "Xətti cəbr (matrislər və vektorlar), ehtimal nəzəriyyəsi, statistika, törəmə və optimizasiya.",
            descEn = "Linear algebra (vectors, matrices), probability, statistics (mean, variance), and derivatives.",
            descRu = "Линейная алгебра (векторы, матрицы), теория вероятностей, статистика и градиенты.",
            iconEmoji = "📐",
            lessons = listOf(
                Lesson(
                    id = "mod8_les1",
                    moduleId = 8,
                    order = 1,
                    titleAz = "Xətti cəbrin təməlləri (Matrislər və vektorlar)",
                    titleEn = "Foundations of Linear Algebra (Vectors & Matrices)",
                    titleRu = "Основы линейной алгебры (Векторы и матрицы)",
                    summaryAz = "Vektorlar, matris vurulması, dot product və çoxölçülü fəza.",
                    summaryEn = "Vectors, matrix multiplication, dot product, and multidimensional feature spaces.",
                    summaryRu = "Векторы, матричное умножение, скалярное произведение и пространства признаков.",
                    contentKidsAz = "Vektor — ox işarəsi kimidir: onun həm uzunluğu, həm də istiqaməti var! Kompüter bütün şəkilləri və sözləri məhz rəqəmlər cədvəli (matris) kimi görür. 🎯",
                    contentAdultsAz = "Xətti Cəbr (Linear Algebra) Süni İntellektin riyazi təməlidir:\n- Skalyar: Tək bir ədəd (məs. 5).\n- Vektor: 1D massiv [x1, x2, x3], məlumat nöqtəsinin koordinatları.\n- Matris: 2D cədvəl (m x n), piksellər və ya çəkilər şəbəkəsi.\n- Skalyar Hasil (Dot Product): İki vektor arasındakı bucağı və oxşarlıq dərəcəsini ölçür (cos theta).",
                    contentKidsEn = "Matrices are tables of numbers that let computers see images and words!",
                    contentAdultsEn = "Linear transformations and dot products form the computational backbone of neural networks and embeddings.",
                    contentKidsRu = "Векторы и матрицы — это язык, на котором нейросети считывают данные!",
                    contentAdultsRu = "Матричные операции и скалярные произведения лежат в основе работы перцептронов.",
                    codeSnippet = "# Vektor Dot Product (Skalyar Hasil)\nv1 = [1, 2, 3]\nv2 = [4, 5, 6]\ndot_product = sum(a * b for a, b in zip(v1, v2))\nprint('Dot Product:', dot_product) # 1*4 + 2*5 + 3*6 = 32",
                    keyTakeawaysAz = listOf(
                        "Bütün AI məlumatları (mətn, şəkil, səs) vektorlara çevrilir",
                        "Matris vurulması neyron şəbəkəsinin əsas hesablamasıdır",
                        "Dot product semantik oxşarlığı müəyyən edir"
                    )
                ),
                Lesson(
                    id = "mod8_les2",
                    moduleId = 8,
                    order = 2,
                    titleAz = "Ehtimal nəzəriyyəsi və statistika (Ortalama, median, dispersiya)",
                    titleEn = "Probability & Statistics (Mean, Median, Variance, Std Dev)",
                    titleRu = "Теория вероятностей и статистика (Среднее, медиана, дисперсия)",
                    summaryAz = "Orta statistik göstəricilər, normal paylanma (Bell curve) və dispersiya.",
                    summaryEn = "Descriptive statistics, Gaussian distribution, variance, and standard deviation.",
                    summaryRu = "Описательная статистика, нормальное распределение Гаусса, дисперсия.",
                    contentKidsAz = "Sinifdəki bütün uşaqların boyunu ölçüb ortasını tapmaq kimi! Orta qiymət bizə ümumi mənzərəni göstərir. 📊",
                    contentAdultsAz = "Sİ-də Tətbiqi Statistika:\n1. Mean (Ədədi orta): Bütün qiymətlərin cəminin saya nisbəti.\n2. Median: Sıralanmış məlumatın tən ortasındakı dəyər (anomaliyalara qarşı dayanıqlı).\n3. Variance (Dispersiya) və Standart Meyl (Std Dev): Məlumatın ortadan nə dərəcədə yayıldığını göstərir.\n4. Qauss Paylanması (Normal Distribution): Təbiətdəki əksər hadisələrin paylanma qanunu.",
                    contentKidsEn = "Statistics helps find the center and spread of all our numbers!",
                    contentAdultsEn = "Statistical profiling and probability distributions are critical for data normalization and Bayesian modeling.",
                    contentKidsRu = "Статистика показывает средние значения и разброс данных в датасете!",
                    contentAdultsRu = "Статистический анализ и нормальное распределение необходимы для очистки данных.",
                    codeSnippet = "data = [10, 20, 20, 40, 50, 100]\nmean = sum(data) / len(data)\nprint(f'Ədədi Orta: {mean:.2f}')",
                    keyTakeawaysAz = listOf(
                        "Median kəskin anomaliyalardan (outliers) təsirlənmir",
                        "Standart meyl məlumatın qeyri-müəyyənlik dərəcəsini göstərir",
                        "Maşın öyrənməsi ehtimallar üzərində qərar verir"
                    )
                ),
                Lesson(
                    id = "mod8_les3",
                    moduleId = 8,
                    order = 3,
                    titleAz = "Törəmə və optimizasiya anlayışları",
                    titleEn = "Derivatives & Optimization Concepts",
                    titleRu = "Производные и основы математической оптимизации",
                    summaryAz = "Funksiyanın dəyişmə sürəti, qradiyent (Gradient) və xətanı minimuma endirmək.",
                    summaryEn = "Derivatives as rate of change, gradient vectors, and loss minimization.",
                    summaryRu = "Производные как скорость изменения функции и градиентный спуск.",
                    contentKidsAz = "Dumanlı dağdan ən aşağı dərəyə düşmək istəyirsən! Hər addımda ayağının altındakı ən dik enişi seçirsən. Törəmə də məhz ən düzgün eniş istiqamətini göstərir! ⛰️",
                    contentAdultsAz = "Törəmə və Qradiyent Optimizasiyası:\n- Törəmə (Derivative - f'(x)): Funksiyanın anlıq dəyişmə sürəti və mailliyi (slope).\n- Qradiyent (Gradient - Nabla): Çoxölçülü məkanda funksiyanın ən sürətli artdığı istiqamət vektoru.\n- Qradiyent Enişi (Gradient Descent): Xəta funksiyasını (Loss Function) minimuma endirmək üçün çəkiləri qradiyentin əksi istiqamətində addım-addım (Learning Rate) yeniləmək:\n  w_new = w_old - learning_rate * dL/dw",
                    contentKidsEn = "Derivatives guide AI down the steepest hill to reach zero mistakes!",
                    contentAdultsEn = "Calculus and partial derivatives power backpropagation via chain rule optimization.",
                    contentKidsRu = "Производная показывает направление самого быстрого спуска к минимуму ошибок!",
                    contentAdultsRu = "Градиентные методы минимизируют функцию потерь нейросети.",
                    codeSnippet = "# Qradiyent Enişi Addımı\nw = 10.0 # İlkin çəki\nlearning_rate = 0.1\n# Tutaq ki, Loss = w^2 -> dL/dw = 2*w\nfor _ in range(5):\n    gradient = 2 * w\n    w = w - learning_rate * gradient\n    print(f'Yeni çəki: {w:.4f}')",
                    keyTakeawaysAz = listOf(
                        "Törəmə xətanın hansı istiqamətdə dəyişdiyini göstərir",
                        "Learning rate addımın ölçüsünü təyin edir",
                        "Optimizasiya AI-nin öyrənmə mühərrikidir"
                    )
                )
            )
        ),

        // Modul 9
        CourseModule(
            id = 9,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 9: NumPy ilə Massiv Hesablamaları",
            titleEn = "Module 9: Array Computations with NumPy",
            titleRu = "Модуль 9: Массивы и вычисления с NumPy",
            descAz = "NumPy array strukturu, sürətli riyazi əməliyyatlar, indeksləmə, broadcasting və çoxölçülü massivlər.",
            descEn = "NumPy ndarrays, vectorization, broadcasting, slicing, and matrix algebra.",
            descRu = "Библиотека NumPy, структура ndarray, векторизация и многомерные массивы.",
            iconEmoji = "🔢",
            lessons = listOf(
                Lesson(
                    id = "mod9_les1",
                    moduleId = 9,
                    order = 1,
                    titleAz = "NumPy kitabxanası və array strukturu",
                    titleEn = "The NumPy Library & ndarray Architecture",
                    titleRu = "Библиотека NumPy и структура ndarray",
                    summaryAz = "Niyə Python list-ləri yerinə NumPy? C dilində optimallaşdırılmış sürətli massivlər.",
                    summaryEn = "Why NumPy over Python lists? Contiguous memory allocation and C-speed execution.",
                    summaryRu = "Преимущества NumPy ndarray перед стандартными списками Python.",
                    contentKidsAz = "NumPy — super-sürətli riyaziyyat kalkulyatorudur! 🚀 Milyonlarla rəqəmi bir göz qırpımında toplayıb vura bilir.",
                    contentAdultsAz = "NumPy (Numerical Python) elmi hesablamaların əsas kitabxanasıdır:\n- np.ndarray: Eyni tipli (homogeneous) elementləri yaddaşda fasiləsiz blokda saxlayır (C-array sürəti).\n- Vektorlaşdırma (Vectorization): Dövr yazmadan bütün massiv üzərində paralel əməliyyatlar.\n- Şəkil, audio və tabular məlumatların rəqəmsal təmsili.",
                    contentKidsEn = "NumPy computes millions of numbers at rocket speed!",
                    contentAdultsEn = "NumPy provides ndarray objects with high memory locality and vectorized execution in C.",
                    contentKidsRu = "NumPy выполняет математические расчеты в тысячи раз быстрее обычного Python!",
                    contentAdultsRu = "NumPy оптимизирует память и предоставляет векторизованные операции над массивами.",
                    codeSnippet = "import numpy as np\narr = np.array([1, 2, 3, 4, 5])\nprint('Massiv:', arr)\nprint('Forması (Shape):', arr.shape)\nprint('2 qatı:', arr * 2)",
                    keyTakeawaysAz = listOf(
                        "NumPy ənənəvi Python listlərindən 50x-100x daha sürətlidir",
                        "ndarray eyni tipli məlumatları saxlayır",
                        "Massivlər üzərində birbaşa riyazi əməliyyat aparmaq mümkündür"
                    )
                ),
                Lesson(
                    id = "mod9_les2",
                    moduleId = 9,
                    order = 2,
                    titleAz = "Sürətli riyazi əməliyyatlar və indeksləmə",
                    titleEn = "Fast Mathematical Operations & Slicing",
                    titleRu = "Быстрые математические операции и срезы (Slicing)",
                    summaryAz = "Broadcasting qaydaları, maskalama (boolean indexing) və statistik metodlar.",
                    summaryEn = "Broadcasting rules, boolean filtering, dot products, and aggregate metrics.",
                    summaryRu = "Правила Broadcasting, булева фильтрация и агрегатные функции.",
                    contentKidsAz = "Bir hərəkətlə siyahıdakı yalnız 50-dən böyük rəqəmləri seçib ayırmaq olar! 🪄",
                    contentAdultsAz = "Qabaqcıl NumPy Əməliyyatları:\n- Broadcasting: Fərqli ölçülü massivlərin avtomatik uyğunlaşdırılaraq hesablanması.\n- Boolean Masking: arr[arr > 50] ilə dərhal filtrləmə.\n- Statistik metodlar: np.mean(), np.std(), np.sum(), np.argmax().",
                    contentKidsEn = "Filter and calculate giant lists with single-line magic commands!",
                    contentAdultsEn = "Broadcasting dynamically aligns tensor dimensions without explicit memory duplication.",
                    contentKidsRu = "Фильтруй и вычисляй огромные массивы без использования циклов!",
                    contentAdultsRu = "Механизм Broadcasting позволяет производить операции над массивами разных размерностей.",
                    codeSnippet = "import numpy as np\nballar = np.array([65, 80, 95, 45, 90])\nkesilenler = ballar[ballar < 50]\nelacilar = ballar[ballar >= 90]\nprint('Kəsilənlər:', kesilenler, '| Əlaçılar:', elacilar)",
                    keyTakeawaysAz = listOf(
                        "Boolean indeksləmə filtrasiyanı inanılmaz dərəcədə sürətləndirir",
                        "Broadcasting fərqli ölçülü matrisləri uyğunlaşdırır",
                        "np.argmax() ən yüksək ehtimallı sinfi tapmaq üçün istifadə olunur"
                    )
                ),
                Lesson(
                    id = "mod9_les3",
                    moduleId = 9,
                    order = 3,
                    titleAz = "Çoxölçülü massivlərlə işləmək",
                    titleEn = "Working with Multi-Dimensional Arrays (2D, 3D, ND)",
                    titleRu = "Работа с многомерными массивами (2D, 3D, тензоры)",
                    summaryAz = "Reshape, Transpose, 3D rəngli piksellər (RGB) və tensor anlayışı.",
                    summaryEn = "Matrix reshaping, transpositions, flattening, and 3D RGB image tensors.",
                    summaryRu = "Изменение формы массивов reshape, транспонирование и 3D-тензоры изображений.",
                    contentKidsAz = "Rəngli bir şəkil — hündürlüyü, eni və 3 rəngi (Qırmızı, Yaşıl, Mavi) olan 3D rəqəmlər qutusudur! 🖼️",
                    contentAdultsAz = "Çoxölçülü Massivlər və Tensorlar:\n- 1D Massiv: Vektor [N]\n- 2D Massiv: Matris [N, M] (Tabulyar cədvəl və ya ağ-qara şəkil)\n- 3D Massiv: [Hündürlük, En, 3 Kanal (RGB)] rəngli şəkillər\n- 4D Tensor: [Batch_Size, Hündürlük, En, Kanallar] (Video və ya mini-batch təlimi)",
                    contentKidsEn = "Images are 3D blocks of red, green, and blue numbers in NumPy!",
                    contentAdultsEn = "Tensors represent high-dimensional arrays forming the core data structure of neural network pipelines.",
                    contentKidsRu = "Изображения и видео представляются в виде трехмерных и четырехмерных тензоров!",
                    contentAdultsRu = "Тензоры размерностей 3D и 4D кодируют батчи цветных изображений и видео.",
                    codeSnippet = "import numpy as np\nmatris = np.arange(1, 10).reshape(3, 3)\nprint('3x3 Matris:\\n', matris)\nprint('Transponirə (Çevrilmiş):\\n', matris.T)",
                    keyTakeawaysAz = listOf(
                        "reshape() elementlərin sayını qoruyaraq ölçünü dəyişir",
                        "Transponirə (T) sətirləri sütunlara çevirir",
                        "Dərin öyrənmədə bütün məlumatlar 3D və 4D tensor şəklində ötürülür"
                    )
                )
            )
        ),

        // Modul 10
        CourseModule(
            id = 10,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 10: Pandas ilə Məlumat Analizi (Data Analysis)",
            titleEn = "Module 10: Data Analysis with Pandas",
            titleRu = "Модуль 10: Анализ данных с Pandas",
            descAz = "Pandas DataFrame və Series, cədvəllərin oxunması, təmizlənməsi, filtr edilməsi və böyük bazalar.",
            descEn = "Pandas DataFrame, Series, CSV/Excel ingestion, data querying, and big data transformations.",
            descRu = "Библиотека Pandas, структуры DataFrame и Series, чтение CSV и фильтрация таблиц.",
            iconEmoji = "🐼",
            lessons = listOf(
                Lesson(
                    id = "mod10_les1",
                    moduleId = 10,
                    order = 1,
                    titleAz = "Pandas DataFrame və Series strukturları",
                    titleEn = "Pandas DataFrames & Series Structures",
                    titleRu = "Структуры Pandas DataFrame и Series",
                    summaryAz = "Python-un Excel gücü: Series (1D) və DataFrame (2D cədvəl) konseptləri.",
                    summaryEn = "Python's data manipulation powerhouse: 1D Series and 2D DataFrame tables.",
                    summaryRu = "Основы Pandas: одномерные Series и двумерные таблицы DataFrame.",
                    contentKidsAz = "Pandas — kompüterdəki ən ağıllı Excel cədvəlidir! 🐼 Milyonlarla insanın adını, yaşını və qiymətlərini səliqəli cədvəldə saxlayır.",
                    contentAdultsAz = "Pandas tabulyar məlumatların manipulyasiyası və təhlili üçün №1 kitabxanadır:\n- Series: İndekslənmiş 1D sütun.\n- DataFrame: Sətir və sütunlardan ibarət 2D cədvəl (SQL və Excel bənzəri).\n- Əsas metodlar: df.head(), df.info(), df.describe(), df.shape.",
                    contentKidsEn = "Pandas turns raw numbers into organized tables just like magic spreadsheets!",
                    contentAdultsEn = "DataFrames provide fast SQL-like querying, indexing, and aggregation over tabular datasets.",
                    contentKidsRu = "Pandas организует разрозненные данные в удобные и быстрые таблицы!",
                    contentAdultsRu = "DataFrames обеспечивают высокоэффективные операции над табличными датасетами.",
                    codeSnippet = "# Sadə DataFrame yaradılması\nimport pandas as pd\ndata = {\n    'Ad': ['Ayan', 'Murad', 'Nigar'],\n    'Yaş': [14, 15, 14],\n    'Bal': [95, 88, 92]\n}\ndf = pd.DataFrame(data)\nprint(df)",
                    keyTakeawaysAz = listOf(
                        "DataFrame sətir və sütunlardan ibarət güclü cədvəldir",
                        "df.describe() statistik xülasəni (mean, min, max) dərhal göstərir",
                        "Sütunlara df['Sütun_Adı'] kimi müraciət edilir"
                    )
                ),
                Lesson(
                    id = "mod10_les2",
                    moduleId = 10,
                    order = 2,
                    titleAz = "Cədvəllərin oxunması, təmizlənməsi və filtr edilməsi",
                    titleEn = "Reading, Cleaning & Filtering Datasets",
                    titleRu = "Чтение, очистка и фильтрация датасетов в Pandas",
                    summaryAz = "pd.read_csv(), pd.read_excel(), loc və iloc ilə dəqiq filtrasiya və qruplaşdırma (groupby).",
                    summaryEn = "Ingesting CSV/Excel, conditional filtering, loc/iloc slicing, and groupby aggregations.",
                    summaryRu = "Чтение CSV/Excel, фильтрация по условиям, срезы loc/iloc и группировка groupby.",
                    contentKidsAz = "Minlərlə oyunçu arasından yalnız 'Səviyyəsi 10-dan çox olanları' bir saniyədə tapmaq mümkündür! 🎮",
                    contentAdultsAz = "Data Filtrləmə və Aqreqasiya:\n- Məlumatın oxunması: df = pd.read_csv('data.csv')\n- Şərtlə filtrləmə: df[df['Yaş'] > 18]\n- loc və iloc: Adla (label-based) və ya indekslə (positional) kəsimlər.\n- GroupBy: df.groupby('Şəhər')['Maaş'].mean() — Şəhərlər üzrə orta maaşın hesablanması.",
                    contentKidsEn = "Filter and find exact rows in massive spreadsheets with simple commands!",
                    contentAdultsEn = "Master conditional query syntax, index-based slicing, and multi-column group-by reductions.",
                    contentKidsRu = "Фильтруйте и группируйте миллионы строк за доли секунды!",
                    contentAdultsRu = "Методы query, loc, iloc и groupby позволяют извлекать точные срезы данных.",
                    codeSnippet = "import pandas as pd\ndf = pd.DataFrame({'Ad': ['A', 'B', 'C'], 'Bal': [45, 92, 78]})\nugurlular = df[df['Bal'] >= 70]\nprint('Uğurlu Tələbələr:\\n', ugurlular)",
                    keyTakeawaysAz = listOf(
                        "pd.read_csv() ən çox istifadə olunan məlumat yükləmə metodudur",
                        "groupby() məlumatları kateqoriyalara bölüb təhlil edir",
                        "loc sətir/sütun adları ilə, iloc rəqəm indeksləri ilə işləyir"
                    )
                ),
                Lesson(
                    id = "mod10_les3",
                    moduleId = 10,
                    order = 3,
                    titleAz = "Böyük məlumat bazaları üzərində əməliyyatlar",
                    titleEn = "Operations on Large Datasets & Merging",
                    titleRu = "Операции над большими базами данных и объединение (Merge/Join)",
                    summaryAz = "Merge, Join, Concat, pivot cədvəllər və yaddaş optimizasiyası (chunksize).",
                    summaryEn = "Relational joins, concatenation, pivot tables, and chunked processing for big data.",
                    summaryRu = "Объединение таблиц merge, concat, сводные таблицы pivot_table.",
                    contentKidsAz = "İki fərqli cədvəli birləşdirib tək bir böyük kitab halına gətirmək kimidir! 📚",
                    contentAdultsAz = "İri Həcmli Məlumatların İdarə Edilməsi:\n- pd.merge(df1, df2, on='id', how='inner') — SQL JOIN məntiqi ilə cədvəllərin bağlanması.\n- pd.concat([df1, df2]) — Cədvəllərin alt-alta və ya yan-yana yapışdırılması.\n- Pivot Tables: df.pivot_table(values='Satış', index='Bölgə', columns='İl')\n- Chunksize: Gigabaytlarla faylı hissə-hissə (stream) oxuyaraq RAM-ı qorumaq.",
                    contentKidsEn = "Combine multiple tables into one master database seamlessly!",
                    contentAdultsEn = "Perform relational algebra across distributed DataFrames with optimized memory foot-printing.",
                    contentKidsRu = "Объединяйте разные таблицы по общим ключам как в SQL!",
                    contentAdultsRu = "Операции merge и pivot_table строят сводные аналитические витрины данных.",
                    codeSnippet = "import pandas as pd\ndf1 = pd.DataFrame({'ID': [1, 2], 'Ad': ['Elmir', 'Leyla']})\ndf2 = pd.DataFrame({'ID': [1, 2], 'Xal': [100, 95]})\numumi = pd.merge(df1, df2, on='ID')\nprint(umumi)",
                    keyTakeawaysAz = listOf(
                        "merge() cədvəlləri ümumi ID üzrə birləşdirir",
                        "pivot_table mürəkkəb çoxölçülü hesabatlar qurur",
                        "chunksize böyük datalarda yaddaşın dolmasının qarşısını alır"
                    )
                )
            )
        ),

        // Modul 11
        CourseModule(
            id = 11,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 11: Məlumatların Təmizlənməsi və Hazırlığı",
            titleEn = "Module 11: Data Cleaning & Preprocessing",
            titleRu = "Модуль 11: Очистка и предобработка данных",
            descAz = "Çatışmayan məlumatların (Missing values) bərpası, dublikatların təmizlənməsi və ML üçün hazırlıq.",
            descEn = "Handling missing values, duplicate removal, outliers, encoding, scaling, and feature engineering.",
            descRu = "Заполнение пропусков, удаление дубликатов, кодирование признаков и масштабирование.",
            iconEmoji = "🧹",
            lessons = listOf(
                Lesson(
                    id = "mod11_les1",
                    moduleId = 11,
                    order = 1,
                    titleAz = "Çatışmayan məlumatların (Missing values) bərpası",
                    titleEn = "Handling Missing Values (Imputation & Dropping)",
                    titleRu = "Восстановление пропущенных значений (NaN)",
                    summaryAz = "NaN/None aşkarlanması, dropna(), fillna(mean/median) və KNN Imputer.",
                    summaryEn = "Detecting NaNs, dropna strategies, mean/median/mode imputation, and KNN imputers.",
                    summaryRu = "Поиск пропусков isnull(), удаление dropna() и заполнение fillna().",
                    contentKidsAz = "Əgər şagirdlərdən biri test vərəqində adını yazmağı unudubsa, biz həmin boşluğu necə tapırıq? Data təmizliyi də məhz belə boşluqları doldurur! 📝",
                    contentAdultsAz = "Məlumat Təmizlənməsi (Data Cleaning) — ML uğurunun 80%-ni təşkil edir:\n- Boşluqların yoxlanması: df.isnull().sum()\n- Silmə Strategiyası: df.dropna() (yalnız çatışmayan sətirlər 5%-dən az olduqda).\n- Doldurma (Imputation): df['Yaş'].fillna(df['Yaş'].median()) — Ədədi orta və ya median ilə bərpa.\n- Kateqorial dəyərlərdə: Ən çox təkrarlanan (Mode) dəyərlə doldurmaq.",
                    contentKidsEn = "Fill in missing pieces of the puzzle so AI never gets confused!",
                    contentAdultsEn = "Systematic handling of MCAR/MAR missingness via statistical and model-based imputers.",
                    contentKidsRu = "Заполняйте пропущенные значения средними или медианами перед обучением!",
                    contentAdultsRu = "Грамотная импутация пропусков исключает смещение обучающей выборки.",
                    codeSnippet = "import pandas as pd\nimport numpy as np\ndf = pd.DataFrame({'Qiymət': [10, np.nan, 30, 40]})\norta = df['Qiymət'].mean()\ndf['Qiymət'] = df['Qiymət'].fillna(orta)\nprint('Təmizlənmiş:\\n', df)",
                    keyTakeawaysAz = listOf(
                        "NaN dəyərləri ML modellərinin işləməsinə mane olur",
                        "Median anomaliyalara qarşı ortalamadan daha etibarlı bərpa vasitəsidir",
                        "Məlumatların keyfiyyəti modelin dəqiqliyini birbaşa təyin edir"
                    )
                ),
                Lesson(
                    id = "mod11_les2",
                    moduleId = 11,
                    order = 2,
                    titleAz = "Dublikatların təmizlənməsi və format dəyişiklikləri",
                    titleEn = "Duplicate Removal & Data Formatting",
                    titleRu = "Удаление дубликатов и форматирование данных",
                    summaryAz = "drop_duplicates(), str metodları, datetime çevirmələri və One-Hot Encoding.",
                    summaryEn = "Deduplication, regex string normalizations, datetime parsing, and categorical encoding.",
                    summaryRu = "Удаление повторов, форматирование дат и кодирование категорий One-Hot.",
                    contentKidsAz = "Bir mahnını siyahıya iki dəfə əlavə etmisənsə, təkrarı silmək lazımdır! 🎵",
                    contentAdultsAz = "Məlumatların Formatlanması:\n- Dublikatların silinməsi: df.drop_duplicates(inplace=True)\n- Tarix formatı: pd.to_datetime(df['Tarix'])\n- Mətnlərin standartlaşdırılması: df['Ad'].str.strip().str.capitalize()\n- One-Hot Encoding: pd.get_dummies(df, columns=['Cins']) — Kateqoriyaları 0 və 1-lərə çevirmək.",
                    contentKidsEn = "Remove duplicate songs from your playlist with a single click!",
                    contentAdultsEn = "Normalize schema formats, resolve duplicate primary keys, and encode nominal categories.",
                    contentKidsRu = "Удаляйте повторяющиеся строки и переводите категории в бинарные признаки!",
                    contentAdultsRu = "One-Hot кодирование преобразует текст в понятные для нейросети числа.",
                    codeSnippet = "import pandas as pd\ndf = pd.DataFrame({'Rəng': ['Qırmızı', 'Mavi', 'Qırmızı']})\ndummies = pd.get_dummies(df['Rəng'])\nprint('One-Hot Encoding:\\n', dummies)",
                    keyTakeawaysAz = listOf(
                        "Dublikatlar modelin həddindən artıq uyğunlaşmasına (overfitting) səbəb ola bilər",
                        "One-Hot Encoding kateqorial məlumatları rəqəmlərə çevirir",
                        "Mətn formatlarını təmizləmək xətaların qarşısını alır"
                    )
                ),
                Lesson(
                    id = "mod11_les3",
                    moduleId = 11,
                    order = 3,
                    titleAz = "Maşın öyrənməsi üçün datanın hazırlanması (Scaling & Splitting)",
                    titleEn = "Data Scaling & Feature Preparation for ML",
                    titleRu = "Масштабирование признаков и подготовка данных к обучению",
                    summaryAz = "MinMaxScaler, StandardScaler, Train-Test Split və anomaliyaların təmizlənməsi.",
                    summaryEn = "Feature scaling (MinMax, StandardScaler), outlier clipping, and train-test partitioning.",
                    summaryRu = "Масштабирование StandardScaler/MinMaxScaler и разделение выборки на Train/Test.",
                    contentKidsAz = "Bütün idmançıların boyunu və çəkisini eyni tərəzidə müqayisə etmək üçün standartlaşdırırıq! ⚖️",
                    contentAdultsAz = "Xüsusiyyətlərin Miqyaslanması (Feature Scaling):\n- StandardScaler (Z-Score): (x - mean) / std — Orta qiyməti 0, dispersiyanı 1 edir.\n- MinMaxScaler: (x - min) / (max - min) — Bütün dəyərləri [0, 1] aralığına gətirir.\n- Niyə vacibdir? Qradiyent enişi və məsafə əsaslı alqoritmlər (KNN, SVM) böyük rəqəmlərdən asılı qalmasın deyə.",
                    contentKidsEn = "Scale all numbers to the same friendly range so AI learns fairly!",
                    contentAdultsEn = "Feature normalization guarantees uniform gradient propagation across multidimensional feature spaces.",
                    contentKidsRu = "Масштабируйте признаки к диапазону от 0 до 1 для стабильности обучения!",
                    contentAdultsRu = "Стандартизация признаков предотвращает доминирование признаков с большими значениями.",
                    codeSnippet = "from sklearn.preprocessing import MinMaxScaler\nimport numpy as np\ndata = np.array([[10], [50], [100]])\nscaler = MinMaxScaler()\nscaled = scaler.fit_transform(data)\nprint('0-1 Aralığında:', scaled.flatten())",
                    keyTakeawaysAz = listOf(
                        "Miqyaslama (Scaling) qradiyent optimizasiyasını 10 qat sürətləndirir",
                        "Məlumat həmişə Train və Test hissələrinə bölünməlidir",
                        "Test datası yalnız yekun yoxlamada istifadə olunmalıdır"
                    )
                )
            )
        ),

        // Modul 12
        CourseModule(
            id = 12,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 12: Məlumatların Vizuallaşdırılması (Matplotlib və Seaborn)",
            titleEn = "Module 12: Data Visualization (Matplotlib & Seaborn)",
            titleRu = "Модуль 12: Визуализация данных (Matplotlib и Seaborn)",
            descAz = "Matplotlib xətti, sütunlu və dairəvi qrafiklər, Seaborn statistika qrafikləri və korrelyasiya xəritəsi.",
            descEn = "Matplotlib line/bar/scatter charts, Seaborn statistical heatmaps, distributions, and correlation.",
            descRu = "Построение графиков в Matplotlib и Seaborn, тепловые карты корреляций и гистограммы.",
            iconEmoji = "📈",
            lessons = listOf(
                Lesson(
                    id = "mod12_les1",
                    moduleId = 12,
                    order = 1,
                    titleAz = "Matplotlib ilə xətti, sütunlu və dairəvi qrafiklər",
                    titleEn = "Line, Bar & Pie Charts with Matplotlib",
                    titleRu = "Линейные, столбчатые и круговые графики в Matplotlib",
                    summaryAz = "plt.plot(), plt.bar(), plt.scatter(), oxların və başlıqların formatlanması.",
                    summaryEn = "Basic plotting mechanics, titles, axis labels, legends, subplots, and styling.",
                    summaryRu = "Построение графиков plt.plot, plt.bar, оформление осей и легенды.",
                    contentKidsAz = "Bir şəkil min sözə bərabərdir! 📊 Qrafiklər rəqəmləri rəngli və maraqlı hekayəyə çevirir.",
                    contentAdultsAz = "Matplotlib — Python-un əsas 2D qrafik mühərrikidir:\n- plt.plot(x, y): Zaman seriyaları və trendlər (Xətti qrafik).\n- plt.bar(kateqoriyalar, qiymətlər): Qrupların müqayisəsi (Sütunlu qrafik).\n- plt.scatter(x, y): İki dəyişən arasındakı paylanma (Səpələnmə qrafiki).\n- plt.title(), plt.xlabel(), plt.ylabel(), plt.grid(), plt.show().",
                    contentKidsEn = "Turn dry numbers into beautiful colorful graphs you can easily understand!",
                    contentAdultsEn = "Matplotlib provides low-level control over figure canvases, subplots, and rendering axes.",
                    contentKidsRu = "Превращайте сухие таблицы в яркие и понятные графики с Matplotlib!",
                    contentAdultsRu = "Matplotlib позволяет строить кастомные графики любых типов и сохранять их в высоком разрешении.",
                    codeSnippet = "import matplotlib.pyplot as plt\nillər = [2022, 2023, 2024, 2025]\nsagirdler = [120, 350, 800, 2100]\nplt.plot(illər, sagirdler, marker='o')\nplt.title('AI Akademiyasının Tələbə Artımı')\n# plt.show()",
                    keyTakeawaysAz = listOf(
                        "Xətti qrafik zaman üzrə dinamikanı göstərmək üçün ən yaxşısıdır",
                        "Səpələnmə qrafiki (Scatter plot) iki parametr arasındakı əlaqəni aşkar edir",
                        "Qrafikdə ox adları və başlıq mütləq olmalıdır"
                    )
                ),
                Lesson(
                    id = "mod12_les2",
                    moduleId = 12,
                    order = 2,
                    titleAz = "Seaborn ilə qabaqcıl statistika qrafikləri",
                    titleEn = "Advanced Statistical Plots with Seaborn",
                    titleRu = "Продвинутые статистические графики в Seaborn",
                    summaryAz = "sns.histplot(), sns.boxplot(), sns.pairplot() və paylanma analizləri.",
                    summaryEn = "Histograms, KDE distributions, boxplots, pairplots, and categorical estimation.",
                    summaryRu = "Построение гистограмм, ящиков с усами (boxplot) и pairplot в Seaborn.",
                    contentKidsAz = "Qutulu qrafik (Boxplot) sinifdə kimin ən yüksək, kimin ən aşağı bal aldığını və çoxluğun harada olduğunu göstərir! 📦",
                    contentAdultsAz = "Seaborn (Matplotlib üzərində qurulmuş yüksək səviyyəli vizuallaşdırma):\n- sns.histplot(df['Qiymət'], kde=True): Məlumatın paylanma formasını (Gaussian) göstərir.\n- sns.boxplot(x='Sinif', y='Bal', data=df): Median, kvartillər və kənar anomaliyaları (Outliers) aşkar edir.\n- sns.pairplot(df): Bütün sütunların bir-biri ilə cüt qrafikləri.",
                    contentKidsEn = "Boxplots and histograms show you the whole story of your dataset at a glance!",
                    contentAdultsEn = "Seaborn automates statistical aggregation and aesthetic color palettes for exploratory data analysis.",
                    contentKidsRu = "Seaborn строит стильные статистические графики с автоматической группировкой!",
                    contentAdultsRu = "Boxplot и kdeplot наглядно визуализируют квантили, медианы и выбросы в датасете.",
                    codeSnippet = "import seaborn as sns\n# sns.boxplot(x='Kateqoriya', y='Dəyər', data=df)\nprint('Seaborn ilə statistik paylanma təhlil edildi')",
                    keyTakeawaysAz = listOf(
                        "Seaborn bir sətir kodla mürəkkəb statistik qrafiklər çəkir",
                        "Boxplot anomaliyaları (outliers) dərhal aşkar edir",
                        "KDE əyrisi ehtimal sıxlığını hamar göstərir"
                    )
                ),
                Lesson(
                    id = "mod12_les3",
                    moduleId = 12,
                    order = 3,
                    titleAz = "Məlumatlardakı gizli əlaqələrin vizual təhlili",
                    titleEn = "Visual Analysis of Hidden Correlations",
                    titleRu = "Визуальный анализ скрытых закономерностей и корреляций",
                    summaryAz = "Korrelyasiya matrisi (Correlation Matrix) və sns.heatmap() ilə əlaqələrin xəritələnməsi.",
                    summaryEn = "Pearson correlation coefficients, covariance matrices, and heatmap visualization.",
                    summaryRu = "Корреляционная матрица Пирсона и тепловые карты sns.heatmap.",
                    contentKidsAz = "İstilik xəritəsi (Heatmap) hava proqnozu kimidir: qırmızı rəng güclü dostluğu, göy rəng isə fərqliliyi göstərir! 🌡️",
                    contentAdultsAz = "Korrelyasiya və İstilik Xəritəsi (Correlation Heatmap):\n- Pirson Korrelyasiyası (r): [-1, +1] aralığında iki dəyişənin xətti əlaqə gücü.\n  +1: Düz mütənasib (Dərs oxuma vaxtı artdıqca bal artır)\n  -1: Tərs mütənasib (Yuxusuzluq artdıqca diqqət azalır)\n  0: Əlaqə yoxdur\n- sns.heatmap(df.corr(), annot=True, cmap='coolwarm'): Hansı xüsusiyyətlərin hədəfə ən çox təsir etdiyini göstərir.",
                    contentKidsEn = "Heatmaps show which features are best friends using vibrant thermal colors!",
                    contentAdultsEn = "Heatmap correlation analysis guides feature selection by pinpointing multicollinearity and target dependencies.",
                    contentKidsRu = "Тепловая карта корреляций мгновенно показывает взаимосвязи между признаками!",
                    contentAdultsRu = "Коэффициент корреляции от -1 до +1 определяет силу линейной связи между переменными.",
                    codeSnippet = "import seaborn as sns\nimport pandas as pd\ndf = pd.DataFrame({'Saat': [2, 4, 6], 'Bal': [50, 75, 95]})\ncorr = df.corr()\nprint('Korrelyasiya Matrisi:\\n', corr)",
                    keyTakeawaysAz = listOf(
                        "Korrelyasiya səbəb-nəticə əlaqəsi deyil, asılılıq dərəcəsidir",
                        "Heatmap modelə hansı xüsusiyyətləri daxil etməyi seçməkdə kömək edir",
                        "Bir-biri ilə 1.0 korrelyasiyada olan artıq sütunları silmək lazımdır"
                    )
                )
            )
        )
    )
}

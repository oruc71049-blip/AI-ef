package com.example.data.curriculum

import com.example.data.models.CourseModule
import com.example.data.models.Lesson
import com.example.data.models.QuizOption
import com.example.data.models.QuizQuestion

object Section3Data {
    private const val SEC_NUM = 3
    private const val SEC_TITLE_AZ = "Bölüm 3: Maşın Öyrənməsi (Machine Learning)"
    private const val SEC_TITLE_EN = "Part 3: Machine Learning"
    private const val SEC_TITLE_RU = "Раздел 3: Машинное обучение (Machine Learning)"

    val modules: List<CourseModule> = listOf(
        // Modul 13
        CourseModule(
            id = 13,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 13: Maşın Öyrənməsinə Giriş",
            titleEn = "Module 13: Introduction to Machine Learning",
            titleRu = "Модуль 13: Введение в машинное обучение",
            descAz = "ML nədir, Nəzarətli və Nəzarətsiz Öyrənmə fərqləri, Scikit-learn və Train-Test Split.",
            descEn = "Supervised vs Unsupervised learning, Scikit-learn fundamentals, and Train-Test split paradigms.",
            descRu = "Обучение с учителем и без учителя, Scikit-learn и разделение на Train-Test.",
            iconEmoji = "🤖",
            lessons = listOf(
                Lesson(
                    id = "mod13_les1",
                    moduleId = 13,
                    order = 1,
                    titleAz = "ML nədir? Nəzarətli və Nəzarətsiz Öyrənmə fərqləri",
                    titleEn = "What is ML? Supervised vs Unsupervised Learning",
                    titleRu = "Что такое ML? Обучение с учителем и без учителя",
                    summaryAz = "Ənənəvi proqramlaşdırma ilə ML fərqi, etiketli (labeled) və etiketsiz məlumatlar.",
                    summaryEn = "Traditional logic vs ML, labeled data paradigms, classification vs clustering.",
                    summaryRu = "Отличие классического кода от ML, размеченные и неразмеченные данные.",
                    contentKidsAz = "Ənənəvi proqramlaşdırmada sən kompüterə hər qaydanı özün deyirsən. ML-də isə kompüterə minlərlə nümunə göstərirsən və o qaydaları özü kəşf edir! 💡",
                    contentAdultsAz = "Maşın Öyrənməsinin (Machine Learning) Əsas Paradiqmaları:\n1. Nəzarətli Öyrənmə (Supervised Learning): Model həm girişləri (X), həm də düzgün cavabları (y) görür. Nümunələr: Reqressiya (Qiymət təyini) və Təsnifat (Spam/Normal).\n2. Nəzarətsiz Öyrənmə (Unsupervised Learning): Düzgün cavablar yoxdur, model məlumatdakı gizli strukturları və klasterləri özü tapır.\n3. Gücləndirilmiş Öyrənmə (Reinforcement Learning): Mükafat və cəza sistemi ilə agentin mühitdə ən optimal strategiyanı öyrənməsi.",
                    contentKidsEn = "In ML, computers learn patterns from examples just like you learn from practice!",
                    contentAdultsEn = "Machine learning induces generalized mapping functions from empirical data without hardcoded rule sets.",
                    contentKidsRu = "В машинном обучении алгоритмы самостоятельно находят правила по примерам!",
                    contentAdultsRu = "Обучение с учителем минимизирует ошибку на размеченных парах признак-ответ.",
                    codeSnippet = "# ML Paradiqması\ntraditional = 'Məlumat + Qaydalar = Cavab'\nmachine_learning = 'Məlumat + Cavablar = Qaydalar (Model)'\nprint('Ənənəvi:', traditional)\nprint('ML:', machine_learning)",
                    keyTakeawaysAz = listOf(
                        "ML qaydaları məlumat əsasında özü öyrənir",
                        "Nəzarətli öyrənmədə hədəf dəyişəni (label) mövcuddur",
                        "Nəzarətsiz öyrənmə qruplaşdırma və anomaliya aşkarlanması üçündür"
                    )
                ),
                Lesson(
                    id = "mod13_les2",
                    moduleId = 13,
                    order = 2,
                    titleAz = "Scikit-learn kitabxanası ilə tanışlıq",
                    titleEn = "Introduction to Scikit-Learn Library",
                    titleRu = "Знакомство с библиотекой Scikit-learn",
                    summaryAz = "Fit, Predict, Transform API arxitekturası və vahid ML interfeysi.",
                    summaryEn = "The unified Estimator API: fit(), predict(), score(), and transform().",
                    summaryRu = "Единый API интерфейс Scikit-learn: fit, predict и transform.",
                    contentKidsAz = "Scikit-learn — Sİ mühəndisinin ən sevimli alətlər qutusudur! 🧰 İçində yüzlərlə hazır ağıllı alqoritm var.",
                    contentAdultsAz = "Scikit-learn Python-un ən populyar klassik ML kitabxanasıdır:\n- Estimator API:\n  1. model = Algorithm(params) — Modelin yaradılması\n  2. model.fit(X_train, y_train) — Modelin öyrənməsi (təlim)\n  3. y_pred = model.predict(X_test) — Yeni məlumatlar üzrə proqnoz\n  4. accuracy = model.score(X_test, y_test) — Dəqiqliyin yoxlanması",
                    contentKidsEn = "Scikit-learn provides ready-made algorithms to train smart models in 3 easy steps!",
                    contentAdultsEn = "Scikit-learn standardizes machine learning workflows via composable estimators and transformers.",
                    contentKidsRu = "Scikit-learn предоставляет готовые алгоритмы машинного обучения с простым синтаксисом!",
                    contentAdultsRu = "Шаблон fit-predict стандартизирует обучение и валидацию классических моделей.",
                    codeSnippet = "# Standart Scikit-Learn İş Axını\nfrom sklearn.linear_model import LinearRegression\nmodel = LinearRegression()\n# model.fit(X, y)\n# proqnoz = model.predict([[5]])\nprint('Model uğurla təyin olundu')",
                    keyTakeawaysAz = listOf(
                        "fit() modeli məlumat üzərində təlim edir",
                        "predict() yeni daxil olan nümunələr üçün cavab verir",
                        "Vahid sintaksis sayəsində fərqli alqoritmləri asanlıqla dəyişmək mümkündür"
                    )
                ),
                Lesson(
                    id = "mod13_les3",
                    moduleId = 13,
                    order = 3,
                    titleAz = "Modelin təlimi və test edilməsi (Train-Test Split)",
                    titleEn = "Model Training & Evaluation (Train-Test Split)",
                    titleRu = "Обучение и тестирование модели (Train-Test Split)",
                    summaryAz = "Məlumatın 80/20 və ya 70/30 nisbətində bölünməsi və Cross-Validation.",
                    summaryEn = "Preventing data leakage, 80/20 partitioning, and K-Fold cross validation.",
                    summaryRu = "Разделение выборки 80/20 и кросс-валидация K-Fold.",
                    contentKidsAz = "İmtahandan əvvəl müəllim sənə hazırlıq sualları verir, amma imtahanda tamamilə yeni suallar soruşur! Train-Test də eynilə belədir. 🎓",
                    contentAdultsAz = "Train-Test Bölünməsi və Qızıl Qayda:\n- Təlim Məlumatı (Train Set - 80%): Modelin çəkilərini öyrənməsi üçün.\n- Test Məlumatı (Test Set - 20%): Modelin əvvəllər heç vaxt görmədiyi real həyat nümunələrindəki dəqiqliyini ölçmək üçün.\n- Data Leakage: Test datasındakı məlumatların təlimə sızmasının qarşısını almaq mütləqdir.",
                    contentKidsEn = "We keep test questions secret so we can check if AI truly learned the topic!",
                    contentAdultsEn = "Train-test splitting benchmarks generalization power and prevents optimistic evaluation bias.",
                    contentKidsRu = "Тестовая выборка проверяет, как модель справляется с абсолютно новыми данными!",
                    contentAdultsRu = "Разделение train_test_split исключает переобучение и утечку целевой переменной.",
                    codeSnippet = "from sklearn.model_selection import train_test_split\nX = [[1], [2], [3], [4], [5]]\ny = [2, 4, 6, 8, 10]\nX_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)\nprint('Təlim sayı:', len(X_train), '| Test sayı:', len(X_test))",
                    keyTakeawaysAz = listOf(
                        "Test datası yalnız yekun qiymətləndirmə üçündür",
                        "random_state nəticələrin təkrarlana bilməsini təmin edir",
                        "Cross-validation modeli bir neçə qat üzrə etibarlı yoxlayır"
                    )
                )
            )
        ),

        // Modul 14
        CourseModule(
            id = 14,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 14: Xətti Reqressiya (Linear Regression)",
            titleEn = "Module 14: Linear Regression",
            titleRu = "Модуль 14: Линейная регрессия",
            descAz = "Qiymət və dəyər proqnozlaşdırma modelləri, əmsalların tapılması, xəttin qurulması və dəqiqlik.",
            descEn = "Predicting continuous values, slope and intercept parameters, MSE, RMSE, and R-squared.",
            descRu = "Прогнозирование непрерывных величин, уравнение прямой, метрики MSE и R2.",
            iconEmoji = "📏",
            lessons = listOf(
                Lesson(
                    id = "mod14_les1",
                    moduleId = 14,
                    order = 1,
                    titleAz = "Qiymət və dəyər proqnozlaşdırma modelləri",
                    titleEn = "Predicting Prices & Numerical Values",
                    titleRu = "Прогнозирование цен и числовых значений",
                    summaryAz = "Davamlı (continuous) ədədlərin proqnozlaşdırılması: Ev qiymətləri, hava temperaturu.",
                    summaryEn = "Regression objectives: forecasting continuous variables like house prices and sales.",
                    summaryRu = "Задачи регрессии: прогнозирование цен на жилье, температур и спроса.",
                    contentKidsAz = "Əgər dondurmanın qiyməti havanın istiliyindən asılı olaraq artırsa, Xətti Reqressiya sabah dondurmanın neçəyə olacağını proqnozlaşdıra bilir! 🍦☀️",
                    contentAdultsAz = "Reqressiya Analizi fasiləsiz ədədi hədəfləri (y) asılı olmayan xüsusiyyətlər (X) vasitəsilə təxmin edir.\n\nRiyazi Tənlik:\ny = w * x + b\n- y: Proqnozlaşdırılan dəyər (məs. Evin qiyməti)\n- x: Giriş xüsusiyyəti (məs. Evin sahəsi kv.m)\n- w: Maililik / Çəki (Slope / Weight)\n- b: Sərbəst hədd (Intercept / Bias)",
                    contentKidsEn = "Linear regression draws the best line through your points to guess future prices!",
                    contentAdultsEn = "Linear regression models conditional expectation as an affine combination of input features.",
                    contentKidsRu = "Линейная регрессия находит прямую линию, которая лучше всего описывает тренд!",
                    contentAdultsRu = "Уравнение прямой y = wx + b описывает зависимость целевой переменной от факторов.",
                    codeSnippet = "from sklearn.linear_model import LinearRegression\nimport numpy as np\nX = np.array([[50], [80], [120]]) # Sahə (m2)\ny = np.array([50000, 80000, 120000]) # Qiymət ($)\nmodel = LinearRegression().fit(X, y)\nprint('100 m2 evin təxmini qiyməti:', model.predict([[100]])[0])",
                    keyTakeawaysAz = listOf(
                        "Reqressiya fasiləsiz rəqəmləri proqnozlaşdırır",
                        "Ən yaxşı xətt bütün nöqtələrə olan məsafənin kvadratları cəmini minimum edir",
                        "Sadə və izaholunan ən güclü baza modelidir"
                    )
                ),
                Lesson(
                    id = "mod14_les2",
                    moduleId = 14,
                    order = 2,
                    titleAz = "Əmsalların tapılması və xəttin qurulması (Ordinary Least Squares)",
                    titleEn = "Coefficient Estimation & Ordinary Least Squares (OLS)",
                    titleRu = "Поиск коэффициентов и метод наименьших квадратов (МНК)",
                    summaryAz = "Xətaların kvadratları cəminin (MSE) minimumlaşdırılması və analitik həll.",
                    summaryEn = "Minimizing Residual Sum of Squares (RSS) via closed-form OLS solutions.",
                    summaryRu = "Минимизация среднеквадратичной ошибки MSE методом наименьших квадратов.",
                    contentKidsAz = "Bütün nöqtələrin tən ortasından keçən elə bir sehrli xətt çəkirik ki, heç bir nöqtə xətdən çox uzaqda qalmasın! 📐",
                    contentAdultsAz = "Ən Kiçik Kvadratlar Metodu (Ordinary Least Squares - OLS):\n- Xəta (Residual - e_i) = y_real - y_pred\n- Məqsəd: Bütün nöqtələr üçün Sum((y_i - (w*x_i + b))^2) cəmini minimum etmək.\n- Çoxölçülü Reqressiya: y = w1*x1 + w2*x2 + ... + wn*xn + b\n- Matris forması: w = (X^T * X)^(-1) * X^T * y",
                    contentKidsEn = "OLS finds the line that makes the smallest total errors on all points!",
                    contentAdultsEn = "Ordinary Least Squares estimates parameters by minimizing the sum of squared residuals.",
                    contentKidsRu = "Метод наименьших квадратов подбирает угол наклона прямой с минимальной ошибкой.",
                    contentAdultsRu = "МНК находит глобальный минимум квадратичной функции потерь через аналитическое решение.",
                    codeSnippet = "# Model əmsalları\n# w = model.coef_\n# b = model.intercept_\nprint('Xətt tənliyi: y = coef * x + intercept')",
                    keyTakeawaysAz = listOf(
                        "MSE xətaların böyük olmasına daha sərt cəza tətbiq edir",
                        "Əmsallar hər parametrin qiymətə neçə manat təsir etdiyini göstərir",
                        "Xətti asılılıq olmadıqda polinamial xüsusiyyətlər əlavə edilə bilər"
                    )
                ),
                Lesson(
                    id = "mod14_les3",
                    moduleId = 14,
                    order = 3,
                    titleAz = "Modelin dəqiqliyinin yoxlanılması (MAE, MSE, RMSE, R²)",
                    titleEn = "Evaluating Model Accuracy (MAE, MSE, RMSE, R²)",
                    titleRu = "Оценка точности регрессии (MAE, MSE, RMSE, R²)",
                    summaryAz = "Metriklər: MAE (Orta Mütləq Xəta), RMSE və Determinasıya əmsalı (R-Squared).",
                    summaryEn = "Evaluation metrics: Mean Absolute Error, Root Mean Squared Error, and R² score.",
                    summaryRu = "Метрики качества: MAE, RMSE и коэффициент детерминации R-квадрат.",
                    contentKidsAz = "Modelin nə qədər az səhv etdiyini faizlə yoxlayırıq: R² balı 100%-ə nə qədər yaxındırsa, model bir o qədər əladır! 💯",
                    contentAdultsAz = "Reqressiya Qiymətləndirmə Metrikləri:\n1. MAE (Mean Absolute Error): Orta mütləq səhv (valyuta vahidi ilə birbaşa oxunur).\n2. MSE / RMSE (Root Mean Squared Error): Böyük səhvləri cəzalandıran standart xəta.\n3. R² (Determinasıya Əmsalı): Modelin verilənlərdəki dispersiyanı hansı nisbətdə izah etdiyini göstərir (0 ilə 1 arasında, 1 = Mükəmməl uyğunluq).",
                    contentKidsEn = "R² score tells us what percentage of the data our model successfully explains!",
                    contentAdultsEn = "R-squared measures the proportion of variance explained by model predictors relative to baseline.",
                    contentKidsRu = "Коэффициент R² показывает долю объясненной моделью дисперсии от 0 до 1!",
                    contentAdultsRu = "Метрики MAE и RMSE измеряют абсолютную и квадратичную погрешность прогноза.",
                    codeSnippet = "from sklearn.metrics import r2_score, mean_absolute_error\ny_real = [100, 200, 300]\ny_pred = [105, 195, 302]\nprint('MAE:', mean_absolute_error(y_real, y_pred))\nprint('R² Balı:', r2_score(y_real, y_pred))",
                    keyTakeawaysAz = listOf(
                        "MAE xətanın orta manat ölçüsünü göstərir",
                        "R² = 0.90 o deməkdir ki, qiymət dəyişkənliyinin 90%-i model tərəfindən izah edilir",
                        "Həmişə bir neçə metriki birlikdə qiymətləndirin"
                    )
                )
            )
        ),

        // Modul 15
        CourseModule(
            id = 15,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 15: Loqistik Reqressiya və Təsnifat (Classification)",
            titleEn = "Module 15: Logistic Regression & Classification",
            titleRu = "Модуль 15: Логистическая регрессия и классификация",
            descAz = "İkili təsnifat məsələləri (Bəli/Xeyr, Spam/Normal), qərar sərhədləri və Sigmoid ehtimal hesablamaları.",
            descEn = "Binary classification (Spam/Ham), decision boundaries, and Sigmoid probability curves.",
            descRu = "Бинарная классификация, сигмоида, логистические функции и границы решений.",
            iconEmoji = "⚖️",
            lessons = listOf(
                Lesson(
                    id = "mod15_les1",
                    moduleId = 15,
                    order = 1,
                    titleAz = "İkili təsnifat məsələləri (Bəli/Xeyr, Spam/Normal)",
                    titleEn = "Binary Classification Problems (Yes/No, Spam/Ham)",
                    titleRu = "Задачи бинарной классификации (Да/Нет, Спам/Норма)",
                    summaryAz = "Klassifikasiya tərifi, 0 və 1 sinifləri, tibbi diaqnoz və kredit təsdiqi.",
                    summaryEn = "Binary class labels, probabilities, spam filtering, and risk scoring.",
                    summaryRu = "Бинарные метки классов 0 и 1, медицинская диагностика и спам-фильтры.",
                    contentKidsAz = "Gələn məktubun Spam (Lazımsız reklam), yoxsa Dostundan gələn vacib məktub olduğunu ayırd etmək! 📧🛡️",
                    contentAdultsAz = "Təsnifat (Classification) giriş verilənlərini diskret kateqoriyalara ayırır:\n- İkili Təsnifat (Binary): 2 sinif (0 və ya 1, Məs. Xəstə / Sağlam).\n- Çoxsinifli Təsnifat (Multiclass): 3 və daha çox sinif (Məs. Pişik / İt / Quş).\n- Loqistik Reqressiya: Adında reqressiya olsa da, əslində təsnifat üçün ehtimal (0.0 - 1.0) hesablayan modeldir.",
                    contentKidsEn = "Classification puts things into neat categories like Yes or No!",
                    contentAdultsEn = "Binary classification maps feature vectors to Bernoulli probability distributions.",
                    contentKidsRu = "Классификация разделяет объекты на категории, например: спам или важное письмо!",
                    contentAdultsRu = "Логистическая регрессия вычисляет вероятность принадлежности объекта к классу.",
                    codeSnippet = "from sklearn.linear_model import LogisticRegression\nmodel = LogisticRegression()\n# model.fit(X, y_binary)\nprint('Loqistik Reqressiya modeli hazırdır')",
                    keyTakeawaysAz = listOf(
                        "Təsnifat kateqorial qərarlar qəbul edir",
                        "Loqistik reqressiya çıxışda ehtimal faizi qaytarır",
                        "Əsas tətbiqləri: spam filtri, fraud aşkarlanması, xəstəlik diaqnozu"
                    )
                ),
                Lesson(
                    id = "mod15_les2",
                    moduleId = 15,
                    order = 2,
                    titleAz = "Qərar sərhədləri və ehtimal hesablamaları (Sigmoid Funksiyası)",
                    titleEn = "Decision Boundaries & Sigmoid Probabilities",
                    titleRu = "Границы решений и функция Sigmoid",
                    summaryAz = "Sigmoid düsturu: 1 / (1 + e^(-z)), Threshold həddi (0.5) və Cross-Entropy Loss.",
                    summaryEn = "Sigmoid mapping to [0,1], decision thresholding, and Log-Loss optimization.",
                    summaryRu = "Функция активации Sigmoid, порог 0.5 и функция потерь Log-Loss.",
                    contentKidsAz = "Sigmoid funksiyası istənilən nəhəng rəqəmi 0% ilə 100% arasına sığışdıran sehrli bir qıf kimidir! 📉",
                    contentAdultsAz = "Sigmoid Aktivasiya Funksiyası:\n$$\\sigma(z) = \\frac{1}{1 + e^{-z}}$$\n- z = w*x + b olduqda:\n  Əgər z çox böyükdürsə -> sigma(z) ~ 1.0\n  Əgər z çox mənfidirsə -> sigma(z) ~ 0.0\n- Qərar Həddi (Threshold): Standart olaraq P >= 0.5 olduqda Sinif 1, əks halda Sinif 0 təyin olunur.\n- Log-Loss (Binary Cross-Entropy): Modelin proqnozlaşdırdığı ehtimal ilə real fakt arasındakı xətanı cəzalandırır.",
                    contentKidsEn = "Sigmoid squashes any big number into a clean percentage between 0% and 100%!",
                    contentAdultsEn = "The Sigmoid link function squashes real-valued logits into calibrated posterior probabilities.",
                    contentKidsRu = "Сигмоида сжимает любые числа в диапазон вероятностей от 0 до 1!",
                    contentAdultsRu = "Порог вероятности 0.5 разделяет пространство признаков гиперплоскостью решения.",
                    codeSnippet = "import math\ndef sigmoid(z):\n    return 1 / (1 + math.exp(-z))\n\nprint('z=0 üçün ehtimal:', sigmoid(0))\nprint('z=5 üçün ehtimal:', sigmoid(5))\nprint('z=-5 üçün ehtimal:', sigmoid(-5))",
                    keyTakeawaysAz = listOf(
                        "Sigmoid çıxışı həmişə [0, 1] intervalında saxlayır",
                        "Həssas sahələrdə (tibbdə) threshold 0.3-ə endirilə bilər",
                        "Log-loss düzgün cavaba yüksək əminliklə verilən səhvləri kəskin cəzalandırır"
                    )
                )
            )
        ),

        // Modul 16
        CourseModule(
            id = 16,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 16: Qərar Ağacları (Decision Trees)",
            titleEn = "Module 16: Decision Trees",
            titleRu = "Модуль 16: Деревья решений (Decision Trees)",
            descAz = "Qərar ağaclarının iş prinsipi və məntiqi, Gini əmsalı və məlumat qazancı (Information Gain).",
            descEn = "Tree topology, recursive binary splitting, Gini impurity, entropy, and pruning.",
            descRu = "Деревья решений, критерий Джини, энтропия, прирост информации и прунинг.",
            iconEmoji = "🌳",
            lessons = listOf(
                Lesson(
                    id = "mod16_les1",
                    moduleId = 16,
                    order = 1,
                    titleAz = "Qərar ağaclarının iş prinsipi və məntiqi",
                    titleEn = "How Decision Trees Work (Nodes, Branches, Leaves)",
                    titleRu = "Принцип работы и логика деревьев решений",
                    summaryAz = "Kök (Root), Budaqlar (Branches) və Yarpaqlar (Leaves). İnsan kimi sual-cavab məntiqi.",
                    summaryEn = "Tree architecture, root nodes, interior decision splits, and leaf predictions.",
                    summaryRu = "Архитектура дерева: корневой узел, ветви решений и листовые прогнозы.",
                    contentKidsAz = "Qərar ağacı '20 Sual' oyunu kimidir! 'Qanadları varmı?' -> Hə -> 'Uça bilirmi?' -> Bəli -> 'Bu Qartaldır!' 🦅",
                    contentAdultsAz = "Qərar Ağacları (Decision Trees) həm təsnifat, həm də reqressiya üçün ən aydın və vizuallaşdırıla bilən modellərdir:\n- Kök Düyün (Root Node): Bütün verilənləri ehtiva edən ilk başlanğıc sual.\n- Qərar Düyünləri (Internal Nodes): Məlumatı ən yaxşı ayıran xüsusiyyət üzrə budaqlanma.\n- Yarpaqlar (Leaves): Yekun sinif və ya dəyər proqnozu.\n- Üstünlüyü: Məlumatın miqyaslanmasına (scaling) ehtiyac duymur və tam izaholunandır.",
                    contentKidsEn = "Decision trees play guessing games asking smart yes/no questions!",
                    contentAdultsEn = "Decision trees partition the feature space into orthogonal hyper-rectangles via greedy recursive splitting.",
                    contentKidsRu = "Дерево решений последовательно задает вопросы, приводя к точному ответу!",
                    contentAdultsRu = "Деревья решений легко интерпретируются и не требуют нормализации признаков.",
                    codeSnippet = "from sklearn.tree import DecisionTreeClassifier\ntree = DecisionTreeClassifier(max_depth=3)\n# tree.fit(X, y)\nprint('Qərar ağacı modeli quruldu')",
                    keyTakeawaysAz = listOf(
                        "Qərar ağacları insan düşüncə tərzinə ən yaxın modeldir",
                        "max_depth parametri ağacın dərinliyini məhdudlaşdırır",
                        "Həm rəqəmlər, həm də kateqoriyalarla əla işləyir"
                    )
                ),
                Lesson(
                    id = "mod16_les2",
                    moduleId = 16,
                    order = 2,
                    titleAz = "Gini əmsalı və məlumat qazancı (Information Gain & Entropy)",
                    titleEn = "Gini Impurity & Information Gain (Entropy)",
                    titleRu = "Коэффициент Джини и прирост информации (Information Gain)",
                    summaryAz = "Qarışıqlıq dərəcəsi (Impurity), Şennon Entropiyası və ən yaxşı bölgünün tapılması.",
                    summaryEn = "Splitting criteria: Gini impurity minimization and Shannon entropy reduction.",
                    summaryRu = "Критерии разбиения: неоднородность Джини и энтропия Шеннона.",
                    contentKidsAz = "Bir qutuda yalnız qırmızı şarlar olanda qutu çox təmizdir (Gini=0). Əgər hər rəng qarışıqdırsa, ağac ən təmiz bölgünü seçir! 🎈",
                    contentAdultsAz = "Bölünmə Meyarları:\n1. Gini Impurity: Qrupdakı elementlərin nə dərəcədə qarışıq olduğunu ölçür:\n   Gini = 1 - sum(p_i^2)\n   Gini = 0 olduqda qrup tam safdır (bütün nümunələr eyni sinfə aiddir).\n2. Entropiya və Information Gain: Xaos dərəcəsini ölçür. Ağac hər addımda Entropiyanı ən çox azaldan sualı (xüsusiyyəti) seçir.",
                    contentKidsEn = "Gini score checks how pure and clean our sorted groups are!",
                    contentAdultsEn = "Information gain maximizes mutual information between split predicates and target class labels.",
                    contentKidsRu = "Индекс Джини оценивает чистоту разделения классов в узле дерева!",
                    contentAdultsRu = "Алгоритм CART минимизирует неоднородность Джини на каждом шаге ветвления.",
                    codeSnippet = "# Gini Hesablanması (Təmiz qrup vs Qarışıq qrup)\np1, p2 = 0.5, 0.5 # 50% Qırmızı, 50% Mavi\ngini_qarisiq = 1 - (p1**2 + p2**2)\nprint('Qarışıq qrup Gini:', gini_qarisiq) # 0.5",
                    keyTakeawaysAz = listOf(
                        "Gini=0 olanda düyün safdır və bölünmə dayanır",
                        "Information Gain xaosu azaldan xüsusiyyəti birinci sual seçir",
                        "Bu riyaziyyat ağacın avtomatik ən vacib xüsusiyyətləri tapmasını təmin edir"
                    )
                )
            )
        ),

        // Modul 17
        CourseModule(
            id = 17,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 17: Random Forest və Ensemble Modellər",
            titleEn = "Module 17: Random Forest & Ensemble Models",
            titleRu = "Модуль 17: Случайный лес (Random Forest) и ансамбли",
            descAz = "Meşə ağacları modeli, Bagging, Boosting və Overfitting (həddindən artıq uyğunlaşma) həlli.",
            descEn = "Bagging ensembles, voting classifiers, feature subsampling, and overfitting mitigation.",
            descRu = "Ансамбли моделей, бэггинг, случайный лес и борьба с переобучением (Overfitting).",
            iconEmoji = "🌲",
            lessons = listOf(
                Lesson(
                    id = "mod17_les1",
                    moduleId = 17,
                    order = 1,
                    titleAz = "Meşə ağacları modeli və gücləndirilmiş alqoritmlər",
                    titleEn = "Random Forest Architecture & Bagging",
                    titleRu = "Архитектура Random Forest и бэггинг",
                    summaryAz = "Tək ağac yerinə 100 ağacın səsverməsi (Wisdom of the Crowds) və Bootstrap Aggregation.",
                    summaryEn = "Wisdom of crowds, bootstrap aggregating (Bagging), and majority voting.",
                    summaryRu = "Коллективное голосование сотен деревьев и бутстрэп-агрегация (Bagging).",
                    contentKidsAz = "Tək bir insanın fikri yerinə 100 müdrik ağacın məclis qurub səs verməsi kimi! Çoxluq hər zaman daha etibarlı qərar verir. 🌲🌳🌴",
                    contentAdultsAz = "Random Forest (Təsadüfi Meşə) — Ansambl (Ensemble) öyrənmənin ən güclü nümayəndəsidir:\n- Bagging (Bootstrap Aggregating): Orijinal datadan təsadüfi seçimlərlə (nümunələrin təkrarı ilə) yüzlərlə fərqli alt-dataset yaradılır.\n- Xüsusiyyət Təsadüfiliyi (Feature Subsampling): Hər düyündə bütün xüsusiyyətlər deyil, yalnız təsadüfi sqrt(N) xüsusiyyət nəzərə alınır.\n- Səsvermə (Majority Voting): Bütün ağacların çıxışları birləşdirilərək ən çox səs toplayan sinif qalib elan olunur.",
                    contentKidsEn = "A whole forest of trees votes together to get the most accurate answer!",
                    contentAdultsEn = "Random Forest reduces variance without increasing bias via de-correlated bagging estimators.",
                    contentKidsRu = "Ансамбль из сотен независимых деревьев голосует за самый вероятный класс!",
                    contentAdultsRu = "Случайный лес снижает дисперсию за счет декорреляции отдельных деревьев.",
                    codeSnippet = "from sklearn.ensemble import RandomForestClassifier\nforest = RandomForestClassifier(n_estimators=100, random_state=42)\n# forest.fit(X_train, y_train)\nprint('100 Ağaclı Random Forest hazırdır')",
                    keyTakeawaysAz = listOf(
                        "Random Forest tək Qərar Ağacından qat-qat sabit və dəqiqdir",
                        "Ağacların müxtəlifliyi səhvlərin bir-birini kompensasiya etməsini təmin edir",
                        "Tabulyar yarışmalarda (Kaggle) ən çox qazanan alqoritmlərdəndir"
                    )
                ),
                Lesson(
                    id = "mod17_les2",
                    moduleId = 17,
                    order = 2,
                    titleAz = "Overfitting (Həddindən artıq uyğunlaşma) problemi və həlli",
                    titleEn = "Overfitting vs Underfitting: Causes & Cures",
                    titleRu = "Проблема переобучения (Overfitting) и методы борьбы",
                    summaryAz = "Məlumatı əzbərləmək (Overfitting) vs Öyrənməmək (Underfitting), Requlyarizasiya və Budama.",
                    summaryEn = "Bias-Variance tradeoff, memorization vs generalization, pruning, and L1/L2 regularization.",
                    summaryRu = "Переобучение (зубрежка данных), регуляризация и обрезка ветвей (Pruning).",
                    contentKidsAz = "Dərsi anlamaq əvəzinə sualları əzbərləyən şagird imtahanda yeni sual görəndə çaşır! Overfitting də modelin məlumatı əzbərləməsidir. 🧠🚫",
                    contentAdultsAz = "Bias-Variance Kompromisi:\n1. Underfitting (Yüksək Bias): Model çox sadədir, qanunauyğunluqları öyrənə bilmir (Təlim balı aşağı, Test balı aşağı).\n2. Overfitting (Yüksək Variance): Model məlumatı və onun içindəki səs-küyü (noise) əzbərləyir (Təlim balı 99%, Test balı 60%).\n3. Həll Yolları:\n   - Ağacın dərinliyini məhdudlaşdırmaq (max_depth, min_samples_split).\n   - Daha çox məlumat toplamaq.\n   - Budama (Pruning) və Ansambl metodlarından istifadə etmək.",
                    contentKidsEn = "Don't just memorize the test answers—understand the concepts so you ace new questions!",
                    contentAdultsEn = "Overfitting occurs when model capacity fits stochastic noise rather than underlying generating distribution.",
                    contentKidsRu = "Переобученная модель идеально знает тренировочный датасет, но ошибается на новых данных.",
                    contentAdultsRu = "Регуляризация и ограничение глубины max_depth предотвращают переобучение.",
                    codeSnippet = "# Overfitting-in qarşısını alan parametrlər\nmodel = RandomForestClassifier(\n    n_estimators=100,\n    max_depth=5, # Çox dərinə getməsin\n    min_samples_leaf=10 # Yarpaqda ən az 10 nümunə olsun\n)",
                    keyTakeawaysAz = listOf(
                        "Təlim balı yüksək, test balı aşağıdırsa -> Overfitting var",
                        "max_depth qoymaq əzbərləmənin qarşısını alır",
                        "Cross-validation overfitting-i vaxtında aşkar edir"
                    )
                )
            )
        ),

        // Modul 18
        CourseModule(
            id = 18,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 18: Klasterləşdirmə (K-Means Clustering)",
            titleEn = "Module 18: K-Means Clustering",
            titleRu = "Модуль 18: Кластеризация методом K-Means",
            descAz = "Nəzarətsiz öyrənmə və qruplaşdırma, müştəri seqmentasiyası və Dirsek (Elbow) metodu.",
            descEn = "Unsupervised grouping, centroid updates, customer segmentation, and the Elbow method.",
            descRu = "Обучение без учителя, центроиды, сегментация клиентов и метод локтя (Elbow method).",
            iconEmoji = "🎯",
            lessons = listOf(
                Lesson(
                    id = "mod18_les1",
                    moduleId = 18,
                    order = 1,
                    titleAz = "Nəzarətsiz öyrənmə və qruplaşdırma məntiqi",
                    titleEn = "Unsupervised Grouping & Centroid Logic",
                    titleRu = "Логика кластеризации и центроиды",
                    summaryAz = "K-Means alqoritminin addımları: K sayda mərkəz təyini, məsafələrin hesablanması və mərkəz yeniləməsi.",
                    summaryEn = "Iterative Voronoi partitioning, Euclidean distance minimization, and centroid convergence.",
                    summaryRu = "Итеративное обновление центроидов по евклидовому расстоянию до сходимости.",
                    contentKidsAz = "Qarışıq konfetləri heç kim kömək etmədən rənglərinə və dadlarına görə ayrı-ayrı qablaşdırmaq kimidir! 🍬🍭",
                    contentAdultsAz = "K-Means Klasterləşdirmə Alqoritmi:\n1. Addım 1: Təsadüfi K sayda mərkəz nöqtəsi (Centroids) seçilir.\n2. Addım 2: Hər bir məlumat nöqtəsi ən yaxın mərkəzə təhkim olunur (Evklid məsafəsi ilə).\n3. Addım 3: Hər klasterin yeni mərkəzi ona aid nöqtələrin ədədi ortası (Mean) olaraq yenilənir.\n4. Addım 4: Mərkəzlərin yeri dəyişməyənə qədər addım 2 və 3 təkrarlanır.",
                    contentKidsEn = "K-Means groups similar candies into matching bowls automatically!",
                    contentAdultsEn = "K-Means iteratively partitions observations into Voronoi cells minimizing within-cluster sum of squares.",
                    contentKidsRu = "Алгоритм K-Means автоматически объединяет похожие объекты в кластеры вокруг центроидов!",
                    contentAdultsRu = "Итеративная минимизация внутрикластерной дисперсии до стабилизации центров.",
                    codeSnippet = "from sklearn.cluster import KMeans\nkmeans = KMeans(n_clusters=3, random_state=42)\n# kmeans.fit(X_unlabeled)\n# klasterler = kmeans.predict(X_unlabeled)\nprint('3 Klasterə qruplaşdırıldı')",
                    keyTakeawaysAz = listOf(
                        "K-Means-də düzgün cavablara (etiketlərə) ehtiyac yoxdur",
                        "Evklid məsafəsi nöqtələrin oxşarlığını ölçür",
                        "İterasiyalar mərkəzlər sabitləşənədək davam edir"
                    )
                ),
                Lesson(
                    id = "mod18_les2",
                    moduleId = 18,
                    order = 2,
                    titleAz = "Müştəri seqmentasiyası və anomaliyaların aşkarlanması",
                    titleEn = "Customer Segmentation & Optimal K (Elbow Method)",
                    titleRu = "Сегментация клиентов и выбор числа кластеров (Метод локтя)",
                    summaryAz = "Biznesdə müştəri qrupları (VİP, Qənaətcil), WCSS və Dirsek (Elbow) qrafiki.",
                    summaryEn = "RFM marketing segmentation, WCSS inertia curves, and Elbow inflection points.",
                    summaryRu = "RFM-сегментация клиентов, график инерции WCSS и точка перегиба локтя.",
                    contentKidsAz = "Mağaza alıcılarını sevimli məhsullarına görə 3 fərqli qrupa ayırıb onlara xüsusi hədiyyələr vermək! 🎁",
                    contentAdultsAz = "Tətbiq Sahələri və K-nın Seçilməsi:\n- Müştəri Seqmentasiyası: Alış-veriş tezliyi və məbləğinə görə müştəriləri VİP, Daimi və Passiv qruplara bölmək.\n- Optimal K Sayının Tapılması (Elbow Method): K artdıqca Klasterdaxili Kvadratlar Cəmi (Inertia / WCSS) azalır. Qrafikin dirsək kimi qatlandığı nöqtə optimal K sayılır.",
                    contentKidsEn = "The elbow chart tells us exactly how many groups make the most sense!",
                    contentAdultsEn = "The Elbow heuristic identifies the parsimonious cluster count balancing variance and complexity.",
                    contentKidsRu = "Метод локтя на графике инерции подсказывает идеальное количество кластеров!",
                    contentAdultsRu = "Кластеризация позволяет выделить VIP-клиентов и персонализировать предложения.",
                    codeSnippet = "# İnersiya (WCSS) dəyəri\n# inertia = kmeans.inertia_\nprint('Inertia nə qədər kiçikdirsə, qruplar o qədər sıxdır')",
                    keyTakeawaysAz = listOf(
                        "Klasterləşdirmə marketinqdə fərdiləşdirilmiş təkliflər üçün əsasdır",
                        "Dirsek metodu ən uyğun qrup sayını vizual olaraq göstərir",
                        "Klasterlərdən kənarda qalan tənha nöqtələr anomaliya (saxtakarlıq) sayıla bilər"
                    )
                )
            )
        ),

        // Modul 19
        CourseModule(
            id = 19,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 19: Maşın Öyrənməsi Performans Metrikləri",
            titleEn = "Module 19: Machine Learning Performance Metrics",
            titleRu = "Модуль 19: Метрики производительности машинного обучения",
            descAz = "Accuracy, Precision, Recall, F1-Score, Confusion Matrix və ROC-AUC əyrisi.",
            descEn = "Confusion Matrix, Accuracy paradox, Precision, Recall, F1-Score, and ROC-AUC curve.",
            descRu = "Матрица ошибок (Confusion Matrix), Accuracy, Precision, Recall, F1-score и ROC-AUC.",
            iconEmoji = "🏆",
            lessons = listOf(
                Lesson(
                    id = "mod19_les1",
                    moduleId = 19,
                    order = 1,
                    titleAz = "Accuracy, Precision, Recall və F1-Score",
                    titleEn = "Accuracy, Precision, Recall & F1-Score",
                    titleRu = "Метрики Accuracy, Precision, Recall и F1-Score",
                    summaryAz = "Niyə təkcə Accuracy kifayət deyil? Balanssız verilənlər və həssaslıq (Recall).",
                    summaryEn = "Accuracy paradox on imbalanced datasets, Precision vs Recall trade-offs, and F1 harmonic mean.",
                    summaryRu = "Парадокс точности Accuracy, баланс Precision и Recall, гармоническое среднее F1.",
                    contentKidsAz = "100 qapıdan 99-u açıqdırsa, 'Bütün qapılar açıqdır' deyən robot 99% düz çıxar, amma bağlı qapını heç vaxt tapa bilməz! Ona görə daha ağıllı qiymətləndirmə lazımdır! 🚪",
                    contentAdultsAz = "Təsnifat Metrikləri:\n- True Positive (TP), False Positive (FP), True Negative (TN), False Negative (FN).\n- Accuracy (Dəqiqlik): (TP + TN) / Total (Balanssız datada aldadıcı ola bilər).\n- Precision (Dəqiqlik dərəcəsi): TP / (TP + FP) — 'Modelin müsbət dediklərinin neçə faizi həqiqətən düz çıxdı?'\n- Recall (Həssaslıq): TP / (TP + FN) — 'Bütün real xəstələrin neçə faizini model tapa bildi?'\n- F1-Score: Precision və Recall-un harmonik ortası:\n  F1 = 2 * (Precision * Recall) / (Precision + Recall)",
                    contentKidsEn = "F1-Score makes sure our AI is both super careful and never misses anything important!",
                    contentAdultsEn = "F1-score provides a robust single-number evaluation metric balancing false alarms and missed detections.",
                    contentKidsRu = "F1-Score находит идеальный баланс между точностью (Precision) и полнотой (Recall)!",
                    contentAdultsRu = "На несбалансированных выборках F1-score объективнее обычной точности Accuracy.",
                    codeSnippet = "from sklearn.metrics import classification_report\ny_real = [1, 1, 0, 1, 0]\ny_pred = [1, 0, 0, 1, 0]\nprint(classification_report(y_real, y_pred))",
                    keyTakeawaysAz = listOf(
                        "Tibbdə və təhlükəsizlikdə Recall ən vacib metrikdir (xəstəni qaçırmamaq)",
                        "Spam filtrində Precision vacibdir (vacib emaili spama atmamaq)",
                        "F1-Score hər iki metriki balanslaşdırır"
                    )
                ),
                Lesson(
                    id = "mod19_les2",
                    moduleId = 19,
                    order = 2,
                    titleAz = "Confusion Matrix (Qarışıqlıq Matrisi) oxunması və analizi",
                    titleEn = "Reading & Analyzing the Confusion Matrix",
                    titleRu = "Чтение и анализ матрицы ошибок (Confusion Matrix)",
                    summaryAz = "Həqiqi vs Proqnozlaşdırılan matris cədvəli və səhvlərin vizual təhlili.",
                    summaryEn = "2x2 contingency table interpretation, diagonal accuracy, and error distribution.",
                    summaryRu = "Интерпретация таблицы ошибок 2x2, главная диагональ и ошибки 1 и 2 рода.",
                    contentKidsAz = "Müəllimin qiymət cədvəli kimi: hansı suallara düz, hansılara səhv cavab verildiyini göstərən 4 xanalı cədvəl! 📊",
                    contentAdultsAz = "Confusion Matrix (Qarışıqlıq Matrisi):\n|                | Proqnoz: Müsbət (1) | Proqnoz: Mənfi (0) |\n|----------------|---------------------|--------------------|\n| Real: Müsbət (1)| True Positive (TP)  | False Negative (FN) (Tip II Səhv)|\n| Real: Mənfi (0) | False Positive (FP) (Tip I Səhv)| True Negative (TN) |\n\n- Tip I Səhv (False Alarm): Sağlam adama 'Xəstəsən' demək.\n- Tip II Səhv (Missed Threat): Xəstə adama 'Sağlamsan' deyib buraxmaq (ən təhlükəlisi!).",
                    contentKidsEn = "Confusion matrix shows every right guess and every tiny mistake clearly!",
                    contentAdultsEn = "Confusion matrix visualizes type I and type II error frequencies across discrete classes.",
                    contentKidsRu = "Матрица ошибок наглядно показывает ошибки первого и второго рода!",
                    contentAdultsRu = "Анализ матрицы ошибок позволяет настроить оптимальный порог классификации.",
                    codeSnippet = "from sklearn.metrics import confusion_matrix\ncm = confusion_matrix([1, 0, 1, 1], [1, 0, 0, 1])\nprint('Confusion Matrix:\\n', cm)",
                    keyTakeawaysAz = listOf(
                        "Matrisin əsas diaqonalındakı rəqəmlər düzgün cavablardır",
                        "Tip II səhv real təhlükəni qaçırmaq deməkdir",
                        "Seaborn heatmap ilə matrisi rəngli vizuallaşdırmaq asandır"
                    )
                )
            )
        )
    )
}

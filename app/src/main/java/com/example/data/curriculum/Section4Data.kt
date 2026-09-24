package com.example.data.curriculum

import com.example.data.models.CourseModule
import com.example.data.models.Lesson
import com.example.data.models.QuizOption
import com.example.data.models.QuizQuestion

object Section4Data {
    private const val SEC_NUM = 4
    private const val SEC_TITLE_AZ = "Bölüm 4: Dərin Öyrənmə (Deep Learning) və Neyron Şəbəkələr"
    private const val SEC_TITLE_EN = "Part 4: Deep Learning & Neural Networks"
    private const val SEC_TITLE_RU = "Раздел 4: Глубокое обучение и нейронные сети"

    val modules: List<CourseModule> = listOf(
        // Modul 20
        CourseModule(
            id = 20,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 20: Süni Neyron Şəbəkələrə Giriş (ANN)",
            titleEn = "Module 20: Introduction to Artificial Neural Networks (ANN)",
            titleRu = "Модуль 20: Введение в искусственные нейронные сети (ANN)",
            descAz = "İnsan neyronunun rəqəmsal modeli, Ağırlıqlar (Weights), bias və aktivləşdirmə funksiyaları (ReLU, Sigmoid).",
            descEn = "Digital neuron architecture, synaptic weights, biases, and activation functions (ReLU, Sigmoid, Softmax).",
            descRu = "Цифровая модель нейрона, синаптические веса, смещения bias и функции активации.",
            iconEmoji = "🧠",
            lessons = listOf(
                Lesson(
                    id = "mod20_les1",
                    moduleId = 20,
                    order = 1,
                    titleAz = "İnsan neyronunun rəqəmsal modeli və Perseptron",
                    titleEn = "The Biological vs Artificial Perceptron Model",
                    titleRu = "Биологический и искусственный перцептрон",
                    summaryAz = "Dendritlər (Giriş), Akson (Çıxış) və 1958-ci ildə Frank Rosenblatt tərəfindən yaradılan Perseptron.",
                    summaryEn = "Biological synapses vs artificial perceptrons: weighted sums and threshold gates.",
                    summaryRu = "Биологические синапсы и модель перцептрона Розенблатта 1958 года.",
                    contentKidsAz = "Bioloji beynimizdəki neyronlar bir-birinə elektrik qığılcımları ötürür! Süni neyron da kompüterdə rəqəmləri toplayıb növbəti neyrona ötürən kiçik bir beyin hüceyrəsidir. ⚡",
                    contentAdultsAz = "Perseptron (Perceptron) — Neyron Şəbəkələrinin fundamental kərpicidir:\n- Girişlər (x_1, x_2, ..., x_n): Verilənlər siqnalı.\n- Çəkilər (w_1, w_2, ..., w_n): Hər siqnalın gücü və əhəmiyyəti.\n- Meyl (Bias - b): Neyronun aktivləşmə astanası.\n- Cəmləyici: z = sum(w_i * x_i) + b\n- Aktivasiya: y = f(z)",
                    contentKidsEn = "Perceptrons combine small clues together to make smart choices!",
                    contentAdultsEn = "Perceptrons compute affine hyperplanes followed by non-linear activations to separate latent classes.",
                    contentKidsRu = "Перцептрон суммирует взвешенные входы и передает сигнал дальше!",
                    contentAdultsRu = "Математическая модель перцептрона вычисляет взвешенную сумму признаков со смещением.",
                    codeSnippet = "# Perseptron Hesablaması\ninputs = [0.5, 0.8]\nweights = [0.4, 0.7]\nbias = 0.1\nz = sum(x * w for x, w in zip(inputs, weights)) + bias\nprint(f'Cəm (z): {z:.2f}')",
                    keyTakeawaysAz = listOf(
                        "Perseptron girişləri çəkilərə vurub toplayır",
                        "Bias neyronun çevikliyini artırır",
                        "Dərin şəbəkələr minlərlə belə neyronun təbəqələrindən ibarətdir"
                    )
                ),
                Lesson(
                    id = "mod20_les2",
                    moduleId = 20,
                    order = 2,
                    titleAz = "Ağırlıqlar, bias və aktivləşdirmə funksiyaları (ReLU, Sigmoid, Softmax)",
                    titleEn = "Weights, Biases & Activation Functions (ReLU, Sigmoid, Softmax)",
                    titleRu = "Веса, смещения и функции активации (ReLU, Sigmoid, Softmax)",
                    summaryAz = "Niyə aktivasiya funksiyası lazımdır? Qeyri-xəttilik (Non-linearity), ReLU və Softmax çoxsinifli paylanma.",
                    summaryEn = "Why non-linearity matters, vanishing gradient problem, ReLU vs Sigmoid, and Softmax output.",
                    summaryRu = "Зачем нужна нелинейность, проблема затухания градиента, ReLU и Softmax.",
                    contentKidsAz = "Aktivasiya funksiyası neyronun 'Oyanıb danışmaq vaxtıdır, yoxsa susmaq vaxtıdır?' qərarını verən açardır! 💡",
                    contentAdultsAz = "Aktivasiya Funksiyalarının Müqayisəsi:\n1. ReLU (Rectified Linear Unit): f(z) = max(0, z) — Ən populyar funksiyadır, mənfiləri 0 edir, müsbətləri saxlayır, qradiyent itməsinin qarşısını alır.\n2. Sigmoid: [0, 1] aralığına sıxır (İkili təsnifat üçün).\n3. Softmax: Bütün çıxışların cəmini 1.0 (100%) edərək çoxsinifli ehtimal paylanması yaradır:\n   Softmax(z_i) = exp(z_i) / sum(exp(z_j))",
                    contentKidsEn = "ReLU wakes up the neuron when it sees a positive exciting signal!",
                    contentAdultsEn = "Non-linear activations grant universal approximation capability to multi-layer perceptron networks.",
                    contentKidsRu = "ReLU отсекает отрицательные сигналы и ускоряет обучение нейросети!",
                    contentAdultsRu = "Softmax преобразует вектор логитов в распределение вероятностей по классам.",
                    codeSnippet = "import numpy as np\ndef relu(z):\n    return np.maximum(0, z)\n\ndef softmax(logits):\n    exp_z = np.exp(logits)\n    return exp_z / np.sum(exp_z)\n\nprint('ReLU(-3):', relu(-3), '| ReLU(5):', relu(5))\nprint('Softmax([2.0, 1.0, 0.1]):', softmax([2.0, 1.0, 0.1]))",
                    keyTakeawaysAz = listOf(
                        "Qeyri-xətti aktivasiya olmasa, dərin şəbəkə sadəcə 1 xətti funksiyaya çevrilər",
                        "ReLU gizli laylar üçün ən sürətli və effektiv funksiyadır",
                        "Softmax çıxış layında çoxsinifli ehtimalları hesablayır"
                    )
                )
            )
        ),

        // Modul 21
        CourseModule(
            id = 21,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 21: TensorFlow və PyTorch Əsasları",
            titleEn = "Module 21: TensorFlow & PyTorch Foundations",
            titleRu = "Модуль 21: Основы TensorFlow и PyTorch",
            descAz = "Dərin öyrənmə kitabxanaları, Tensor strukturları, Avtomatik diferensiasiya və sadə şəbəkənin qurulması.",
            descEn = "PyTorch and TF ecosystems, Autograd computation graphs, GPU acceleration, and Sequential models.",
            descRu = "Экосистемы PyTorch и TensorFlow, тензоры на GPU и автоградиент (Autograd).",
            iconEmoji = "🔥",
            lessons = listOf(
                Lesson(
                    id = "mod21_les1",
                    moduleId = 21,
                    order = 1,
                    titleAz = "Dərin öyrənmə kitabxanaları və Tensor strukturları",
                    titleEn = "Deep Learning Frameworks & GPU Tensors",
                    titleRu = "Фреймворки глубокого обучения и тензоры на GPU",
                    summaryAz = "PyTorch vs TensorFlow fərqləri, Dinamik Hesablama Qrafı və GPU (CUDA) sürətləndirməsi.",
                    summaryEn = "PyTorch dynamic computation graph vs TensorFlow static graphs, and CUDA parallelism.",
                    summaryRu = "Сравнение PyTorch и TensorFlow, динамический граф вычислений и ускорение CUDA.",
                    contentKidsAz = "PyTorch və TensorFlow — Sİ mühəndislərinin böyük neyron fabrikləridir! 🏭 Kompüterin video kartının (GPU) gücündən istifadə edərək milyardlarla hesablama aparır.",
                    contentAdultsAz = "PyTorch və TensorFlow Dərin Öyrənmə Nəhəngləri:\n- PyTorch: Meta tərəfindən yaradılmış, Pythonic, dinamik qraf (Eager execution) və tədqiqat dünyasının lideri.\n- TensorFlow / Keras: Google tərəfindən yaradılmış, istehsalat və mobil tətbiqlərdə (TFLite) geniş yayılmış platforma.\n- GPU/CUDA Təsiri: Matris əməliyyatlarını minlərlə GPU nüvəsində paralel apararaq təlim vaxtını həftələrdən saatlara endirir.",
                    contentKidsEn = "PyTorch uses powerful graphics cards to train smart robots at lightspeed!",
                    contentAdultsEn = "Tensors in PyTorch support automatic differentiation (Autograd) and CUDA hardware dispatching.",
                    contentKidsRu = "PyTorch ускоряет матричные расчеты с помощью видеокарт NVIDIA CUDA!",
                    contentAdultsRu = "Автоматическое дифференцирование Autograd отслеживает операции для расчета градиентов.",
                    codeSnippet = "# PyTorch Tensor Nümunəsi\n# import torch\n# x = torch.tensor([1.0, 2.0, 3.0], requires_grad=True)\n# y = x.pow(2).sum()\n# y.backward() # Qradiyent hesablandı: dy/dx = 2*x\nprint('PyTorch Autograd qradiyentləri avtomatik hesablayır!')",
                    keyTakeawaysAz = listOf(
                        "Tensorlar GPU üzərində işləyə bilən çoxölçülü matrislərdir",
                        "requires_grad=True avtomatik törəmə qrafını aktiv edir",
                        "PyTorch müasir LLM və AI araşdırmalarında ən çox seçilən alətdir"
                    )
                ),
                Lesson(
                    id = "mod21_les2",
                    moduleId = 21,
                    order = 2,
                    titleAz = "Sadə neyron şəbəkəsinin qurulması (Keras / PyTorch nn.Module)",
                    titleEn = "Building a Multi-Layer Perceptron (Sequential Model)",
                    titleRu = "Построение простой нейросети (Keras Sequential / PyTorch nn.Module)",
                    summaryAz = "Layların ardıcıllığı: Dense/Linear, Aktivasiya, Loss təyini və model.fit().",
                    summaryEn = "Stacking Dense/Linear layers, configuring optimizers (Adam), and training loops.",
                    summaryRu = "Сборка полносвязной сети из слоев Dense, оптимизатор Adam и эпохи обучения.",
                    contentKidsAz = "Lego kərpicləri kimi layları bir-birinin üstünə düzürsən və bir neçə dəqiqədən sonra şəbəkən öyrənməyə başlayır! 🧱",
                    contentAdultsAz = "Keras ilə Sadə Neyron Şəbəkəsi Arxitekturası:\n```python\nimport tensorflow as tf\nfrom tensorflow.keras import layers, models\n\nmodel = models.Sequential([\n    layers.Dense(64, activation='relu', input_shape=(10,)),\n    layers.Dense(32, activation='relu'),\n    layers.Dense(1, activation='sigmoid') # İkili çıxış\n])\n\nmodel.compile(\n    optimizer='adam',\n    loss='binary_crossentropy',\n    metrics=['accuracy']\n)\n```",
                    contentKidsEn = "Stacking layers like Lego blocks creates a smart brain that learns from data!",
                    contentAdultsEn = "Constructing sequential layer topologies with feedforward transformations and backpropagated losses.",
                    contentKidsRu = "Слои нейросети соединяются последовательно, как блоки конструктора!",
                    contentAdultsRu = "Метод compile связывает архитектуру сети с оптимизатором Adam и функцией потерь.",
                    codeSnippet = "# Neyron Laylarının Strukturu\nlaylar = ['Giriş (10 neyron)', 'Gizli Lay 1 (64 neyron, ReLU)', 'Gizli Lay 2 (32 neyron, ReLU)', 'Çıxış (1 neyron, Sigmoid)']\nprint(' -> '.join(laylar))",
                    keyTakeawaysAz = listOf(
                        "Sequential modeli layları ardıcıl şəkildə birləşdirir",
                        "Dense tam əlaqəli (fully connected) standart laydır",
                        "Adam ən çox istifadə olunan adaptiv optimizasiya alqoritmidir"
                    )
                )
            )
        ),

        // Modul 22
        CourseModule(
            id = 22,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 22: Geri Yayılım (Backpropagation) və Optimizasiya",
            titleEn = "Module 22: Backpropagation & Optimization",
            titleRu = "Модуль 22: Обратное распространение ошибки (Backpropagation)",
            descAz = "Xətanın hesablanması (Loss Functions), Zəncir qaydası (Chain Rule) və Adam optimizatoru.",
            descEn = "Loss functions (Cross-Entropy, MSE), Chain Rule gradient flow, and Adaptive optimizers (Adam, RMSProp).",
            descRu = "Функции потерь, цепное правило вычисления градиентов и оптимизатор Adam.",
            iconEmoji = "🔄",
            lessons = listOf(
                Lesson(
                    id = "mod22_les1",
                    moduleId = 22,
                    order = 1,
                    titleAz = "Xətanın hesablanması (Loss Functions) və Zəncir qaydası",
                    titleEn = "Loss Functions & The Chain Rule of Calculus",
                    titleRu = "Функции потерь (Loss Functions) и цепное правило",
                    summaryAz = "Model nə dərəcədə səhv etdi? Loss funksiyası və geriyə doğru törəmələrin yayılması (Chain Rule).",
                    summaryEn = "Measuring empirical error and decomposing gradients layer-by-layer via calculus chain rule.",
                    summaryRu = "Вычисление ошибки и передача градиентов от выхода к входу по цепному правилу.",
                    contentKidsAz = "Bir oyunda xal itirəndə harada səhv etdiyini düşünüb növbəti dəfə daha diqqətli olursan! Geri yayılım da kompüterin səhvlərdən dərs çıxarmasıdır. 🎯",
                    contentAdultsAz = "Geri Yayılım (Backpropagation) Alqoritmi:\n1. İrəli Ötürmə (Forward Pass): Girişlər şəbəkədən keçir və proqnoz (y_pred) alınır.\n2. Xətanın Hesablanması (Loss Calculation): Loss = L(y_real, y_pred) hesablanır.\n3. Geri Ötürmə (Backward Pass): Zəncir qaydası (Chain Rule) vasitəsilə çıxışdan girişə doğru hər bir çəkinin xətaya təsiri (dL/dw) hesablanır:\n   dL/dw_1 = (dL/dy) * (dy/dz) * (dz/dw_1)",
                    contentKidsEn = "Backpropagation teaches AI by looking backwards at mistakes and fixing them!",
                    contentAdultsEn = "Backpropagation efficiently computes exact partial derivatives across arbitrary computational graphs.",
                    contentKidsRu = "Алгоритм Backpropagation передает сигнал ошибки обратно по сети, корректируя каждый вес.",
                    contentAdultsRu = "Цепное правило дифференцирования позволяет рассчитывать частные производные в глубоких сетях.",
                    codeSnippet = "# Zəncir Qaydası (Chain Rule)\n# dL_dw = dL_dy * dy_dz * dz_dw\nprint('Geri yayılım: Çıxış xətası -> Hər çəkinin məsuliyyət payı')",
                    keyTakeawaysAz = listOf(
                        "Backpropagation olmasa dərin neyron şəbəkələri öyrənə bilməzdi",
                        "Zəncir qaydası mürəkkəb funksiyaların törəməsini asanlaşdırır",
                        "Hər bir çəki xətanı azaltmaq istiqamətində yenilənir"
                    )
                ),
                Lesson(
                    id = "mod22_les2",
                    moduleId = 22,
                    order = 2,
                    titleAz = "Qradiyent enişi və müasir optimizatorlar (SGD, Adam)",
                    titleEn = "Gradient Descent Variants & The Adam Optimizer",
                    titleRu = "Градиентный спуск и современные оптимизаторы (SGD, Adam)",
                    summaryAz = "Stochastic Gradient Descent, Momentum və Adam (Adaptive Moment Estimation).",
                    summaryEn = "Mini-batch SGD, momentum inertia, RMSProp, and Adam learning rate adaptation.",
                    summaryRu = "Стохастический градиентный спуск SGD, инерция и адаптивный оптимизатор Adam.",
                    contentKidsAz = "Adam optimizatoru həm sürətlə qaçan, həm də döngələrdə ehtiyatla sürətini azaldan ağıllı yarış avtomobili kimidir! 🏎️",
                    contentAdultsAz = "Optimizasiya Alqoritmlərinin Təkamülü:\n- SGD (Stochastic Gradient Descent): Hər iterasiyada təsadüfi tək nümunə və ya mini-batch istifadə edir (sürətli amma dalğalı).\n- Momentum: Qradiyentə ətalət (inersiya) qataraq yerli minimumlardan (local minima) sıçrayıb çıxmağa kömək edir.\n- Adam (Adaptive Moment Estimation): Həm 1-ci dərəcəli (orta meyl), həm də 2-ci dərəcəli (dispersiya) momentləri nəzərə alaraq hər çəki üçün fərdi adaptiv Learning Rate tətbiq edir.",
                    contentKidsEn = "Adam optimizer steers the learning smoothly so AI never gets stuck!",
                    contentAdultsEn = "Adam combines AdaGrad and RMSProp advantages, maintaining exponentially decaying historical gradient moments.",
                    contentKidsRu = "Оптимизатор Adam автоматически подстраивает скорость обучения для каждого параметра!",
                    contentAdultsRu = "Adam сочетает накопление импульса Momentum с адаптивным масштабированием RMSProp.",
                    codeSnippet = "# Adam Optimizatoru Tənzimləməsi\nlearning_rate = 0.001\nbeta1, beta2 = 0.9, 0.999\nprint(f'Adam Standart Parametrləri: lr={learning_rate}, b1={beta1}, b2={beta2}')",
                    keyTakeawaysAz = listOf(
                        "Adam müasir dərin öyrənmədə ən etibarlı standart optimizatordur",
                        "Learning Rate çox böyük olsa model öyrənməz, çox kiçik olsa həddən artıq gecikər",
                        "Mini-batch ölçüsü (məs. 32, 64) yaddaş və təlim sabitliyini balanslaşdırır"
                    )
                )
            )
        ),

        // Modul 23
        CourseModule(
            id = 23,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 23: Kompüter Görməsi (Computer Vision) və OpenCV",
            titleEn = "Module 23: Computer Vision & OpenCV",
            titleRu = "Модуль 23: Компьютерное зрение и OpenCV",
            descAz = "Rəqəmsal şəkillərin rəqəmlər kimi oxunması, OpenCV ilə şəkil və video üzərində əməliyyatlar.",
            descEn = "Pixel representations, color spaces (BGR/RGB/HSV), OpenCV kernels, filtering, and video streams.",
            descRu = "Пиксели и цветовые пространства, библиотека OpenCV, фильтрация и обработка видеопотока.",
            iconEmoji = "👁️",
            lessons = listOf(
                Lesson(
                    id = "mod23_les1",
                    moduleId = 23,
                    order = 1,
                    titleAz = "Rəqəmsal şəkillərin rəqəmlər kimi oxunması və Rəng Fəzaları",
                    titleEn = "Reading Images as Numerical Matrices & Color Spaces",
                    titleRu = "Цифровые изображения как матрицы чисел и цветовые пространства",
                    summaryAz = "Piksellər (0-255 aralığı), RGB, BGR, Grayscale və HSV rəng modelləri.",
                    summaryEn = "Pixel matrices (0-255 uint8), color channel decomposition, and HSV color segmentation.",
                    summaryRu = "Пиксели (0-255), каналы RGB/BGR, оттенки серого и цветовое пространство HSV.",
                    contentKidsAz = "Bütün şəkillər əslində mozaika kimidir! 🧩 Hər kiçik piksel 0-dan 255-ə qədər olan bir rəqəmdir. 0 Qara rəng, 255 isə Ağ rəngdir.",
                    contentAdultsAz = "Kompüter Görməsinin Əsasları (Computer Vision):\n- Rəqəmsal Təsvir: Hündürlük x En ölçüsündə 2D və ya 3D matris.\n- RGB Kanalları: Qırmızı, Yaşıl, Mavi intensivliyi (hər kanal 8-bit, 0-255).\n- OpenCV Xüsusiyyəti: Şəkilləri standart RGB deyil, BGR ardıcıllığında oxuyur.\n- Grayscale Çevirmə: Hesablama yükünü 3 dəfə azaltmaq üçün boz rəng çalarlarına keçid.",
                    contentKidsEn = "To a computer, every photo is a giant matrix of colorful numbers!",
                    contentAdultsEn = "Digital images are discrete 3D spatial tensors of chromatic intensity vectors.",
                    contentKidsRu = "Для компьютера любая картинка — это просто таблица чисел от 0 до 255!",
                    contentAdultsRu = "OpenCV считывает изображения в формате BGR, преобразуя их в массивы NumPy.",
                    codeSnippet = "import numpy as np\n# 3x3 Ağ-Qara Şəkil Matrisi\nsekil_matrisi = np.array([\n    [0, 128, 255],\n    [255, 255, 0],\n    [100, 50, 200]\n], dtype=np.uint8)\nprint('Piksel Matrisi:\\n', sekil_matrisi)",
                    keyTakeawaysAz = listOf(
                        "Kompüter şəkli təkcə rəqəmlər toplusu olaraq görür",
                        "Grayscale çevrilməsi təhlili sürətləndirir",
                        "HSV rəng fəzası işıq dəyişikliklərinə qarşı rəng aşkarlamada daha stabildir"
                    )
                ),
                Lesson(
                    id = "mod23_les2",
                    moduleId = 23,
                    order = 2,
                    titleAz = "OpenCV ilə şəkil və video üzərində əməliyyatlar",
                    titleEn = "Image Processing & Real-Time Video with OpenCV",
                    titleRu = "Обработка изображений и видеопотока в OpenCV",
                    summaryAz = "cv2.imread(), kənarların tapılması (Canny Edge), konturlar və veb-kamera axını.",
                    summaryEn = "cv2.imread/imshow, Gaussian blur, Canny edge detection, contour bounding boxes, and webcam loops.",
                    summaryRu = "Поиск границ Canny, размытие по Гауссу, поиск контуров и захват видео с веб-камеры.",
                    contentKidsAz = "Veb-kamera vasitəsilə kompüter sənin əl hərəkətlərini və üzünü canlı izləyə bilər! 📹✨",
                    contentAdultsAz = "OpenCV ilə Əsas Əməliyyatlar:\n1. Filtrasiya və Hamarlaşdırma: cv2.GaussianBlur() ilə küyü təmizləmək.\n2. Sərhədlərin Tapılması: cv2.Canny() qradiyent dəyişiklikləri ilə obyektlərin konturunu çıxarır.\n3. Kontur Aşkarlanması: cv2.findContours() və cv2.boundingRect() ilə obyektlərin ətrafına çərçivə çəkmək.\n4. Canlı Video Axını: cv2.VideoCapture(0) ilə real vaxt kadrları emal etmək.",
                    contentKidsEn = "OpenCV gives eyes to your computer so it can see your gestures!",
                    contentAdultsEn = "OpenCV accelerates classical spatial filtering, thresholding, and morphological transformations.",
                    contentKidsRu = "OpenCV находит контуры предметов и распознает движение в реальном времени!",
                    contentAdultsRu = "Детектор Canny и поиск контуров локализуют объекты на видеокадрах.",
                    codeSnippet = "# OpenCV Tipik İş Axını\n# import cv2\n# cap = cv2.VideoCapture(0)\n# ret, frame = cap.read()\n# gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)\n# edges = cv2.Canny(gray, 50, 150)\nprint('OpenCV Canny Kənar Aşkarlayıcı hazırdır')",
                    keyTakeawaysAz = listOf(
                        "Canny alqoritmi kəskin rəng dəyişmələrini obyekt sərhədi kimi tanıyır",
                        "Bulanıqlaşdırma (Blur) yalançı siqnalları azaldır",
                        "Real-vaxt video emalında FPS və optimizasiya mühüm rol oynayır"
                    )
                )
            )
        ),

        // Modul 24
        CourseModule(
            id = 24,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 24: Konvolyusion Neyron Şəbəkələri (CNN)",
            titleEn = "Module 24: Convolutional Neural Networks (CNN)",
            titleRu = "Модуль 24: Сверточные нейронные сети (CNN)",
            descAz = "Şəkil tanıma və təsnifat modelləri, Konvolyusiya filtrləri, Pooling, Üz tanıma və YOLO.",
            descEn = "Convolution kernels, feature maps, MaxPooling, translation invariance, ResNet, and YOLO detection.",
            descRu = "Сверточные слои Conv2D, пулинг MaxPooling, архитектура ResNet и детекция объектов YOLO.",
            iconEmoji = "🔍",
            lessons = listOf(
                Lesson(
                    id = "mod24_les1",
                    moduleId = 24,
                    order = 1,
                    titleAz = "Şəkil tanıma və təsnifat modelləri (Conv2D & MaxPooling)",
                    titleEn = "Image Classification with Conv2D & MaxPooling",
                    titleRu = "Классификация изображений с Conv2D и MaxPooling",
                    summaryAz = "Niyə klassik ANN şəkillər üçün kifayət etmir? Sürüşən pəncərə (Filter/Kernel) və Feature Maps.",
                    summaryEn = "Spatial hierarchies, 3x3 convolution kernels, feature map extraction, and downsampling.",
                    summaryRu = "Сверточные фильтры 3x3, карты признаков и сжатие размерности MaxPooling.",
                    contentKidsAz = "Konvolyusiya — şəklin üzərində gəzən kiçik bir böyüdücü şüşə kimidir! 🔍 O, pişik qulaqlarını, gözlərini və bığını addım-addım axtarıb tapır.",
                    contentAdultsAz = "Konvolyusion Neyron Şəbəkələri (CNN) Görünüşün Məkan Qanunauyğunluğunu Qoruyur:\n1. Konvolyusiya Layı (Conv2D): 3x3 və ya 5x5 ölçülü kiçik filtrlər (Kernels) şəkil üzərində sürüşərək xətləri, bucaqları və toxumaları (Feature Map) çıxarır.\n2. MaxPooling (Qovuşdurma): Şəklin məkan ölçüsünü 2 dəfə kiçildərək hesablama yükünü azaldır və fərqli mövqelərdə dayanıqlıq (Translation Invariance) təmin edir.\n3. Flatten & Dense: Çıxarılan xüsusiyyətlər düzləşdirilərək son təsnifat qatına ötürülür.",
                    contentKidsEn = "CNNs scan images with smart magnifying filters to spot patterns instantly!",
                    contentAdultsEn = "CNNs extract translation-invariant spatial hierarchies via localized parameter sharing.",
                    contentKidsRu = "Сверточные слои находят линии и текстуры, а пулинг уменьшает размер карты признаков!",
                    contentAdultsRu = "Архитектура Conv2D + MaxPooling сохраняет пространственную структуру изображения.",
                    codeSnippet = "# Keras CNN Modeli\nfrom tensorflow.keras import layers, models\ncnn = models.Sequential([\n    layers.Conv2D(32, (3, 3), activation='relu', input_shape=(64, 64, 3)),\n    layers.MaxPooling2D((2, 2)),\n    layers.Conv2D(64, (3, 3), activation='relu'),\n    layers.MaxPooling2D((2, 2)),\n    layers.Flatten(),\n    layers.Dense(10, activation='softmax')\n])\nprint('CNN Arxitekturası quruldu')",
                    keyTakeawaysAz = listOf(
                        "CNN-lər piksellərin qonşuluq əlaqəsini qoruyub saxlayır",
                        "İlkin laylar xətt və kənarları, dərin laylar isə mürəkkəb obyektləri (göz, təkər) tanıyır",
                        "ResNet və EfficientNet müasir CNN arxitekturalarının zirvəsidir"
                    )
                ),
                Lesson(
                    id = "mod24_les2",
                    moduleId = 24,
                    order = 2,
                    titleAz = "Üz tanıma və obyektlərin aşkarlanması sistemləri (YOLO)",
                    titleEn = "Object Detection & Face Recognition (YOLO)",
                    titleRu = "Распознавание лиц и детекция объектов (YOLO)",
                    summaryAz = "Təsnifat vs Obyekt Aşkarlanması, Bounding Box, IoU və Real-Time YOLO (You Only Look Once).",
                    summaryEn = "Classification vs Object Detection, bounding box regression, IoU, and YOLO one-stage detectors.",
                    summaryRu = "Детекция объектов в реальном времени YOLO, Bounding Boxes и метрика IoU.",
                    contentKidsAz = "Kamerada təkcə 'Burada insan var' demir, həm də insanın, velosipedin və avtomobilin ətrafına rəngli çərçivələr çəkib adlarını yazır! 🚗🚶🚲",
                    contentAdultsAz = "Obyektlərin Aşkarlanması (Object Detection):\n- Fərq: Təsnifat 'Bu şəkildə nə var?' sualına cavab verir. Obyekt aşkarlanması 'Obyektlər haradadır və neçə dənədir?' (Localization + Classification) sualını həll edir.\n- YOLO (You Only Look Once): Bütün şəkli tək bir keçiddə (one-stage) şəbəkəyə ötürərək saniyədə 60-140 kadr sürətlə (FPS) real vaxtda obyektləri aşkarlayır.\n- Bounding Box Parametrləri: (x, y, en, hündürlük, inam dərəcəsi - confidence).",
                    contentKidsEn = "YOLO puts bright boxes around cars, pets, and people in the blink of an eye!",
                    contentAdultsEn = "YOLO formulates object detection as a single regression problem from full image pixels to bounding boxes.",
                    contentKidsRu = "YOLO находит и обводит рамками десятки объектов на видео со скоростью 60+ FPS!",
                    contentAdultsRu = "Одностадийные детекторы YOLO предсказывают координаты Bounding Box и вероятности классов.",
                    codeSnippet = "# YOLO Konsepti\n# from ultralytics import YOLO\n# model = YOLO('yolov8n.pt')\n# results = model('traffic.jpg')\nprint('YOLOv8: Real-Time Obyekt Aşkarlama Hazırdır')",
                    keyTakeawaysAz = listOf(
                        "YOLO sürət və dəqiqlik baxımından dünyanın 1 nömrəli detektorudur",
                        "Avtopilot avtomobillər və təhlükəsizlik kameraları YOLO əsasında işləyir",
                        "IoU (Intersection over Union) çərçivənin dəqiqliyini ölçür"
                    )
                )
            )
        ),

        // Modul 25
        CourseModule(
            id = 25,
            sectionNumber = SEC_NUM,
            sectionTitleAz = SEC_TITLE_AZ,
            sectionTitleEn = SEC_TITLE_EN,
            sectionTitleRu = SEC_TITLE_RU,
            titleAz = "Modul 25: Təbii Dil Emalı (NLP) Təməlləri",
            titleEn = "Module 25: Natural Language Processing (NLP) Foundations",
            titleRu = "Модуль 25: Основы обработки естественного языка (NLP)",
            descAz = "Mətnlərin tokenizasiyası və vektorlaşdırılması, Word2Vec, Embeddings və Duyğu analizi (Sentiment Analysis).",
            descEn = "Text tokenization, Bag of Words, TF-IDF, Word2Vec embeddings, and Sentiment Analysis classification.",
            descRu = "Токенизация текста, TF-IDF, векторные эмбеддинги Word2Vec и анализ тональности.",
            iconEmoji = "💬",
            lessons = listOf(
                Lesson(
                    id = "mod25_les1",
                    moduleId = 25,
                    order = 1,
                    titleAz = "Mətnlərin tokenizasiyası və vektorlaşdırılması (TF-IDF & Embeddings)",
                    titleEn = "Text Tokenization, TF-IDF & Vector Embeddings",
                    titleRu = "Токенизация текстов, TF-IDF и векторные эмбеддинги",
                    summaryAz = "Kompüter sözləri necə başa düşür? Tokenlər, Stop-words, TF-IDF və Word2Vec semantik fəzası.",
                    summaryEn = "Tokenizers (BPE, WordPiece), TF-IDF frequency scoring, and dense semantic vector embeddings.",
                    summaryRu = "Токенизация BPE, частотный анализ TF-IDF и плотные семантические векторы слов.",
                    contentKidsAz = "Kompüter hər sözə xüsusi bir gizli nömrə (kod) verir! Oxşar mənalı sözlər (məsələn 'Kral' və 'Şahzadə') xəritədə bir-birinə çox yaxın yerləşir. 👑🤴",
                    contentAdultsAz = "Təbii Dil Emalında (NLP) Mətnin Rəqəmlərə Çevrilməsi:\n1. Tokenizasiya (Tokenization): Cümlənin söz və ya alt-hissələrə (sub-tokens) parçalanması.\n2. TF-IDF (Term Frequency - Inverse Document Frequency): Nadir və vacib sözlərin çəkisini artıran statistik metod.\n3. Söz Vektorları (Word Embeddings - Word2Vec / GloVe): Sözlərin mənaca yaxınlığını çoxölçülü məkanda (məs. 300D) saxlayır:\n   Vektor('Kral') - Vektor('Kişi') + Vektor('Qadın') ~ Vektor('Kraliça')",
                    contentKidsEn = "Vector embeddings place words with similar meanings close together in 3D space!",
                    contentAdultsEn = "Dense continuous vector representations capture nuanced semantic and syntactic linguistic relationships.",
                    contentKidsRu = "Векторные эмбеддинги превращают слова в координаты в многомерном пространстве смыслов!",
                    contentAdultsRu = "Word2Vec и семантические эмбеддинги позволяют вычислять косинусную близость между фразами.",
                    codeSnippet = "# Mətn Tokenizasiyası Nümunəsi\nmetn = 'Süni intellekt gələcəyi dəyişir'\ntokenler = metn.lower().split()\nprint('Tokenlər:', tokenler)",
                    keyTakeawaysAz = listOf(
                        "Embeddings sözlərin məna və əlaqələrini riyazi koordinatlara çevirir",
                        "Kosinal Oxşarlıq (Cosine Similarity) iki mətnin məzmunca yaxınlığını ölçür",
                        "Müasir bütün LLM-lərin girişində Embedding qatı dayanır"
                    )
                ),
                Lesson(
                    id = "mod25_les2",
                    moduleId = 25,
                    order = 2,
                    titleAz = "Duyğu analizi (Sentiment Analysis - Mətnin müsbət/mənfi olduğunu tapmaq)",
                    titleEn = "Sentiment Analysis & Text Classification",
                    titleRu = "Анализ тональности текста (Sentiment Analysis)",
                    summaryAz = "Müştəri şərhlərinin və rəylərinin təhlili: Müsbət (Positive), Mənfi (Negative), Neytral.",
                    summaryEn = "Classifying consumer sentiment, reviews, tweet polarity, and customer satisfaction pipelines.",
                    summaryRu = "Классификация отзывов и твитов на позитивные, негативные и нейтральные.",
                    contentKidsAz = "Sİ insanların yazdığı şərhləri oxuyub onların sevincli 😄 yoxsa əsəbi 😡 olduğunu anlaya bilir!",
                    contentAdultsAz = "Duyğu Analizi (Sentiment Analysis) biznesdə ən çox tətbiq olunan NLP sahəsidir:\n- İstifadə Sahələri: Məhsul rəyləri, sosial media reaksiyaları, müştəri dəstək mesajlarının prioritetləşdirilməsi.\n- Metodlar:\n  1. Leksik və Qayda əsaslı (VADER, TextBlob)\n  2. ML Modelləri (TF-IDF + Logistic Regression / Naive Bayes)\n  3. Transformator Modelləri (BERT, RoBERTa) — Kontekst və ironiyanı (sarkazmı) dərindən anlayır.",
                    contentKidsEn = "Sentiment analysis helps apps know if users are happy or need help!",
                    contentAdultsEn = "Sentiment classifiers gauge affective states and subjectivity from unstructured customer feedback text.",
                    contentKidsRu = "Анализ тональности автоматически оценивает настроение отзывов покупателей!",
                    contentAdultsRu = "Трансформеры BERT распознают сложные эмоциональные оттенки и контекст с высокой точностью.",
                    codeSnippet = "# Sadə Duyğu Təhlili Məntiqi\ndef duygu_analizi(serh):\n    musbet_sozler = ['əla', 'möhtəşəm', 'sevdim', 'super']\n    menfi_sozler = ['pis', 'bərbad', 'donur', 'xarab']\n    if any(s in serh.lower() for s in musbet_sozler):\n        return 'Müsbət 😊'\n    elif any(s in serh.lower() for s in menfi_sozler):\n        return 'Mənfi 😞'\n    return 'Neytral 😐'\n\nprint(duygu_analizi('Bu kurs həqiqətən əla və çox faydalıdır!'))",
                    keyTakeawaysAz = listOf(
                        "Duyğu analizi şirkətlərə müştəri narazılığını saniyələr içində aşkarlamağa imkan verir",
                        "Dərin modellər sarkazm və mürəkkəb cümlə strukturlarını başa düşür",
                        "Xarici dillərdə və Azərbaycan dilində təlim olunmuş BERT modelləri yüksək nəticə verir"
                    )
                )
            )
        )
    )
}

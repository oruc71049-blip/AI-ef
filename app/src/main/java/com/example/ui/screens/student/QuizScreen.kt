package com.example.ui.screens.student

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.models.AppLanguage
import com.example.data.models.Lesson
import com.example.data.models.Translations
import com.example.ui.theme.AiAmber
import com.example.ui.theme.AiCyan
import com.example.ui.theme.AiEmerald
import com.example.ui.theme.AiIndigo
import com.example.ui.theme.AiPink
import com.example.ui.theme.AiPurple

@Composable
fun QuizScreen(
    lesson: Lesson,
    currentLanguage: AppLanguage,
    onBackClick: () -> Unit,
    onQuizCompleted: (scorePercent: Int, timeSpentSeconds: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val questions = lesson.quizQuestions
    var currentIndex by remember { mutableIntStateOf(0) }
    var selectedOption by remember { mutableIntStateOf(-1) }
    var isSubmitted by remember { mutableStateOf(false) }
    var correctCount by remember { mutableIntStateOf(0) }
    var isQuizFinished by remember { mutableStateOf(false) }

    val currentQuestion = questions.getOrNull(currentIndex)
    val total = questions.size

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .testTag("quiz_screen")
    ) {
        // Quiz Top Bar
        Surface(
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 4.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp)
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
                Spacer(modifier = Modifier.width(4.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = Translations.get("quiz_title", currentLanguage),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = if (total > 0) "${currentIndex + 1} / $total" else "",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        if (isQuizFinished || total == 0) {
            // Quiz Result Screen
            val scorePercent = if (total > 0) (correctCount * 100) / total else 100
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = CircleShape,
                    color = AiAmber.copy(alpha = 0.2f),
                    modifier = Modifier.size(100.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.EmojiEvents,
                            contentDescription = null,
                            tint = AiAmber,
                            modifier = Modifier.size(56.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Təbriklər! Möhtəşəm Nəticə!",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "${Translations.get("quiz_score", currentLanguage)}: $scorePercent%",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = AiCyan
                )

                Text(
                    text = "$total sualdan $correctCount düzgün cavab",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // XP Reward Card
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = AiPurple.copy(alpha = 0.15f)),
                    border = androidx.compose.foundation.BorderStroke(1.dp, AiPurple.copy(alpha = 0.4f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = AiPurple)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "+${lesson.xpReward} XP və +${lesson.coinReward} AI Sikkə qazandınız! 🌟",
                            fontWeight = FontWeight.Bold,
                            color = AiPurple
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = {
                        onQuizCompleted(scorePercent, 90)
                        onBackClick()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = AiIndigo),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .testTag("finish_quiz_button")
                ) {
                    Text(
                        text = "Dərslərə Qayıt",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        } else if (currentQuestion != null) {
            // Question Progress
            LinearProgressIndicator(
                progress = { (currentIndex + 1).toFloat() / total.toFloat() },
                color = AiCyan,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
            )

            val questionText = when (currentLanguage) {
                AppLanguage.AZ -> currentQuestion.questionAz
                AppLanguage.EN -> currentQuestion.questionEn
                AppLanguage.RU -> currentQuestion.questionRu
            }
            val explanation = when (currentLanguage) {
                AppLanguage.AZ -> currentQuestion.explanationAz
                AppLanguage.EN -> currentQuestion.explanationEn
                AppLanguage.RU -> currentQuestion.explanationRu
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Question Card
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(3.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "Sual ${currentIndex + 1}:",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = AiCyan
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = questionText,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }

                // Options List
                currentQuestion.options.forEachIndexed { index, option ->
                    val isSelected = selectedOption == index
                    val isCorrect = index == currentQuestion.correctOptionIndex

                    val optText = when (currentLanguage) {
                        AppLanguage.AZ -> option.textAz
                        AppLanguage.EN -> option.textEn
                        AppLanguage.RU -> option.textRu
                    }

                    val bgColor = when {
                        !isSubmitted && isSelected -> MaterialTheme.colorScheme.primaryContainer
                        isSubmitted && isCorrect -> AiEmerald.copy(alpha = 0.2f)
                        isSubmitted && isSelected && !isCorrect -> Color(0xFFEF4444).copy(alpha = 0.2f)
                        else -> MaterialTheme.colorScheme.surface
                    }

                    val borderColor = when {
                        !isSubmitted && isSelected -> MaterialTheme.colorScheme.primary
                        isSubmitted && isCorrect -> AiEmerald
                        isSubmitted && isSelected && !isCorrect -> Color(0xFFEF4444)
                        else -> MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                    }

                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = bgColor,
                        border = androidx.compose.foundation.BorderStroke(1.5.dp, borderColor),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(enabled = !isSubmitted) { selectedOption = index }
                            .testTag("quiz_option_$index")
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = if (isSelected || (isSubmitted && isCorrect)) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.size(28.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = "${('A' + index)}",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp,
                                        color = if (isSelected || (isSubmitted && isCorrect)) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = optText,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }

                // Explanation Box (Shown after submission)
                if (isSubmitted) {
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (selectedOption == currentQuestion.correctOptionIndex) AiEmerald.copy(alpha = 0.1f) else Color(0xFFEF4444).copy(alpha = 0.1f)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = if (selectedOption == currentQuestion.correctOptionIndex) "✅ Düzgün Cavab!" else "❌ Səhv Cavab!",
                                fontWeight = FontWeight.Bold,
                                color = if (selectedOption == currentQuestion.correctOptionIndex) AiEmerald else Color(0xFFEF4444)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = explanation,
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }

            // Bottom Submit / Next Bar
            Surface(
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.padding(16.dp)) {
                    if (!isSubmitted) {
                        Button(
                            onClick = {
                                if (selectedOption != -1) {
                                    isSubmitted = true
                                    if (selectedOption == currentQuestion.correctOptionIndex) {
                                        correctCount++
                                    }
                                }
                            },
                            enabled = selectedOption != -1,
                            colors = ButtonDefaults.buttonColors(containerColor = AiIndigo),
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp)
                                .testTag("quiz_submit_btn")
                        ) {
                            Text(
                                text = Translations.get("submit_answer", currentLanguage),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    } else {
                        Button(
                            onClick = {
                                if (currentIndex + 1 < total) {
                                    currentIndex++
                                    selectedOption = -1
                                    isSubmitted = false
                                } else {
                                    isQuizFinished = true
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = AiCyan),
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp)
                                .testTag("quiz_next_btn")
                        ) {
                            Text(
                                text = if (currentIndex + 1 < total) Translations.get("next_question", currentLanguage) else Translations.get("finish_quiz", currentLanguage),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}

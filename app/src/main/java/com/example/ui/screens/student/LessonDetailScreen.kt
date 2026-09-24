package com.example.ui.screens.student

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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.database.UserProfileEntity
import com.example.data.models.AgeCategory
import com.example.data.models.AppLanguage
import com.example.data.models.Lesson
import com.example.data.models.Translations
import com.example.ui.theme.AiAmber
import com.example.ui.theme.AiCyan
import com.example.ui.theme.AiEmerald
import com.example.ui.theme.AiIndigo
import com.example.ui.theme.AiPurple

@Composable
fun LessonDetailScreen(
    lesson: Lesson,
    userProfile: UserProfileEntity?,
    currentLanguage: AppLanguage,
    onBackClick: () -> Unit,
    onStartQuizClick: () -> Unit,
    onDiscussWithAiClick: () -> Unit,
    onSpeakText: (String) -> Unit,
    onStopSpeaking: () -> Unit,
    isSpeaking: Boolean,
    modifier: Modifier = Modifier
) {
    val isKids = (userProfile?.age ?: 14) <= 14
    var viewKidsMode by remember { mutableStateOf(isKids) }
    var fontScaleMultiplier by remember { mutableFloatStateOf(1.0f) }

    val title = when (currentLanguage) {
        AppLanguage.AZ -> lesson.titleAz
        AppLanguage.EN -> lesson.titleEn
        AppLanguage.RU -> lesson.titleRu
    }
    val content = if (viewKidsMode) {
        when (currentLanguage) {
            AppLanguage.AZ -> lesson.contentKidsAz
            AppLanguage.EN -> lesson.contentKidsEn
            AppLanguage.RU -> lesson.contentKidsRu
        }
    } else {
        when (currentLanguage) {
            AppLanguage.AZ -> lesson.contentAdultsAz
            AppLanguage.EN -> lesson.contentAdultsEn
            AppLanguage.RU -> lesson.contentAdultsRu
        }
    }

    val takeaways = when (currentLanguage) {
        AppLanguage.AZ -> lesson.keyTakeawaysAz
        AppLanguage.EN -> lesson.keyTakeawaysEn
        AppLanguage.RU -> lesson.keyTakeawaysRu
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .testTag("lesson_detail_screen")
    ) {
        // Detail Header
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
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.testTag("lesson_back_button")
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
                Spacer(modifier = Modifier.width(4.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        fontSize = 17.sp
                    )
                    Text(
                        text = "${Translations.get("nav_learn", currentLanguage)} • +${lesson.xpReward} XP",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = AiCyan
                    )
                }

                // Font Size Toggle Button (A- / A+)
                IconButton(
                    onClick = {
                        fontScaleMultiplier = if (fontScaleMultiplier >= 1.25f) 0.9f else fontScaleMultiplier + 0.15f
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.FormatSize,
                        contentDescription = "Font size",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }

                // Audio Speech Reader Button
                IconButton(
                    onClick = {
                        if (isSpeaking) onStopSpeaking() else onSpeakText(content)
                    },
                    modifier = Modifier.testTag("tts_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.VolumeUp,
                        contentDescription = "Read Audio",
                        tint = if (isSpeaking) AiCyan else MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }

        // Body Content
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Age Mode Switcher (Kids / Adults)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = if (viewKidsMode) AiCyan.copy(alpha = 0.2f) else MaterialTheme.colorScheme.surfaceVariant,
                    border = if (viewKidsMode) androidx.compose.foundation.BorderStroke(1.5.dp, AiCyan) else null,
                    modifier = Modifier
                        .weight(1f)
                        .clickable { viewKidsMode = true }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(12.dp)
                    ) {
                        Text(
                            text = "🎈 ${Translations.get("age_kids_title", currentLanguage)}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = if (!viewKidsMode) AiIndigo.copy(alpha = 0.2f) else MaterialTheme.colorScheme.surfaceVariant,
                    border = if (!viewKidsMode) androidx.compose.foundation.BorderStroke(1.5.dp, AiIndigo) else null,
                    modifier = Modifier
                        .weight(1f)
                        .clickable { viewKidsMode = false }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(12.dp)
                    ) {
                        Text(
                            text = "🎓 ${Translations.get("age_adults_title", currentLanguage)}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            // Main Lesson Body Card
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = content,
                        fontSize = (17 * fontScaleMultiplier).sp,
                        lineHeight = (28 * fontScaleMultiplier).sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        letterSpacing = 0.2.sp
                    )
                }
            }

            // Code Snippet Section
            if (lesson.codeSnippet.isNotBlank()) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0B132B)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Code, contentDescription = null, tint = AiCyan, modifier = Modifier.size(20.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = "Python & Prompt Nümunəsi", color = AiCyan, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            }
                            Text(text = "Live Code", color = Color.LightGray, fontSize = 12.sp)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = lesson.codeSnippet,
                            fontFamily = FontFamily.Monospace,
                            fontSize = (13 * fontScaleMultiplier).sp,
                            color = Color(0xFFE2E8F0),
                            lineHeight = (20 * fontScaleMultiplier).sp
                        )
                    }
                }
            }

            // Key Takeaways Box
            if (takeaways.isNotEmpty()) {
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = AiEmerald.copy(alpha = 0.1f)),
                    border = androidx.compose.foundation.BorderStroke(1.dp, AiEmerald.copy(alpha = 0.4f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(
                            text = "💡 Əsas Nəticələr (Key Takeaways)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = AiEmerald
                        )
                        takeaways.forEach { point ->
                            Row(verticalAlignment = Alignment.Top) {
                                Icon(Icons.Default.Check, contentDescription = null, tint = AiEmerald, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = point,
                                    fontSize = (14 * fontScaleMultiplier).sp,
                                    lineHeight = (22 * fontScaleMultiplier).sp,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }
            }
        }

        // Bottom Action Bar
        Surface(
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 8.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Discuss with AI Button
                OutlinedButton(
                    onClick = onDiscussWithAiClick,
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp)
                        .testTag("discuss_with_ai_button")
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Psychology, contentDescription = null, tint = AiPurple, modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = Translations.get("discuss_with_ai", currentLanguage),
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )
                    }
                }

                // Start Quiz Button
                Button(
                    onClick = onStartQuizClick,
                    colors = ButtonDefaults.buttonColors(containerColor = AiIndigo),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp)
                        .testTag("start_quiz_button")
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Quiz, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = Translations.get("quiz_button", currentLanguage),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

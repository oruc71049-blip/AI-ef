package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.FamilyRestroom
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.database.UserProfileEntity
import com.example.data.models.AppLanguage
import com.example.data.models.Translations
import com.example.data.models.UserRole
import com.example.ui.theme.AiAmber
import com.example.ui.theme.AiCyan
import com.example.ui.theme.AiIndigo
import com.example.ui.theme.AiPink
import com.example.ui.theme.AiPurple

@Composable
fun AiTopBar(
    title: String,
    userProfile: UserProfileEntity?,
    currentLanguage: AppLanguage,
    onLanguageClick: () -> Unit,
    onRoleClick: () -> Unit,
    onThemeToggle: (Boolean) -> Unit,
    onStreakClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isDark = userProfile?.isDarkMode ?: true

    Surface(
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.95f),
        tonalElevation = 6.dp,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Title & Subtitle
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.linearGradient(
                                    listOf(AiCyan, AiIndigo)
                                )
                            )
                    ) {
                        Text(text = "AI", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 16.sp)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        userProfile?.let {
                            val roleText = when (it.role) {
                                "PARENT" -> Translations.get("role_parent", currentLanguage)
                                "ADMIN" -> Translations.get("role_admin", currentLanguage)
                                else -> "${it.name} • ${Translations.get("level", currentLanguage)} ${it.level}"
                            }
                            Text(
                                text = roleText,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }

                // Quick Action Bar Icons
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // Streak Pill
                    userProfile?.let {
                        StreakChip(
                            streakDays = it.streak,
                            onClick = onStreakClick
                        )
                    }

                    // Role switch button
                    IconButton(
                        onClick = onRoleClick,
                        modifier = Modifier
                            .size(36.dp)
                            .testTag("role_switch_button")
                    ) {
                        val roleIcon = when (userProfile?.role) {
                            "PARENT" -> Icons.Default.FamilyRestroom
                            "ADMIN" -> Icons.Default.AdminPanelSettings
                            else -> Icons.Default.Psychology
                        }
                        Icon(
                            imageVector = roleIcon,
                            contentDescription = "Switch Role",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    // Language button
                    IconButton(
                        onClick = onLanguageClick,
                        modifier = Modifier
                            .size(36.dp)
                            .testTag("language_button")
                    ) {
                        Text(
                            text = currentLanguage.flag,
                            fontSize = 18.sp
                        )
                    }

                    // Dark/Light toggle
                    IconButton(
                        onClick = { onThemeToggle(!isDark) },
                        modifier = Modifier
                            .size(36.dp)
                            .testTag("theme_toggle_button")
                    ) {
                        Icon(
                            imageVector = if (isDark) Icons.Default.LightMode else Icons.Default.DarkMode,
                            contentDescription = "Toggle Theme",
                            tint = if (isDark) AiAmber else MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            // Gamification stats row (XP & Coins)
            userProfile?.let {
                if (it.role == "STUDENT") {
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            // XP Badge
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = AiPurple.copy(alpha = 0.15f),
                                modifier = Modifier.border(1.dp, AiPurple.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = AiPurple, modifier = Modifier.size(14.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "${it.xp} ${Translations.get("xp", currentLanguage)}",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AiPurple
                                    )
                                }
                            }

                            // Coins Badge
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = AiAmber.copy(alpha = 0.15f),
                                modifier = Modifier.border(1.dp, AiAmber.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Text(text = "🪙", fontSize = 12.sp)
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "${it.coins}",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AiAmber
                                    )
                                }
                            }
                        }

                        // Rank Title
                        val rankTitle = getRankTitle(it.xp, currentLanguage)
                        Text(
                            text = rankTitle,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = AiCyan
                        )
                    }
                }
            }
        }
    }
}

fun getRankTitle(xp: Int, lang: AppLanguage): String {
    return when {
        xp < 200 -> when (lang) {
            AppLanguage.AZ -> "🌱 Başlanğıc Tələbə"
            AppLanguage.EN -> "🌱 AI Novice"
            AppLanguage.RU -> "🌱 Новичок ИИ"
        }
        xp < 500 -> when (lang) {
            AppLanguage.AZ -> "⚡ Prompt Çırağı"
            AppLanguage.EN -> "⚡ Prompt Apprentice"
            AppLanguage.RU -> "⚡ Подмастерье Промптов"
        }
        xp < 1000 -> when (lang) {
            AppLanguage.AZ -> "🧠 Neyron Tədqiqatçı"
            AppLanguage.EN -> "🧠 Neural Explorer"
            AppLanguage.RU -> "🧠 Исследователь Сетей"
        }
        xp < 2000 -> when (lang) {
            AppLanguage.AZ -> "✨ Prompt Ustası"
            AppLanguage.EN -> "✨ Prompt Master"
            AppLanguage.RU -> "✨ Мастер Промптов"
        }
        else -> when (lang) {
            AppLanguage.AZ -> "👑 AI Qrandmaster"
            AppLanguage.EN -> "👑 AI Grandmaster"
            AppLanguage.RU -> "👑 Грандмастер ИИ"
        }
    }
}

@Composable
fun StreakChip(
    streakDays: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 1.0f,
        targetValue = 1.15f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Surface(
        shape = RoundedCornerShape(14.dp),
        color = Color(0xFFEF4444).copy(alpha = 0.15f),
        modifier = modifier
            .border(1.dp, Color(0xFFEF4444).copy(alpha = 0.5f), RoundedCornerShape(14.dp))
            .clickable { onClick() }
            .testTag("streak_chip")
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.LocalFireDepartment,
                contentDescription = "Streak",
                tint = Color(0xFFEF4444),
                modifier = Modifier
                    .size(16.dp)
                    .scale(scale)
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = "$streakDays",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color(0xFFEF4444)
            )
        }
    }
}

@Composable
fun AiBottomNavBar(
    selectedTab: Int,
    userRole: String,
    currentLanguage: AppLanguage,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 8.dp,
        modifier = modifier
    ) {
        NavigationBarItem(
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) },
            icon = {
                Icon(
                    imageVector = if (userRole == "ADMIN") Icons.Default.AdminPanelSettings else Icons.Default.MenuBook,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = if (userRole == "ADMIN") Translations.get("role_admin", currentLanguage)
                    else Translations.get("nav_learn", currentLanguage),
                    fontSize = 11.sp
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AiCyan,
                selectedTextColor = AiCyan,
                indicatorColor = AiCyan.copy(alpha = 0.15f)
            ),
            modifier = Modifier.testTag("nav_item_learn")
        )

        NavigationBarItem(
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) },
            icon = { Icon(Icons.Default.Psychology, contentDescription = null) },
            label = { Text(Translations.get("nav_chat", currentLanguage), fontSize = 11.sp) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AiPurple,
                selectedTextColor = AiPurple,
                indicatorColor = AiPurple.copy(alpha = 0.15f)
            ),
            modifier = Modifier.testTag("nav_item_chat")
        )

        NavigationBarItem(
            selected = selectedTab == 2,
            onClick = { onTabSelected(2) },
            icon = { Icon(Icons.Default.FamilyRestroom, contentDescription = null) },
            label = { Text(Translations.get("nav_parent", currentLanguage), fontSize = 11.sp) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AiIndigo,
                selectedTextColor = AiIndigo,
                indicatorColor = AiIndigo.copy(alpha = 0.15f)
            ),
            modifier = Modifier.testTag("nav_item_parent")
        )

        NavigationBarItem(
            selected = selectedTab == 3,
            onClick = { onTabSelected(3) },
            icon = { Icon(Icons.Default.ShoppingBag, contentDescription = null) },
            label = { Text(Translations.get("nav_shop", currentLanguage), fontSize = 11.sp) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AiAmber,
                selectedTextColor = AiAmber,
                indicatorColor = AiAmber.copy(alpha = 0.15f)
            ),
            modifier = Modifier.testTag("nav_item_shop")
        )

        NavigationBarItem(
            selected = selectedTab == 4,
            onClick = { onTabSelected(4) },
            icon = { Icon(Icons.Default.Person, contentDescription = null) },
            label = { Text(Translations.get("nav_profile", currentLanguage), fontSize = 11.sp) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AiPink,
                selectedTextColor = AiPink,
                indicatorColor = AiPink.copy(alpha = 0.15f)
            ),
            modifier = Modifier.testTag("nav_item_profile")
        )
    }
}

@Composable
fun LanguageDialog(
    currentLanguage: AppLanguage,
    onLanguageSelected: (AppLanguage) -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Dili Seçin / Choose Language / Выберите язык",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                AppLanguage.values().forEach { lang ->
                    val isSelected = lang == currentLanguage
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onLanguageSelected(lang)
                                onDismiss()
                            }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(14.dp)
                        ) {
                            Text(text = lang.flag, fontSize = 24.sp)
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = lang.displayName,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RoleDialog(
    currentRole: String,
    currentLanguage: AppLanguage,
    onRoleSelected: (UserRole) -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = Translations.get("select_role", currentLanguage),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                RoleItemCard(
                    title = Translations.get("role_student", currentLanguage),
                    desc = Translations.get("role_student_desc", currentLanguage),
                    icon = Icons.Default.Psychology,
                    isSelected = currentRole == "STUDENT",
                    onClick = {
                        onRoleSelected(UserRole.STUDENT)
                        onDismiss()
                    }
                )

                RoleItemCard(
                    title = Translations.get("role_parent", currentLanguage),
                    desc = Translations.get("role_parent_desc", currentLanguage),
                    icon = Icons.Default.FamilyRestroom,
                    isSelected = currentRole == "PARENT",
                    onClick = {
                        onRoleSelected(UserRole.PARENT)
                        onDismiss()
                    }
                )

                RoleItemCard(
                    title = Translations.get("role_admin", currentLanguage),
                    desc = Translations.get("role_admin_desc", currentLanguage),
                    icon = Icons.Default.AdminPanelSettings,
                    isSelected = currentRole == "ADMIN",
                    onClick = {
                        onRoleSelected(UserRole.ADMIN)
                        onDismiss()
                    }
                )
            }
        }
    }
}

@Composable
private fun RoleItemCard(
    title: String,
    desc: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(14.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = desc,
                    fontSize = 12.sp,
                    color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f) else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

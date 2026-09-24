package com.example.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.FamilyRestroom
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.database.UserProfileEntity
import com.example.data.models.AppLanguage
import com.example.data.models.Translations
import com.example.data.models.UserRole
import com.example.ui.components.getRankTitle
import com.example.ui.theme.AiAmber
import com.example.ui.theme.AiCyan
import com.example.ui.theme.AiEmerald
import com.example.ui.theme.AiIndigo
import com.example.ui.theme.AiPurple

@Composable
fun ProfileSettingsScreen(
    userProfile: UserProfileEntity?,
    currentLanguage: AppLanguage,
    onLanguageClick: () -> Unit,
    onRoleClick: () -> Unit,
    onThemeToggle: (Boolean) -> Unit,
    onResetOnboarding: () -> Unit,
    onLogoutClick: () -> Unit = onResetOnboarding,
    modifier: Modifier = Modifier
) {
    val isDark = userProfile?.isDarkMode ?: true
    val rankTitle = getRankTitle(userProfile?.xp ?: 0, currentLanguage)

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .testTag("profile_settings_screen")
    ) {
        // User Profile Card
        item {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(4.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.linearGradient(listOf(AiCyan, AiPurple))
                            )
                    ) {
                        Text(
                            text = (userProfile?.name?.take(1) ?: "U").uppercase(),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = userProfile?.name ?: "Şagird",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Text(
                        text = userProfile?.email ?: "student@gmail.com",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = AiCyan.copy(alpha = 0.15f),
                        modifier = Modifier.padding(2.dp)
                    ) {
                        Text(
                            text = rankTitle,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = AiCyan,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // XP & Coins Badges Row
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = AiPurple.copy(alpha = 0.12f),
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(12.dp)
                            ) {
                                Text(text = "${userProfile?.xp ?: 0}", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = AiPurple)
                                Text(text = Translations.get("xp", currentLanguage), fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = AiAmber.copy(alpha = 0.12f),
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(12.dp)
                            ) {
                                Text(text = "${userProfile?.coins ?: 0}", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = AiAmber)
                                Text(text = Translations.get("coins", currentLanguage), fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = Color(0xFFEF4444).copy(alpha = 0.12f),
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(12.dp)
                            ) {
                                Text(text = "${userProfile?.streak ?: 0} gün", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFFEF4444))
                                Text(text = Translations.get("streak", currentLanguage), fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                    }
                }
            }
        }

        // Settings Section
        item {
            Text(
                text = Translations.get("settings_title", currentLanguage),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    // Language Switch Row
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onLanguageClick() }
                            .padding(12.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Translate, contentDescription = null, tint = AiCyan)
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(text = Translations.get("language", currentLanguage), fontWeight = FontWeight.SemiBold)
                                Text(text = currentLanguage.displayName, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                        Text(text = currentLanguage.flag, fontSize = 22.sp)
                    }

                    // Role Switch Row
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onRoleClick() }
                            .padding(12.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            val roleIcon = when (userProfile?.role) {
                                "PARENT" -> Icons.Default.FamilyRestroom
                                "ADMIN" -> Icons.Default.AdminPanelSettings
                                else -> Icons.Default.Psychology
                            }
                            Icon(roleIcon, contentDescription = null, tint = AiPurple)
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(text = Translations.get("role_label", currentLanguage), fontWeight = FontWeight.SemiBold)
                                val roleName = when (userProfile?.role) {
                                    "PARENT" -> Translations.get("role_parent", currentLanguage)
                                    "ADMIN" -> Translations.get("role_admin", currentLanguage)
                                    else -> Translations.get("role_student", currentLanguage)
                                }
                                Text(text = roleName, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                        Text(text = "Dəyiş ➔", fontSize = 12.sp, color = AiCyan, fontWeight = FontWeight.Bold)
                    }

                    // Dark / Light Theme Toggle
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(if (isDark) Icons.Default.DarkMode else Icons.Default.LightMode, contentDescription = null, tint = AiAmber)
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(text = Translations.get("dark_mode", currentLanguage), fontWeight = FontWeight.SemiBold)
                                Text(text = if (isDark) "Gecə rejimi aktiv" else "Gündüz rejimi aktiv", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                        Switch(
                            checked = isDark,
                            onCheckedChange = { onThemeToggle(it) },
                            colors = SwitchDefaults.colors(checkedThumbColor = AiCyan, checkedTrackColor = AiIndigo)
                        )
                    }

                    // Re-run Onboarding / Edit Profile
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onResetOnboarding() }
                            .padding(12.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Person, contentDescription = null, tint = AiIndigo)
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "Profili və Yaşı Redaktə Et", fontWeight = FontWeight.SemiBold)
                        }
                        Text(text = "➔", fontSize = 14.sp, color = AiIndigo)
                    }

                    // Reset / Logout Profile
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onLogoutClick() }
                            .padding(12.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Person, contentDescription = null, tint = Color(0xFFEF4444))
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = "Hesabdan Çıxış / Yeni Şagird Yarat",
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFFEF4444)
                            )
                        }
                        Text(text = "➔", fontSize = 14.sp, color = Color(0xFFEF4444))
                    }
                }
            }
        }
    }
}

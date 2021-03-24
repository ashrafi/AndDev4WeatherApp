/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.EmojiTheme
import com.example.androiddevchallenge.ui.theme.KlingonTheme
import com.example.androiddevchallenge.ui.theme.MartianTheme
import com.example.androiddevchallenge.ui.theme.MyTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Grin
import compose.icons.fontawesomeicons.solid.Skull
import compose.icons.fontawesomeicons.solid.UserAstronaut

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Mars : Screen("mars", R.string.mars, FontAwesomeIcons.Solid.UserAstronaut)
    object Emoji : Screen("emoji", R.string.emoji, FontAwesomeIcons.Solid.Grin)
    object Klingon : Screen("klingon", R.string.klingon, FontAwesomeIcons.Solid.Skull)
}

// Start building your app here!
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyApp() {
    val ctx = LocalContext.current
    val items = listOf(
        Screen.Mars,
        Screen.Emoji,
        Screen.Klingon,
    )

    // AppCompatDelegate.setDefaultNightMode()

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                screen.icon, "icon",
                                modifier = Modifier.size(27.dp)
                            )
                        },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo = navController.graph.startDestination
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                            }
                        },

                    )
                }
            }
        }
    ) {

        NavHost(navController, startDestination = Screen.Mars.route) {
            composable(Screen.Mars.route) {
                val colors_mars = listOf(
                    Color.DarkGray,
                    Color.Gray,
                    Color.Black
                )
                MartianTheme() {
                    MainFace(ctx, R.drawable.ic_mars, colors_mars)
                }
            }
            composable(Screen.Emoji.route) {
                val colors_emoji = listOf(
                    Color(0xFFffd7d7.toInt()),
                    Color(0xFFffe9d6.toInt()),
                    Color(0xFFfffbd0.toInt()),
                    Color(0xFFe3ffd9.toInt()),
                    Color(0xFFd0fff8.toInt())
                )

                EmojiTheme() {
                    MainFace(ctx, R.drawable.ic_kawaii_earth, colors_emoji)
                }
            }
            composable(Screen.Klingon.route) {
                val colors_klingon = listOf(
                    Color.DarkGray,
                    Color.Gray,
                    Color.Black
                )
                KlingonTheme() { // we can also do VulcanTheme() {
                    MainFace(ctx, R.drawable.klingon_planet, colors_klingon)
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

const val TAG = "weather"

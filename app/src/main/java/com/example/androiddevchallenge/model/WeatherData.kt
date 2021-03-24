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
package com.example.androiddevchallenge.model

import androidx.compose.ui.graphics.vector.ImageVector
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Church
import compose.icons.fontawesomeicons.solid.Cloud
import compose.icons.fontawesomeicons.solid.CloudMoonRain
import compose.icons.fontawesomeicons.solid.Ghost
import compose.icons.fontawesomeicons.solid.Rainbow
import compose.icons.fontawesomeicons.solid.Sun
import compose.icons.fontawesomeicons.solid.Water
import compose.icons.fontawesomeicons.solid.Wind
import kotlin.random.Random

data class WeatherRowData(
    val day: String,
    val activity: String,
    val dayTemp: Int,
    val nightTemp: Int,
    // val img: @Composable () -> Unit
)

fun GenWeatherRowData(): List<WeatherRowData> {

    val WeatherRowDataInfo: List<WeatherRowData> = listOf(
        WeatherRowData(
            day = "Monday",
            activity = "Work like a 🐶",
            dayTemp = Random.nextInt(70, 90),
            nightTemp = Random.nextInt(50, 70),
        ),

        WeatherRowData(
            day = "Tuesday",
            activity = "Busy like a 🐝",
            dayTemp = Random.nextInt(70, 90),
            nightTemp = Random.nextInt(50, 70),
        ),

        WeatherRowData(
            day = "Wedendsay",
            activity = "🐫 day",
            dayTemp = Random.nextInt(70, 80),
            nightTemp = Random.nextInt(40, 50),
        ),

        WeatherRowData(
            day = "Thursday",
            activity = "Play ⚽️",
            dayTemp = Random.nextInt(70, 80),
            nightTemp = Random.nextInt(40, 50),

        ),

        WeatherRowData(
            day = "Friday",
            activity = "🍿 date night 🎥 🎞",
            dayTemp = Random.nextInt(70, 90),
            nightTemp = Random.nextInt(40, 50),

        ),

        WeatherRowData(
            day = "Saturday",
            activity = "Ride your 🚵🏿‍♀️🚲",
            dayTemp = Random.nextInt(70, 90),
            nightTemp = Random.nextInt(40, 50),

        ),
        WeatherRowData(
            day = "Sunday",
            activity = "📞 your 👩‍👦",
            dayTemp = Random.nextInt(70, 90),
            nightTemp = Random.nextInt(40, 50),
        )
    )
    return WeatherRowDataInfo
}

fun getIcon(inx: Int): ImageVector {
    var weatherIcon: ImageVector = FontAwesomeIcons.Solid.Water
    weatherIcon = when (inx) {
        1 -> FontAwesomeIcons.Solid.Cloud
        2 -> FontAwesomeIcons.Solid.Sun
        3 -> FontAwesomeIcons.Solid.Wind
        4 -> FontAwesomeIcons.Solid.Ghost
        5 -> FontAwesomeIcons.Solid.Rainbow
        6 -> FontAwesomeIcons.Solid.CloudMoonRain
        7 -> FontAwesomeIcons.Solid.Church // FontAwesomeIcons.Solid.CloudMoon
        else -> { // Note the block
            FontAwesomeIcons.Solid.Water
        }
    }
    return weatherIcon
}

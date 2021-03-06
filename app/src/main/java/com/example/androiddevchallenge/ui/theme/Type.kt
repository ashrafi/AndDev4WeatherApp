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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

private val KlingonFontFamily = FontFamily(
    Font(
        R.font.klingon_font,
        weight = FontWeight.W300
    )
)

private val MartianFontFamily = FontFamily(
    Font(
        R.font.zephyr_jubilee,
        weight = FontWeight.W300
    )
)

private val EmojiFontFamily = FontFamily(
    Font(
        R.font.googleemojis_regular,
        weight = FontWeight.W300
    )
)

// Vulcan
private val SyneFontFamily = FontFamily(
    Font(
        R.font.synemono_regular,
        weight = FontWeight.W300
    )
)

// Set of Material typography styles to start with
val emojiTypography = Typography(
    body1 = TextStyle(
        fontFamily = EmojiFontFamily, // FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp
    ),
    // Other default text styles to override
    button = TextStyle(
        fontFamily = EmojiFontFamily, // FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    )/*,
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/
)

// Set of Material typography styles to start with
val klingonTypography = Typography(
    body1 = TextStyle(
        fontFamily = KlingonFontFamily, // FontFamily.Default,
        fontWeight = FontWeight.Normal,
        // fontSize = 110.sp
    ),
    // Other default text styles to override
    button = TextStyle(
        fontFamily = KlingonFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        color = Color.Red
    )/*,
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/
)
// Set of Material typography styles to start with
val martianTypography = Typography(
    body1 = TextStyle(
        fontFamily = MartianFontFamily, // FontFamily.Default,
        fontWeight = FontWeight.Normal,
        // fontSize = 40.sp
    ),
    // Other default text styles to override
    button = TextStyle(
        fontFamily = MartianFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        color = Color.Red
    )/*,
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/
)
private val VolcanFontFamily = FontFamily(
    Font(
        R.font.vulcan_script,
        weight = FontWeight.W300
    )
)
// Set of Material typography styles to start with
val volcanTypography = Typography(
    body1 = TextStyle(
        fontFamily = VolcanFontFamily, // FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 100.sp
    ),

    body2 = TextStyle(
        fontFamily = VolcanFontFamily, // FontFamily.Default,
        // fontWeight = FontWeight.Normal,
        fontWeight = FontWeight.W300,
        fontSize = 100.sp
    ),

    h1 = TextStyle(
        fontFamily = VolcanFontFamily, // FontFamily.Default,
        // fontWeight = FontWeight.Normal,
        fontWeight = FontWeight.W300,
        fontSize = 100.sp
    ),
    // Other default text styles to override
    button = TextStyle(
        fontFamily = VolcanFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        color = Color.Cyan
    )/*,
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/
)

// Set of Material typography styles to start with
val syneTypography = Typography(
    body1 = TextStyle(
        fontFamily = SyneFontFamily, // FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp
    ),

    h1 = TextStyle(
        fontFamily = SyneFontFamily, // FontFamily.Default,
        // fontWeight = FontWeight.Normal,
        fontWeight = FontWeight.W300,
        fontSize = 45.sp
    )
    /* Other default text styles to override
button = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp
),
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/
)

// Set of Material typography styles to start with
val typography = Typography(
    body1 = TextStyle(
        fontFamily = EmojiFontFamily, // FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp
    )
    /* Other default text styles to override
button = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp
),
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/
)

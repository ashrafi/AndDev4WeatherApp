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

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Church
import compose.icons.fontawesomeicons.solid.Cloud
import compose.icons.fontawesomeicons.solid.CloudRain
import compose.icons.fontawesomeicons.solid.CloudSun
import compose.icons.fontawesomeicons.solid.CloudSunRain
import compose.icons.fontawesomeicons.solid.Rainbow
import compose.icons.fontawesomeicons.solid.Sun
import compose.icons.fontawesomeicons.solid.Water

// .animateContentSize()

@Composable
fun animaRepeat(): Pair<Float, Float> {
    val infiniteTransition = rememberInfiniteTransition()
    val alphaChangeUp by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                0.7f at 500
            },
            repeatMode = RepeatMode.Reverse
        )
    )
    val alphaChangeDown by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                0.7f at 500
            },
            repeatMode = RepeatMode.Reverse
        )
    )
    return Pair(alphaChangeUp, alphaChangeDown)
}

/*@Composable
fun animaOneShot(): Pair<Float, Float> {
    val alpha: Float by animateFloatAsState(if (enabled) 1f else 0.5f)
    Box(
        Modifier.fillMaxSize()
            .graphicsLayer(alpha = alpha)
            .background(Color.Red)
    )
    return Pair(alphaChangeUp, alphaChangeDown)
}
@Composable
fun getIcon(selected : Int) : @Composable () -> Unit {
    return {
        if (selected == 0) // put when statement here
            SunaFog(alphaChangeUp, alphaChangeDown) else
            SunaFog(1F, 0F)
    }

    img = {
        if (selected == 1)
            RainClouds(alphaChangeUp, alphaChangeDown) else
            RainClouds(1F, 0F)
    }

    img = {
        if (selected == 2)
            SunRainClouds(alphaChangeUp, alphaChangeDown) else
            SunRainClouds(alphaChangeUp, alphaChangeDown)
    }

    img = {
        if (selected == 3)
            SunClouds(alphaChangeUp, alphaChangeDown) else
            SunClouds(alphaChangeUp, alphaChangeDown)
    }

    img = {
        SunWeather()
    }

    img = {
        if (selected == 5)
            CloudUp(alphaChangeUp, alphaChangeDown) else
            CloudUp(alphaChangeUp, alphaChangeDown)
    }

    img = {
        if (selected == 6)
            ChurchWeather(alphaChangeUp, alphaChangeDown) else
            CloudUp(1F, 0F)
    }
}*/

// 1
@Composable
fun SunaFog(alphaChangeUp: Float, alphaChangeDown: Float) {
    val sunBox = Box(modifier = Modifier.height(40.dp)) {
        Icon(
            imageVector = FontAwesomeIcons.Solid.Water,
            contentDescription = null,
            modifier = Modifier.alpha(alphaChangeUp),
            tint = Color.Gray
        )
        Icon(
            imageVector = FontAwesomeIcons.Solid.Sun,
            contentDescription = null,
            modifier = Modifier.alpha(alphaChangeDown),
            tint = Color.Yellow
        )
    }
}

// 3
@Composable
fun SunRainClouds(alphaChangeUp: Float, alphaChangeDown: Float) {
    Box(modifier = Modifier.height(40.dp)) {
        Icon(
            imageVector = FontAwesomeIcons.Solid.CloudSunRain,
            contentDescription = null,
            modifier = Modifier.alpha(alphaChangeUp),
            tint = Color.Blue
        )
        Icon(
            imageVector = FontAwesomeIcons.Solid.CloudSun,
            contentDescription = null,
            modifier = Modifier.alpha(alphaChangeDown),
            tint = Color.Gray
        )
    }
}

// 4
@Composable
fun SunClouds(alphaChangeUp: Float, alphaChangeDown: Float) {
    Box(modifier = Modifier.height(40.dp)) {
        Icon(
            imageVector = FontAwesomeIcons.Solid.CloudSun,
            contentDescription = null,
            modifier = Modifier.alpha(alphaChangeUp),
            tint = Color.Gray
        )
        Icon(
            imageVector = FontAwesomeIcons.Solid.Sun,
            contentDescription = null,
            modifier = Modifier.alpha(alphaChangeDown),
            tint = Color.Yellow
        )
    }
}

// 5
@Composable
fun RainClouds(alphaChangeUp: Float, alphaChangeDown: Float) {

    Box(modifier = Modifier.height(40.dp)) {
        Icon(
            imageVector = FontAwesomeIcons.Solid.CloudRain,
            contentDescription = null,
            modifier = Modifier.alpha(alphaChangeUp),
            tint = Color.Blue

        )
        Icon(
            imageVector = FontAwesomeIcons.Solid.Cloud,
            contentDescription = null,
            modifier = Modifier.alpha(alphaChangeDown),
            tint = Color.Gray
        )
    }
}

// G
@Composable
fun ChurchWeather(alphaChangeUp: Float, alphaChangeDown: Float) {
    Box(modifier = Modifier.height(40.dp)) {
        Icon(
            imageVector = FontAwesomeIcons.Solid.Church,
            contentDescription = null,
            modifier = Modifier.alpha(alphaChangeUp)
        )
        Icon(
            imageVector = FontAwesomeIcons.Solid.Rainbow,
            contentDescription = null,
            modifier = Modifier.alpha(alphaChangeDown)
        )
    }
}

// 7
@Composable
fun CloudUp(alphaChangeUp: Float, alphaChangeDown: Float) {
    Box(modifier = Modifier.height(40.dp)) {
        Icon(
            imageVector = FontAwesomeIcons.Solid.Cloud,
            contentDescription = null,
            modifier = Modifier.alpha(alphaChangeUp)
        )
        Icon(
            imageVector = Icons.Filled.CloudUpload,
            contentDescription = null,
            modifier = Modifier.alpha(alphaChangeDown)
        )
    }
}

@Composable
fun SunWeather() {
    val infiniteTransition = rememberInfiniteTransition()

    val motionSize by animateDpAsState(
        // initialValue = 0.dp,
        targetValue = 40.dp,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 300),
            repeatMode = RepeatMode.Reverse
        )
    )

    val spin by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 3000
                0.7f at 500
            },
            repeatMode = RepeatMode.Restart
        )
    )
    Box(modifier = Modifier.height(40.dp)) {
        Icon(
            imageVector = FontAwesomeIcons.Solid.Sun,
            contentDescription = null,
            modifier = Modifier
                .rotate(spin),
            tint = Color(0xffd1b03b)
        )
    }
}

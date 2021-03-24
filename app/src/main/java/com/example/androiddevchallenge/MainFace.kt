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

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@ExperimentalMaterialApi
@Composable
fun MainFace(ctx: Context, planet: Int, colors: List<Color>) {

    BottomSheetScaffold(
        sheetContent = { WeatherBottomSheet(ctx, colors) },
        content = { MainWeather(ctx, planet) },
        sheetShape = RoundedCornerShape(0.dp),
        sheetPeekHeight = 120.dp
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainWeather(ctx: Context, planet: Int) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.universe),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        ConstraintLayout {
            // Create references for the composables to constrain
            val (centerImg, text, ship) = createRefs()

            Text(
                "Planetary Weather",
                modifier = Modifier
                    .constrainAs(text) {
                        top.linkTo(parent.top, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth(),
                fontSize = 35.sp
            )

            Image(
                painter = painterResource(planet),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(centerImg) {
                        top.linkTo(parent.top, margin = 16.dp)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },

                // contentScale = ContentScale.FillBounds
            )

            Image(
                painter = painterResource(R.drawable.ic_spacecraft_svgrepo_com),
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
                    .constrainAs(ship) {
                        top.linkTo(parent.top, margin = 16.dp)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end, margin = 27.dp)
                    },

                // contentScale = ContentScale.FillBounds
            )
        }
    }
}

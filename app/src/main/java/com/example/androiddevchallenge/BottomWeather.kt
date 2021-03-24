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
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.GenWeatherRowData
val weatherInfo = GenWeatherRowData()

@Composable
fun WeatherBottomSheet(ctx: Context, colors: List<Color>) {

    val (alphaChangeUp, alphaChangeDown) = animaRepeat()

    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 40.dp, bottom = 24.dp),
            text = "Weekly Weather",
            textAlign = TextAlign.Center
        )

        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            itemsIndexed(weatherInfo) { index, weather ->
                Divider()
                Card(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = 8.dp,
                    backgroundColor = colors[index % colors.size],
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            // .padding(horizontal = 16.dp)
                            // .paddingFromBaseline(,top = 24.dp, bottom = 16.dp)
                            // .height(40.dp),
                            .padding(horizontal = 16.dp)
                            .height(56.dp)
                            .clickable {
                                Log.v(TAG, "Got Click ${weather.activity}")
                                // checkOKViewModel.setCurrCheckOK(alert)
                                // alarmIndex.value = index
                                // sendCmd(ACTION_INITIALIZE_DATA)
                                // Log.v(TAG, "I got clicked $index / alarmIndex.value")
                                // add navigation
                                Toast
                                    .makeText(ctx, weather.activity, Toast.LENGTH_LONG)
                                    .show()
                            },

                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,

                    ) {
                        Text(weather.day)
                        Text("${weather.dayTemp}°\n${weather.nightTemp}°")
                        when (index) {
                            0 -> SunaFog(alphaChangeUp, alphaChangeDown)
                            1 -> RainClouds(alphaChangeUp, alphaChangeDown)
                            2 -> SunRainClouds(alphaChangeUp, alphaChangeDown)
                            3 -> SunClouds(alphaChangeUp, alphaChangeDown)
                            4 -> CloudUp(alphaChangeUp, alphaChangeDown)
                            5 -> SunWeather()
                            6 -> ChurchWeather(alphaChangeUp, alphaChangeDown) // FontAwesomeIcons.Solid.CloudMoon
                            else -> { // Note the block
                                SunWeather()
                            }
                        }
                    }
                }
            }
        }
    }
}

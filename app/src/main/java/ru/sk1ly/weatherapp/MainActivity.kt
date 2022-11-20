package ru.sk1ly.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import ru.sk1ly.weatherapp.data.Weather
import ru.sk1ly.weatherapp.screens.MainCard
import ru.sk1ly.weatherapp.screens.TabLayout
import ru.sk1ly.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                val weather: MutableState<Weather> = remember {
                    mutableStateOf(Weather())
                }
                WeatherApiRequestor.getWeather("Moscow", weather, this)
                Image(
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "Background",
                )
                Column {
                    MainCard(weather)
                    TabLayout(weather)
                }
            }
        }
    }
}
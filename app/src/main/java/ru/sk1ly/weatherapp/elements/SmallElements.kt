package ru.sk1ly.weatherapp.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sk1ly.weatherapp.data.DailyWeather
import ru.sk1ly.weatherapp.data.HourlyWeather
import ru.sk1ly.weatherapp.data.WeatherCode
import ru.sk1ly.weatherapp.ui.theme.DarkDeepBlue
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ListItem(hourlyWeather: HourlyWeather) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        backgroundColor = DarkDeepBlue,
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .width(150.dp)
                    .padding(
                        start = 8.dp,
                        top = 5.dp,
                        bottom = 5.dp
                    ),
            ) {
                Text(
                    text = hourlyWeather.time,
                    color = Color.White
                )
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    text = WeatherCode.getDescription(hourlyWeather.weatherCode),
                    color = Color.White,
                    style = TextStyle(fontSize = 14.sp)
                )
            }
            Text(
                text = "${hourlyWeather.temp}°C",
                color = Color.White,
                style = TextStyle(fontSize = 25.sp)
            )
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .padding(top = 5.dp, bottom = 5.dp, end = 15.dp),
                painter = painterResource(id = WeatherCode.getDrawable(hourlyWeather.weatherCode)),
                contentDescription = "Weather icon",
            )
        }
    }
}

@Composable
fun ListItem(dailyWeather: DailyWeather) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        backgroundColor = DarkDeepBlue,
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .width(150.dp)
                    .padding(
                        start = 8.dp,
                        top = 5.dp,
                        bottom = 5.dp
                    )
            ) {
                Text(
                    text = LocalDate.parse(dailyWeather.date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                        .dayOfWeek.name
                        .lowercase()
                        .replaceFirstChar { it.uppercase() },
                    color = Color.White
                )
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    text = WeatherCode.getDescription(dailyWeather.weatherCode),
                    color = Color.White,
                    style = TextStyle(fontSize = 14.sp)
                )
            }
            Text(
                text = "${dailyWeather.maxTemp}/${dailyWeather.minTemp}°C",
                color = Color.White,
                style = TextStyle(fontSize = 25.sp)
            )
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .padding(top = 5.dp, bottom = 5.dp, end = 15.dp),
                painter = painterResource(id = WeatherCode.getDrawable(dailyWeather.weatherCode)),
                contentDescription = "Weather icon",
            )
        }
    }
}
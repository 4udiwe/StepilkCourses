package com.stepikcourses.ui.screens.enter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stepikcourses.R


@Composable
fun GreetingScreen(
    paddingValues: PaddingValues,
    onContinue: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
            .padding(paddingValues)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 170.dp),
            text = "Тысячи курсов\nв одном месте",
            color = Color.White,
            fontSize = 30.sp
        )

        Column(Modifier.align(Alignment.Center)) {
            LazyRow(
                contentPadding = PaddingValues(vertical = 4.dp),
                state = LazyListState(firstVisibleItemScrollOffset = 200),
                userScrollEnabled = false
            ) {
                item { CourseButton(text = "1C Администрирование") }
                item {
                    CourseButton(
                        modifier = Modifier
                            .offset(y = 6.dp)
                            .rotate(-15.0F),
                        text = "RabbitMQ",
                        flag = true
                    )
                }
                item { CourseButton(text = "Трафик") }
            }
            LazyRow(
                contentPadding = PaddingValues(vertical = 4.dp),
                state = LazyListState(firstVisibleItemScrollOffset = 200),
                userScrollEnabled = false
            ) {
                item { CourseButton(text = "Контент маркетинг") }
                item { CourseButton(text = "B2B маркетинг") }
                item { CourseButton(text = "Google Аналитика") }
            }
            LazyRow(
                contentPadding = PaddingValues(vertical = 4.dp),
                state = LazyListState(firstVisibleItemScrollOffset = 200),
                userScrollEnabled = false
            ) {
                item { CourseButton(text = "UX исследователь") }
                item { CourseButton(text = "Веб-аналитика") }
                item {
                    CourseButton(
                        modifier = Modifier
                            .offset(y = -6.dp)
                            .rotate(15.0F),
                        text = "Big Data",
                        flag = true
                    )
                }
            }
            LazyRow(
                contentPadding = PaddingValues(vertical = 4.dp),
                state = LazyListState(firstVisibleItemScrollOffset = 200),
                userScrollEnabled = false
            ) {
                item { CourseButton(text = "Геймдизайн") }
                item { CourseButton(text = "Веб-дизайн") }
                item { CourseButton(text = "Cinema 4D") }
                item { CourseButton(text = "Промпт инженеринг") }
            }
            LazyRow(
                contentPadding = PaddingValues(vertical = 4.dp),
                state = LazyListState(firstVisibleItemScrollOffset = 200),
                userScrollEnabled = false
            ) {
                item { CourseButton(text = "Webflow") }
                item {
                    CourseButton(
                        modifier = Modifier
                            .offset(y = -6.dp)
                            .rotate(-15.0F),
                        text = "Three.js",
                        flag = true
                    )
                }
                item { CourseButton(text = "Парсинг") }
                item { CourseButton(text = "Python-разработка") }
            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .align(Alignment.BottomCenter),
            onClick = {
                onContinue.invoke()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.green),
                contentColor = Color.White
            )
        ) {
            Text("Продолжить")
        }


    }
}

@Composable
fun CourseButton(
    modifier: Modifier = Modifier,
    text: String,
    flag: Boolean = false,
) {
    Button(
        modifier = modifier.padding(horizontal = 2.dp),
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor =
            if (!flag) colorResource(R.color.elements).copy(alpha = 0.8f)
            else colorResource(R.color.green),
            contentColor = Color.White
        )
    ) {
        Text(
            text = text,
            maxLines = 1,
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
        )
    }
}
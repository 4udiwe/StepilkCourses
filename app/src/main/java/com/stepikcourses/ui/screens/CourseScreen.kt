package com.stepikcourses.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.htmlEncode
import com.example.domain.model.Course
import com.stepikcourses.R


@Composable
fun CourseScreen(
    course: Course = Course(
        title = "Course title - asdfasd",
        description = "desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion ",
        price = "12 000",
        becamePublishedAt = "22 Мая 2024",
        isFavorite = false
    ),
    onBackClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .scrollable(
                state = rememberScrollState(),
                orientation = Orientation.Vertical
            ),
    ) {
        Box(modifier = Modifier.fillMaxWidth()){
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "123",
                contentScale = ContentScale.Crop
            )
            IconButton(
                modifier = Modifier.padding(16.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),
                onClick = {
                    onBackClicked.invoke()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back"
                )
            }

            IconButton(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "back"
                )
            }
            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(10.dp)
            ) {
                Card(
                    modifier = Modifier.padding(end = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xB2464646)),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "star",
                            tint = colorResource(id = R.color.green),
                            modifier = Modifier
                                .size(18.dp)
                                .padding(end = 4.dp)
                        )
                        Text(text = "4.9", color = Color.White)
                    }

                }
                Card(
                    modifier = Modifier,
                    colors = CardDefaults.cardColors(containerColor = Color(0xB2464646)),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            text = course.becamePublishedAt.toString(),
                            color = Color.White
                        )
                    }
                }
            }
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ){
            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = course.title.toString(),
                fontSize = 26.sp,
                color = Color.White
            )

            Row {
                //автор icon
                Image(
                    modifier = Modifier.size(60.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "author"
                )
                Column {
                    Text(text = "Автор", color = Color.White)

                }
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green)),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Начать курс")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.elements)),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Перейти на платформу")
            }

            Text(modifier = Modifier.padding(bottom = 4.dp, top = 16.dp), text = "О курсе", color = Color.White, fontSize = 22.sp)
            Text(text = course.description.toString().htmlEncode(), color = Color.Gray)

            if(course.price != null)
                Text(modifier = Modifier.padding(bottom = 4.dp, top = 16.dp), text = "Цена ${course.price} ₽", color = Color.White, fontSize = 22.sp)

        }

    }
}
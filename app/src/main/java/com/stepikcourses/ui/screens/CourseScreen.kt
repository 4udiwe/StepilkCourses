package com.stepikcourses.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.htmlEncode
import coil.compose.AsyncImage
import com.example.domain.entity.CourseModel
import com.example.domain.model.Course
import com.stepikcourses.R
import com.stepikcourses.viewmodel.MainViewModel


@Composable
fun CourseScreen(
    course: Course,
    onBackClicked: () -> Unit,
    onGoToPlatformClicked: (course: Course) -> Unit,
    viewModel: MainViewModel,
    innerPadding: PaddingValues

) {
    val isFav = remember { mutableStateOf(course.isFavorite) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .padding(bottom = innerPadding.calculateBottomPadding())
            .verticalScroll(rememberScrollState())
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                model = course.cover,
                contentDescription = "cover",
                contentScale = ContentScale.Crop
            )
            IconButton(
                modifier = Modifier.padding(innerPadding).padding(16.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White, contentColor = Color.Black),
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
                    .padding(innerPadding)
                    .padding(16.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White, contentColor = Color.Black),
                onClick = {
                    if (course.isFavorite == true) {
                        course.isFavorite = false
                        isFav.value = false
                        viewModel.deleteFavorite(course)
                    } else {
                        course.isFavorite = true
                        isFav.value = true
                        viewModel.addFavorite(course)
                    }
                }
            ) {
                if (isFav.value == true) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        tint = colorResource(R.color.green),
                        contentDescription = "favorite"
                    )
                } else {
                    course.isFavorite = true
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "favorite"
                    )
                }
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
                        val pubDate = course.becamePublishedAt
                        val month = when (pubDate?.substring(5, 7)) {
                            "01" -> "Января"
                            "02" -> "Февраля"
                            "03" -> "Марта"
                            "04" -> "Апреля"
                            "05" -> "Майя"
                            "06" -> "Июня"
                            "07" -> "Июля"
                            "08" -> "Августа"
                            "09" -> "Сентября"
                            "10" -> "Октября"
                            "11" -> "Ноября"
                            "12" -> "Декабря"
                            else -> {
                                ""
                            }
                        }
                        Text(
                            text = "${
                                pubDate?.substring(
                                    8,
                                    10
                                )
                            } $month ${pubDate?.take(4)}",
                            color = Color.White
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = course.title.toString(),
                fontSize = 26.sp,
                color = Color.White
            )

            Text(text = course.summary ?: "Course Summary")

            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.green),
                    contentColor = Color.White
                ),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Начать курс")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.elements),
                    contentColor = Color.White
                ),
                onClick = {
                    onGoToPlatformClicked(course)
                }
            ) {
                Text(text = "Перейти на платформу")
            }

            Text(
                modifier = Modifier.padding(bottom = 4.dp, top = 16.dp),
                text = "О курсе",
                color = Color.White,
                fontSize = 22.sp
            )
            Text(text = course.description.toString(), color = Color.Gray)
            Text(text = "Сложность: ${course.difficulty ?: "course difficulty"}")

            if (course.price != null)
                Text(
                    modifier = Modifier.padding(bottom = 4.dp, top = 16.dp),
                    text = "Цена ${course.price} ₽",
                    color = Color.White,
                    fontSize = 22.sp
                )

        }

    }
}
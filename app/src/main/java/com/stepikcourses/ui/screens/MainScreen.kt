package com.stepikcourses.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.Courses
import com.stepikcourses.R
import com.stepikcourses.viewmodel.MainViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.job

@Composable
fun MainScreen(viewModel: MainViewModel, innerPadding: PaddingValues) {

    val coursesState = viewModel.courses.collectAsState()
    Column(
        Modifier
            .fillMaxSize()
            .padding(innerPadding), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "All Courses")
        LazyColumn {
            items(coursesState.value) { course ->
                CourseSheet(course)
            }
            item {

                Button(
                    modifier = Modifier.fillParentMaxWidth(),
                    onClick = {
                        viewModel.getCourses()
                    }
                ) {
                    Text(text = "More")
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CourseSheet(
    course: Courses = Courses(
        title = "Course title - asdfasd",
        description = "desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion ",
        price = "12 000",
        becamePublishedAt = "22 Мая 2024",
        isFavorite = false
    )
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Box {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "123",
                        contentScale = ContentScale.FillWidth
                    )
                    Icon(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 10.dp, end = 10.dp),
                        imageVector =
                        if (course.isFavorite == true)
                            Icons.Default.Favorite
                        else Icons.Default.FavoriteBorder,
                        contentDescription = "123"
                    )
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
                                modifier = Modifier.padding(4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = "star",
                                    tint = Color.Green,
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
                                modifier = Modifier.padding(4.dp),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                Text(text = course.becamePublishedAt.toString(), color = Color.White)
                            }
                        }
                    }
                }

            }

            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 10.dp)
            ) {
                Text(
                    text = course.title.toString(),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = course.description.toString(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "${course.price} ₽", fontWeight = FontWeight.Bold)
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Подробнее")
                        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "123")
                    }
                }
            }
        }
    }

}
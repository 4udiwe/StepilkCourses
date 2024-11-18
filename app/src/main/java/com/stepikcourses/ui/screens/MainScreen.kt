package com.stepikcourses.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.model.Course
import com.stepikcourses.R
import com.stepikcourses.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel,
    innerPadding: PaddingValues,
    onCourseClick: () -> Unit
) {

    val coursesState = viewModel.courses.collectAsState()
    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .padding(innerPadding)
            .padding(horizontal = 4.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(end = 4.dp),
                query = "Search courses...",
                onQueryChange = {},
                onSearch = {},
                active = false,
                onActiveChange = {},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search",
                        tint = Color.White
                    )
                },
                colors = SearchBarDefaults.colors(containerColor = colorResource(id = R.color.elements))
            ) {}
            IconButton(
                modifier = Modifier.size(58.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = colorResource(id = R.color.elements)),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "filter",
                    tint = Color.White
                )
            }
        }
        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            onClick = { /*TODO*/ }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Сортировка", color = colorResource(id = R.color.green))
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "123",
                    tint = colorResource(id = R.color.green)
                )
            }


        }
        val favCourses = viewModel.favoriteCourses.collectAsState(initial = emptyList()).value
        LazyColumn {
            items(coursesState.value) { course->
                course.isFavorite = favCourses.find { courseModel -> courseModel.id == course.id } != null

                CourseSheet(
                    course = course,
                    onDetailsClick = {
                        viewModel.currentCourse = course
                        onCourseClick.invoke()
                    },
                    onAddFav = {
                        course.isFavorite = true
                        viewModel.addFavorite(course)
                    },
                    onDeleteFav = {
                        viewModel.deleteFavorite(course)
                    }
                )
            }
            item {
                Button(
                    modifier = Modifier.fillParentMaxWidth(),
                    onClick = {
                        viewModel.getCourses()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green))
                ) {
                    Text(text = "More")
                }
            }
        }
    }
}

//@Preview(showSystemUi = true)
@Composable
fun CourseSheet(
    course: Course = Course(
        title = "Course title - asdfasd",
        description = "desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion desctiprion ",
        price = "12 000",
        becamePublishedAt = "22 Мая 2024",
        isFavorite = false
    ),
    onDetailsClick: () -> Unit,
    onAddFav: () -> Unit,
    onDeleteFav: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.elements),
            contentColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.elements))
            ) {
                Box {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        model = course.cover,
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth
                    )
                    IconButton(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 10.dp, end = 10.dp),
                        onClick = {
                            if (course.isFavorite == true)
                                onDeleteFav.invoke()
                            else
                                onAddFav.invoke()
                        }
                    ) {
                        Icon(
                            imageVector =
                            if (course.isFavorite == true)
                                Icons.Default.Favorite
                            else Icons.Default.FavoriteBorder,
                            contentDescription = "favorite"
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
                    text = course.summary.toString(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (course.price != null)
                        Text(text = "${course.price} ₽", fontWeight = FontWeight.Bold)
                    else
                        Text(text = "")
                    TextButton(
                        onClick = {
                            onDetailsClick.invoke()
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = colorResource(id = R.color.green),
                            containerColor = Color.Transparent
                        )
                    ) {
                        Text(text = "Подробнее")
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "123"
                        )
                    }
                }
            }
        }
    }

}
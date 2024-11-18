package com.stepikcourses.ui.screens

import android.widget.RadioGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.util.TableInfo
import coil.compose.AsyncImage
import com.example.domain.model.Course
import com.stepikcourses.R
import com.stepikcourses.viewmodel.MainViewModel
import com.stepikcourses.viewmodel.SortingType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel, innerPadding: PaddingValues, onCourseClick: () -> Unit
) {

    val coursesState = viewModel.courses.collectAsState()
    val sortingDialogState = remember { mutableStateOf(false) }

    if (sortingDialogState.value)
        SortingDialog(viewModel = viewModel, dialogState = sortingDialogState)

    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
            .padding(innerPadding)
            .padding(horizontal = 12.dp)
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
            IconButton(modifier = Modifier.size(58.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = colorResource(id = R.color.elements)),
                onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "filter",
                    tint = Color.White
                )
            }
        }
        TextButton(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp), onClick = { /*TODO*/ }) {
            Row(
                modifier = Modifier.fillMaxWidth().clickable {
                    sortingDialogState.value = true
                },
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "По ${
                    when (viewModel.sortingType) {
                        SortingType.DATE -> "дате публикации"
                        SortingType.POPULARITY -> "популярности"
                        SortingType.RAINING -> "рейтингу"
                    }
                }", color = colorResource(id = R.color.green))
            }


        }
        val favCourses = viewModel.favoriteCourses.collectAsState(initial = emptyList()).value
        LazyColumn {
            items(coursesState.value.sortedBy { course ->
                when (viewModel.sortingType) {
                    SortingType.DATE -> course.becamePublishedAt
                    SortingType.POPULARITY -> course.isPopular
                    SortingType.RAINING -> course.becamePublishedAt
                }.toString()
            }
            ) { course ->
                course.isFavorite =
                    favCourses.find { courseModel -> courseModel.id == course.id } != null

                CourseSheet(course = course, onDetailsClick = {
                    viewModel.currentCourse = course
                    onCourseClick.invoke()
                }, onAddFav = {
                    course.isFavorite = true
                    viewModel.addFavorite(course)
                }, onDeleteFav = {
                    viewModel.deleteFavorite(course)
                })
            }
            item {
                val isLoading = remember { mutableStateOf(false) }

                Button(
                    modifier = Modifier.fillParentMaxWidth(),
                    onClick = {
                        val job = viewModel.getCourses()
                        when (job.isActive) {
                            true -> isLoading.value = true
                            false -> isLoading.value = false
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green))
                ) {
                    Text(text = if (!isLoading.value) "Показать еще" else "Загрузка")
                }
            }
        }
    }
}

@Composable
fun CourseSheet(
    course: Course, onDetailsClick: () -> Unit, onAddFav: () -> Unit, onDeleteFav: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.elements), contentColor = Color.White
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
                    IconButton(modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 10.dp, end = 10.dp),
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color(
                                0xB2464646
                            )
                        ),
                        onClick = {
                            if (course.isFavorite == true) onDeleteFav.invoke()
                            else onAddFav.invoke()
                        }) {
                        if (course.isFavorite == true) Icon(
                            imageVector = Icons.Default.Favorite,
                            tint = colorResource(R.color.green),
                            contentDescription = "favorite"
                        )
                        else Icon(
                            imageVector = Icons.Default.FavoriteBorder,
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
                                            8, 10
                                        )
                                    } $month ${pubDate?.take(4)}", color = Color.White
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
                    if (course.price != null) Text(
                        text = "${course.price} ₽",
                        fontWeight = FontWeight.Bold
                    )
                    else Text(text = "")
                    TextButton(
                        onClick = {
                            onDetailsClick.invoke()
                        }, colors = ButtonDefaults.buttonColors(
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


@Composable
fun SortingDialog(
    viewModel: MainViewModel,
    dialogState: MutableState<Boolean>
) {

    val datePicked = remember { mutableStateOf(viewModel.sortingType == SortingType.DATE) }
    val rainingPicked = remember { mutableStateOf(viewModel.sortingType == SortingType.RAINING) }
    val popularityPicked = remember { mutableStateOf(viewModel.sortingType == SortingType.POPULARITY) }

    AlertDialog(
        modifier = Modifier,
        containerColor = colorResource(R.color.elements),
        textContentColor = Color.White,
        onDismissRequest = { dialogState.value = false },
        dismissButton = {
            TextButton(onClick = { dialogState.value = false }) {
                Text("Назад")
            }
        },
        confirmButton = {
            TextButton(onClick = {
                viewModel.sortingType =
                    if (datePicked.value) SortingType.DATE
                    else if (rainingPicked.value) SortingType.RAINING
                    else SortingType.POPULARITY

                dialogState.value = false
            }) {
                Text("Применить")
            }
        },
        title = {
            Text("Сортировать по...")
        },
        text = {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = datePicked.value,
                        colors = RadioButtonDefaults.colors(selectedColor = colorResource(R.color.green)),
                        onClick = {
                            datePicked.value = true
                            rainingPicked.value = false
                            popularityPicked.value = false
                        }
                    )
                    Text(
                        text = "Дате публикации",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp),
                        textAlign = TextAlign.Start
                    )
                }
                Divider()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = rainingPicked.value,
                        colors = RadioButtonDefaults.colors(selectedColor = colorResource(R.color.green)),
                        onClick = {
                            datePicked.value = false
                            rainingPicked.value = true
                            popularityPicked.value = false
                        }
                    )
                    Text(
                        text = "Рейтингу",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp),
                        textAlign = TextAlign.Start
                    )
                }
                Divider()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = popularityPicked.value,
                        colors = RadioButtonDefaults.colors(selectedColor = colorResource(R.color.green)),
                        onClick = {
                            datePicked.value = false
                            rainingPicked.value = false
                            popularityPicked.value = true
                        }
                    )
                    Text(
                        text = "Популярности",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp),
                        textAlign = TextAlign.Start
                    )
                }
            }
        },

        )
}
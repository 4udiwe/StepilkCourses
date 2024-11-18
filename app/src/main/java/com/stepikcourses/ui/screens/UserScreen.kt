package com.stepikcourses.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Course
import com.stepikcourses.R
import com.stepikcourses.viewmodel.MainViewModel

@Composable
fun UserScreen(
    viewModel: MainViewModel,
    innerPadding: PaddingValues,
    onCourseClick: () -> Unit
) {
    val favCourses = viewModel.favoriteCourses.collectAsState(initial = emptyList()).value.map {
        Course(
            id = it.id,
            summary = it.summary,
            cover = it.cover,
            title = it.title,
            price = it.price,
            description = it.description,
            becamePublishedAt = it.becamePublishedAt,
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.background))
            .padding(innerPadding)
            .padding(horizontal = 12.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp, top = 16.dp),
            text = "Профиль",
            color = Color.White,
            fontSize = 22.sp
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.elements),
                contentColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 8.dp)
            ) {
                Row (
                    modifier = Modifier.clickable {  }.fillMaxWidth().padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text("Написать в поддержку")
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "arrow")
                }
                Divider()
                Row (
                    modifier = Modifier.clickable {  }.fillMaxWidth().padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text("Настройки")
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "arrow")
                }
                Divider()
                Row (
                    modifier = Modifier.clickable {  }.fillMaxWidth().padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text("Выйти из аккаунта")
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "arrow")
                }


            }
        }

        Text(
            modifier = Modifier.padding(bottom = 16.dp, top = 16.dp),
            text = "Избранное",
            color = Color.White,
            fontSize = 22.sp
        )
        LazyColumn {
            items(favCourses) { course ->
                course.isFavorite = true
                CourseSheet(
                    course = course,
                    onDetailsClick = {
                        viewModel.currentCourse = course
                        onCourseClick.invoke()
                    },
                    onAddFav = {
                        viewModel.addFavorite(course)
                    },
                    onDeleteFav = {
                        viewModel.deleteFavorite(course)
                    }
                )
            }
        }
    }

}
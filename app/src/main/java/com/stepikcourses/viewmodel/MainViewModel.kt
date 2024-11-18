package com.stepikcourses.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.CourseModel
import com.example.domain.model.Course
import com.example.domain.usecase.AddFavoriteCourseUseCase
import com.example.domain.usecase.DeleteFavoriteUseCase
import com.example.domain.usecase.GetCourseUseCase
import com.example.domain.usecase.GetFavoriveCoursesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getCourseUseCase: GetCourseUseCase,
    private val addFavoriteCourseUseCase: AddFavoriteCourseUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase,
    getFavoriteCoursesUseCase: GetFavoriveCoursesUseCase
) : ViewModel() {

    private val _innerCourses = MutableStateFlow<List<Course>>(emptyList())
    val courses = _innerCourses.asStateFlow()

    lateinit var currentCourse: Course

    private var page = 3

    val favoriteCourses = getFavoriteCoursesUseCase.invoke()

    fun getCourses() = viewModelScope.launch {
        val currentCourses = _innerCourses.value.toMutableList()
        repeat(3){
            val coursesInfo = getCourseUseCase.invoke(page)
            if (coursesInfo.meta?.hasNext == true) {
                currentCourses.addAll(coursesInfo.courses)
                page++
            }
            _innerCourses.value = currentCourses
        }

    }

    fun addFavorite(course: Course) = viewModelScope.launch {
        val model = CourseModel(
            id = course.id,
            summary = course.summary,
            cover = course.cover,
            isFavorite = course.isFavorite,
            price = course.price,
            title = course.title,
            becamePublishedAt = course.becamePublishedAt,
            description = course.description
        )
        addFavoriteCourseUseCase.invoke(model)
    }

    fun deleteFavorite(course: Course) = viewModelScope.launch {
        val model = CourseModel(
            id = course.id,
            summary = course.summary,
            cover = course.cover,
            isFavorite = course.isFavorite,
            price = course.price,
            title = course.title,
            becamePublishedAt = course.becamePublishedAt,
            description = course.description
        )
        deleteFavoriteUseCase.invoke(model)
    }
}
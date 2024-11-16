package com.stepikcourses.viewmodel

import android.util.Log
import androidx.compose.ui.platform.LocalDensity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Courses
import com.example.domain.usecase.GetCourseUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getCourseUseCase: GetCourseUseCase
) : ViewModel() {

    private val _innerCourses = MutableStateFlow<List<Courses>>(emptyList())
    val courses = _innerCourses.asStateFlow()

    lateinit var currentCourse: Courses

    private var page = 3

    fun getCourses() = viewModelScope.launch {
        val currentCourses = _innerCourses.value.toMutableList()
        val coursesInfo = getCourseUseCase.invoke(page)


        if (coursesInfo.meta?.hasNext == true) {
            currentCourses.addAll(coursesInfo.courses)
            page++
            _innerCourses.value = currentCourses
            Log.d("RRR", "innerCourses UPDATED")
        }
    }
}
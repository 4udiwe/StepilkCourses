package com.stepikcourses.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetCourseUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getCourseUseCase: GetCourseUseCase
) : ViewModel() {
    fun getCourses() = viewModelScope.launch {
        getCourseUseCase.invoke(3)
    }
}
package com.example.domain.usecase

import com.example.domain.model.CoursesInfo
import com.example.domain.repository.CoursesRepository

class GetCourseUseCase(
    private val repository: CoursesRepository
) {
    suspend fun invoke(page: Int = 1) : CoursesInfo = repository.getCourses(page)
}
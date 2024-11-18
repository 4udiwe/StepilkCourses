package com.example.domain.usecase

import com.example.domain.entity.CourseModel
import com.example.domain.repository.CoursesRepository

class DeleteFavoriteUseCase(
    private val repository: CoursesRepository
) {
    suspend fun invoke(course: CourseModel) = repository.deleteFavorite(course)
}
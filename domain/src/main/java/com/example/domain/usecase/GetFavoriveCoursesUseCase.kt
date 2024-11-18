package com.example.domain.usecase

import com.example.domain.repository.CoursesRepository

class GetFavoriveCoursesUseCase(
    private val repository: CoursesRepository
) {
    fun invoke() = repository.getFavorite()
}
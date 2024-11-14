package com.example.data.repository

import com.example.data.api.StepikApi
import com.example.domain.model.CoursesInfo
import com.example.domain.repository.CoursesRepository

class CoursesRepositoryImpl(
    private val api: StepikApi
) : CoursesRepository{
    override suspend fun getCourses(page: Int): CoursesInfo = api.get(page).mapDomain()
}
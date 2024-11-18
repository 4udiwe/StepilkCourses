package com.example.domain.repository

import com.example.domain.entity.CourseModel
import com.example.domain.model.CoursesInfo
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {

    suspend fun getCourses(page: Int) : CoursesInfo

    fun getFavorite() : Flow<List<CourseModel>>

    suspend fun addFavorite(course: CourseModel)

    suspend fun deleteFavorite(course: CourseModel)
}
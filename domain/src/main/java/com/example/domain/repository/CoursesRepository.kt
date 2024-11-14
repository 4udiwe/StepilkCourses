package com.example.domain.repository

import com.example.domain.model.CoursesInfo

interface CoursesRepository {
    suspend fun getCourses(page: Int) : CoursesInfo
}
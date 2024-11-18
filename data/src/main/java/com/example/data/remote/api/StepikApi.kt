package com.example.data.remote.api

import com.example.data.remote.model.CoursesInfoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface StepikApi {
    @GET("courses")
    suspend fun get(
        @Query("page") page: Int
    ) : CoursesInfoDto
}
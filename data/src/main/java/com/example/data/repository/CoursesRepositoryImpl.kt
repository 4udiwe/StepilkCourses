package com.example.data.repository

import com.example.data.remote.api.StepikApi
import com.example.data.database.CourseDao
import com.example.data.database.entity.CourseEntity
import com.example.domain.entity.CourseModel
import com.example.domain.model.CoursesInfo
import com.example.domain.repository.CoursesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CoursesRepositoryImpl(
    private val api: StepikApi,
    private val dao: CourseDao
) : CoursesRepository {
    override suspend fun getCourses(page: Int): CoursesInfo = api.get(page).mapDomain()


    override suspend fun addFavorite(course: CourseModel) {
        dao.add(
            course = CourseEntity(
                id = course.id,
                summary = course.summary,
                cover = course.cover,
                isFavorite = course.isFavorite,
                price = course.price,
                title = course.title,
                becamePublishedAt = course.becamePublishedAt,
                description = course.description,
            )
        )
    }

    override suspend fun deleteFavorite(course: CourseModel) {
        dao.delete(
            course = CourseEntity(
                id = course.id,
                summary = course.summary,
                cover = course.cover,
                isFavorite = course.isFavorite,
                price = course.price,
                title = course.title,
                becamePublishedAt = course.becamePublishedAt,
                description = course.description,
            )
        )
    }

    override fun getFavorite(): Flow<List<CourseModel>> = dao.getAll().map { list ->
        list.map {
            it.mapDomain()
        }
    }

}
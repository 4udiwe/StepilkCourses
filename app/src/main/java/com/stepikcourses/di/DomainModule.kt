package com.stepikcourses.di

import com.example.domain.usecase.AddFavoriteCourseUseCase
import com.example.domain.usecase.DeleteFavoriteUseCase
import com.example.domain.usecase.GetCourseUseCase
import com.example.domain.usecase.GetFavoriveCoursesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetCourseUseCase> {
        GetCourseUseCase(repository = get())
    }
    factory<GetFavoriveCoursesUseCase> {
        GetFavoriveCoursesUseCase(repository = get())
    }
    factory<AddFavoriteCourseUseCase> {
        AddFavoriteCourseUseCase(repository = get())
    }
    factory<DeleteFavoriteUseCase> {
        DeleteFavoriteUseCase(repository = get())
    }
}
package com.stepikcourses.di

import com.example.domain.usecase.GetCourseUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetCourseUseCase> {
        GetCourseUseCase(repository = get())
    }
}
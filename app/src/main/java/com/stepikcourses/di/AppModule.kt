package com.stepikcourses.di

import com.stepikcourses.viewmodel.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            getCourseUseCase = get(),
            addFavoriteCourseUseCase = get(),
            deleteFavoriteUseCase = get(),
            getFavoriveCoursesUseCase = get()
        )
    }
}
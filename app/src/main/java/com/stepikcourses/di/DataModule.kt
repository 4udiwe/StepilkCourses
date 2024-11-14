package com.stepikcourses.di

import com.example.data.api.StepikApi
import com.example.data.repository.CoursesRepositoryImpl
import com.example.domain.repository.CoursesRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    factory<CoursesRepository> {
        CoursesRepositoryImpl(api = get())
    }

    single<StepikApi> {
        val interseptor = HttpLoggingInterceptor()
        interseptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interseptor)
            .build()

        Retrofit.Builder()
            .baseUrl("https://stepik.org/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StepikApi::class.java)
    }
}
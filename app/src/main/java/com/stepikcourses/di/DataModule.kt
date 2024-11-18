package com.stepikcourses.di

import androidx.room.Room
import com.example.data.remote.api.StepikApi
import com.example.data.database.CourseDao
import com.example.data.database.CourseDataBase
import com.example.data.repository.CoursesRepositoryImpl
import com.example.domain.repository.CoursesRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    factory<CoursesRepository> {
        CoursesRepositoryImpl(api = get(), dao = get())
    }

    single<StepikApi> {
        val interсeptor = HttpLoggingInterceptor()
        interсeptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interсeptor)
            .build()

        Retrofit.Builder()
            .baseUrl("https://stepik.org/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StepikApi::class.java)
    }

    single<CourseDataBase> {
        Room.databaseBuilder(
            context = get(),
            CourseDataBase::class.java,
            "courses.db"
        ).build()
    }

    single <CourseDao>{
        val db = get<CourseDataBase>()
        db.courseDao()
    }
}
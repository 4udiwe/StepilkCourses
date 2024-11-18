package com.example.domain.model


data class CoursesInfo(

    var meta: Meta? = Meta(),
    var courses: ArrayList<Course> = arrayListOf(),
    var enrollments: ArrayList<String> = arrayListOf()

)
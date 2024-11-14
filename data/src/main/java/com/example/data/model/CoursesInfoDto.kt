package com.example.data.model

import com.example.domain.model.CoursesInfo
import com.google.gson.annotations.SerializedName


data class CoursesInfoDto(

    @SerializedName("meta") var meta: MetaDto? = MetaDto(),
    @SerializedName("courses") var courses: ArrayList<CoursesDto> = arrayListOf(),
    @SerializedName("enrollments") var enrollments: ArrayList<String> = arrayListOf()

) {
    fun mapDomain() = CoursesInfo(meta?.mapDomain(), courses.map { it.mapDomain() } as ArrayList, enrollments)
}
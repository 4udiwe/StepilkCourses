package com.example.data.model

import com.example.domain.model.ViewGradeBook
import com.google.gson.annotations.SerializedName


data class ViewGradeBookDto(

    @SerializedName("enabled") var enabled: Boolean? = null,
    @SerializedName("needs_permission") var needsPermission: String? = null

) {
    fun mapDomain() = ViewGradeBook(enabled, needsPermission)
}
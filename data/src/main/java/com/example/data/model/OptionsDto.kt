package com.example.data.model

import com.example.domain.model.Options
import com.google.gson.annotations.SerializedName


data class OptionsDto(
    @SerializedName("option") var option: String? = null
){
    fun mapDomain() = Options(option)
}
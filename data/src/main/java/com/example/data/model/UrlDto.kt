package com.example.data.model

import com.example.domain.model.Url
import com.google.gson.annotations.SerializedName

data class UrlDto(
    @SerializedName("quality") var quality: String?,
    @SerializedName("url") var url: String?
){
    fun mapDomain() = Url(quality, url)
}

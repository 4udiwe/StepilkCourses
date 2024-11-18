package com.example.data.remote.model

import com.example.domain.model.IntroVideo
import com.google.gson.annotations.SerializedName

data class IntroVideoDto(
    @SerializedName("thumbnail") var thumbnail: String?,
    @SerializedName("urls") var urls: ArrayList<com.example.data.remote.model.UrlDto> = arrayListOf(),
    @SerializedName("duration") var duration: Int?,
    @SerializedName("status") var status: String?,
    @SerializedName("upload_date") var uploadDate: String?,
    @SerializedName("filename") var filename: String?
) {
    fun mapDomain() = IntroVideo(
        thumbnail,
        urls.map { it.mapDomain() } as ArrayList,
        duration,
        status,
        uploadDate,
        filename)
}

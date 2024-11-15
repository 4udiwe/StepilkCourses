package com.example.data.model

import com.example.domain.model.IntroVideo
import com.google.gson.annotations.SerializedName

data class IntroVideoDto(
    @SerializedName("id") var id: Int?,
    @SerializedName("thumbnail") var thumbnail: String?,
    @SerializedName("urls") var urls: ArrayList<UrlDto> = arrayListOf(),
    @SerializedName("duration") var duration: Int?,
    @SerializedName("status") var status: String?,
    @SerializedName("upload_date") var uploadDate: String?,
    @SerializedName("filename") var filename: String?
) {
    fun mapDomain() = IntroVideo(
        id,
        thumbnail,
        urls.map { it.mapDomain() } as ArrayList,
        duration,
        status,
        uploadDate,
        filename)
}

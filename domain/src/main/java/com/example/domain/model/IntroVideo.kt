package com.example.domain.model

data class IntroVideo(
    var id: Int?,
    var thumbnail: String?,
    var urls: ArrayList<Url> = arrayListOf(),
    var duration: Int?,
    var status: String?,
    var uploadDate: String?,
    var filename: String?
)


package com.example.data.model

import com.example.domain.model.Meta
import com.google.gson.annotations.SerializedName


data class MetaDto(

    @SerializedName("page") var page: Int? = null,
    @SerializedName("has_next") var hasNext: Boolean? = null,
    @SerializedName("has_previous") var hasPrevious: Boolean? = null

) {
    fun mapDomain() = Meta(page, hasNext, hasPrevious)
}
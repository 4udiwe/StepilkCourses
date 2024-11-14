package com.example.data.model

import com.example.domain.model.EditTags
import com.google.gson.annotations.SerializedName


data class EditTagsDto(

    @SerializedName("enabled") var enabled: Boolean? = null

) {
    fun mapDomain() = EditTags(enabled)
}
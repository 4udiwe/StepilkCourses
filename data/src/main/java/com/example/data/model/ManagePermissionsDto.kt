package com.example.data.model

import com.example.domain.model.ManagePermissions
import com.google.gson.annotations.SerializedName


data class ManagePermissionsDto(

    @SerializedName("enabled") var enabled: Boolean? = null,
    @SerializedName("needs_permission") var needsPermission: String? = null

) {
    fun mapDomain() = ManagePermissions(enabled, needsPermission)
}
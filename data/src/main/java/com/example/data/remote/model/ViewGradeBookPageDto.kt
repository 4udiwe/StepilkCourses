package com.example.data.remote.model

import com.example.domain.model.ViewGradeBookPage
import com.google.gson.annotations.SerializedName

data class ViewGradeBookPageDto (

  @SerializedName("enabled"          ) var enabled         : Boolean? = null,
  @SerializedName("needs_permission" ) var needsPermission : String?  = null

) {
  fun mapDomain() = ViewGradeBookPage(enabled, needsPermission)
}
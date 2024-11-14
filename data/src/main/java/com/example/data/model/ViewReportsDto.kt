package com.example.data.model

import com.example.domain.model.ViewReports
import com.google.gson.annotations.SerializedName


data class ViewReportsDto (

  @SerializedName("enabled"          ) var enabled         : Boolean? = null,
  @SerializedName("needs_permission" ) var needsPermission : String?  = null

) {
  fun mapDomain() = ViewReports(enabled, needsPermission)
}
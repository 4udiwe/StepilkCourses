package com.example.data.model

import com.example.domain.model.EditReports
import com.google.gson.annotations.SerializedName


data class EditReportsDto (

  @SerializedName("enabled"          ) var enabled         : Boolean? = null,
  @SerializedName("needs_permission" ) var needsPermission : String?  = null

){
  fun mapDomain() = EditReports(enabled, needsPermission)
}
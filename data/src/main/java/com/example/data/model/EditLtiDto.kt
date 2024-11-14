package com.example.data.model

import com.example.domain.model.EditLti
import com.google.gson.annotations.SerializedName


data class EditLtiDto (

  @SerializedName("enabled"          ) var enabled         : Boolean? = null,
  @SerializedName("needs_permission" ) var needsPermission : String?  = null

){
  fun mapDomain() = EditLti(enabled, needsPermission)
}
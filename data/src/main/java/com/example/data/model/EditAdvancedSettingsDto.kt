package com.example.data.model

import com.example.domain.model.EditAdvancedSettings
import com.google.gson.annotations.SerializedName


data class EditAdvancedSettingsDto (

  @SerializedName("enabled"          ) var enabled         : Boolean? = null,
  @SerializedName("needs_permission" ) var needsPermission : String?  = null

){
  fun mapDomain() = EditAdvancedSettings(enabled, needsPermission)
}
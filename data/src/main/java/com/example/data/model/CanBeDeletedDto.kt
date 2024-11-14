package com.example.data.model

import com.example.domain.model.CanBeDeleted
import com.google.gson.annotations.SerializedName


data class CanBeDeletedDto (

  @SerializedName("enabled" ) var enabled : Boolean? = null

){
  fun mapDomain() = CanBeDeleted(enabled)
}
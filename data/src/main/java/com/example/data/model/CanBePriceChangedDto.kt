package com.example.data.model

import com.example.domain.model.CanBePriceChanged
import com.google.gson.annotations.SerializedName


data class CanBePriceChangedDto (

  @SerializedName("enabled" ) var enabled : Boolean? = null

){
  fun mapDomain() = CanBePriceChanged(enabled)
}
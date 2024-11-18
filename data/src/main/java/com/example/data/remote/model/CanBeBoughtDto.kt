package com.example.data.remote.model


import com.example.domain.model.CanBeBought
import com.google.gson.annotations.SerializedName

data class CanBeBoughtDto (

  @SerializedName("enabled" ) var enabled : Boolean? = null

){
  fun mapDomain() = CanBeBought(enabled)
}
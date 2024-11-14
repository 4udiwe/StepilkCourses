package com.example.data.model

import com.example.domain.model.ViewRevenue
import com.google.gson.annotations.SerializedName


data class ViewRevenueDto (

  @SerializedName("enabled" ) var enabled : Boolean? = null

) {
  fun mapDomain() = ViewRevenue(enabled)
}
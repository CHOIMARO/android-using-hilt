package com.tngen.domain.model

import com.google.gson.annotations.SerializedName

data class HouseModel(
    @SerializedName("items")
    val items: List<HouseModelItemsModel>

)

data class HouseModelItemsModel(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("price")
    val price: String,

    @SerializedName("imgUrl")
    val imgUrl: String,

    @SerializedName("lat")
    val lat: Double,

    @SerializedName("lng")
    val lng: Double
)

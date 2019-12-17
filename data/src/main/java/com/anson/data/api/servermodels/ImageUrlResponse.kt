package com.anson.data.api.servermodels

import com.google.gson.annotations.SerializedName

data class ImageUrlResponse(
    @SerializedName("url") val url: String
)
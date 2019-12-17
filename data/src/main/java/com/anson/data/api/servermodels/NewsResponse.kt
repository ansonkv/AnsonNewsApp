package com.anson.data.api.servermodels

import com.google.gson.annotations.SerializedName

class NewsResponse(
    @SerializedName("title") val title: String,
    @SerializedName("published_date") val date: String,
    @SerializedName("abstract") val abstract: String,
    @SerializedName("media") val imageUrls: List<MediaResponse>,
    @SerializedName("byline")val byline:String
)
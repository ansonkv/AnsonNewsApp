package com.anson.data.api.servermodels

import com.google.gson.annotations.SerializedName

data class NewsResults(
    @SerializedName("results") val results: List<NewsResponse>
)
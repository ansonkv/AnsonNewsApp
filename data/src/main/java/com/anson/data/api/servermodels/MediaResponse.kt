package com.anson.data.api.servermodels

import com.google.gson.annotations.SerializedName

class MediaResponse(
    @SerializedName("media-metadata") val metadata: List<ImageUrlResponse>
)
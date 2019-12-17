package com.anson.data.api.common

import com.anson.data.api.servermodels.ImageUrlResponse
import com.anson.data.api.servermodels.MediaResponse
import com.anson.data.api.servermodels.NewsResponse
import com.anson.data.api.servermodels.NewsResults
import io.reactivex.Observable

object TestData {

    fun getNewsResults(): Observable<NewsResults> {
        return Observable.just(NewsResults(getNewsResponse()))
    }

    private fun getMediaResponse(): ArrayList<MediaResponse> {
        val mediaResponses: ArrayList<MediaResponse> = ArrayList()
        mediaResponses.add(MediaResponse(getMetadata()))
        return mediaResponses
    }

    private fun getMetadata(): ArrayList<ImageUrlResponse> {
        val imgUrls: ArrayList<ImageUrlResponse> = ArrayList()
        imgUrls.add(ImageUrlResponse("url1"))
        return imgUrls
    }

   private fun getNewsResponse(): List<NewsResponse> {
        val list: ArrayList<NewsResponse> = ArrayList()
        list.add(NewsResponse("title1", "date1", "abstract1", getMediaResponse(),"name1"))
        return list
    }
}
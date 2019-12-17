package com.anson.data.api.common

import com.anson.data.api.servermodels.NewsResponse
import com.anson.data.api.servermodels.NewsResults
import io.reactivex.Observable
import retrofit2.http.GET

interface NewsApi {
    @GET("7.json?api-key=YWgTbXkw4UIcpPOGpnruai7WOEOU0gIV")
    fun getNews(): Observable<NewsResults>
}
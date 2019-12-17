package com.anson.domain.repository

import com.anson.domain.entity.NewsItem
import io.reactivex.Observable

interface NewsDataStore {
    fun getNews(): Observable<List<NewsItem>>
}
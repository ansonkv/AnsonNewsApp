package com.anson.data.api

import app.vyap.domain.common.Mapper
import com.anson.data.api.common.NewsApi
import com.anson.data.api.common.TestData
import com.anson.data.api.converters.NewsResponseConverter
import com.anson.domain.entity.NewsItem
import com.anson.domain.repository.NewsDataStore
import io.reactivex.Observable

class NewsDataStoreImpl(val newsApi: NewsApi, val mapper: NewsResponseConverter) : NewsDataStore {
    override fun getNews(): Observable<List<NewsItem>> {
        return newsApi.getNews().flatMap {
            return@flatMap Observable.just(mapper.mapFrom(it))
        }
    }
}
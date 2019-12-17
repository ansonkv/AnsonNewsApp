package com.anson.domain.usecases

import app.vyap.domain.common.Transformer
import com.anson.domain.entity.NewsItem
import com.anson.domain.repository.NewsDataStore
import io.reactivex.Observable

open class GetNews(private val newsDataStore: NewsDataStore, transformer: Transformer<List<NewsItem>>) :
    Usecase<List<NewsItem>>(transformer) {
    override fun execute(data: Map<String, Any>?): Observable<List<NewsItem>> {
        return newsDataStore.getNews()
    }
}
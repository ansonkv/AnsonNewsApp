package com.anson.data.api.converters

import app.vyap.domain.common.Mapper
import com.anson.data.api.servermodels.NewsResponse
import com.anson.data.api.servermodels.NewsResults
import com.anson.domain.entity.NewsItem

open class NewsResponseConverter : Mapper<NewsResults, List<NewsItem>> {
    override fun mapFrom(from: NewsResults): List<NewsItem> {
        val newsItems: ArrayList<NewsItem> = ArrayList()
        for (news in from.results) {
            newsItems.add(
                NewsItem(
                    news.title,
                    news.imageUrls[0].metadata[0].url,
                    news.date,
                    news.abstract,
                    news.byline
                )
            )
        }
        return newsItems
    }
}
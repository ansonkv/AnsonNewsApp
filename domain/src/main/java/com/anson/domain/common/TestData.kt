package app.vyap.domain.common

import com.anson.domain.entity.NewsItem
import io.reactivex.Observable

object TestData {
    fun getNewsData(): Observable<List<NewsItem>> {
        val news: ArrayList<NewsItem> = ArrayList()
        news.add(NewsItem("Title!", "URL1", "date1", "details1","name1"))
        return Observable.just(
            news
        )
    }
}
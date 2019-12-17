package com.anson.newsapp.ui.newslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.vyap.domain.entity.AppError
import com.anson.domain.entity.NewsItem
import com.anson.domain.usecases.GetNews
import com.anson.newsapp.ui.common.BaseViewModel

class NewsListViewModel(val getNews: GetNews) : BaseViewModel() {
    private val _news: MutableLiveData<List<NewsItem>> = MutableLiveData()
    private val _error: MutableLiveData<AppError> = MutableLiveData()

    val news: LiveData<List<NewsItem>> = _news

    fun loadNews() {
        addDisposible(getNews.observable().subscribe(
            {
                _news.postValue(it)

            }, {
                _error.postValue(AppError(it.message ?: "Unexpected error", ""));
            }
        ))
    }

}

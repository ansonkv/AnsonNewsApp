package com.anson.newsapp.ui.newslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anson.domain.usecases.GetNews

class NewsListVMFactory(private val getNews: GetNews) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsListViewModel(getNews) as T

    }
}
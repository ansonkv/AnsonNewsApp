package com.anson.newsapp.di.newslist

import com.anson.newsapp.ui.newsdetails.NewsDetailsFragment
import com.anson.newsapp.ui.newslist.NewsListFragment
import dagger.Subcomponent


@NewsListScope
@Subcomponent(modules = arrayOf(NewsListModule::class))
interface NewsListSubComponent {
    fun inject(newsListFragment: NewsListFragment)

    fun inject(newsDetailsFragment: NewsDetailsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): NewsListSubComponent
    }
}
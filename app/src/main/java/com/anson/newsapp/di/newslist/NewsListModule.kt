package com.anson.newsapp.di.newslist

import com.anson.data.api.NewsDataStoreImpl
import com.anson.data.api.common.NewsApi
import com.anson.data.api.converters.NewsResponseConverter
import com.anson.domain.repository.NewsDataStore
import com.anson.domain.usecases.GetNews
import com.anson.newsapp.ui.newslist.NewsListAdapter
import com.anson.newsapp.ui.newslist.NewsListVMFactory
import com.jithin.sampleapp.common.AsyncTransformer
import dagger.Module
import dagger.Provides

@Module
object NewsListModule {
    @Provides
    @NewsListScope
    fun providesGetNewsUsecase(dataStore: NewsDataStore): GetNews {
        return GetNews(dataStore, AsyncTransformer())
    }

    @Provides
    @NewsListScope
    fun providesVMFactory(getNews: GetNews): NewsListVMFactory {
        return NewsListVMFactory(getNews)
    }

    @Provides
    @NewsListScope
    fun providesAdapter(): NewsListAdapter {
        return NewsListAdapter()
    }

    @Provides
    @NewsListScope
    fun providesNewsDataStore(newsApi: NewsApi, mapper: NewsResponseConverter): NewsDataStore {
        return NewsDataStoreImpl(newsApi, mapper)
    }

    @Provides
    @NewsListScope
    fun providesNewsMapper(): NewsResponseConverter {
        return NewsResponseConverter()
    }
}
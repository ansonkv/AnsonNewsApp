package com.anson.newsapp.di.modules

import com.anson.newsapp.di.newslist.NewsListSubComponent
import dagger.Module

@Module(subcomponents = arrayOf(NewsListSubComponent::class))
object SubComponentModule {
}
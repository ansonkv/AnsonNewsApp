package com.anson.newsapp.di

import com.anson.newsapp.di.modules.NetworkModule
import com.anson.newsapp.di.modules.SubComponentModule
import com.anson.newsapp.di.newslist.NewsListSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(SubComponentModule::class, NetworkModule::class))
interface MainComponent {
    fun newsSubComponent(): NewsListSubComponent.Factory
}
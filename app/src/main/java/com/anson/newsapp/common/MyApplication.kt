package com.anson.newsapp.common

import android.app.Application
import com.anson.newsapp.di.DaggerMainComponent
import com.anson.newsapp.di.MainComponent
import com.anson.newsapp.di.newslist.NewsListSubComponent

class MyApplication : Application() {
    lateinit var mainComponent: MainComponent

    override fun onCreate() {
        super.onCreate()
        mainComponent = DaggerMainComponent.create()
    }

    fun newsComponent(): NewsListSubComponent {
        return mainComponent.newsSubComponent().create()
    }
}
package com.anson.newsapp.ui.common

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun addDisposible(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun clearDisposible() {
        compositeDisposable.clear()
    }

    override fun onCleared() {
        super.onCleared()
        clearDisposible()
    }

}
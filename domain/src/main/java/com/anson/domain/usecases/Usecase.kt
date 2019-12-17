package com.anson.domain.usecases

import app.vyap.domain.common.Transformer
import io.reactivex.Observable

abstract class Usecase<T>(var transformer: Transformer<T>) {
    abstract fun execute(data: Map<String, Any>? = null): Observable<T>

    fun observable(data: Map<String, Any>? = null): Observable<T> {
        return execute(data).compose(transformer)
    }
}
package com.anson.data.api

import com.anson.data.api.common.NewsApi
import com.anson.data.api.common.TestData
import com.anson.data.api.converters.NewsResponseConverter
import com.anson.domain.entity.NewsItem
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NewsDataStoreImplTest {

    private lateinit var newsDataStoreImpl: NewsDataStoreImpl


    @Mock
    lateinit var newsApi: NewsApi

    lateinit var responseConverter: NewsResponseConverter


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        responseConverter = NewsResponseConverter()
        newsDataStoreImpl = NewsDataStoreImpl(newsApi, responseConverter)

    }

    @Test
    fun getNews() {
        Mockito.`when`(newsApi.getNews()).thenReturn(TestData.getNewsResults())

        val testObserver = newsDataStoreImpl.getNews().test()



        testObserver.assertValue {
            val newsItem = it.get(0)
            val result: Boolean = newsItem.date == "date1" && newsItem.details == "abstract1" &&
                    newsItem.imgUrl == "url1" && newsItem.title == "title1" && newsItem.byLine == "name1"

            return@assertValue result
        }
    }

}
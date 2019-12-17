package com.anson.newsapp.ui.newslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.vyap.domain.common.TestData
import com.anson.domain.entity.NewsItem
import com.anson.domain.usecases.GetNews
import com.anson.newsapp.common.TestTransformer
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Callable

@RunWith(MockitoJUnitRunner::class)
class NewsListViewModelTest {

    @Mock
    lateinit var getNews: GetNews

    lateinit var newsListViewModel: NewsListViewModel

    @Rule
    @JvmField
    var testSchedulerRule = InstantTaskExecutorRule()

    @Mock
    lateinit var observer: androidx.lifecycle.Observer<List<NewsItem>>

    @Before
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler: Callable<Scheduler> -> Schedulers.trampoline() }
        MockitoAnnotations.initMocks(this)
        newsListViewModel = NewsListViewModel(getNews)
    }


    @Test
    fun loadNews() {
        getNews.transformer = TestTransformer()
        Mockito.`when`(getNews.execute()).thenReturn(TestData.getNewsData())
        newsListViewModel.news.observeForever(observer)

        newsListViewModel.loadNews()

        assertEquals(newsListViewModel.news.value!![0].date, "date1")

    }


}
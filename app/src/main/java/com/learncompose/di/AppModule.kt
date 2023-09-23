package com.learncompose.di

import android.app.Application
import com.learncompose.data.manager.LocalUserManagerImpl
import com.learncompose.data.remote.NewsApi
import com.learncompose.data.repository.NewsRepositoryImpl
import com.learncompose.domain.manager.LocalUserManager
import com.learncompose.domain.repository.NewsRepository
import com.learncompose.domain.usecases.app_entry.AppOpenUseCases
import com.learncompose.domain.usecases.app_entry.ReadAppOpen
import com.learncompose.domain.usecases.app_entry.SaveAppOpen
import com.learncompose.domain.usecases.news.GetNews
import com.learncompose.domain.usecases.news.NewsUseCases
import com.learncompose.utils.Constants.NEWS_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppOpenUseCases(
        saveAppOpened = SaveAppOpen(localUserManager),
        readAppOpened = ReadAppOpen(localUserManager),
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder().baseUrl(NEWS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi = newsApi)
    }


    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(
                newsRepository = newsRepository
            )
        )
    }
}

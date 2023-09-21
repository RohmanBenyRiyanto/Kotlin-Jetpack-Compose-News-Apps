package com.learncompose.di

import android.app.Application
import com.learncompose.data.manager.LocalUserManagerImpl
import com.learncompose.domain.manager.LocalUserManager
import com.learncompose.domain.usecases.AppOpenUseCases
import com.learncompose.domain.usecases.ReadAppOpen
import com.learncompose.domain.usecases.SaveAppOpen
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ) : LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppOpenUseCases(
        saveAppOpened = SaveAppOpen(localUserManager),
        readAppOpened = ReadAppOpen(localUserManager),
    )
}

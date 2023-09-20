package com.learncompose.domain.manager

import kotlinx.coroutines.flow.Flow


interface LocalUserManager {
    suspend fun saveAppOpened()
    fun readAppOpened(): Flow<Boolean>
}

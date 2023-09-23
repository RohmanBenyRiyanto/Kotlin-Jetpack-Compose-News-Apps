package com.learncompose.domain.usecases.app_entry

import com.learncompose.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppOpen(
    private val localUserManager: LocalUserManager
) {
     operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppOpened()
    }
}
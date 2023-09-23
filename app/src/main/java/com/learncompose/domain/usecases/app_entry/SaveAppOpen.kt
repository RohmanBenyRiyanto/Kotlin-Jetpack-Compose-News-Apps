package com.learncompose.domain.usecases.app_entry

import com.learncompose.domain.manager.LocalUserManager

class SaveAppOpen(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppOpened()
    }
}
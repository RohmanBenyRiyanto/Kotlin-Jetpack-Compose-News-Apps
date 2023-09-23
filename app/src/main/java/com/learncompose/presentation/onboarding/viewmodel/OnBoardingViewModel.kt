package com.learncompose.presentation.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learncompose.domain.usecases.app_entry.AppOpenUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appOpenUseCases: AppOpenUseCases
) : ViewModel() {

    fun onEvent(event: OnBoardingEvent) {
        when (event) {
            is OnBoardingEvent.SaveAppOpened -> {
                saveAppOpened()
            }
        }
    }

    private fun saveAppOpened() {
        viewModelScope.launch {
            appOpenUseCases.saveAppOpened()
        }
    }
}
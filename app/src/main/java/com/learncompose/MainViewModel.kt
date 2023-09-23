package com.learncompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learncompose.domain.usecases.app_entry.AppOpenUseCases
import com.learncompose.presentation.navgraph.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    appOpenUseCases: AppOpenUseCases
) : ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set
    var startDestination by mutableStateOf(Routes.AppStartNavigation.route)
        private set

    init {
        appOpenUseCases.readAppOpened().onEach { appOpened ->
            startDestination = if (appOpened) {
                Routes.NewsNavigation.route
            } else {
                Routes.AppStartNavigation.route
            }
            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }

}

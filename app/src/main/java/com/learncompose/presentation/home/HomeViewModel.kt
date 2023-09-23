package com.learncompose.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.learncompose.domain.usecases.news.NewsUseCases
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases,
) : ViewModel() {

    val news = newsUseCases.getNews(
        sources = listOf("bbc-news", "cnn", "fox-news", "the-verge")
    ).cachedIn(viewModelScope)
}
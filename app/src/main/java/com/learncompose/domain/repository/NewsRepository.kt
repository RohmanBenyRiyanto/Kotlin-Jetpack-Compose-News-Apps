package com.learncompose.domain.repository

import androidx.paging.PagingData
import com.learncompose.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources: List<String>): Flow<PagingData<Article>>
}
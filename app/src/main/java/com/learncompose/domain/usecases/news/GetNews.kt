package com.learncompose.domain.usecases.news

import androidx.paging.PagingData
import com.learncompose.domain.model.Article
import com.learncompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources)
    }
}
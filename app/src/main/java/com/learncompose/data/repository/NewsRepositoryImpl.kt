package com.learncompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.learncompose.data.remote.NewsApi
import com.learncompose.data.remote.NewsPagingSource
import com.learncompose.domain.model.Article
import com.learncompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(config = PagingConfig(pageSize = 20), pagingSourceFactory = {
            NewsPagingSource(
                newsApi = newsApi, sources = sources.joinToString(separator = ",")
            )
        }).flow
    }
}
package com.learncompose.data.remote.dto

import com.learncompose.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
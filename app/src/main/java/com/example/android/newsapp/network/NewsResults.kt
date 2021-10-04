package com.example.android.newsapp.network

import com.squareup.moshi.Json

data class NewsResults(
    @Json(name = "status")
    val status: String,
    @Json(name = "totalResults")
    val totalResults: Int,
    @Json(name = "results")
    val newsResults: List<NewsData>
)
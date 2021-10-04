package com.example.android.newsapp.network

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "newsData")
data class NewsData(
    @PrimaryKey
    @ColumnInfo(name = "title")
    @Json(name = "title") val newsTitle: String,
    @ColumnInfo(name = "image_url")
    @Json(name = "image_url") val newsImage: String?,
    @ColumnInfo(name = "description")
    @Json(name = "description") val newsDescription: String,
    @ColumnInfo(name = "link")
    @Json(name = "link") val newsLink: String
)
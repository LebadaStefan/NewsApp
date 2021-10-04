package com.example.android.newsapp

import android.app.Application
import com.example.android.newsapp.data.NewsDataRoomDatabase

class NewsDataApplication: Application() {
    val database: NewsDataRoomDatabase by lazy { NewsDataRoomDatabase.getDatabase(this) }
}
package com.example.android.newsapp

import com.example.android.newsapp.data.NewsDataDao
import com.example.android.newsapp.network.NewsApi

class NewsRepository(val dao: NewsDataDao) {
    suspend fun updateNewsList() {
        val apiResult = NewsApi.retrofitService.getNews()
        dao.insert(apiResult.newsResults)
        for(rata in apiResult.newsResults){
            if (rata.newsImage == null)
                dao.delete(rata)
        }

    }

    fun getNewsList() = dao.getAllNewsData()
}
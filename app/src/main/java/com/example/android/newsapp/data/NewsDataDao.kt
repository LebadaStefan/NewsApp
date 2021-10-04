package com.example.android.newsapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import com.example.android.newsapp.network.NewsData

@Dao
interface NewsDataDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(newsData: NewsData)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(newsData: List<NewsData>)

    @Delete
    suspend fun delete(newsData: NewsData)

    @Query("SELECT * FROM newsData WHERE title = :title")
    fun getNewsData(title: String): LiveData<NewsData>

    @Query("SELECT * FROM newsData ORDER BY title ASC")
    fun getAllNewsData(): LiveData<List<NewsData>>
}
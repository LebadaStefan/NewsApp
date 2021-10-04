package com.example.android.newsapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.newsapp.network.NewsData

@Database(entities = [NewsData::class], version = 1, exportSchema = false)
abstract class NewsDataRoomDatabase : RoomDatabase() {

    abstract fun newsDataDao(): NewsDataDao

    companion object {
        @Volatile
        private var INSTANCE: NewsDataRoomDatabase? = null

        fun getDatabase(context: Context): NewsDataRoomDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NewsDataRoomDatabase::class.java,
                    "newsData_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }

        }
    }
}
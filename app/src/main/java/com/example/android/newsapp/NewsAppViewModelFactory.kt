package com.example.android.newsapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.newsapp.overview.OverviewViewModel


class NewsAppViewModelFactory(val newsRepository: NewsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OverviewViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OverviewViewModel(repository = newsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
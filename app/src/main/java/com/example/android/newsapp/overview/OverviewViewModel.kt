/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.newsapp.overview

import androidx.lifecycle.*
import com.example.android.newsapp.NewsRepository
import com.example.android.newsapp.data.NewsDataDao
import com.example.android.newsapp.network.NewsApi
import com.example.android.newsapp.network.NewsData
import com.example.android.newsapp.network.NewsResults
import kotlinx.coroutines.launch

enum class NewsApiStatus { LOADING, ERROR, DONE }

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel(private  val repository: NewsRepository) : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<NewsApiStatus>()
    // The external immutable LiveData for the request status
    val status: LiveData<NewsApiStatus> = _status

    private val _newsData = MutableLiveData<List<NewsData>>()
    val newsData: LiveData<List<NewsData>> = repository.getNewsList()

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getNewsTitle()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getNewsTitle() {
        viewModelScope.launch {
            _status.value = NewsApiStatus.LOADING
            try {
                repository.updateNewsList()
                _status.value = NewsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = NewsApiStatus.ERROR
            }
        }

    }
}

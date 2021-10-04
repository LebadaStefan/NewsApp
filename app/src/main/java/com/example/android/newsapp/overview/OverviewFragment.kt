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

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.newsapp.NewsAppViewModelFactory
import com.example.android.newsapp.NewsRepository
import com.example.android.newsapp.data.NewsDataRoomDatabase
import com.example.android.newsapp.databinding.FragmentOverviewBinding

/**
 * This fragment shows the the status of the Mars photos web services transaction.
 */
class OverviewFragment : Fragment() {

    private lateinit var viewModelFactory: NewsAppViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(
            viewModelStore,
            viewModelFactory
        ).get(OverviewViewModel::class.java)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        viewModelFactory = NewsAppViewModelFactory(
            NewsRepository(
                NewsDataRoomDatabase.getDatabase(requireActivity()).newsDataDao()
            )
        )
    }

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOverviewBinding.inflate(inflater)
        //val binding = GridViewItemBinding.inflate(inflater)
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        binding.newsGrid.adapter = NewsGridAdapter()

        return binding.root
    }
}

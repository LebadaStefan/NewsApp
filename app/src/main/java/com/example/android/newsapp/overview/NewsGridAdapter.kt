package com.example.android.newsapp.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.newsapp.databinding.GridViewItemBinding
import com.example.android.newsapp.network.NewsData

class NewsGridAdapter : ListAdapter<NewsData, NewsGridAdapter.NewsDataViewHolder>(DiffCallback) {

    class NewsDataViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(NewsData: NewsData) {
            binding.newsData = NewsData
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<NewsData>() {
        override fun areItemsTheSame(oldItem: NewsData, newItem: NewsData): Boolean {
            return oldItem.newsTitle == newItem.newsTitle
        }

        override fun areContentsTheSame(oldItem: NewsData, newItem: NewsData): Boolean {
            return oldItem.newsImage == newItem.newsImage
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsGridAdapter.NewsDataViewHolder {
        return NewsDataViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NewsDataViewHolder, position: Int) {
        val newsData = getItem(position)
        holder.bind(newsData)
    }


}
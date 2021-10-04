package com.example.android.newsapp

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.newsapp.network.NewsData
import com.example.android.newsapp.overview.NewsApiStatus
import com.example.android.newsapp.overview.NewsGridAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<NewsData>?) {
    val adapter = recyclerView.adapter as NewsGridAdapter
    adapter.submitList(data)
}


@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    val imageUrl2: String? = "https://image.flaticon.com/icons/png/512/983/983213.png"
    val useUrl: String? = imageUrl ?: imageUrl2
    useUrl?.let {
        val imageUri = useUrl.toUri().buildUpon().scheme("https").build()
        imageView.load(imageUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

//@BindingAdapter("newsApiStatus")
//fun bindStatus(statusImageView: ImageView, status: NewsApiStatus?) {
//    when (status) {
//        NewsApiStatus.LOADING -> {
//            statusImageView.visibility = View.VISIBLE
//            statusImageView.setImageResource(R.drawable.loading_animation)
//        }
//        NewsApiStatus.ERROR -> {
//            statusImageView.visibility = View.VISIBLE
//            statusImageView.setImageResource(R.drawable.ic_connection_error)
//        }
//        NewsApiStatus.DONE -> {
//            statusImageView.visibility = View.GONE
//        }
//    }
//}
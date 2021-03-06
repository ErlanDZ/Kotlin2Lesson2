package com.example.kotlin2lesson2.presentation.ui.adapter.topnews.topheadlinesintheus

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlin2lesson2.R
import com.example.kotlin2lesson2.databinding.TopNewsItemBinding
import com.example.kotlin2lesson2.presentation.base.BaseComparator
import com.example.kotlin2lesson2.presentation.model.NewsUI

class TopNewsAdapter(
    private val itemClick: (item: NewsUI) -> Unit,
) : ListAdapter<NewsUI, TopNewsAdapter.TopNewsViewHolder>(
    BaseComparator()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopNewsViewHolder {
        return TopNewsViewHolder(
            TopNewsItemBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
        )
    }

    override fun onBindViewHolder(holder: TopNewsViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    inner class TopNewsViewHolder(
        private val binding: TopNewsItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener{
                getItem(absoluteAdapterPosition)?.let {
                    itemClick(it)
                }
            }
        }

        fun onBind(news: NewsUI) = with(binding) {
            title.text = news.title
            publishedAt.text = news.publishedAt
            if (news.author == null) {
                val users = "No name"
                user.text = users
            } else {
                user.text = news.author
            }

            if (news.urlToImage == "") {
                topNewsIm.setImageResource(R.drawable.news_image)
            } else {
                topNewsIm.load(news.urlToImage)
            }
        }
    }
}

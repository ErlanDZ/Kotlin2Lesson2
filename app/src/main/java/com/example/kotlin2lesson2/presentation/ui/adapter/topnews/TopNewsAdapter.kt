package com.example.kotlin2lesson2.presentation.ui.adapter.topnews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlin2lesson2.R
import com.example.kotlin2lesson2.databinding.TopNewsItemBinding
import com.example.kotlin2lesson2.presentation.base.BaseComparator
import com.example.kotlin2lesson2.presentation.model.TopNewsUI

class TopNewsAdapter : ListAdapter<TopNewsUI, TopNewsAdapter.TopNewsViewHolder>(
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

    class TopNewsViewHolder(
        private val binding: TopNewsItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(news: TopNewsUI) = with(binding) {
            title.text = news.title
            publishedAt.text = news.publishedAt
            if (news.author == ""){
                val users = "User"
                user.text = users
            }else{
                user.text = news.author
            }
            imageTopNews.load(news.urlToImage)
        }
    }
}

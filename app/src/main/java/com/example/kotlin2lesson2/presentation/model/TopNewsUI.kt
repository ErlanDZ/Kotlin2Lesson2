package com.example.kotlin2lesson2.presentation.model

import com.example.kotlin2lesson2.domain.model.TopNews
import com.example.kotlin2lesson2.presentation.base.IBaseDiffModel

class TopNewsUI(
    val source: SourceUI,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
) : IBaseDiffModel {
    override val id: String
        get() = TODO("Not yet implemented")
}

fun TopNews.toUI() = TopNewsUI(
    source.toUI(),
    author,
    title,
    description,
    url,
    urlToImage,
    publishedAt
)
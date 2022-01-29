package com.example.kotlin2lesson2.presentation.model

import com.example.domain.model.News
import com.example.kotlin2lesson2.presentation.base.IBaseDiffModel

class NewsUI(
    override val source: SourceUI,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
) : IBaseDiffModel

fun News.toUI() = NewsUI(
    source.toUI(),
    author,
    title,
    description,
    url,
    urlToImage,
    publishedAt,
)
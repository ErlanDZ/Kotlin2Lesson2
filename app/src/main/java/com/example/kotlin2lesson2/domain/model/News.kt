package com.example.kotlin2lesson2.domain.model

import com.example.kotlin2lesson2.presentation.model.NewsUI

class News(
    val source: Source,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
)

fun News.toSourceUI() = NewsUI(
    source.toSourceUI(),
    author,
    title,
    description,
    url,
    urlToImage,
    publishedAt,
)


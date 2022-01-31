package com.example.kotlin2lesson2.presentation.model

import android.os.Parcelable
import com.example.domain.model.News
import com.example.kotlin2lesson2.presentation.base.IBaseDiffModel
import kotlinx.parcelize.Parcelize

@Parcelize
class NewsUI(
    override val source: SourceUI,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
) : IBaseDiffModel, Parcelable

fun News.toUI() = NewsUI(
    source.toUI(),
    author,
    title,
    description,
    url,
    urlToImage,
    publishedAt,
)
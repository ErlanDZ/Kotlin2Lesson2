package com.example.kotlin2lesson2.data.remote.dtos.topnews

import com.example.kotlin2lesson2.domain.model.News
import com.google.gson.annotations.SerializedName

data class NewsDto(
    @SerializedName("source")
    val source: SourceDto,

    @SerializedName("author")
    val author: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("urlToImage")
    val urlToImage: String?,

    @SerializedName("publishedAt")
    val publishedAt: String?,
)

fun NewsDto.toDomain() = News(
    source.toDomain(),
    author,
    title,
    description,
    url,
    urlToImage,
    publishedAt,
)
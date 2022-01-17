package com.example.kotlin2lesson2.data.remote.dtos.topnews

import com.google.gson.annotations.SerializedName

data class NewsResponseDto<T>(
    @SerializedName("status")
    val status: String,

    @SerializedName("totalResult")
    val totalResult: Int,

    @SerializedName("articles")
    val article: List<T>,
)
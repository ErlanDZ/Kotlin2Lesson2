package com.example.data.remote.dtos.news

import com.google.gson.annotations.SerializedName

data class NewsResponseDto<T>(
    @SerializedName("status")
    val status: String,

    @SerializedName("totalResult")
    val totalResult: Int,

    @SerializedName("articles")
    val article: List<T>,

    @SerializedName("sources")
    val sources: List<T>,
)
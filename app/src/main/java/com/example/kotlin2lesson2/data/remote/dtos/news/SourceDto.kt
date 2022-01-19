package com.example.kotlin2lesson2.data.remote.dtos.news

import com.example.kotlin2lesson2.domain.model.Source
import com.google.gson.annotations.SerializedName

data class SourceDto(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("category")
    val category: String?,

    @SerializedName("language")
    val language: String?,

    @SerializedName("country")
    val country: String?,
)

fun SourceDto.toDomain() = Source(
    id,
    name,
    description,
    url,
    category,
    language,
    country,
)
package com.example.kotlin2lesson2.data.remote.dtos.topnews

import com.example.kotlin2lesson2.domain.model.Source
import com.google.gson.annotations.SerializedName

data class SourceDto(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String,
)

fun SourceDto.toDomain() = Source(
    id,
    name,
)
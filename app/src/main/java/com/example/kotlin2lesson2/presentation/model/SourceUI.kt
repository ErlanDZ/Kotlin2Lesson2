package com.example.kotlin2lesson2.presentation.model

import com.example.domain.model.Source

data class SourceUI(
    val id: String?,
    val name: String,
    val description: String?,
    val url: String?,
    val category: String?,
    val language: String?,
    val country: String?,
)

fun Source.toUI() = SourceUI(
    id,
    name,
    description,
    url,
    category,
    language,
    country,
)
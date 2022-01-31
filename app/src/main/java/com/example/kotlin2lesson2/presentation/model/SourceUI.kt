package com.example.kotlin2lesson2.presentation.model

import android.os.Parcelable
import com.example.domain.model.Source
import kotlinx.parcelize.Parcelize

@Parcelize
data class SourceUI(
    val id: String?,
    val name: String,
    val description: String?,
    val url: String?,
    val category: String?,
    val language: String?,
    val country: String?,
) : Parcelable

fun Source.toUI() = SourceUI(
    id,
    name,
    description,
    url,
    category,
    language,
    country,
)
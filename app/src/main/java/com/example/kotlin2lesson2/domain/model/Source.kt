package com.example.kotlin2lesson2.domain.model

import com.example.kotlin2lesson2.presentation.model.SourceUI

class Source(
    val id: String?,
    val name: String,
)

fun Source.toSourceUI() = SourceUI(
    id,
    name,
)
package com.example.kotlin2lesson2.presentation.model

import com.example.kotlin2lesson2.domain.model.Source

class SourceUI(
    val id: String?,
    val name: String,
)


fun Source.toUI() = SourceUI(
    id,
    name,
)
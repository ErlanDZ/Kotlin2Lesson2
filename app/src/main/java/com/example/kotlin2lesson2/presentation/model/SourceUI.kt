package com.example.kotlin2lesson2.presentation.model

import com.example.kotlin2lesson2.domain.model.Source
import com.example.kotlin2lesson2.presentation.base.IBaseDiffModel

class SourceUI(
    override val id: String?,
    val name: String,
): IBaseDiffModel

fun Source.toUI() = SourceUI(
    id,
    name
)
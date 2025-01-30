package com.example.spendwise.model

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter

data class Icon2TextModel(
    var modifier: Modifier = Modifier,
    val icon: Painter,
    val title: String,
    val subtitle: String?
)
package com.example.spendwise.model

import androidx.compose.ui.graphics.vector.ImageVector

data class AmountCardModel(
    val imageVector: ImageVector,
    val accountType: String,
    val amount: String,
    val profit: String,
    val loss: String
    //val currency: Currency,
)
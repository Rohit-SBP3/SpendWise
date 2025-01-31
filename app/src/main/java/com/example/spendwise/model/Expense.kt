package com.example.spendwise.model

import java.util.Date

data class Expense(
    val title: String,
    val amount: Double,
    val category: String,
    val date: Date
)
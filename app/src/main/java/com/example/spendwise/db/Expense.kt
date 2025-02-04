package com.example.spendwise.db

import androidx.room.Entity
import java.util.Date

@Entity(tableName = "expenses")
data class Expense(
    val title: String,
    val amount: Double,
    val category: String,
    val date: Date
)
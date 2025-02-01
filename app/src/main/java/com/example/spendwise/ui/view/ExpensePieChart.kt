package com.example.spendwise.ui.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.graphics.Color
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import com.github.mikephil.charting.data.PieEntry
import androidx.compose.ui.viewinterop.AndroidView
import com.example.spendwise.model.Expense
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet

@Composable
fun ExpensePieChart(expenses: List<Expense>, modifier: Modifier = Modifier) {
    // Convert expenses to PieEntry list
    val entries = expenses.groupBy { it.category }
        .map { (category, items) ->
            // Ensure the amount is correctly converted to Float
            PieEntry(items.sumOf { it.amount }.toFloat(), category)
        }


    // Configure PieDataSet
    val dataSet = PieDataSet(entries, "Expenses by Category").apply {
        colors = listOf(
            Color.parseColor("#FFA726"), // Example colors
            Color.parseColor("#66BB6A"),
            Color.parseColor("#EF5350"),
            Color.parseColor("#42A5F5")
        )
        valueTextColor = Color.WHITE
        valueTextSize = 12f
    }

    // Create PieData
    val pieData = PieData(dataSet)

    // Render PieChart using AndroidView
    AndroidView(
        modifier = Modifier.fillMaxSize().padding(30.dp),
        factory = { context ->
            PieChart(context).apply {
                data = pieData
                description.isEnabled = false
                isDrawHoleEnabled = true
                setEntryLabelColor(Color.WHITE)
                legend.orientation = Legend.LegendOrientation.VERTICAL
                legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
                animateY(1000)
            }
        }
    )
}
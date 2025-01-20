package com.example.spendwise.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TransactionDateSection(
    modifier: Modifier = Modifier,
    date: String,
    amount: String,
    numberOfTransaction: Int
){
    Column(
        modifier.padding(10.dp)
    ){
        Text(
            text = date,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = amount,
                fontSize = 16.sp,
            )
            Text(
                text = " ⦁ ",
                fontSize = 15.sp
            )
            Text(
                text = "$numberOfTransaction transaction",
                fontSize = 16.sp
            )
        }
    }
}
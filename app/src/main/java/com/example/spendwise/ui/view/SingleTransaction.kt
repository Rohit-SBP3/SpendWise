package com.example.spendwise.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spendwise.R


@Composable
fun SingleTransactionSection(
    modifier: Modifier = Modifier,
    text: String,
    type: String,
    time: String,
    expense: String
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Icon(
            painter = painterResource(id = R.drawable.money),
            contentDescription = "Transaction",
            modifier.size(50.dp)
        )
        Spacer(modifier = modifier.width(10.dp))
        Column(
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = text,
                fontSize = 17.sp
            )
            Row(
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = type,
                    fontSize = 16.sp
                )
                Text(
                    text = " ⦁ ",
                    fontSize = 15.sp
                )
                Text(
                    text = time,
                    fontSize = 16.sp
                )
            }
        }
        Spacer(modifier = modifier.weight(1f))
        Text(
            text = expense,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(R.color.green)
        )
    }
}

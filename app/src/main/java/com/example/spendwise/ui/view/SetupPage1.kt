package com.example.spendwise.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spendwise.R


@Preview(showBackground = true)
@Composable
fun SetupPageInitialScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Icon(
            painter = painterResource(id = R.drawable.wallet),
            contentDescription = "App Logo",
            tint = Color.Gray,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        LowerFlow(modifier,title = "SpendWise", subtitle = "Your personal finance tracker")
    }
}


@Composable
fun LowerFlow(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String
){
    Column(
        modifier
            .padding(20.dp)
            .fillMaxWidth()
    ){
        Text(
            text = title,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = subtitle,
            fontSize = 18.sp,
        )
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Next")
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Move forward"
                )
            }
        }
    }
}
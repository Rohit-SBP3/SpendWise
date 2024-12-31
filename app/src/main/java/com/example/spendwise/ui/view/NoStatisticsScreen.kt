package com.example.spendwise.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spendwise.R

@Preview(showBackground = true)
@Composable
fun NoStatisticsScreen(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        StatMonthSelection(modifier)
        Spacer(modifier = Modifier.height(180.dp))
        DefaultTemplate(
            modifier,
            text = "No data to show",
            image = painterResource(id = R.drawable.piechart),
            buttonText = "Select range",
            buttonIcon = Icons.Default.Search
        )
    }
}

@Composable
fun StatMonthSelection(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "Left"
            )
            Spacer(modifier = modifier.width(40.dp))
            Button(
                modifier = modifier.width(200.dp),
                onClick = {  }
            ) {
                Text(
                    text = "December",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.W400
                )
            }
            Spacer(modifier = modifier.width(40.dp))
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Right"
            )

        }
        Row (
            modifier= modifier.padding(top = 10.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Text(
                text = "By month",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = modifier.width(170.dp))
            Text(
                text = "More options",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
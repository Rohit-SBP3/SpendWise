package com.example.spendwise.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun DefaultScreen(modifier: Modifier = Modifier){
    Column(
        modifier
            .fillMaxSize()
            .padding(10.dp)
    ){
        DefaultScreenTopbar(modifier)
        DefaultBody(modifier)

    }
}

@Composable
fun DefaultBody(modifier: Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize().padding(31.dp)
    ) {
        Text(
            text = "No transactions for the last 7 days",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )
        Icon(
            imageVector = Icons.Default.Face,
            contentDescription = "No Transaction",
            modifier.size(70.dp)
        )
        Text(
            text = "Cick on + button to add a new transaction",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DefaultScreenTopbar(modifier: Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        Text(
            text = "Hi, Default Profile!",
            style = MaterialTheme.typography.headlineSmall
        )
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "User Profile",
            modifier.size(40.dp)
        )
    }
}
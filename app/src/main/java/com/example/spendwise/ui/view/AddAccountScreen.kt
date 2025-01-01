package com.example.spendwise.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spendwise.R

@Preview(showBackground = true)
@Composable
fun AddAccountScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ){
        UpperNavigation(modifier)
        Spacer(modifier = modifier.height(15.dp))
        AddAccountDetails(modifier)
    }
}

@Composable
fun AddAccountDetails(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.padding(10.dp),
    ) {
        Row (
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ){
            Icon(
                painter = painterResource(id = R.drawable.wallet),
                contentDescription = "Account Image",
                modifier = modifier.size(80.dp)
            )
            Text(
                text = "Account name",
                fontSize = 26.sp
            )
            Icon(
                imageVector = Icons.Default.Create,
                contentDescription = "Edit name",
                modifier
                    .padding(10.dp)
                    .size(25.dp)
            )
        }
        Text(
            text = "Change icon",
            fontSize = 14.sp,
            modifier = modifier.padding(top = 12.dp)
        )
    }
}
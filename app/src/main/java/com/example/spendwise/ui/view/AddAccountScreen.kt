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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.navArgument
import com.example.spendwise.R

@Composable
fun AddAccountScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ){
        UpperNavigation(modifier = modifier, navController = navController)
        Spacer(modifier = modifier.height(15.dp))
        AddAccountDetails(modifier)
        Balance(modifier)
        CurrencyAndExclude(modifier)
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

@Composable
fun Balance(modifier: Modifier = Modifier){

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "$0.00",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = "Update balance",
            fontSize = 16.sp,
        )
    }
}

@Composable
fun CurrencyAndExclude(modifier: Modifier = Modifier){

    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier
            .padding(start = 10.dp, top = 50.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Exclude from balance",
                fontSize = 20.sp,
            )
            Checkbox(
                checked = isChecked,
                onCheckedChange = {isChecked = it}
            )
        }
        Row (
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Currency",
                fontSize = 20.sp,
            )
            Spacer(modifier = modifier.height(80.dp))
            Text(
                text = "USD",
                fontSize = 18.sp,
                modifier = modifier.padding(end = 10.dp)
            )
        }
    }
}
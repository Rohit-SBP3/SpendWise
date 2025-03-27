package com.example.spendwise.ui.view

import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.navArgument
import com.example.spendwise.R
import com.example.spendwise.ui.theme.Blue80

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

@Preview(showBackground = true)
@Composable
fun AddAccountDetails(modifier: Modifier = Modifier){

    var accountName by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    var isEditing by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    Column(
        modifier = modifier.padding(10.dp),
    ) {
        Row (
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(id = R.drawable.wallet),
                contentDescription = "Account Image",
                modifier = modifier.size(70.dp),
                tint = Blue80
            )
            Column(
                modifier = modifier.weight(1f),
            ){
                TextField (
                    value = accountName,
                    onValueChange = {
                        accountName = it
                        showError = it.isBlank()
                    },
                    label = { Text("Account name") },
                    placeholder = { Text(accountName) },
                    singleLine = true,
                    textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent, // Removes background color
                        focusedContainerColor = Color.Transparent,   // Ensures no background when focused
                        disabledContainerColor = Color.Transparent,  // No background when disabled
                        unfocusedIndicatorColor = Color.Transparent, // Removes underline when not focused
                        focusedIndicatorColor = Color.Transparent    // Removes underline when focused
                    ),
                    modifier = Modifier.focusRequester(focusRequester)
                )
                if (showError) {
                    Text(
                        text = "Please fill out the field",
                        color = Color.Red,
                        fontSize = 8.sp,
                        modifier = modifier.padding(start = 16.dp)
                    )
                }
            }

            if(accountName.isBlank()){
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = "Edit name",
                    modifier
                        .size(25.dp)
                        .clickable {
                            isEditing = true
                            focusRequester.requestFocus()
                        }
                )
            }else {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "save name",
                    modifier
                        .size(25.dp)
                        .clickable {

                        }
                )
            }
        }
        Text(
            text = "Change icon",
            fontSize = 12.sp,
            modifier = modifier.padding(top = 8.dp)
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
            style = TextStyle(color = Blue80)
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
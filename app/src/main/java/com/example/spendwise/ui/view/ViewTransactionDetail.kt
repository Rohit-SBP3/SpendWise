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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import com.example.spendwise.R
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun ViewTranslationDetail(modifier: Modifier = Modifier){

    var transactionName by remember { mutableStateOf("Gift for Myself") }

    Column(
        modifier = modifier.fillMaxSize()
    ){
        TopBarWithSelection(modifier)
        Column(
            modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            OutlinedTextField(
                value = transactionName,
                onValueChange = { transactionName = it },
                modifier = modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Dropdown Icon",
                        modifier = modifier.size(20.dp)
                    )
                }
            )
            Spacer(modifier.height(25.dp))
            Text(
                text = "$99.01",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            AccountDetail(
                accountName = "Sending account",
                type = "Main",
                amount = "$715.68"
            )
            AccountDetail(
                accountName = "Receiving account",
                type = "Savings",
                amount = "$67710.08"
            )
            TransactionDateDetail(date = "January 10 2025 06:37 PM")
            CreatedOn(date = "January 10 2025 06:37 PM")
        }
    }
}

@Composable
fun TransactionDateDetail(modifier: Modifier = Modifier, date: String){
    Column(
        modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ){
        Text(
            text = "Transaction date",
            fontSize = 20.sp,
            style = TextStyle(color = Color.Gray)
        )
        Spacer(modifier = modifier.height(15.dp))
        Row {
            Text(
                text = date,
                fontSize = 20.sp
            )
            Spacer(modifier = modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Change the date"
            )
        }
    }
}

@Composable
fun CreatedOn(modifier: Modifier = Modifier, date: String){
    Column(
        modifier = modifier.padding(top = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Created at January $date",
            fontSize = 15.sp,
            style = TextStyle(color = Color.Gray)
        )
        Spacer(modifier = modifier.height(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = Color.Red,
                modifier = modifier.size(32.dp)
            )
            Spacer(modifier = modifier.width(10.dp))
            Text(
                text = "Delete Transaction",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun AccountDetail(
    modifier: Modifier = Modifier,
    accountName: String,
    type: String,
    amount: String
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ){
        Text(
            text = accountName,
            fontSize = 20.sp,
            style = TextStyle(color = Color.Gray)
        )
        Spacer(modifier = modifier.height(10.dp))
        Row{
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "Account",
                modifier.size(50.dp)
            )
            Spacer(modifier = modifier.width(10.dp))
            Column {
                Text(
                    text = type,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = amount,
                    fontSize = 15.sp
                )
            }
        }

    }

}



@Composable
fun TopBarWithSelection(
    modifier: Modifier = Modifier,
){

    val options = listOf("Transfer","Income","Expense")
    var selected by remember { mutableStateOf("Transfer") }

    Row(
        modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close",
            modifier = modifier.size(30.dp)
        )
        DropDownMenu(
            options = options,
            selected = selected,
            onOptionSelected = { selected = it },
            modifier = modifier
        )
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Create"
        )
    }

}
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
import com.example.spendwise.R
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
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
import androidx.compose.ui.res.painterResource
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
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier.fillMaxWidth()
        ){
            Text(text = "Account")
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.wallet),
                    contentDescription = "Account",
                    modifier.size(40.dp)
                )
                Column {
                    Text(text = "Main")
                    Text(text = "$715.68")
                }
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
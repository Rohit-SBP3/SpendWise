package com.example.spendwise.ui.view

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spendwise.model.AmountCardModel

@Preview(showBackground = true)
@Composable
fun AccountsScreen(modifier: Modifier = Modifier){

    var accountlist : List<AmountCardModel> = listOf(
        AmountCardModel(
            Icons.Default.AccountCircle,
            "Saving",
            "$67,770.00",
            "$303.00",
            "-86.006"
        ),
        AmountCardModel(
            Icons.Default.Home,
        "Saving",
        "$67,770.00",
        "$303.00",
        "-86.006"
        ),
        AmountCardModel(
            Icons.Default.Face,
            "Saving",
            "$67,770.00",
            "$303.00",
            "-86.006"
        )
    )

    Column(
        modifier
            .fillMaxSize()
    ){
        AccountsTopBar(modifier = modifier)
        Spacer(modifier = modifier.height(20.dp))
        LazyColumn(){
            items(accountlist){
                Column(
                    modifier.padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
                ){
                    AccountCard(modifier = modifier, amountDetail = it)
                }
            }
            item {
                Column(
                    modifier.padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
                ){
                    CreateAnAccount(modifier)
                }
            }
        }
    }
}

@Composable
fun AccountCard(
    modifier: Modifier,
    amountDetail: AmountCardModel
){
    Column(
        modifier
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFFF0C0F3))
            .padding(10.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = amountDetail.imageVector,
                contentDescription = "Account Icon",
                modifier.size(70.dp)
            )
            Spacer(modifier = modifier.width(8.dp))
            Column(){
                Text(
                    text = amountDetail.accountType,
                    fontSize = 20.sp
                )
                Text(
                    text = amountDetail.amount,
                    fontSize = 25.sp
                )
            }
        }
        Spacer(modifier = modifier.height(5.dp))
        Column(){
            Text(
                text = "This month",
                fontSize = 20.sp
            )
            IncomeExpenseSection(modifier,amountDetail.profit,amountDetail.loss)
        }
    }
}

@Composable
fun IncomeExpenseSection(
    modifier: Modifier,
    profit: String,
    loss: String
){
    Row(
        modifier
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column {
            Text(text = "Income")
            Text(
                text = profit,
                fontSize = 18.sp
            )
        }
        Column {
            Text(text = "Expense")
            Text(text = loss,fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAnAccount(modifier: Modifier = Modifier){
    Column(
        modifier
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFFF0C0F3))
            .fillMaxWidth()
            .height(165.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Create an Account",
            fontSize = 32.sp
        )
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Create An Account!",
            modifier.size(50.dp)
        )
    }

}

@Composable
fun AccountsTopBar(modifier: Modifier){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Accounts",
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )
        Icon(
            imageVector = Icons.Default.List,
            contentDescription = "Rearrange",
            modifier = modifier.size(30.dp)
        )
    }
}
package com.example.spendwise.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spendwise.model.AmountCardModel

@Preview(showBackground = true)
@Composable
fun AccountsScreen(modifier: Modifier = Modifier){
    Column(
        modifier.fillMaxSize().padding(15.dp)
    ){
        AccountsTopBar(modifier = modifier)
    }
}

@Composable
fun AccountCard(
    modifier: Modifier,
   amountDetail: AmountCardModel
){
    Column(
        modifier.background(Color(0xFFF0C0F3))
    ){

    }

}

@Composable
fun AccountsTopBar(modifier: Modifier){
    Row(
        modifier = modifier.fillMaxWidth(),
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
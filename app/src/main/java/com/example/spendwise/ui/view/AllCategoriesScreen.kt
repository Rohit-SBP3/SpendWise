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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun AllCategoriesScreen(modifier: Modifier = Modifier){
    Column(
        modifier.fillMaxSize()
    ){
        BackIconWithText(modifier, "Categories")
    }
}

@Composable
fun CategoryListItem(
    modifier: Modifier = Modifier,
    text: String,
    icon: Painter,
    price: Double
){

}

@Composable
fun BackIconWithText(modifier: Modifier = Modifier, text:String){
    Row(
        modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Absolute.Left,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back Button",
            modifier.size(30.dp)
        )
        Spacer(modifier = modifier.width(20.dp))
        Text(
            text = text,
            fontSize = 26.sp
        )
    }
}
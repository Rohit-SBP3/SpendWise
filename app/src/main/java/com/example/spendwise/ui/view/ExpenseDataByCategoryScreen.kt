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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spendwise.model.CategoryModel

@Preview(showBackground = true)
@Composable
fun ExpenseDataByCategoryScreen(
    //category: CategoryModel,
    category: String = "Eating out",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        UpperBarWithIconAndText(
            leadIcon = Icons.Default.ArrowBack,
            trailIcon = Icons.Default.Create,
            text = category,
            modifier
        )
        StatMonthSelection()
        CategoryExpenseDataSection(
            icon = Icons.Default.Home,
            transactions = 3,
            price = "$10.29",
            modifier = modifier
        )
        NoTransactionToShow(modifier)
    }
}

@Composable
fun NoTransactionToShow(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "No transaction to show",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Try updating the filters",
            fontSize = 14.sp
        )
    }
}

@Composable
fun CategoryExpenseDataSection(
    icon: ImageVector,
    price: String,
    transactions: Int,
    modifier: Modifier
){
   Column(
       modifier = modifier.padding(10.dp)
   ){
       Row(
           modifier
               .fillMaxWidth()
               .clip(RoundedCornerShape(15.dp))
               .background(Color(0xFFF0C0F3))
               .padding(8.dp),
           verticalAlignment = Alignment.CenterVertically,
       ){
           Icon(
               imageVector = icon,
               contentDescription = "Category image",
               modifier = modifier.size(60.dp),
           )
           Spacer(modifier = modifier.width(15.dp))
           Column(){
               Text(
                   text = price,
                   fontSize = 25.sp,
                   fontWeight = FontWeight.Bold,
                   letterSpacing = 1.4.sp
               )
               Text(
                   text = " $transactions transactions",
                   fontSize = 14.sp
               )
           }
       }
       Spacer(modifier = modifier.height(14.dp))
       Row(
           modifier.fillMaxWidth()
       ){
           Row(
               modifier
                   .clip(RoundedCornerShape(15.dp))
                   .background(Color(0xFFF0C0F3))
                   .weight(0.5f)
                   .padding(15.dp)
           ) {
               Text(
                   text = price,
                   fontSize = 25.sp,
                   fontWeight = FontWeight.Bold,
                   letterSpacing = 1.4.sp
               )
           }
           Spacer(modifier = modifier.width(12.dp))
           Row(
               modifier
                   .clip(RoundedCornerShape(15.dp))
                   .background(Color(0xFFF0C0F3))
                   .background(Color(0xFFF0C0F3))
                   .weight(0.5f)
                   .padding(15.dp)
           ){
               Text(
                   text = price,
                   fontSize = 25.sp,
                   fontWeight = FontWeight.Bold,
                   letterSpacing = 1.4.sp
               )
           }
       }

   }
}

@Composable
fun UpperBarWithIconAndText(leadIcon: ImageVector, trailIcon: ImageVector?, text:String, modifier: Modifier = Modifier){
    Row(
       modifier = Modifier
           .fillMaxWidth()
           .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.Left,
    ){
        Icon(
            imageVector = leadIcon,
            contentDescription = "Back Button",
            modifier.size(30.dp)
        )
        Spacer(modifier = modifier.width(20.dp))
        Text(
            text = text,
            fontSize = 26.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(1f))
        if(trailIcon != null){
            Icon(
                imageVector = trailIcon,
                contentDescription = "Something",
                modifier.size(30.dp)
            )
        }
    }
}
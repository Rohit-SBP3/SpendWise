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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
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
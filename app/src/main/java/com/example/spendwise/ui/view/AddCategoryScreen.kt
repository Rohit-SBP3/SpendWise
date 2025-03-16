package com.example.spendwise.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.sharp.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddCategoryScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){

    var categoryName by remember { mutableStateOf("") }

    Column(
        modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        UpperNavigation(
            modifier = modifier,
            navController = navController
        )
        Spacer(modifier = modifier.height(20.dp))
        Icon(
            imageVector = Icons.Sharp.AddCircle,
            contentDescription = "Add Image",
            modifier.size(120.dp)
        )
        Text(
            text = "Change icon",
            fontSize = 19.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = modifier.height(20.dp))
        TextField(
            value = categoryName,
            onValueChange = {categoryName = it },
            label = { Text("Category name") },
            placeholder = { Text(categoryName) },
            singleLine = true,
            textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
            modifier = modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFFFFFFF)
            )
        )
    }
}
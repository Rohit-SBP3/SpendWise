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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddUserInfoScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){

    var username by remember { mutableStateOf("") }

    Column(
        modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        UpperNavigation(
            modifier = modifier,
            navController = navController
        )
        Spacer(modifier = modifier.height(20.dp))
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Add Image",
            modifier.size(120.dp)
        )
        TextField(
            value = username,
            onValueChange = {username = it },
            label = { Text("Rohit Singh")},
            placeholder = {Text(username)},
            singleLine = true,
            textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
            modifier = modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFFFFFFF)
            )
        )
    }
}

@Composable
fun UpperNavigation(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Row(
        modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back Button",
            modifier.size(30.dp).clickable {
                navController.popBackStack()
            }
        )
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Save",
            modifier.size(30.dp).clickable {

            }
        )
    }
}

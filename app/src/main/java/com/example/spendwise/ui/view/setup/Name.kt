package com.example.spendwise.ui.view.setup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spendwise.ui.view.UpperBarWithIconAndText

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SetupNameScreen(modifier: Modifier = Modifier, navController: NavController){

    var username by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(true) }

    Column(
        modifier.fillMaxSize()
    ){
        UpperBarWithIconAndText(
            leadIcon = Icons.Default.ArrowBack,
            trailIcon = null,
            text = "What's your name?",
            navController = navController
        )
        Row(
            modifier = modifier.padding(10.dp)
        ){
            TextField(
                value = username,
                onValueChange = {
                    username = it
                    showError = false
                },
                label = { Text("") },
                placeholder = { Text(username) },
                singleLine = true,
                textStyle = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 18.sp),
                modifier = modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFFFFFFF)
                )
            )
        }
        if (showError) {
            Text(
                text = "Please fill out the field",
                color = Color.Red,
                fontSize = 14.sp,
                modifier = modifier.padding(start = 12.dp, top = 4.dp)
            )
        }
        Spacer(modifier = modifier.weight(1f))
        LowerPanelWithButtonAndDots(
            modifier,
            pagerState = null,
            buttonText = "Next",
            navController = navController,
            destination =
                if (username.isBlank()) {
                    showError = true
                    null
                } else "photo"
        )
    }
}
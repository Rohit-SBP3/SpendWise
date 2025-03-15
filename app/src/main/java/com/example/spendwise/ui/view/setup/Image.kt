package com.example.spendwise.ui.view.setup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spendwise.ui.view.UpperBarWithIconAndText

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SetupImageScreen(modifier: Modifier = Modifier, navController: NavController){
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UpperBarWithIconAndText(
            leadIcon = Icons.Default.ArrowBack,
            trailIcon = null,
            text = "Add a photo"
        )
        HintMessage(modifier = modifier, text = "This is optional. Your photo will be stored only on your device, " +
                "and will not be included in backups.")
        Spacer(modifier = modifier.height(40.dp))
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Add Image",
            modifier.size(120.dp)
        )
        Spacer(modifier = modifier.weight(1f))
        LowerPanelWithButtonAndDots(
            pagerState = null,
            buttonText = "Skip",
            navController = navController,
            destination = "currency"
        )
    }
}

@Composable
fun HintMessage(modifier: Modifier = Modifier, text: String){
    Row(
        modifier = modifier.padding(start = 10.dp, end = 10.dp, top = 20.dp),
    ){
        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = "warning",
            tint = Color.Gray
        )
        Spacer(modifier = modifier.width(8.dp))
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            style = TextStyle(color = Color.Gray)
        )
    }
}
package com.example.spendwise.ui.view.setup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spendwise.ui.view.UpperBarWithIconAndText

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun SetupCurrencyScreen(modifier: Modifier = Modifier){

    var currency by remember { mutableStateOf("~~~") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        UpperBarWithIconAndText(
            leadIcon = Icons.Default.ArrowBack,
            trailIcon = null,
            text = "Select a currency"
        )
        HintMessage(modifier = modifier, text = "This will be your primary currency. You can change this later in Preferences menu")
        Spacer(modifier = modifier.height(20.dp))
        TextField(
            value = currency,
            onValueChange = { currency = it },
            placeholder = { Text(currency) },
            singleLine = true,
            textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp, textAlign = TextAlign.Center),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFFFFFFF),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            )
        )
        Spacer(modifier = modifier.height(20.dp))
        Button(onClick = {}) {
            Text(text = "Choose a currency")
        }
        Spacer(modifier = modifier.weight(1f))
        LowerPanelWithButtonAndDots(pagerState = null, buttonText = "Next")
    }
}

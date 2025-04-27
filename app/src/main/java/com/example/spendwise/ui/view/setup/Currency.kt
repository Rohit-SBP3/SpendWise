package com.example.spendwise.ui.view.setup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spendwise.data.iso4217CurrenciesGrouped
import com.example.spendwise.ui.view.UpperBarWithIconAndText

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SetupCurrencyScreen(modifier: Modifier = Modifier, navController: NavController){

    var currency by remember { mutableStateOf("~~~") }
    var showBottomSheet by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        UpperBarWithIconAndText(
            leadIcon = Icons.Default.ArrowBack,
            trailIcon = null,
            text = "Select a currency",
            navController = navController
        )
        HintMessage(modifier = modifier, text = "This will be your primary currency. You can change this later in Preferences menu")
        Spacer(modifier = modifier.height(20.dp))
        TextField(
            value = currency,
            onValueChange = {
                currency = it
            },
            placeholder = { Text(currency) },
            singleLine = true,
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 25.sp, textAlign = TextAlign.Center),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent, // ✅ Removes background color
                focusedContainerColor = Color.Transparent,   // ✅ Ensures no background when focused
                disabledContainerColor = Color.Transparent,  // ✅ No background when disabled
                unfocusedIndicatorColor = Color.Transparent, // ✅ Removes underline when not focused
                focusedIndicatorColor = Color.Transparent    // ✅ Removes underline when focused
            ),
            enabled = true
        )
        Spacer(modifier = modifier.height(20.dp))
        Button(onClick = {
            showBottomSheet = true
        }) {
            Text(text = "Choose a currency")
        }
        Spacer(modifier = modifier.weight(1f))
        LowerPanelWithButtonAndDots(
            pagerState = null,
            buttonText = "Next",
            navController = navController,
            onClick = {
                if (currency != "~~~") navController.navigate("account")
            }
        )
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        ) {
            CurrencyPicker(
                onCurrencySelected = { selectedCurrency ->
                    currency = selectedCurrency
                    showBottomSheet = false
                }
            )
        }
    }
}

@Composable
fun CurrencyDetails(
    country: String = "India",
    name: String = "Indian Rupee",
    code: String = "INR",
    onCurrencySelected: (String) -> Unit
){

    Row (
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                 onCurrencySelected(code)
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column {
            Text(
                text = name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = country,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = code,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }

}

@Composable
fun CurrencyPicker(onCurrencySelected: (String) -> Unit) {

    val allCurrencies = iso4217CurrenciesGrouped.values.map { "${it.code} - ${it.name} - ${it.country}" }
    var searchQuery by remember { mutableStateOf("") }
    val filteredCurrencies = allCurrencies.filter { it.contains(searchQuery, ignoreCase = true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Select Currency",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Search Bar
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search currency") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Blue
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
        ) {
            LazyColumn {
                items(filteredCurrencies.take(6)) {currency ->
                    CurrencyDetails(
                        code = currency.split(" - ")[0],
                        name = currency.split(" - ")[1],
                        country = currency.split(" - ")[2],
                        onCurrencySelected = onCurrencySelected
                    )
                }
            }
        }
    }
}



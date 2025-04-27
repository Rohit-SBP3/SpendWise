package com.example.spendwise.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spendwise.R
import com.example.spendwise.ui.theme.Blue80
import com.example.spendwise.ui.view.setup.Numpad
import com.example.spendwise.ui.view.setup.buildNumpadChildren

@Composable
fun AddAccountScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        UpperNavigation(modifier = modifier, navController = navController)
        Spacer(modifier = modifier.height(15.dp))
        AddAccountDetails(modifier)
        Balance(modifier)
        CurrencyAndExclude(modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun AddAccountDetails(modifier: Modifier = Modifier) {

    var accountName by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var isEditing by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(isEditing) {
        if (isEditing) {
            focusRequester.requestFocus()
        }
    }

    Column(
        modifier = modifier.padding(10.dp),
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.wallet),
                contentDescription = "Account Image",
                modifier = modifier.size(70.dp),
                tint = Blue80
            )

            Column(
                modifier = modifier.padding(20.dp).weight(1f),
            ) {
                if (isEditing) {
                    TextField(
                        value = accountName,
                        onValueChange = {
                            accountName = it
                            showError = it.isBlank()
                        },
                        placeholder = { Text("Account name") },
                        singleLine = true,
                        textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp, textAlign = TextAlign.Start),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Blue80
                        ),
                        modifier = Modifier
                            .focusRequester(focusRequester)
                            .onFocusChanged { focusState ->
                                // Optional, if you still want some UI change on focus
                            }.padding(0.dp)
                    )
                } else {
                    Text(
                        text = accountName.ifBlank { "Account name" },
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                }

                if (showError && isEditing) {
                    Text(
                        text = "Please fill out the field",
                        color = Color.Red,
                        fontSize = 8.sp,
                    )
                }
            }

            if (!isEditing) {
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = "Edit name",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            isEditing = true
                        }
                )
            } else {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Save name",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            isEditing = false
                        }
                )
            }
        }
        Text(text = "Change icon", fontSize = 12.sp, modifier = modifier.padding(top = 8.dp))
    }
}

/*fun AddAccountDetails(modifier: Modifier = Modifier){

    var accountName by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var showIcon by remember { mutableStateOf(true) }

    var isEditing by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    Column(
        modifier = modifier.padding(10.dp),
    ) {
        Row (
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(id = R.drawable.wallet),
                contentDescription = "Account Image",
                modifier = modifier.size(70.dp),
                tint = Blue80
            )
            Column(
                modifier = modifier.padding(20.dp).weight(1f),
            ){
                TextField (
                    value = accountName,
                    onValueChange = {
                        accountName = it
                        showError = it.isBlank()
                    },
                    placeholder = { Text("Account name") },
                    singleLine = true,
                    textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent, // Removes background color
                        focusedContainerColor = Color.Transparent,   // Ensures no background when focused
                        disabledContainerColor = Color.Transparent,  // No background when disabled
                        unfocusedIndicatorColor = Color.Transparent, // Removes underline when not focused
                        focusedIndicatorColor = if(showIcon) Blue80 else Color.Transparent   // Removes underline when focused
                    ),
                    modifier = Modifier.focusRequester(focusRequester).onFocusChanged { focusState ->
                        showIcon = focusState.isFocused
                    }
                )
                if (showError) {
                    Text(
                        text = "Please fill out the field",
                        color = Color.Red,
                        fontSize = 8.sp,
                        modifier = modifier.padding(start = 16.dp)
                    )
                }
            }

            if(!showIcon){
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = "Edit name",
                    modifier
                        .size(25.dp)
                        .clickable {
                            isEditing = true
                            focusRequester.requestFocus()
                        }
                )
            }else {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "save name",
                    modifier
                        .size(25.dp)
                        .clickable {
                            isEditing = false
                            focusRequester.freeFocus()
                            showIcon = false
                        }
                )
            }
        }
        Text(text = "Change icon", fontSize = 12.sp, modifier = modifier.padding(top = 8.dp))
    }
}*/


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Balance(modifier: Modifier = Modifier){

    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    var showSheet by remember { mutableStateOf(false) }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = bottomSheetState,
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            Numpad(
                crossAxisCount = 3,
                children = buildNumpadChildren {
                    println("Clicked: $it")
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }

    Column(
        modifier = modifier
            .padding(top = 20.dp)
            .clickable {
                showSheet = true
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "$0.00", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = modifier.height(8.dp))
        Text(text = "Update balance", fontSize = 16.sp, style = TextStyle(color = Blue80))
    }
}

@Composable
fun CurrencyAndExclude(modifier: Modifier = Modifier){

    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier
            .padding(start = 10.dp, top = 50.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Exclude from balance", fontSize = 18.sp,)
            Checkbox(
                checked = isChecked,
                onCheckedChange = {isChecked = it},
                modifier = modifier.size(20.dp)
            )
        }
        Row (
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Currency", fontSize = 18.sp,)
            Spacer(modifier = modifier.height(80.dp))
            Text(text = "USD", fontSize = 16.sp, modifier = modifier.padding(end = 10.dp))
        }
    }
}
package com.example.spendwise.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.example.spendwise.ui.view.setup.CurrencyPicker
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
        Spacer(modifier = modifier.height(8.dp))
        AddAccountDetails(modifier)
        Balance(modifier)
        CurrencyAndExclude(modifier)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAccountDetails(modifier: Modifier = Modifier) {

    var accountName by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var isEditing by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    var showSheet by remember { mutableStateOf(false) }

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
                modifier = modifier.size(70.dp).clickable {
                    showSheet = true
                },
                tint = Blue80
            )

            Column(
                modifier = modifier
                    .padding(20.dp)
                    .weight(1f),
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
                        textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp, textAlign = TextAlign.Center),
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
                            }
                            .padding(0.dp)
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

            if(showSheet){
                ModalBottomSheet(
                    onDismissRequest = {showSheet = false},
                    sheetState = bottomSheetState,
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
                ) {
                    ChangeIconFromModalSheet(modifier)
                }
            }
        }
        Text(
            text = "Change icon",
            fontSize = 12.sp,
            modifier = modifier.padding(top = 8.dp).clickable {
                showSheet = true
            }
        )
    }
}

@Composable
fun AddAccountDetailsTT(modifier: Modifier = Modifier){

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
                        showIcon = it.isNotBlank()
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
                            showIcon != showIcon
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
                            showIcon = !showIcon
                        }
                )
            }
        }
        Text(text = "Change icon", fontSize = 12.sp, modifier = modifier.padding(top = 8.dp))
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Balance(modifier: Modifier = Modifier) {

    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    var showSheet by remember { mutableStateOf(false) }
    var inputText by remember { mutableStateOf("") }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = bottomSheetState,
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                TextField(
                    value = inputText,
                    onValueChange = {},
                    readOnly = true,
                    placeholder = { Text(text = "$0") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Numpad(
                    crossAxisCount = 3,
                    children = buildNumpadChildren { key ->
                        when (key) {
                            "⌫" -> {
                                if (inputText.isNotEmpty()) {
                                    inputText = inputText.dropLast(1)
                                }
                            }
                            "✅" -> {
                                // Confirm balance input (You can add save logic here)
                                showSheet = false
                            }
                            else -> {
                                inputText += key
                            }
                        }
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))
            }
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
    ) {
        Text(text = if(inputText == "") "$0.00" else "$$inputText.00" , fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = modifier.height(8.dp))
        Text(text = "Update balance", fontSize = 16.sp, style = TextStyle(color = Blue80))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyAndExclude(modifier: Modifier = Modifier){

    var isChecked by remember { mutableStateOf(false) }
    var showBottomSheet by remember { mutableStateOf(false) }
    var currency by remember { mutableStateOf("USD") }

    Column(
        modifier.padding(start = 10.dp, top = 50.dp, end = 10.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier.fillMaxWidth().clickable {
                isChecked = !isChecked
            },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Exclude from balance", fontSize = 18.sp,)
            Checkbox(
                checked = isChecked,
                onCheckedChange = {isChecked = it},
                modifier = modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row (
            modifier.fillMaxWidth().clickable {
                showBottomSheet = !showBottomSheet
            },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Currency", fontSize = 18.sp,)
            Text(text = currency, fontSize = 16.sp)
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
}

@Preview(showBackground = true)
@Composable
fun ChangeIconFromModalSheet(modifier: Modifier = Modifier){

    Column(
        modifier = modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Change Icon",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier.height(10.dp))
        Column {
            ChangeIconBox(iconName = "Icon", icon = Icons.Default.AddCircle)
            ChangeIconBox(iconName = "Character", icon = Icons.Default.MailOutline)
            ChangeIconBox(iconName = "Image", icon = Icons.Default.AccountBox)
        }
    }

}


@Composable
fun ChangeIconBox(
    modifier: Modifier = Modifier,
    iconName: String,
    icon: ImageVector
){
    Row(
        modifier = modifier.fillMaxWidth().padding(14.dp)
    ){
        Icon(
            imageVector = icon,
            contentDescription = "Icon Type",
            modifier = modifier.size(32.dp),
            tint = Blue80
        )
        Spacer(modifier = modifier.width(18.dp))
        Text(
            text = iconName,
            fontSize = 18.sp,
            fontWeight = FontWeight.W400
        )
    }
}
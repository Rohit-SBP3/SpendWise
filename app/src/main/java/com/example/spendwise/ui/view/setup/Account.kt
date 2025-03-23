package com.example.spendwise.ui.view.setup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spendwise.ui.theme.Blue80
import com.example.spendwise.ui.theme.Pink80
import com.example.spendwise.ui.theme.Purple80
import com.example.spendwise.ui.view.UpperBarWithIconAndText

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SetupAccountScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Column(
        modifier = modifier.fillMaxSize()
    ){
        UpperBarWithIconAndText(
            leadIcon = Icons.Default.ArrowBack,
            trailIcon = null,
            text = "Setup accounts",
            navController = navController
        )
        HintMessage(text = "Create new accounts, and/or add from the presents. You can change this later in the \"Accounts\" tab")
        Spacer(modifier = modifier.height(10.dp))
        AddAccountBox(navController = navController)
        AccountBox(icon = Icons.Default.AccountCircle, type = "Main", amount = "$716.85")
        AccountBox(icon = Icons.Default.Face, type = "Savings", amount = "$10.2")
        AccountBox(icon = Icons.Default.AccountBox, type = "Cash", amount = "$120.1")
        Spacer(modifier = modifier.weight(1f))
        LowerPanelWithButtonAndDots(
            pagerState = null,
            buttonText = "Next",
            navController = navController,
            destination = "category"
        )
    }

}

@Composable
fun AddAccountBox(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Row(
        modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Blue80)
            .clickable {
                navController.navigate("addAccountScreen")
            }
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Account Icon",
            modifier = modifier
                .padding(15.dp)
                .size(60.dp)
        )
        Text(
            text = "Add new account",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun AccountBox(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    type: String,
    amount: String
){
    Row(
        modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Purple80),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = icon,
            contentDescription = "Account Icon",
            modifier = modifier
                .padding(15.dp)
                .size(60.dp)
        )
        Column{
            Text(
                text = type,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Text(text = amount,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
            )
        }
    }
}
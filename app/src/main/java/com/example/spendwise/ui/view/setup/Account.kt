package com.example.spendwise.ui.view.setup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.spendwise.ui.view.UpperBarWithIconAndText

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun SetupAccountScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize()
    ){
        UpperBarWithIconAndText(
            leadIcon = Icons.Default.ArrowBack,
            trailIcon = null,
            text = "Setup accounts"
        )
        HintMessage(text = "Create new accounts, and/or add from the presents. You can change this later in the \"Accounts\" tab")
        Spacer(modifier = modifier.weight(1f))
        LowerPanelWithButtonAndDots(pagerState = null, buttonText = "Next")
    }

}
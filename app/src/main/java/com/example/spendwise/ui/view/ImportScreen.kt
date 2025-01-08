package com.example.spendwise.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun ImportScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        UpperBarWithIconAndText(
            leadIcon = Icons.Default.ArrowBack,
            trailIcon = null,
            text = "Import"
        )
    }
}
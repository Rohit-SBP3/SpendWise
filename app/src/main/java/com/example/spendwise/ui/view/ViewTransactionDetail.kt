package com.example.spendwise.ui.view

import android.view.translation.ViewTranslationCallback
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ViewTranslationDetail(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize()
    ){
        TopBarWithSelection()
    }
}

@Composable
fun TopBarWithSelection(
    modifier: Modifier = Modifier,
){

    val options = listOf<String>("Transfer","Income","Expense")
    var selected by remember { mutableStateOf("Transfer") }

    Row(
        modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close",
            modifier = modifier.size(30.dp)
        )
        DropDownMenu(
            options = options,
            selected = selected,
            onOptionSelected = { selected = it }
        )
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Create"
        )
    }

}
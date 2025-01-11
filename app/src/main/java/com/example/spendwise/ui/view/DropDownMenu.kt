package com.example.spendwise.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier


@Composable
fun DropDownMenu(
    options: List<String>,
    selected: String,
    onOptionSelected: (String) -> Unit
){

    var expanded by remember{ mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(selected) }

    OutlinedTextField(
        value = selected,
        onValueChange = { },
        label = { Text("Select an Option")},
        modifier = Modifier.clickable { expanded = true },
        enabled = false,
        trailingIcon = {
            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = "Dropdown Icon",
                modifier = Modifier.clickable { expanded = !expanded }
            )
        }
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        options.forEach { option ->
            DropdownMenuItem(
                onClick = {
                    selectedOption = option
                    expanded = false
                    onOptionSelected(option)
                },
                text = { Text(text = option) }
            )
        }
    }

}
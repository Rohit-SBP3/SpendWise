package com.example.spendwise.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DropDownMenu(
    options: List<String>,
    selected: String,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier
){

    var expanded by remember{ mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(selected) }

    OutlinedTextField(
        value = selected,
        onValueChange = { },
        modifier = modifier.width(140.dp).clickable { expanded = true },
        trailingIcon = {
            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = "Dropdown Icon",
                modifier = modifier.clickable { expanded = !expanded }
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent, // Transparent background
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            focusedBorderColor = Color.White,  // White outline when focused
            unfocusedBorderColor = Color.White, // White outline when unfocused
        )
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
                text = {
                    Text(
                        text = option,
                    )
                }
            )
        }
    }

}
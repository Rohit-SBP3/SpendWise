package com.example.spendwise.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.spendwise.R
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.spendwise.model.Icon2TextModel

@Preview(showBackground = true)
@Composable
fun PreferencesScreen(
    modifier: Modifier = Modifier){

    var list: List<Icon2TextModel> = listOf(
        Icon2TextModel(
            painterResource(id = R.drawable.brightness),
            "Theme",
            "Light"
        ),
        Icon2TextModel(
            painterResource(id = R.drawable.language),
            "Language",
            "English"
        ),
        Icon2TextModel(
            painterResource(id = R.drawable.money),
            "Primary currency",
            "USD"
        ),
        Icon2TextModel(
            painterResource(id = R.drawable.numpad),
            "Numpad",
            "Classic"
        ),
        Icon2TextModel(
            painterResource(id = R.drawable.transfer),
            "Transfer",
            "Combine into one"
        )
    )

    UpperBarWithIconAndText(
        leadIcon = Icons.Default.ArrowBack,
        trailIcon = null,
        text = "Preferences"
    )

    LazyColumn(){
        items(list){
            PreferencesItem(
                modifier = modifier,
                it.icon,
                it.title,
                it.subtitle
            )
        }
    }

}

@Composable
fun PreferencesItem(
    modifier: Modifier = Modifier,
    painter: Painter,
    title: String,
    subtitle: String,
){
    Row {
        Icon(
            painter = painter,
            contentDescription = null
        )
        Column {
            Text(text = title)
            Text(text = subtitle)
        }
    }
}
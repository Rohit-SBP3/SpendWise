package com.example.spendwise.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.spendwise.R
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spendwise.model.Icon2TextModel

@Preview(showBackground = true)
@Composable
fun PreferencesScreen(modifier: Modifier = Modifier){

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

    Column(
        modifier = modifier.fillMaxSize()
    ){
        UpperBarWithIconAndText(
            leadIcon = Icons.Default.ArrowBack,
            trailIcon = null,
            text = "Preferences"
        )

        LazyColumn() {
            items(list) {
                PreferencesItem(
                    modifier = modifier,
                    it.icon,
                    it.title,
                    it.subtitle
                )
            }
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
    Row(
        modifier.padding(15.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painter = painter,
            contentDescription = null,
            modifier.size(30.dp)
        )
        Spacer(modifier = modifier.width(20.dp))
        Column {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.W400
            )
            Text(
                text = subtitle,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Open Pref",
            modifier.size(30.dp)
        )
    }
}
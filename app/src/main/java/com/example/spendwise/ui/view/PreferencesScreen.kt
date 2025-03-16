package com.example.spendwise.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import com.example.spendwise.model.Icon2TextModel

@Composable
fun PreferencesScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){

    val list: List<Icon2TextModel> = listOf(
        Icon2TextModel(
            icon = painterResource(id = R.drawable.brightness),
            title = "Theme",
            subtitle = "Light"
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.language),
            title = "Language",
            subtitle = "English"
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Primary currency",
            subtitle = "USD",
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.numpad),
            title = "Numpad",
            subtitle = "Classic"
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.transfer),
            title = "Transfer",
            subtitle = "Combine into one"
        )
    )

    Column(
        modifier = modifier.fillMaxSize()
    ){
        UpperBarWithIconAndText(
            leadIcon = Icons.Default.ArrowBack,
            trailIcon = null,
            text = "Preferences",
            navController = navController
        )

        LazyColumn() {
            items(list) {
                it.subtitle?.let { it1 ->
                    PreferencesItem(
                        modifier = modifier,
                        it.icon,
                        it.title,
                        it1
                    )
                }
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
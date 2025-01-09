package com.example.spendwise.ui.view

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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spendwise.R
import com.example.spendwise.model.ImageWithText

@Preview(showBackground = true)
@Composable
fun ProfileScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {
        ProfileSection()
        OptionSection(imageWithText = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.categories),
                text = "Categories"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.preference),
                text = "Preferences"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.backupsystem),
                text = "Backup"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.download),
                text = "Import"
            )
        ))
    }
}


@Composable
fun OptionSection(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
){
    LazyColumn(
        Modifier.padding(top = 30.dp)
    ){
        items(imageWithText){
            OptionItem(modifier, image = it.image, text = it.text)
        }
    }
}

@Composable
fun OptionItem(modifier: Modifier, image: Painter, text: String){
    Row(
        modifier.padding(20.dp).fillMaxWidth()
    ){
        Icon(
            painter = image,
            contentDescription = text,
            modifier = modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Profile",
            modifier = modifier.size(90.dp)
        )
        Text(
            text = "Default Profile",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
    }
}
package com.example.spendwise.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spendwise.R

@Preview(showBackground = true)
@Composable
fun ExportScreen(modifier: Modifier = Modifier){
    Column(
        modifier.fillMaxSize()
    ){
        UpperBarWithIconAndText(
            leadIcon = Icons.Default.ArrowBack,
            trailIcon = null,
            text = "Export"
        )
        ExportListItem(modifier = modifier)
    }
}

@Composable
fun ExportListItem(modifier: Modifier){
    Column(
        modifier
            .fillMaxSize()
            .padding(top = 10.dp, end = 10.dp, start = 10.dp),
        verticalArrangement = Arrangement.SpaceAround
    ){
        ExportItem(
            modifier = modifier,
            painter = painterResource(id = R.drawable.csv),
            title = "As CSV",
            subTitle = "Cannot be used for restore/import! Ideal for " +
                       "opening in software like Google Sheets"
        )
        ExportItem(
            modifier = modifier,
            painter = painterResource(id = R.drawable.jsonbackup),
            title = "As backup (json)",
            subTitle = "Can be restored later"
        )
        ExportItem(
            modifier = modifier,
            painter = painterResource(id = R.drawable.backuphistory),
            title = "Backup history",
            subTitle = "See backup made by you, and created automatically"
        )
    }
}

@Composable
fun ExportItem(modifier: Modifier, painter: Painter, title: String, subTitle: String){
    Column(
        modifier
            .fillMaxWidth()
            .height(225.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF0C0F3))
            .padding(20.dp)
    ) {
        Icon(
            painter = painter,
            contentDescription = "Type of Export",
            modifier.size(100.dp)
        )
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = modifier.height(7.dp))
        Text(
            text = subTitle,
            fontSize = 14.sp
        )
    }
}
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
import com.example.spendwise.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun ImportScreen(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ){
        UpperBarWithIconAndText(
            leadIcon = Icons.Default.ArrowBack,
            trailIcon = null,
            text = "Import"
        )
        Spacer(modifier = modifier.height(15.dp))
        RestoreImport(modifier)
    }
}

@Composable
fun RestoreImport(modifier: Modifier = Modifier){
   Column(
       modifier = modifier
           .fillMaxWidth()
           .height(240.dp)
           .clip(RoundedCornerShape(15.dp))
           .background(Color(0xFFF0C0F3))
           .padding(27.dp),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {

       Icon(
           painter = painterResource(id = R.drawable.jsonbackup),
           contentDescription = "Import Data",
           modifier.size(100.dp)
       )
       Spacer(modifier = modifier.height(10.dp))
       Text(
           text = "Select a file",
           fontSize = 20.sp,
           fontWeight = FontWeight.Bold,
           textAlign = TextAlign.Center
       )
       Spacer(modifier = modifier.height(10.dp))
       Text(
           text = "Pick a backup file to restore. Must be a JSON File",
           fontSize = 16.sp,
           textAlign = TextAlign.Center
       )

   }
}
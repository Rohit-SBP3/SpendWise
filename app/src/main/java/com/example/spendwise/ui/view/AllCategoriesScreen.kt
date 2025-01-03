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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spendwise.model.CategoryListModel

@Preview(showBackground = true)
@Composable
fun AllCategoriesScreen(modifier: Modifier = Modifier){

    val categoryList: List<CategoryListModel> = listOf(
        CategoryListModel(
            Icons.Default.Home,
            "Home",
            "$50.5"
        ),
        CategoryListModel(
            Icons.Default.Home,
        "Home",
        "$50.5"
        ),
        CategoryListModel(
            Icons.Default.Home,
            "Home",
            "$50.5"
        ),
        CategoryListModel(
            Icons.Default.Home,
            "Home",
            "$50.5"
        ),
        CategoryListModel(
            Icons.Default.Home,
            "Home",
            "$50.5"
        ),
        CategoryListModel(
            Icons.Default.Home,
            "Home",
            "$50.5"
        ),
        CategoryListModel(
            Icons.Default.Home,
            "Home",
            "$50.5"
        ),
        CategoryListModel(
            Icons.Default.Home,
            "Home",
            "$50.5"
        ),
        CategoryListModel(
            Icons.Default.Home,
            "Home",
            "$50.5"
        ),
        CategoryListModel(
            Icons.Default.Home,
            "Home",
            "$50.5"
        )
    );

    Column(
        modifier.fillMaxSize()
    ){
        BackIconWithText(modifier, "Categories")
        LazyColumn(modifier){
            items(categoryList){
                Column(
                    modifier
                        .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
                        .clip(RoundedCornerShape(15.dp))
                ) {
                    CategoryListItem(
                        text = it.text,
                        icon = it.icon,
                        price = it.price
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryListItem(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    price: String
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Cyan)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = icon,
            contentDescription = text,
            modifier.size(50.dp)
        )
        Spacer(modifier = modifier.width(20.dp))
        Column(

        ){
            Text(
                text = text,
                fontSize = 20.sp
            )
            Text(
                text = price,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun BackIconWithText(modifier: Modifier = Modifier, text:String){
    Row(
        modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Absolute.Left,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back Button",
            modifier.size(30.dp)
        )
        Spacer(modifier = modifier.width(20.dp))
        Text(
            text = text,
            fontSize = 26.sp
        )
    }
}
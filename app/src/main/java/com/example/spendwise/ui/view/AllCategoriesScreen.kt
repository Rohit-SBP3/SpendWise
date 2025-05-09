package com.example.spendwise.ui.view

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spendwise.R
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spendwise.model.Icon2TextModel
import com.example.spendwise.ui.theme.Blue80

@Composable
fun AllCategoriesScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){

    val categoryList: List<Icon2TextModel> = listOf(
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = "$50.5"
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = "$50.5"
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = "$50.5"
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = "$50.5"
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = "$50.5"
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = "$50.5"
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = "$50.5"
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = "$50.5"
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = "$50.5"
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = "$50.5"
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = "$50.5"
        )
    )

    Column(
        modifier.fillMaxSize()
    ){
        UpperBarWithIconAndText(
            leadIcon = Icons.Default.ArrowBack,
            trailIcon = null,
            text = "Categories",
            navController = navController
        )
        LazyColumn(modifier){
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFFF0C0F3)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Category",
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp)) // Optional spacing between icon and text
                    Text(
                        text = "Add a category",
                        fontSize = 20.sp
                    )
                }
            }
            items(categoryList){
                Column(
                    modifier
                        .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
                        .clip(RoundedCornerShape(15.dp))
                ) {
                    it.subtitle?.let { it1 ->
                        CategoryListItem(
                            text = it.title,
                            icon = it.icon,
                            price = it1
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryListItem(
    modifier: Modifier = Modifier,
    text: String,
    icon: Painter,
    price: String?
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Blue80)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painter = icon,
            contentDescription = text,
            modifier.size(40.dp)
        )
        Spacer(modifier = modifier.width(20.dp))
        Column(

        ){
            Text(
                text = text,
                fontSize = 18.sp
            )
            if(price != null) {
                Text(
                    text = price,
                    fontSize = 14.sp
                )
            }
        }
    }
}
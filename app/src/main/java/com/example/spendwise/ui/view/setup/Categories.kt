package com.example.spendwise.ui.view.setup

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spendwise.R
import com.example.spendwise.model.Icon2TextModel
import com.example.spendwise.ui.theme.Blue80
import com.example.spendwise.ui.view.CategoryListItem
import com.example.spendwise.ui.view.UpperBarWithIconAndText

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SetupCategoryScreen(modifier: Modifier = Modifier, navController: NavController) {

    val categoryList: List<Icon2TextModel> = listOf(
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = null
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = null
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = null
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = null
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = null
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = null
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = null
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = null
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = null
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = null
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = null
        ),
        Icon2TextModel(
            icon = painterResource(id = R.drawable.money),
            title = "Home",
            subtitle = null
        ),
    )

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        UpperBarWithIconAndText(
            leadIcon = Icons.Default.ArrowBack,
            trailIcon = null,
            text = "Categories",
            navController = navController
        )
        HintMessage(text = "Create categories, and/or add from the presents. You can change this later in \"profile > categories\" menu")
        LazyColumn(modifier.weight(1f)) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Blue80),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Category",
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp)) // Optional spacing between icon and text
                    Text(
                        text = "Add a category",
                        fontSize = 16.sp
                    )
                }
            }
            items(categoryList) {
                Column(
                    modifier
                        .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
                        .clip(RoundedCornerShape(15.dp))
                ) {
                    CategoryListItem(
                        icon = it.icon,
                        text = it.title,
                        price = null
                    )
                }
            }
        }
        LowerPanelWithButtonAndDots(
            pagerState = null,
            buttonText = "Next",
            navController = navController,
            onClick = { navController.navigate("home")}
        )
    }
}

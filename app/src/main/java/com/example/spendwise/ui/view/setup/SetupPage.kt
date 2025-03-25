package com.example.spendwise.ui.view.setup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spendwise.R
import com.example.spendwise.ui.theme.Blue80
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SetupPageInitialScreens(modifier: Modifier = Modifier, navController: NavController){
    Column{

        val pagerState = rememberPagerState(initialPage = 0) { 2 }

        HorizontalPager(
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> PageContent(
                    title = "SpendWise",
                    subtitle = "Your personal finance tracker",
                    icon = painterResource(id = R.drawable.wallet),
                    buttonText = "Next",
                    pagerState = pagerState,
                    navController = navController
                )
                1 -> PageContent(
                    title = "You own your data",
                    subtitle = "All of your data is stored only on device, with full export options available",
                    icon = painterResource(id = R.drawable.money),
                    buttonText = "Get Started",
                    pagerState = pagerState,
                    navController = navController
                )
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageContent(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    icon: Painter,
    buttonText: String,
    pagerState: PagerState,
    navController: NavController
){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Spacer(modifier = modifier.weight(1f))
        Icon(
            painter = icon,
            contentDescription = "App Logo",
            tint = Blue80,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = modifier.weight(1f))
        Column(
            modifier.padding(20.dp),
        ) {
            Text(
                text = title,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = subtitle,
                fontSize = 18.sp,
            )
            Spacer(modifier = Modifier.height(30.dp))
        }
        LowerPanelWithButtonAndDots(
            modifier = modifier,
            pagerState = pagerState,
            buttonText = buttonText,
            navController = navController,
            onClick = {}
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LowerPanelWithButtonAndDots(
    modifier: Modifier = Modifier,
    pagerState: PagerState?,
    buttonText: String,
    navController: NavController,
    onClick: (() -> Unit)
){

    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier.fillMaxWidth().padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(pagerState != null ) {
            DotsIndicator(totalDots = 2, selectedIndex = pagerState.currentPage)
            Button(
                onClick = {
                    if (pagerState.currentPage < 1) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    } else {
                        navController.navigate("name") {
                            popUpTo("category") { inclusive = true }
                        }
                    }
                }

            ) {
                Text(text = buttonText)
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Move forward"
                )
            }
        }else{
            Spacer(modifier = modifier.weight(1f))
            Button(
                onClick = { onClick() }) {
                Text(
                    text = buttonText
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Move forward"
                )
            }
        }
    }
}
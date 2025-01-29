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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spendwise.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun SetupPageInitialScreens(modifier: Modifier = Modifier){
    Column{

        val pagerState = rememberPagerState(initialPage = 1) { 2 }

        HorizontalPager(
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> PageContent(
                    title = "SpendWise",
                    subtitle = "Your personal finance tracker",
                    icon = painterResource(id = R.drawable.wallet),
                    buttonText = "Next",
                    pagerState = pagerState
                )
                1 -> PageContent(
                    title = "You own your data",
                    subtitle = "All of your data is stored only on device, with full export options available",
                    icon = painterResource(id = R.drawable.money),
                    buttonText = "Get Started",
                    pagerState = pagerState
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
    pagerState: PagerState
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
            tint = Color.Gray,
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
        LowerPanelWithButtonAndDots(modifier,pagerState, buttonText)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LowerPanelWithButtonAndDots(modifier: Modifier = Modifier, pagerState: PagerState?, buttonText: String){
    Row(
        modifier.fillMaxWidth().padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(pagerState != null ) {
            DotsIndicator(totalDots = 2, selectedIndex = pagerState.currentPage)
            Button(
                onClick = {
                    if (pagerState.currentPage < 2) {
                        CoroutineScope(Dispatchers.Main).launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                }) {
                Text(text = buttonText)
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Move forward"
                )
            }
        }else{
            Spacer(modifier = modifier.weight(1f))
            Button(
                onClick = {

                }) {
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
package com.example.spendwise.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.spendwise.R

@Composable
fun BottomNavBarApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { ScreenContent("Home Screen") }
            composable("search") { ScreenContent("Search Screen") }
            composable("profile") { ScreenContent("Profile Screen") }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        Screen.Home,
        Screen.Stats,
        Screen.Add,
        Screen.Wallet,
        Screen.Profile
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(20.dp)) 
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        NavigationBar{
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

            items.forEach { screen ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = screen.icon(),
                            contentDescription = "Icon",
                            modifier = Modifier.size(30.dp)
                        )
                    },
                    label = { Text(screen.label) },
                    selected = currentRoute == screen.route,
                    onClick = { navController.navigate(screen.route) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        indicatorColor = MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
    }
}

// Sealed class to define navigation items
sealed class Screen(val route: String, val label: String, val icon: @Composable () -> Painter) {
    object Home : Screen("home", "Home",  { painterResource(R.drawable.home) })
    object Stats : Screen("stat", "Stats",  { painterResource(R.drawable.barchart) })
    object Add : Screen("add", "Add",  { painterResource(R.drawable.add) })
    object Wallet : Screen("wallet", "Wallet", { painterResource(R.drawable.wallet) })
    object Profile : Screen("profile", "Profile",  { painterResource(R.drawable.user) })
}

@Composable
fun ScreenContent(text: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text)
    }
}

@Preview
@Composable
fun PreviewBottomNavBarApp() {
    BottomNavBarApp()
}
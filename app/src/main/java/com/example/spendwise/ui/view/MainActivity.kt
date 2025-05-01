package com.example.spendwise.ui.view

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spendwise.ui.theme.SpendWiseTheme
import com.example.spendwise.ui.view.setup.PhotoPickerBottomSheet
import com.example.spendwise.ui.view.setup.SetupAccountScreen
import com.example.spendwise.ui.view.setup.SetupCategoryScreen
import com.example.spendwise.ui.view.setup.SetupCurrencyScreen
import com.example.spendwise.ui.view.setup.SetupImageScreen
import com.example.spendwise.ui.view.setup.SetupNameScreen
import com.example.spendwise.ui.view.setup.SetupPageInitialScreens

class MainActivity : ComponentActivity(){
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpendWiseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //AppNav()
                    AddAccountScreen(navController = NavController(this))
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable fun AppNav(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "setup") {
        composable("setup") { SetupPageInitialScreens(navController = navController) }
        composable("name"){  SetupNameScreen(navController = navController) }
        composable("photo") { SetupImageScreen(navController = navController) }
        composable("currency") { SetupCurrencyScreen(navController = navController) }
        composable("account") { SetupAccountScreen(navController = navController) }
        composable("category") { (SetupCategoryScreen(navController = navController)) }
        composable("home") { BottomNavBarApp() }
        composable("photoPicker") { PhotoPickerBottomSheet(navController = navController) }
        composable("addAccountScreen") { AddAccountScreen(navController = navController) }
    }
}
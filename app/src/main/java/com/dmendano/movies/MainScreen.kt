package com.dmendano.movies

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dmendano.home_ui.FavouritesScreen
import com.dmendano.home_ui.HomeScreen
import com.dmendano.home_ui.SettingsScreen

sealed class BottomNavigationScreen(
    val route: String,
    @StringRes val title: Int,
    val icon: ImageVector
) {
    object Home :
        BottomNavigationScreen("Home", R.string.home, Icons.Default.Home)

    object Favourites :
        BottomNavigationScreen("Favourites", R.string.favourites, Icons.Default.Star)

    object Settings :
        BottomNavigationScreen("Settings", R.string.settings, Icons.Default.Settings)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomNavItems = listOf(
        BottomNavigationScreen.Home,
        BottomNavigationScreen.Favourites,
        BottomNavigationScreen.Settings
    )

    Scaffold(
        bottomBar = { BottomBar(navController, bottomNavItems) }
    ) {
        MainScreenNavConfigurations(navController)
    }
}

@Composable
fun MainScreenNavConfigurations(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavigationScreen.Home.route) {
        composable(BottomNavigationScreen.Home.route) { HomeScreen() }
        composable(BottomNavigationScreen.Favourites.route) { FavouritesScreen() }
        composable(BottomNavigationScreen.Settings.route) { SettingsScreen() }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    bottomNavItems: List<BottomNavigationScreen>
) {
    var currentRoute by remember { mutableStateOf(BottomNavigationScreen.Home.route) }
    BottomNavigation {
        bottomNavItems.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.icon, stringResource(id = screen.title)) },
                label = { Text(text = stringResource(id = screen.title)) },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        currentRoute = screen.route
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

package com.dmendano.movies.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dmendano.feature_home.FavouritesScreen
import com.dmendano.feature_home.HomeScreen
import com.dmendano.feature_home.HomeViewModel
import com.dmendano.feature_home.SearchScreen
import com.dmendano.movies.navigation.BottomNavigationScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomNavItems = listOf(
        BottomNavigationScreen.Home,
        BottomNavigationScreen.Search,
        BottomNavigationScreen.Favourites
    )

    Scaffold(
        bottomBar = { BottomBar(navController, bottomNavItems) }
    ) {
        MainScreenNavConfigurations(navController, it)
    }
}

@Composable
fun MainScreenNavConfigurations(
    navController: NavHostController,
    padding: PaddingValues
) {
    Box(Modifier.padding(padding)) {
        NavHost(
            navController = navController,
            startDestination = BottomNavigationScreen.Home.route
        ) {
            composable(BottomNavigationScreen.Home.route) { HomeScreen() }
            composable(BottomNavigationScreen.Search.route) { SearchScreen() }
            composable(BottomNavigationScreen.Favourites.route) { FavouritesScreen() }
        }
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

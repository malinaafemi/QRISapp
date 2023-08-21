package com.example.qrisapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.qrisapp.ui.nav.BottomNavGraph


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController)}
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.QRIS,
        BottomBarScreen.History
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation (
        backgroundColor = Color.White
    ) {
        screens.forEach{ screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController,
                iconColor = Color(android.graphics.Color.parseColor("#FF006d77")),
                textColor = Color(android.graphics.Color.parseColor("#FF006d77"))
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
    iconColor: Color,
    textColor: Color
) {
    BottomNavigationItem(
        label = {
            Text(
                text = screen.title,
                color = textColor
            )
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = "Navigation Icon",
                tint = iconColor
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route)
        }
    )
}

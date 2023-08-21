package com.example.qrisapp.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.qrisapp.ui.screens.QRScannerScreen
import com.example.qrisapp.ui.screens.BottomBarScreen
import com.example.qrisapp.ui.screens.HomeScreen
import com.example.qrisapp.ui.screens.TrHistoryScreen
import com.example.qrisapp.ui.vm.BalanceViewModel

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination =  BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(balanceViewModel = BalanceViewModel())
        }
        composable(route = BottomBarScreen.QRIS.route){
            QRScannerScreen()
        }
        composable(route = BottomBarScreen.History.route){
            TrHistoryScreen()
        }
    }
}
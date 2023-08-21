package com.example.qrisapp.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.qrisapp.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.baseline_home_24
    )
    object QRIS: BottomBarScreen(
        route = "qris",
        title = "QRIS",
        icon = R.drawable.baseline_qr_code_scanner_24
    )
    object History: BottomBarScreen(
        route = "history",
        title = "History",
        icon = R.drawable.baseline_receipt_long_24
    )
}

package com.example.qrisapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qrisapp.ui.vm.BalanceViewModel

@Composable
fun HomeScreen(balanceViewModel: BalanceViewModel) {
    val userBalance = balanceViewModel.userBalance.value?.balance ?: "0"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Your Balance",
            fontSize = 16.sp,
            color = Color(0xFFE76F51),
            textAlign = TextAlign.Center

        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Rp$userBalance",
            fontSize = 30.sp,
            color = Color(0xFF006D77),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    val previewBalanceViewModel = BalanceViewModel()
    HomeScreen(balanceViewModel = previewBalanceViewModel)
}
package com.example.qrisapp.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.qrisapp.R
import com.example.qrisapp.ui.vm.QRViewModel

@Composable
fun QRScannerScreen(viewModel: QRViewModel = hiltViewModel()) {

    val state = viewModel.state.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
            text = state.value.details
        )
        Image(
            painter = painterResource(id = R.drawable.img_qr),
            contentDescription = null)
        Button(
            onClick = viewModel::startScanning,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFe76f51),
                contentColor = Color.White
            ),
            modifier = Modifier
                .width(300.dp)
                .height(50.dp)
        ) {
            Text(text = "Scan QR Code")
        }
    }

}
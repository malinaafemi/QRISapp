package com.example.qrisapp.domain.repo

import kotlinx.coroutines.flow.Flow


interface QRRepo {
    fun startScanning() : Flow<String?>
}
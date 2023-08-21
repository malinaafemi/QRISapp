package com.example.qrisapp.data.repo

import com.example.qrisapp.domain.repo.QRRepo
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class QRRepoImpl @Inject constructor(
    private val scanner: GmsBarcodeScanner
): QRRepo {

    override fun startScanning(): Flow<String?> {

        return callbackFlow {
            scanner.startScan()
                .addOnSuccessListener { barcode ->
                    launch {
                        barcode.rawValue
                        send(getDetails(barcode))
                    }
                }
                .addOnFailureListener {
                    it.printStackTrace()
                }

            awaitClose {  }
        }

    }

    private fun getDetails(barcode: Barcode):String{

        return when(barcode.valueType){
            Barcode.TYPE_WIFI -> {
                val ssid = barcode.wifi!!.ssid
                val password = barcode.wifi!!.password
                val type = barcode.wifi!!.encryptionType
                "ssid : $ssid, password : $password, type : $type"
            }
            Barcode.TYPE_URL -> {
                "url : ${barcode.url!!.url}"
            }
            Barcode.TYPE_PRODUCT -> {
                "productType : ${barcode.displayValue}"
            }
            Barcode.TYPE_EMAIL -> {
                "email : ${barcode.email}"
            }
            Barcode.TYPE_CONTACT_INFO -> {
                "contact : ${barcode.contactInfo}"
            }
            Barcode.TYPE_PHONE -> {
                "phone : ${barcode.phone}"
            }
            Barcode.TYPE_CALENDAR_EVENT -> {
                "calender event : ${barcode.calendarEvent}"
            }
            Barcode.TYPE_GEO -> {
                "geo point : ${barcode.geoPoint}"
            }
            Barcode.TYPE_ISBN -> {
                "isbn : ${barcode.displayValue}"
            }
            Barcode.TYPE_DRIVER_LICENSE -> {
                "driving license : ${barcode.driverLicense}"
            }
            Barcode.TYPE_SMS -> {
                "sms : ${barcode.sms}"
            }
            Barcode.TYPE_TEXT -> {
                val blocks = splitRawValue(barcode.rawValue)

                if (blocks.size == 4) {
                    val transactionId = blocks[1]
                    val merchantName = blocks[2]
                    val transactionNominal = blocks[3]

                    "$transactionId\nMerchant Name: $merchantName\nTransaction Nominal: Rp$transactionNominal"
                } else {
                    "Invalid QR code format"
                }
            }
            Barcode.TYPE_UNKNOWN -> {
                "unknown: ${barcode.rawValue}"
            }
            else -> {
                barcode.rawValue ?: "Couldn't determine"
            }
        }
    }

    private fun splitRawValue(rawValue: String?): List<String> {
        return rawValue?.split(".") ?: emptyList()
    }

}


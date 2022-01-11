package com.labcnt.usdEurConverter

import okhttp3.OkHttpClient
import org.springframework.stereotype.Service

@Service
class Service {
    private val appId = "22cc04af4d714aa981df2690f6439387"
    private val client = OkHttpClient()

    fun convertUsdToEur(number: Double) : Double {
        if (number > 0) return number * ApiOpenExchangeRates().getUSDtoEUR(appId, client)
        else throw IllegalArgumentException("enter a positive number")
    }

    fun convertEurToUsd(number: Double) : Double {
        if (number > 0) return number / ApiOpenExchangeRates().getUSDtoEUR(appId, client)
        else throw IllegalArgumentException("enter a positive number")
    }
}
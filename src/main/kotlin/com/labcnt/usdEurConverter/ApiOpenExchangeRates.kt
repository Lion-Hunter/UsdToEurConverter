package com.labcnt.usdEurConverter

import com.beust.klaxon.Klaxon
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class ApiOpenExchangeRates {
    private val appId = "22cc04af4d714aa981df2690f6439387"
    private val client = OkHttpClient()

    fun getUSDtoEUR(): Double {
        val request = Request.Builder()
            .url("https://openexchangerates.org/api/latest.json?app_id=$appId")
            .build()

        var resp: String

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            resp = response.body()!!.string()
        }

        if (resp.isEmpty()) {
            throw IOException("Response is empty")
        }

        val result = Klaxon()
            .parse<ApiRequestResponse>(resp)

        return result!!.rates.eur
    }
}
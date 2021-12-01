package com.labcnt.usdEurConverter

import com.beust.klaxon.*


data class Rates(
    @Json(name = "EUR")
    val eur: Double
)

data class ApiRequestResponse(
    @Json(name = "rates")
    val rates: Rates
)
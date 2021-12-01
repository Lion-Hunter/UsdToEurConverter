package com.labcnt.usdEurConverter

import org.springframework.stereotype.Service

@Service
class Service {
    fun convertUsdToEur(count: Double) = count * ApiOpenExchangeRates().getUSDtoEUR()

    fun convertEurToUsd(count: Double) = count / ApiOpenExchangeRates().getUSDtoEUR()
}
package com.labcnt.usdEurConverter
import okhttp3.OkHttpClient
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.function.Executable
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import java.io.IOException

@SpringBootTest
class ConverterTests {
    val appId = "22cc04af4d714aa981df2690f6439387"
    val client = OkHttpClient()
    val openEx = ApiOpenExchangeRates()
    private val service = Service()
    val controller = Controller(service)

    @Test
    fun connectCorrectly() {
        assertNotNull(openEx.getUSDtoEUR(appId, client))
    }

    @Test
    fun connectIncorrectly() {
        assertThrows(IOException::class.java) { openEx.getUSDtoEUR("wrongIp32132124219218y3", client) }
    }

    @Test
    fun convertEtoUCorrectly() {
        val count = 20.9832
        val x = openEx.getUSDtoEUR(appId, client)
        val expectedCount = count / x
        assertEquals(expectedCount, controller.convertEurToUsd(count.toString()).body!!)
    }

    @Test
    fun convertUtoECorrectly() {
        val count = 193
        val x = openEx.getUSDtoEUR(appId, client)
        val expectedCount = count * x
        assertEquals(expectedCount, controller.convertUsdToEur(count.toString()).body!!)
    }

    @Test
    fun convertIncorrectly() {
        val count = -837.021
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, controller.convertUsdToEur(count.toString()).statusCode)
    }
}

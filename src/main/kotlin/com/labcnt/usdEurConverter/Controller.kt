package com.labcnt.usdEurConverter

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController("/")
class Controller(private val service: Service) {
    @GetMapping("/UtoE")
    @ResponseBody
    fun convertUsdToEur(@RequestParam param: String): ResponseEntity<Double> {
        val count = param.toDouble()
        val responseHeaders = HttpHeaders()
        val result: Double

        try {
            result = service.convertUsdToEur(count)
        } catch (e: Exception) {
            println("API Error: ${e.message}")
            return ResponseEntity(null, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR)
        }

        return ResponseEntity(result, responseHeaders, HttpStatus.OK)
    }

    @GetMapping("/EtoU")
    fun convertEurToUsd(@RequestParam param: String): ResponseEntity<Double> {
        val count = param.toDouble()
        val responseHeaders = HttpHeaders()
        val result: Double

        try {
            result = service.convertEurToUsd(count)
        } catch (e: Exception) {
            println("API Error: ${e.message}")
            return ResponseEntity(null, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR)
        }

        return ResponseEntity(result, responseHeaders, HttpStatus.OK)
    }
}
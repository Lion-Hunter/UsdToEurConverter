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
        return null
    }

    @GetMapping("/EtoU")
    @ResponseBody
    fun convertEurToUsd(@RequestParam param: String): ResponseEntity<Double> {
        return null
    }
}

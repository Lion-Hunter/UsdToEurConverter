package com.labcnt.usdEurConverter

import com.beust.klaxon.Klaxon
import org.apache.tomcat.util.json.JSONParser
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UsdToEurConverterApplication

fun main() {
    runApplication<UsdToEurConverterApplication>()
}

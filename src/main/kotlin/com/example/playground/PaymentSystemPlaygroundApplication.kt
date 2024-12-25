package com.example.playground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PaymentSystemPlaygroundApplication

fun main(args: Array<String>) {
    runApplication<PaymentSystemPlaygroundApplication>(*args)
}

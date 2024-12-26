package com.example.playground.payment.adapter.outbound.web.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "toss")
data class TossProperties(
    val url: String,
    val secretKey: String,
)
package com.example.playground.payment.adapter.inbound.web.request

data class TossPaymentConfirmRequest(
    val paymentKey: String,
    val orderId: String,
    val amount: Long,
)
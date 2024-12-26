package com.example.playground.payment.adapter.outbound.web.executor

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class TossPaymentExecutor(
    private val tossPaymentWebClient: WebClient,
) {
    fun execute(paymentKey: String, orderId: String, amount: String): Mono<String> {
        return tossPaymentWebClient.post()
            .uri("/v1/payments/confirm")
            .bodyValue("""
                {
                    "paymentKey": "$paymentKey",
                    "orderId": "$orderId",
                    "amount": $amount
                }
            """.trimIndent()
            )
            .retrieve()
            .bodyToMono(String::class.java)
    }
}
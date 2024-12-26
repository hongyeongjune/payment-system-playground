package com.example.playground.payment.adapter.inbound.web.api

import com.example.playground.payment.adapter.inbound.web.request.TossPaymentConfirmRequest
import com.example.playground.payment.adapter.inbound.web.response.ApiResponse
import com.example.playground.payment.adapter.outbound.web.executor.TossPaymentExecutor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class TossPaymentController(
    private val tossPaymentExecutor: TossPaymentExecutor,
) {
    @PostMapping("/v1/toss/confirm")
    fun confirm(@RequestBody request: TossPaymentConfirmRequest): Mono<ResponseEntity<ApiResponse<String>>> {
        return tossPaymentExecutor
            .execute(
                paymentKey = request.paymentKey,
                orderId = request.orderId,
                amount = request.amount.toString(),
            )
            .map { ResponseEntity.ok().body(ApiResponse.of(HttpStatus.OK, "OK", it)) }
    }
}
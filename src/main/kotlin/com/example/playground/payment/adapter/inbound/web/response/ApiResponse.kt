package com.example.playground.payment.adapter.inbound.web.response

import org.springframework.http.HttpStatus

data class ApiResponse<T> (
    val status: Int,
    val message: String,
    val data: T?,
) {
    companion object {
        fun <T> of(httpStatus: HttpStatus, message: String, data: T?): ApiResponse<T> {
            return ApiResponse(httpStatus.value(), message, data)
        }
    }
}
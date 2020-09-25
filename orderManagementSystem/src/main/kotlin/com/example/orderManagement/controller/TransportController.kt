package com.example.orderManagement.controller

import com.example.orderManagement.product.Transport
import com.example.orderManagement.productRepository.TransportRepository
import com.example.orderManagement.service.TransportService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class TransportController(private val tServ: TransportService) {

    @GetMapping("/transport/{orderId}")
    fun fetchByOrderId(@PathVariable(value = "orderId") orderId: Int): ResponseEntity<String> {
        return ResponseEntity.ok().body(tServ.getTransportByOrderId(orderId))
    }

}
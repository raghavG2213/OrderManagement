package com.example.orderManagement.productRepository

import com.example.orderManagement.product.OrderDetails
import com.example.orderManagement.product.Transport
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface TransportRepository : JpaRepository<Transport, Int>{
    fun findByorder(order: OrderDetails?): Transport
}

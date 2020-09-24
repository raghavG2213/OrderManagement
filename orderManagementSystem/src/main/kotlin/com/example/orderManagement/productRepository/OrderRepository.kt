package com.example.orderManagement.productRepository

import com.example.orderManagement.product.OrderDetails
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<OrderDetails, Int>
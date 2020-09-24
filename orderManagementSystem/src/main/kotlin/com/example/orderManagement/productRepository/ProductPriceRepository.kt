package com.example.orderManagement.productRepository

import com.example.orderManagement.product.ProductPrice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ProductPriceRepository: JpaRepository<ProductPrice, Int>{
    fun findAmtByProductId(@Param("pId") pId: Int?): Double
}
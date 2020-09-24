package com.example.orderManagement.dao

import com.example.orderManagement.product.ProductPrice
import com.example.orderManagement.productRepository.ProductPriceRepository
import org.springframework.stereotype.Repository

@Repository
class ProductPriceDao (private val pPRep: ProductPriceRepository) {
    fun addProdPrice(price: ProductPrice){
        pPRep.save(price)
    }
    fun getPriceByID(id:Int) = pPRep.findAmtByProductId(id)

}
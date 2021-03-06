package com.example.orderManagement.service

import com.example.orderManagement.dao.ProductPriceDao
import com.example.orderManagement.product.ProductPrice
import org.springframework.stereotype.Service

@Service
class ProductPriceService(private val pPDao:ProductPriceDao)
{
    fun addProductPrice(prod: ProductPrice) = pPDao.addProdPrice(prod)
}
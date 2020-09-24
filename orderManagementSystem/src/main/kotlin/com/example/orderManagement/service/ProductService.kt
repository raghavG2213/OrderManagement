package com.example.orderManagement.service

import com.example.orderManagement.dao.ProductDao
import com.example.orderManagement.product.Product
import org.springframework.stereotype.Service
import java.time.LocalDate
@Service
class ProductService(private val pDao:ProductDao)
{
    fun createNewProduct(prod: Product) = pDao.createNewProduct(prod)
    fun getProdByQty(id:Int,qty:Int):String{
        val result = when {
            pDao.getProdByQty(id) == null -> {
                "Product with $id doesn't exist"
            }
            pDao.getProdByQty(id).QTY < qty -> {
                "Product with $id doesn't has sufficient quantity"
            }
            pDao.getProdByQty(id).VALID_TO < java.sql.Date.valueOf(LocalDate.now())  -> {
                "Product with $id is not valid"
            }
            else -> {
                pDao.getProdByQty(id).toString()
            }
        }
        return result
    }
}
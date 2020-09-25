package com.example.orderManagement.service

import com.example.orderManagement.dao.ProductDao
import com.example.orderManagement.dao.ProductPriceDao
import com.example.orderManagement.product.Product
import org.springframework.stereotype.Service
import java.sql.Date
import java.time.LocalDate
@Service
class ProductService(private val pDao:ProductDao,private val pPDao:ProductPriceDao)
{
    companion object {
        fun prodAvail(id: Int, qty: Int, prod: Product): String {
            return when {
                prod == null -> {
                    "Product with $id doesn't exist"
                }
                prod.QTY < qty -> {
                    "Product with $id doesn't has sufficient quantity"
                }
                prod.VALID_TO < Date.valueOf(LocalDate.now()) && prod.VALID_FROM > Date.valueOf(LocalDate.now()) -> {
                    "Product with $id is not valid"
                }
                else -> {
                    "Product Available"
                }
            }
        }
    }
    //fun createNewProduct(prod: Product) = pDao.createNewProduct(prod)
    fun getProdByQty(id:Int,qty:Int):String{
        val prod = pDao.getProdById(id)
        var result = prodAvail(id,qty,prod)
        return when (result) {
            "Product Available" -> prod.toString()
            else -> result
        }

    }

    fun getTotalPrice(id: Int,qty:Int):String {

        val prod = pDao.getProdById(id)
        var result = prodAvail(id,qty,prod)
        return when (result) {
            "Product Available" -> {
                val totalPrice = qty * pPDao.getPriceByID(pDao.getProdById(id)).AMOUNT
                return totalPrice.toString()
            }
            else -> result
        }

    }
}
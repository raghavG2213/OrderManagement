package com.example.orderManagement.service

import com.example.orderManagement.dao.ProductDao
import com.example.orderManagement.dao.ProductPriceDao
import com.example.orderManagement.product.Product
import org.springframework.stereotype.Service
import java.time.LocalDate
@Service
class ProductService(private val pDao:ProductDao,private val pPDao:ProductPriceDao)
{
    companion object {
        fun prodAvail(id: Int, qty: Int, prod: Product): String {
            var result = when {
                prod == null -> {
                    "Product with $id doesn't exist"
                }
                prod.QTY < qty -> {
                    "Product with $id doesn't has sufficient quantity"
                }
                prod.VALID_TO < java.sql.Date.valueOf(LocalDate.now()) && prod.VALID_FROM > java.sql.Date.valueOf(LocalDate.now()) -> {
                    "Product with $id is not valid"
                }
                else -> {
                    "Product Available"
                }
            }
            return result.toString()
        }
    }
    fun createNewProduct(prod: Product) = pDao.createNewProduct(prod)
    fun getProdByQty(id:Int,qty:Int):String{
        val result = when {
            pDao.getProdById(id) == null -> {
                "Product with $id doesn't exist"
            }
            pDao.getProdById(id).QTY < qty -> {
                "Product with $id doesn't has sufficient quantity"
            }
            pDao.getProdById(id).VALID_TO < java.sql.Date.valueOf(LocalDate.now())  -> {
                "Product with $id is not valid"
            }
            else -> {
                pDao.getProdById(id).toString()
            }
        }
        return result
    }

    fun getTotalPrice(id: Int,qty:Int):String {
        val result = when {
            pDao.getProdById(id) == null -> {
                "Product with $id doesn't exist"
            }
            pDao.getProdById(id).QTY < qty -> {
                "Product with $id doesn't has sufficient quantity"
            }
            pDao.getProdById(id).VALID_TO < java.sql.Date.valueOf(LocalDate.now()) && pDao.getProdById(id).VALID_FROM > java.sql.Date.valueOf(LocalDate.now()) -> {
                "Product with $id is not valid"
            }
            else -> {
                val totalPrice = qty * pPDao.getPriceByID(pDao.getProdById(id)).AMOUNT
                return totalPrice.toString()
            }
        }
        return result
    }
}
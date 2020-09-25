package com.example.orderManagement.service

import com.example.orderManagement.dao.OrderDao
import com.example.orderManagement.dao.ProductDao
import com.example.orderManagement.dao.ProductPriceDao
import com.example.orderManagement.dao.TransportDao
import com.example.orderManagement.product.OrderDetails
import com.example.orderManagement.product.Transport
import org.springframework.stereotype.Service
import java.time.LocalDate
@Service
class OrderService(private val oDao: OrderDao, private val pDao: ProductDao, private val pPDao:ProductPriceDao, private val tDao:TransportDao)
{
    fun createNewOrder(id: Int, qty:Int):String {
        //var prodID = order.PRODUCT_ID
        val result = ProductService.prodAvail(id,qty,pDao.getProdById(id))
        return when(result){
            "Product Available" ->{
                val totalPrice = qty * pPDao.getPriceByID(pDao.getProdById(id)).AMOUNT
                val order:OrderDetails = oDao.createNewOrder(OrderDetails(0,id,totalPrice))
                tDao.createNewTransportRequest(Transport(0,order,0,"Order Placed",java.sql.Date.valueOf(LocalDate.now()),null))
                pDao.updateQuantity(id,pDao.getProdById(id).QTY - qty)
                order.toString()
            }
            else -> result.toString()
        }

    }
    fun getOrderByID(id:Int):String{
        val result = when {
            oDao.getOrderById(id) == null ->{
                "Order with $id not found"
            }
            else ->{
                oDao.getOrderById(id).toString()
            }
        }
        return result
    }
}
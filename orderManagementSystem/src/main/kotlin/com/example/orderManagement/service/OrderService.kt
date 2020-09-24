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
    fun createNewOrder(id: Int,qty:Int):String {
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
                val totalPrice = qty * pPDao.getPriceByID(id)
                val order:OrderDetails = oDao.createNewOrder(OrderDetails(0,id,totalPrice))
                tDao.createNewTransportRequest(Transport(0,order.ORDER_ID,0,"Order Placed",java.sql.Date.valueOf(LocalDate.now()),null))
                order.toString()
            }
        }
        return result
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
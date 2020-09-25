package com.example.orderManagement.service

import com.example.orderManagement.dao.OrderDao
import com.example.orderManagement.dao.TransportDao
import org.springframework.stereotype.Service

@Service
class TransportService(private val tDao:TransportDao, private val oDao: OrderDao)
{
    fun getTransportByOrderId(id: Int):String {

        val response = tDao.getTransportByOrderId(oDao.getOrderById(id)?: 0)
        return response.toString()
    }
}
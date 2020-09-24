package com.example.orderManagement.service

import com.example.orderManagement.dao.TransportDao
import org.springframework.stereotype.Service

@Service
class TransportService(private val tDao:TransportDao)
{
    fun getTransportByOrderId(id: Int):String {
        val response = tDao.getTransportByOrderId(id)
        return response.toString()
    }
}
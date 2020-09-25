package com.example.orderManagement.dao
import com.example.orderManagement.product.OrderDetails
import org.springframework.stereotype.Repository
import com.example.orderManagement.productRepository.OrderRepository
import org.springframework.data.repository.findByIdOrNull

@Repository
class OrderDao(private val oRep:OrderRepository){
    fun createNewOrder(ord: OrderDetails):OrderDetails {
        return oRep.save(ord)
    }
    fun getOrderById(id:Int):OrderDetails?{
       return oRep.findByIdOrNull(id)
    }
}
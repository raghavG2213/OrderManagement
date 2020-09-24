package com.example.orderManagement.dao
import com.example.orderManagement.product.Transport
import org.springframework.stereotype.Repository
import com.example.orderManagement.productRepository.TransportRepository


@Repository
class TransportDao(private val tRep:TransportRepository){
    fun createNewTransportRequest(trans: Transport) {
        tRep.save(trans)
    }
    fun getTransportByOrderId(id:Int) = tRep.fetchByOrderId(id)

}

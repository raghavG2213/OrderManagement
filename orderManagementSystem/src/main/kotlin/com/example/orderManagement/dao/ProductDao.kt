package com.example.orderManagement.dao
import com.example.orderManagement.product.Product
import org.springframework.stereotype.Repository
import com.example.orderManagement.productRepository.ProductRepository

@Repository
class ProductDao(private val pRep:ProductRepository){

    fun createNewProduct(prod: Product) = pRep.save(prod)

    fun getProdById(id:Int):Product{
        return pRep.findById(id).orElse(null)
    }

    fun updateQuantity(id: Int, updatedQty: Int) {
        pRep.updateQty(id,updatedQty)
    }
}


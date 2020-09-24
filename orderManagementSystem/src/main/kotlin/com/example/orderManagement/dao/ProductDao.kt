package com.example.orderManagement.dao
import com.example.orderManagement.product.Product
import org.springframework.stereotype.Repository
import com.example.orderManagement.productRepository.ProductRepository

@Repository
class ProductDao(private val pRep:ProductRepository){

    fun createNewProduct(prod: Product) = pRep.save(prod)

    fun getProdByQty(id:Int):Product{
        return pRep.findById(id).orElse(null)
    }
}


package com.example.orderManagement.controller
import com.example.orderManagement.product.Product
import com.example.orderManagement.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ProductController(private val pServ:ProductService) {

    @GetMapping("/product/{id}/{quantity}")
    fun getProductByQty(@PathVariable(value = "id") id:Int,@PathVariable(value = "quantity") qty:Int): ResponseEntity<String>  {
        return ResponseEntity.ok().body(pServ.getProdByQty(id,qty))
    }

    @GetMapping("/totalPrice/{id}/{quantity}")
    fun getTotalPrice(@PathVariable(value = "id") id:Int,@PathVariable(value = "quantity") qty:Int): ResponseEntity<String>  {
        return ResponseEntity.ok().body(pServ.getTotalPrice(id,qty))
    }
}
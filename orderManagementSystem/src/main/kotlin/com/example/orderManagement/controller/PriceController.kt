package com.example.orderManagement.controller
import com.example.orderManagement.product.ProductPrice
import com.example.orderManagement.service.ProductPriceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PriceController(private val pPServ:ProductPriceService) {
    @PostMapping("/price")
    fun createNewProduct(@Valid @RequestBody prod: ProductPrice):ResponseEntity<String> {
        pPServ.addProductPrice(prod)
        return ResponseEntity.ok().body("Price Added Successfully")
    }
}
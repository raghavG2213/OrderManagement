package com.example.orderManagement.controller
import com.example.orderManagement.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class OrderController(private val oServ:OrderService) {
    @PostMapping("/order/{id}/{quantity}")
    fun createNewOrder(@PathVariable(value = "id") id:Int,@PathVariable(value = "quantity") qty:Int) =
            ResponseEntity.ok().body(oServ.createNewOrder(id,qty))
    @GetMapping("/order/{id}")
    fun getProductByQty(@PathVariable(value = "id") id:Int): ResponseEntity<String>  {
        return ResponseEntity.ok().body(oServ.getOrderByID(id))
    }
}
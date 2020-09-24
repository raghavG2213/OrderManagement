package com.example.orderManagement.product

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
data class OrderDetails (
        @Id @GeneratedValue(strategy=GenerationType.AUTO)
        var ORDER_ID: Int = 0,
        @NotNull
        var PRODUCT_ID: Int = 0,
        @NotNull
        var TOTAL_PRICE: Double = 0.0

)
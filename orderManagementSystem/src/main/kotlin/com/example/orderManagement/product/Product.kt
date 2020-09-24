package com.example.orderManagement.product

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Product (
        @Id
        var PRODUCT_ID: Int = 0,
        @get: NotBlank
        var NAME: String = "",
        var DESCRIPT: String = "",
        @get: NotBlank
        var CATEGORY: String = "",
        @NotNull
        var VALID_FROM: Date = Date(),
        @NotNull
        var VALID_TO: Date = Date(),
        @NotNull
        var QTY: Int = 0
)
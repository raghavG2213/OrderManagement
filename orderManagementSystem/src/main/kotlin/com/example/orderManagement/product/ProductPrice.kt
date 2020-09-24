package com.example.orderManagement.product
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name="PRODUCT_PRICE", schema="ahold")
@NamedQuery(name="ProductPrice.findAmtByProductId", query="SELECT p.AMOUNT FROM ProductPrice p WHERE p.PRODUCT_ID = :pId")
data class ProductPrice (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var ID:Int = 0,
        @NotNull
        var PRODUCT_ID: Int = 0,
        @NotNull
        var AMOUNT: Double = 0.0,
        @get: NotBlank
        var CURRENCY: String = "",
        @NotNull
        var VALID_FROM: Date = Date(),
        @NotNull
        var VALID_TO: Date? = Date()
        )
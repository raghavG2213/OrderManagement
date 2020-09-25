package com.example.orderManagement.product
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name="PRODUCT_PRICE", schema="ahold")
data class ProductPrice (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var ID:Int = 0,
        @OneToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "PRODUCT_ID")
        var prod: Product,
        @NotNull
        var AMOUNT: Double = 0.0,
        @get: NotBlank
        var CURRENCY: String = "",
        @NotNull
        var VALID_FROM: Date = Date(),
        @NotNull
        var VALID_TO: Date? = Date()
        )
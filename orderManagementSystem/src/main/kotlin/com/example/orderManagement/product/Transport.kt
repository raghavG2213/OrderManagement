package com.example.orderManagement.product

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "TRANSPORT", schema="ahold")
data class Transport (
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
        var ID: Int = 0,
        @NotNull
        var orderId: Int,
        @NotNull
        var STAGE_ID: Int = 0,
        @get: NotBlank
        var STATUS: String = " ",
        @NotNull
        var START_TIME: Date = Date(),
        var END_TIME: Date? = Date()
        )
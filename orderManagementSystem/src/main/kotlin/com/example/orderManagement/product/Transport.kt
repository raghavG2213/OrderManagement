package com.example.orderManagement.product

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "TRANSPORT", schema="ahold")
@NamedQuery(name = "Transport.fetchByOrderId", query = "SELECT e FROM Transport e WHERE e.ORDER_ID =:orderId")
data class Transport (
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
        var ID: Int = 0,
        @NotNull
        var ORDER_ID: Int = 0,
        @NotNull
        var STAGE_ID: Int = 0,
        @get: NotBlank
        var STATUS: String = " ",
        @NotNull
        var START_TIME: Date = Date(),
        var END_TIME_TIME: Date? = Date()
        )
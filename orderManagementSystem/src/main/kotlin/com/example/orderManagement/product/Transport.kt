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
        @OneToOne(cascade= [CascadeType.ALL])
        @JoinColumn(name = "ORDER_ID")
        var order:OrderDetails,
        @NotNull
        var STAGE_ID: Int = 0,
        @get: NotBlank
        var STATUS: String = " ",
        @NotNull
        var START_TIME: Date = Date(),
        var END_TIME_TIME: Date? = Date()
        )
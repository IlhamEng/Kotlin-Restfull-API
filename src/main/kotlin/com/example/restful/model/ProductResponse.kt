package com.example.restful.model

import jakarta.persistence.Column
import jakarta.persistence.Id
import java.util.*

data class ProductResponse(

    val id: String,

    val name: String,

    val price: Long,

    val quantity: Int,

    val createdAt: Date,

    val updateAt: Date?
)

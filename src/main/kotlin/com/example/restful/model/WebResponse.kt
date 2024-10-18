package com.example.restful.model

import java.util.Date

data class WebResponse<T>(
    val code: Int,
    val status: String,
    val date: T
)
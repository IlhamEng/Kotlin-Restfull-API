package com.example.restful.service

import com.example.restful.model.CreateProductRequest
import com.example.restful.model.ListProductRequest
import com.example.restful.model.ProductResponse
import com.example.restful.model.UpdateProductRequest

interface ProductService {
    fun create(createProductRequest: CreateProductRequest): ProductResponse;
    fun get(id: String): ProductResponse;
    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse
    fun delete(id: String)
    fun list(listProductRequest: ListProductRequest): List<ProductResponse>
}
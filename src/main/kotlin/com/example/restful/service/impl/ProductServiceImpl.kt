package com.example.restful.service.impl

import com.example.restful.entity.Product
import com.example.restful.error.NotFoundException
import com.example.restful.model.CreateProductRequest
import com.example.restful.model.ListProductRequest
import com.example.restful.model.ProductResponse
import com.example.restful.model.UpdateProductRequest
import com.example.restful.repository.ProductRepository
import com.example.restful.service.ProductService
import com.example.restful.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val validationUtil: ValidationUtil
    ): ProductService {

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest)
        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price!!,
            quantity = createProductRequest.quantity!!,
            createdAt = Date(),
            updateAt = null
        )
        productRepository.save(product)
        return convertProductToProductResponse(product)
    }

    override fun get(id: String): ProductResponse {
       val product = findProductByIdOrThrowNotFound(id)
        return convertProductToProductResponse(product)
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
       val product = findProductByIdOrThrowNotFound(id)
        validationUtil.validate(updateProductRequest)
           product.apply {
               name = updateProductRequest.name!!
               price = updateProductRequest.price!!
               quantity = updateProductRequest.quantity!!
               updateAt = Date()
           }
            productRepository.save(product)
            return convertProductToProductResponse(product)
    }

    override fun delete(id: String) {
       val product = findProductByIdOrThrowNotFound(id)
        productRepository.delete(product)
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
        val products: List<Product> = page.get().collect(Collectors.toList())

        return products.map { convertProductToProductResponse(it) }
    }

    private fun findProductByIdOrThrowNotFound(id: String): Product {
        val product = productRepository.findByIdOrNull(id)
        if (product == null) {
            throw NotFoundException()
        }else {
            return product
        }
    }

    private fun convertProductToProductResponse(product: Product): ProductResponse{
        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updateAt = product.updateAt
        )
    }
}

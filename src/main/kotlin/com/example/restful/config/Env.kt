package com.example.restful.config

class Env {
    companion object {
        val SPRING_SECRET_KEY = System.getenv("KEY")!!
    }
}
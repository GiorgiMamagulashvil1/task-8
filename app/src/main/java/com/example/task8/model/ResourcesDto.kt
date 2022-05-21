package com.example.task8.model

data class ResourcesDto(
    val data: List<Resources>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)
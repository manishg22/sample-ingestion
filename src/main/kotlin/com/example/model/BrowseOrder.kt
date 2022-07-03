package com.example.model

data class BrowseOrder(
    val id: String,
    val parent_category_id: Long,
    val category_id: Long,
    val pimid: Long,
    val leaf: Boolean,
    val productName: String,
    val browse_order: Long,
    val auto_ordered: Boolean
)

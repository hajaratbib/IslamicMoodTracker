package com.example.compose

data class DhikrUi(
    val id: Int,
    val title: String? = null,
    val text: String,
    val desc: String? = null,
    val remaining: Int
)
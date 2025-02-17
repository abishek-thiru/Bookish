package com.abi.bookish.book.domain

data class Book(
    val id: String,
    val title: String,
    val imageUrl: String,
    val authors: List<String>,
    val description: String?,
    val languages: List<String>,
    val firstPublished: String?,
    val avgRatings: Double?,
    val ratingsCount: Int?,
    val numPages: Int?,
    val numEditions: Int
)
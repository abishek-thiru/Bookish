package com.abi.bookish.book.presentation.book_detail

import com.abi.bookish.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)

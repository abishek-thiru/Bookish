package com.abi.bookish.book.domain

import com.abi.bookish.core.domain.DataError
import com.abi.bookish.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
    suspend fun getBookDescription(bookId: String): Result<String?, DataError>
}
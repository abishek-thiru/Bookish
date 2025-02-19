package com.abi.bookish.book.data.repository

import com.abi.bookish.book.data.network.RemoteDataSource
import com.abi.bookish.book.domain.Book
import com.abi.bookish.book.domain.BookRepository
import com.abi.bookish.book.mappers.toBook
import com.abi.bookish.core.domain.DataError
import com.abi.bookish.core.domain.Result
import com.abi.bookish.core.domain.map

class DefaultRepository(
    private val remoteBookDataSource: RemoteDataSource
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }
}
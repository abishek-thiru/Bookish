package com.abi.bookish.book.data.network

import com.abi.bookish.book.data.dto.SearchResponseDto
import com.abi.bookish.core.domain.DataError
import com.abi.bookish.core.domain.Result

interface RemoteDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>
}
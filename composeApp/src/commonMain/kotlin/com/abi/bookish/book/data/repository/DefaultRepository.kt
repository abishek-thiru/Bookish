package com.abi.bookish.book.data.repository

import androidx.sqlite.SQLiteException
import com.abi.bookish.book.data.database.FavoriteBookDao
import com.abi.bookish.book.data.network.RemoteDataSource
import com.abi.bookish.book.domain.Book
import com.abi.bookish.book.domain.BookRepository
import com.abi.bookish.book.mappers.toBook
import com.abi.bookish.book.mappers.toBookEntity
import com.abi.bookish.core.domain.DataError
import com.abi.bookish.core.domain.EmptyResult
import com.abi.bookish.core.domain.Result
import com.abi.bookish.core.domain.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultRepository(
    private val remoteBookDataSource: RemoteDataSource,
    private val favoriteBookDao: FavoriteBookDao
) : BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        return remoteBookDataSource
            .getBookDetails(bookId)
            .map { it.description }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.map { it.toBook() }
            }
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.any { it.id == id }
            }
    }

    override suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local> {
        return try {
            favoriteBookDao.upsert(book.toBookEntity())
            Result.Success(Unit)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorites(id: String) {
        favoriteBookDao.deleteFavoriteBook(id)
    }
}
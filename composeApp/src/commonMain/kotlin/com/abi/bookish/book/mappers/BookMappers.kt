package com.abi.bookish.book.mappers

import com.abi.bookish.book.data.database.BookEntity
import com.abi.bookish.book.data.dto.SearchedBookDto
import com.abi.bookish.book.domain.Book

fun SearchedBookDto.toBook(): Book {
      return Book(
          id = id.substringAfterLast("/"),
          title = title,
          imageUrl = if (coverKey != null) {
              "https://covers.openlibrary.org/b/olid/${coverKey}-L.jpg"
          } else {
              "https://covers.openlibrary.org/b/olid/${coverAlternativeKey}-L.jpg"
          },
          authors = authorNames?: emptyList(),
          description = null,
          languages = languages?: emptyList(),
          firstPublished = firstPublishedYear.toString(),
          avgRatings = avgRatings,
          ratingsCount = ratingsCount,
          numPages = numPagesMedian,
          numEditions = numEditions?: 0

      )
}

fun Book.toBookEntity(): BookEntity {
    return BookEntity(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        languages = languages,
        authors = authors,
        firstPublishYear = firstPublished,
        ratingsAverage = avgRatings,
        ratingsCount = ratingsCount,
        numPagesMedian = numPages,
        numEditions = numEditions
    )
}

fun BookEntity.toBook(): Book {
    return Book(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        languages = languages,
        authors = authors,
        firstPublished = firstPublishYear,
        avgRatings = ratingsAverage,
        ratingsCount = ratingsCount,
        numPages = numPagesMedian,
        numEditions = numEditions
    )
}
package com.abi.bookish.book.mappers

import com.abi.bookish.book.data.dto.SearchedBookDto
import com.abi.bookish.book.domain.Book

fun SearchedBookDto.toBook(): Book {
      return Book(
          id = id,
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
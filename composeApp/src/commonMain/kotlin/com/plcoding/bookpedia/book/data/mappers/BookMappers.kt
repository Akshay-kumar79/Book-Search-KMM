package com.plcoding.bookpedia.book.data.mappers

import com.plcoding.bookpedia.book.data.database.BookEntity
import com.plcoding.bookpedia.book.data.dto.SearchBookDto
import com.plcoding.bookpedia.book.domain.Book

fun SearchBookDto.toBook(): Book {
    return Book(
        id = id.substringAfterLast("/"),
        title = title,
        imageUrl = if (coverKey != null) {
            "https://covers.openlibrary.org/b/olid/${coverKey}-M.jpg"
        } else {
            "https://covers.openlibrary.org/b/id/${coverAlternativeKey}-M.jpg"
        },
        authors = authorNames ?: emptyList(),
        description = null,
        languages = languages ?: emptyList(),
        firstPublishYear = firstPublishYear?.toString(),
        averageRating = ratingAverage,
        ratingCount = ratingCount,
        numPages = numPagesMedian,
        numEdition = numEditions ?: 0
    )
}

fun Book.toBookEntity(): BookEntity {
    return BookEntity(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        authors = authors,
        languages = languages,
        firstPublishYear = firstPublishYear,
        ratingsAverage = averageRating,
        ratingCount = ratingCount,
        numPagesMedian = numPages,
        numEditions = numEdition
    )
}

fun BookEntity.toBook(): Book{
    return Book(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        authors = authors,
        languages = languages,
        firstPublishYear = firstPublishYear,
        averageRating = ratingsAverage,
        ratingCount = ratingCount,
        numPages = numPagesMedian,
        numEdition = numEditions
    )
}
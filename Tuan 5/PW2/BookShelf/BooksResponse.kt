package com.example.bookshelf

data class BooksResponse(
    val items: List<BookItem>
)

data class BookItem(
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    val imageLinks: ImageLinks?
)

data class ImageLinks(
    val thumbnail: String
)

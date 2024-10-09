package com.example.bookshelf

class BookRepository(private val api: GoogleBooksApi) {

    suspend fun searchBooks(query: String): BooksResponse {
        return api.searchBooks(query)
    }
}

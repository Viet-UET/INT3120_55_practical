package com.example.bookshelf

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BooksViewModel(private val repository: BookRepository) : ViewModel() {

    val booksLiveData = MutableLiveData<List<BookItem>>()

    fun searchBooks(query: String) {
        viewModelScope.launch {
            try {
                val response = repository.searchBooks(query)
                booksLiveData.postValue(response.items)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}

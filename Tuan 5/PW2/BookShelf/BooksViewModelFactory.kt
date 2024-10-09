package com.example.bookshelf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BooksViewModelFactory(private val repository: BookRepository) : ViewModelProvider.Factory {
    class BooksViewModelFactory(private val repository: BookRepository) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(BooksViewModel::class.java)) {
                return BooksViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}

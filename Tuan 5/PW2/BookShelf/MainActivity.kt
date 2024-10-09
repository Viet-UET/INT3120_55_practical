package com.example.bookshelf

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var booksViewModel: BooksViewModel
    private lateinit var booksAdapter: BooksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = BookRepository(RetrofitInstance.api)
        val viewModelFactory = BooksViewModelFactory(repository)
        booksViewModel = ViewModelProvider(this, viewModelFactory).get(BooksViewModel::class.java)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        booksViewModel.booksLiveData.observe(this, { books ->
            booksAdapter = BooksAdapter(books)
            recyclerView.adapter = booksAdapter
        })

        // Trigger search with a sample query
        booksViewModel.searchBooks("android development")
    }
}

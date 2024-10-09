package com.example.bookshelf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class BooksAdapter(private val books: List<BookItem>) : RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookTitle: TextView = itemView.findViewById(R.id.bookTitle)
        val bookThumbnail: ImageView = itemView.findViewById(R.id.bookThumbnail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bookTitle.text = book.volumeInfo.title

        val thumbnailUrl = book.volumeInfo.imageLinks?.thumbnail
        if (thumbnailUrl != null) {
            Picasso.get().load(thumbnailUrl).into(holder.bookThumbnail)
        } else {
            holder.bookThumbnail.setImageResource(R.drawable.placeholder_image)
        }
    }

    override fun getItemCount() = books.size
}

package com.odyssey.booktube.repository;

import com.odyssey.booktube.database.BookManager;
import com.odyssey.booktube.models.Book;
import com.odyssey.booktube.repository.BooktubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class BookRepository implements BooktubeRepository<Book> {

    @Autowired
    private BookManager bookManager;

    @Override
    public Book save(Book book) {
        return bookManager.insertBook(book).orElse(Book.builder().build());
    }

    @Override
    public Book get(String title) {
       return bookManager.getBook(title).orElse(Book.builder().build());
    }

    @Override
    public List<Book> list() {
        return bookManager.getBooks().orElse(Collections.emptyList());
    }
}

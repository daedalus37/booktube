package com.odyssey.booktube.service;

import com.odyssey.booktube.models.Book;
import com.odyssey.booktube.repository.BookRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBook(String title) {
        return bookRepository.get(title);
    }

    public List<Book> getBooks() {
        return bookRepository.list();
    }
}

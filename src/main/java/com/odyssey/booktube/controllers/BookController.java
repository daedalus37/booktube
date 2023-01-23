package com.odyssey.booktube.controllers;

import com.odyssey.booktube.models.Author;
import com.odyssey.booktube.models.Book;
import com.odyssey.booktube.models.response.Response;
import com.odyssey.booktube.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * Add a book to the system
     * @param title The title of the book
     * @param price The price of the book
     * @param numberOfPages The number of pages contained in the book
     * @param author The author of the book
     * @return The response containing the created book
     */
    @RequestMapping(value = "/add_book", method = RequestMethod.POST)
    public Response insertBook(@RequestParam(value = "title") String title,
                                   @RequestParam(value = "price") BigDecimal price,
                                   @RequestParam(value = "numberOfPages") int numberOfPages,
                                   @RequestParam(value = "author") String author) {

        Book newBook = Book.builder()
                .numberOfPages(numberOfPages)
                .price(price)
                .author(Author.builder().name(author).build())
                .title(title)
                .build();

         Book insertedBook = bookService.createBook(newBook);

        return Response.builder().item(insertedBook).status_code(HttpStatus.OK.value()).build();
    }

    /**
     * Get a book from the system
     * @param title The title of the book to get
     * @return The response containing the book that matches the title
     */
    @RequestMapping(value = "/get_book", method = RequestMethod.GET)
    public Response getBook(@RequestParam(value = "title") String title) {
        Book book = bookService.getBook(title);
        return Response.builder().build();
    }

    /**
     * List the books in the system
     * @return The response containing the list of books
     */
    @RequestMapping(value = "/list_books", method = RequestMethod.GET)
    public Response getBooks() {
        List<Book> books = bookService.getBooks();
        return Response.builder().item(books).status_code(HttpStatus.OK.value()).build();
    }
}

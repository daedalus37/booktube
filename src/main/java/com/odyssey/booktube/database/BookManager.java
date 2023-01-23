package com.odyssey.booktube.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.odyssey.booktube.models.Author;
import com.odyssey.booktube.models.Book;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.odyssey.booktube.database.jooq.model.book_tube.Tables.BOOK;

@Component
public class BookManager {

    private static Logger logger = LoggerFactory.getLogger(BookManager.class);

    @Autowired
    private final DSLContext create;

    @Autowired
    private final AuthorManager authorManager;


    public BookManager(DSLContext dslContext) {
        this.create = dslContext;
        this.authorManager = new AuthorManager(dslContext);
    }

    /**
     * A book that matches the title (Returns the first book that matches if there are duplicates)
     * @param title The title of the book
     * @return The first book that matches the title
     */
    public Optional<Book> getBook(String title) {
        Result<Record> result = create.select()
                .from(BOOK)
                .where(BOOK.TITLE.eq(title)).fetch();

        if(result.size() < 1) {
            logger.info("Book {} was not found", title);
            return Optional.empty();
        }

        Record record = result.get(0);
        Author author = authorManager.getAuthor(record.getValue(BOOK.AUTHORID)).orElse(Author.builder().build());
        return Optional.of(Book.builder()
                        .title(record.getValue(BOOK.TITLE))
                        .id(record.getValue(BOOK.ID))
                        .price(record.getValue(BOOK.PRICE))
                        .author(author)
                        .numberOfPages(record.getValue(BOOK.NUMBEROFPAGES))
                        .build());

    }

    /**
     * Insert a book into the database
     * @param book The book to insert into the database
     * @return Return an optional of the book. Optional empty if the book is not present,
     *          otherwise an optional of the book
     */
    public Optional<Book> insertBook(Book book) {

        Optional<Author> authorOptional = authorManager.getAuthor(book.getAuthor().getName());
        Author author;
        if (authorOptional.isEmpty()) {
            authorOptional = authorManager.insertAuthor(book.getAuthor());
        }

        if(authorOptional.isEmpty()) {
            logger.info("Unable to insert the author of the book. Not creating book");
            return Optional.empty();
        }

        author = authorOptional.get();

        int insertAmount = create.insertInto(BOOK, BOOK.TITLE, BOOK.AUTHORID, BOOK.PRICE, BOOK.NUMBEROFPAGES)
                .values(book.getTitle(), author.getId(), book.getPrice(), book.getNumberOfPages()).execute();

        if(insertAmount < 1) {
            logger.info("Unable to insert book {}", book);
            return Optional.empty();
        }

        return getBook(book.getTitle());
    }

    /**
     * Get the books from the database
     * @return A list of books from the database
     */
    public Optional<List<Book>> getBooks() {
        Result<Record> result = create
                .select()
                .from(BOOK)
                .fetch();

        if(result.size() < 1) {
            logger.info("There were no books to list");
            return Optional.empty();
        }

        List<Book> books = new ArrayList<>();

        for(Record record: result) {
            Author author = authorManager.getAuthor(record.getValue(BOOK.AUTHORID)).orElse(Author.builder().build());
            Book book = Book.builder()
                    .title(record.getValue(BOOK.TITLE))
                    .id(record.getValue(BOOK.ID))
                    .price(record.getValue(BOOK.PRICE))
                    .author(author)
                    .numberOfPages(record.getValue(BOOK.NUMBEROFPAGES))
                    .build();

            books.add(book);
        }

        return Optional.of(books);

    }


}

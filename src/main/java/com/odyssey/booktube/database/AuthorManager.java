package com.odyssey.booktube.database;

import com.odyssey.booktube.models.Author;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.odyssey.booktube.database.jooq.model.book_tube.Tables.AUTHOR;

@Component
public class AuthorManager {
    private static final Logger logger = LoggerFactory.getLogger(AuthorManager.class);

    @Autowired
    private final DSLContext create;

    @Autowired
    public AuthorManager(DSLContext context) {
        this.create = context;
    }


    /**
     * Insert a new author into the database
     * @param author The new author to insert
     * @return The author to insert
     */
    public Optional<Author> insertAuthor(Author author) {

        int result = create.insertInto(AUTHOR,  AUTHOR.NAME, AUTHOR.LOCATION)
                .values(author.getName(), author.getLocation())
                .execute();

        if (result == 1) {
            logger.info("Successfully added author to the database");
            return getAuthor(author.getName());
        }

        logger.info("There was an error inserting the author to the database");
        return Optional.empty();
    }

    /**
     * Get an author by their name
     * @param name The name of the author
     * @return The author object that matches the authors name
     */
    public Optional<Author> getAuthor(String name) {
        Result<Record> result = create
                .select()
                .from(AUTHOR)
                .where(AUTHOR.NAME.eq(name)).fetch();

        return getAuthorFromResult(result);
    }

    /**
     * Get the author from result object
     * @param result The result object containing the record
     * @return An optional containing the author
     */
    private Optional<Author> getAuthorFromResult(Result<Record> result) {
        if(result.size() < 1) {
            logger.info("There was no author record");
            return Optional.empty();
        }

        Record record = result.get(0);
        logger.info("Successfully retrieved author with name {}", record.getValue(AUTHOR.NAME));
        return Optional.of(Author.builder()
                .id(record.getValue(AUTHOR.ID))
                .name(record.getValue(AUTHOR.NAME))
                .location(record.getValue(AUTHOR.LOCATION))
                .build());
    }

    /**
     * Given an Id return an author from the database
     * @param id The id of the author
     * @return An author who is represented by the id
     */
    public Optional<Author> getAuthor(Long id) {

        Result<Record> result = create
                .select()
                .from(AUTHOR)
                .where(AUTHOR.ID.eq(id)).fetch();

        return getAuthorFromResult(result);
    }

    /**
     * Get the authors
     * @return A list of the authors in the database
     */
    public Optional<List<Author>> getAuthors() {
        Result<Record> result = create.select().from(AUTHOR).fetch();
        List<Author> authors = new ArrayList<>();

        if(result.size() < 1) {
            logger.info("There were no authors in the database");
            return Optional.empty();
        }

        for(Record record: result) {
            Author author = Author.builder()
                    .id(record.getValue(AUTHOR.ID))
                    .name(record.getValue(AUTHOR.NAME))
                    .location(record.getValue(AUTHOR.LOCATION))
                    .build();
            authors.add(author);
        }

        return Optional.of(authors);
    }

}

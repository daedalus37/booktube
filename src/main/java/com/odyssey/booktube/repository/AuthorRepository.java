package com.odyssey.booktube.repository;

import com.odyssey.booktube.database.AuthorManager;
import com.odyssey.booktube.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class AuthorRepository implements BooktubeRepository<Author> {

    @Autowired
    AuthorManager authorDB;

    @Override
    public Author save(Author author) {
        return authorDB.insertAuthor(author).orElse(Author.builder().build());
    }

    @Override
    public Author get(String name) {
        return authorDB.getAuthor(name).orElse(Author.builder().build());
    }

    @Override
    public List<Author> list() {
        return authorDB.getAuthors().orElse(Collections.emptyList());
    }
}

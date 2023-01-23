package com.odyssey.booktube.service;

import com.odyssey.booktube.models.Author;
import com.odyssey.booktube.models.response.Response;
import com.odyssey.booktube.repository.AuthorRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
public class AuthorService implements com.odyssey.booktube.service.Service {
    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author getAuthor(String name) {
        return authorRepository.get(name);
    }

    public List<Author> getAuthors() {
        return authorRepository.list();
    }

}

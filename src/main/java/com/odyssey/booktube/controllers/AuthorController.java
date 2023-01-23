package com.odyssey.booktube.controllers;


import com.odyssey.booktube.models.Author;
import com.odyssey.booktube.models.response.Response;
import com.odyssey.booktube.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    /**
     * Insert an author into the system
     * @param name The name of the author
     * @param location The location where the author lives
     * @return Returns the response containing the inserted author
     */
    @RequestMapping(value = "/insert_author", method = RequestMethod.POST)
    public Response insertAuthor(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "location") String location) {

        Author newAuthor = Author.builder().name(name).location(location).build();
        Author insertedAuthor = authorService.createAuthor(newAuthor);
        return Response.builder().item(insertedAuthor).status_code(HttpStatus.OK.value()).build();
    }

    /**
     * Get an author from the system
     * @param name The name of the author to get from the system
     * @return The author that matches the name
     */
    @RequestMapping(value = "/get_author", method = RequestMethod.GET)
    public Response getAuthor(@RequestParam(value = "name") String name) {
        Author response = authorService.getAuthor(name);
        return Response.builder().item(response).status_code(HttpStatus.OK.value()).build();
    }

    /**
     * List the authors in the database
     * @return The authors in the system
     */
    @RequestMapping(value = "/list_authors", method = RequestMethod.GET)
    public Response listAuthors() {
        List<Author> response = authorService.getAuthors();
        return Response.builder().item(response).status_code(HttpStatus.OK.value()).build();
    }

}

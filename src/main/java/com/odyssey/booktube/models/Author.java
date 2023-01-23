package com.odyssey.booktube.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@Table(name = "Author")
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Author extends Person {

    private static final Logger logger = LoggerFactory.getLogger(Author.class);

    @Id
    @Column(name = "id", unique = true, insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "favoriteBookId")
    private Book favoriteBook;

    @Override
    public void communicate() {
        logger.info("I have written a book!!");
    }
}

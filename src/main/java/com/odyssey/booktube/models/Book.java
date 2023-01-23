package com.odyssey.booktube.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;

    @Column(name = "numberOfPages")
    private int numberOfPages;

    @Column(name = "price")
    private BigDecimal price;


    // TODO: how do we calculate the number of people reading this book
    @Column(name = "number_of_readers")
    private int numberOfReaders;

}

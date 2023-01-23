package com.odyssey.booktube.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Builder
@AllArgsConstructor
public class Reader extends Person {

    private static final Logger logger = LoggerFactory.getLogger(Reader.class);


    /**
     * The name of the reader
     */
    private String name;

    /**
     * The current book they are reading
     */
    private Book currentBook;

    /**
     * Their favorite author
     */
    private Author favoriteAuthor;

    private boolean isReading = false;

    private String thought;

    private void thinking() {
        this.thought = "This book is interesting";
    }

    public void startReading() {
        this.isReading = true;
    }

    public void stopReading() {
        this.isReading = false;
    }

    public Boolean isReading() {
        return this.isReading;
    }

    public String getName() {
        return this.name;
    }
}

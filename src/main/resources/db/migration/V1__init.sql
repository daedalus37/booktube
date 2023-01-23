CREATE TABLE Author (id  BIGINT AUTO_INCREMENT,
                     name VARCHAR(256) NOT NULL,
                     location VARCHAR(256),
                     favoriteBookId BIGINT,
                     PRIMARY KEY (id));

CREATE TABLE Book (id BIGINT AUTO_INCREMENT,
                   title VARCHAR(256) NOT NULL,
                   authorId BIGINT NOT NULL,
                   numberOfPages INT NOT NULL,
                   price DECIMAL(13, 4) NOT NULL,
                   numberOfReaders INT,
                   PRIMARY KEY (id));

ALTER TABLE Author
    ADD CONSTRAINT FK_AuthorBookId_BookId FOREIGN KEY (favoriteBookId)
    REFERENCES Book (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE Book
    ADD CONSTRAINT FK_BookAuthorId_AuthorId FOREIGN KEY (authorId)
    REFERENCES Author (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


/*
 * This file is generated by jOOQ.
 */
package com.odyssey.booktube.database.jooq.model.book_tube.tables.records;


import com.odyssey.booktube.database.jooq.model.book_tube.tables.Book;

import java.math.BigDecimal;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookRecord extends UpdatableRecordImpl<BookRecord> implements Record6<Long, String, Long, Integer, BigDecimal, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>book_tube.Book.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>book_tube.Book.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>book_tube.Book.title</code>.
     */
    public void setTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>book_tube.Book.title</code>.
     */
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>book_tube.Book.authorId</code>.
     */
    public void setAuthorid(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>book_tube.Book.authorId</code>.
     */
    public Long getAuthorid() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>book_tube.Book.numberOfPages</code>.
     */
    public void setNumberofpages(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>book_tube.Book.numberOfPages</code>.
     */
    public Integer getNumberofpages() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>book_tube.Book.price</code>.
     */
    public void setPrice(BigDecimal value) {
        set(4, value);
    }

    /**
     * Getter for <code>book_tube.Book.price</code>.
     */
    public BigDecimal getPrice() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>book_tube.Book.numberOfReaders</code>.
     */
    public void setNumberofreaders(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>book_tube.Book.numberOfReaders</code>.
     */
    public Integer getNumberofreaders() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, String, Long, Integer, BigDecimal, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Long, String, Long, Integer, BigDecimal, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Book.BOOK.ID;
    }

    @Override
    public Field<String> field2() {
        return Book.BOOK.TITLE;
    }

    @Override
    public Field<Long> field3() {
        return Book.BOOK.AUTHORID;
    }

    @Override
    public Field<Integer> field4() {
        return Book.BOOK.NUMBEROFPAGES;
    }

    @Override
    public Field<BigDecimal> field5() {
        return Book.BOOK.PRICE;
    }

    @Override
    public Field<Integer> field6() {
        return Book.BOOK.NUMBEROFREADERS;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getTitle();
    }

    @Override
    public Long component3() {
        return getAuthorid();
    }

    @Override
    public Integer component4() {
        return getNumberofpages();
    }

    @Override
    public BigDecimal component5() {
        return getPrice();
    }

    @Override
    public Integer component6() {
        return getNumberofreaders();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getTitle();
    }

    @Override
    public Long value3() {
        return getAuthorid();
    }

    @Override
    public Integer value4() {
        return getNumberofpages();
    }

    @Override
    public BigDecimal value5() {
        return getPrice();
    }

    @Override
    public Integer value6() {
        return getNumberofreaders();
    }

    @Override
    public BookRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public BookRecord value2(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public BookRecord value3(Long value) {
        setAuthorid(value);
        return this;
    }

    @Override
    public BookRecord value4(Integer value) {
        setNumberofpages(value);
        return this;
    }

    @Override
    public BookRecord value5(BigDecimal value) {
        setPrice(value);
        return this;
    }

    @Override
    public BookRecord value6(Integer value) {
        setNumberofreaders(value);
        return this;
    }

    @Override
    public BookRecord values(Long value1, String value2, Long value3, Integer value4, BigDecimal value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BookRecord
     */
    public BookRecord() {
        super(Book.BOOK);
    }

    /**
     * Create a detached, initialised BookRecord
     */
    public BookRecord(Long id, String title, Long authorid, Integer numberofpages, BigDecimal price, Integer numberofreaders) {
        super(Book.BOOK);

        setId(id);
        setTitle(title);
        setAuthorid(authorid);
        setNumberofpages(numberofpages);
        setPrice(price);
        setNumberofreaders(numberofreaders);
    }
}
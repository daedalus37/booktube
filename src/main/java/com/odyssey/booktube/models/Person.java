package com.odyssey.booktube.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Person {
    private static final Logger logger = LoggerFactory.getLogger(Person.class);
    public void communicate() {
        logger.info("I am talking");
    };
}

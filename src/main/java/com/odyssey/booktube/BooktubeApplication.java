package com.odyssey.booktube;

import com.odyssey.booktube.models.Author;
import com.odyssey.booktube.models.Book;
import com.odyssey.booktube.models.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.awt.*;


@EnableWebMvc
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BooktubeApplication {
	private static Logger logger = LoggerFactory.getLogger(BooktubeApplication.class);
	public static void main(String[] args) {
		logger.info("Starting the application");
		SpringApplication.run(BooktubeApplication.class, args);
	}

}

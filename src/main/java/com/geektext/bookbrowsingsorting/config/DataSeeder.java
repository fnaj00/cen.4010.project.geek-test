package com.geektext.bookbrowsingsorting.config;

import com.geektext.bookbrowsingsorting.model.Book;
import com.geektext.bookbrowsingsorting.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedBooks(BookRepository repo) {
        return args -> {
            repo.save(new Book(111L, "The Hobbit", "J.R.R. Tolkien", "Fantasy", 15.99, 4.8, 5000));
            repo.save(new Book(222L, "Dune", "Frank Herbert", "Sci-Fi", 19.99, 4.6, 4000));
            repo.save(new Book(333L, "Harry Potter", "J.K. Rowling", "Fantasy", 12.99, 4.9, 10000));
        };
    }
}
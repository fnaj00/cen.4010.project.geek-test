package com.geektext.bookbrowsingsorting.controller;

import com.geektext.bookbrowsingsorting.model.Book;
import com.geektext.bookbrowsingsorting.repository.BookRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    // GET http://localhost:8080/api/books/genre?Genre=Fantasy
    @GetMapping("/genre")
    public List<Book> getBooksByGenre(@RequestParam(name = "Genre") String genre) {
        return repo.findByGenreIgnoreCase(genre);
    }

    // GET http://localhost:8080/api/books?sort=price
    @GetMapping
    public List<Book> getBooksSorted(
            @RequestParam String sort,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort.Direction dir = direction.equalsIgnoreCase("desc")
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        return repo.findAll(Sort.by(dir, sort));
    }
}
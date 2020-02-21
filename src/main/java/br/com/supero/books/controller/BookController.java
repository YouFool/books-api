package br.com.supero.books.controller;

import br.com.supero.books.entity.Book;
import br.com.supero.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for {@link Book books}.
 */
@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Lists books. Filters optionally by year range and/or title, author or ISBN code.
     *
     * @param search    search query filter
     * @param startYear start year filter
     * @param endYear   end year filter
     * @param pageable  the {@link Pageable page request}
     * @return a {@link Page} of {@link Book books}
     */
    @GetMapping
    public Page<Book> listBooks(@RequestParam(required = false) String search,
                                @RequestParam(required = false) Integer startYear,
                                @RequestParam(required = false) Integer endYear,
                                @PageableDefault Pageable pageable) {
        return this.bookRepository.listBooks(search, startYear, endYear, pageable);
    }

}

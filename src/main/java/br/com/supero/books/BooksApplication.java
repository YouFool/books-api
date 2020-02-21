package br.com.supero.books;

import br.com.supero.books.entity.Book;
import br.com.supero.books.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@SpringBootApplication
public class BooksApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(BooksApplication.class, args);
        final BookRepository bookRepository = context.getBean(BookRepository.class);
        createRandomBooks(bookRepository);
    }

    private static void createRandomBooks(BookRepository bookRepository) {
        final Set<Book> randomBooks = LongStream.range(1920, 2022)
                .mapToObj(Book::createRandomBook)
                .collect(Collectors.toSet());
        bookRepository.saveAll(randomBooks);
    }


}

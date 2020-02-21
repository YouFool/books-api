package br.com.supero.books.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Represents a given book.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    /**
     * Book identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The title of the book.
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * Book ISBN code.
     */
    @Size(max = 13)
    @Column(name = "isbn", nullable = false)
    private String isbnCode;

    /**
     * Book author.
     */
    @Column(name = "author", nullable = false)
    private String author;

    /**
     * Book publisher.
     */
    @Column(name = "publisher", nullable = false)
    private String publisher;

    /**
     * Book publish year.
     */
    @Column(name = "year", nullable = false)
    private Long year;

    /**
     * Book original language.
     */
    @Column(name = "language", nullable = false)
    private String language;

    /**
     * The book weight in grams (g).
     */
    @Column(name = "weight", nullable = false)
    private Long weight;

    /**
     * The book dimensions in cubic meters.
     */
    @Column(name = "dimension", nullable = false)
    private String dimension;

    /**
     * Creates a book with all fields containing random values, except it's release year.
     *
     * @param year book release date
     * @return a book instance with random values in fields
     */
    public static Book createRandomBook(long year) {
        final SecureRandom random = new SecureRandom();
        final String randomUUID = UUID.randomUUID().toString();
        final Locale randomLanguage = Stream.of(Locale.getAvailableLocales())
                .filter(locale -> StringUtils.hasText(locale.getCountry()))
                .findAny()
                .orElse(Locale.getDefault());
        return new Book(null, randomUUID, randomUUID.substring(0, 13), randomUUID, randomUUID, year, randomLanguage.getCountry(), random.nextLong(), randomUUID);
    }

}

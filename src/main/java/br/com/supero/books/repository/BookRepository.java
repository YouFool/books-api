package br.com.supero.books.repository;

import br.com.supero.books.entity.Book;
import br.com.supero.books.entity.QBook;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.util.StringUtils;

/**
 * Spring Data repository for {@link Book books}.
 */
public interface BookRepository extends JpaRepository<Book, Long>, QuerydslPredicateExecutor<Book> {

    /**
     * Lists books. Filters optionally by title, author or ISBN code and year range.
     *
     * @param search    search query filter
     * @param startYear start year filter
     * @param endYear   end year filter
     * @param pageable  the {@link Pageable page request}
     * @return a {@link Page} of {@link Book books}
     */
    default Page<Book> listBooks(String search, Integer startYear, Integer endYear, Pageable pageable) {
        return this.findAll(this.getSearchBooksPredicate(search, startYear, endYear), pageable);
    }

    /**
     * Returns a {@link Predicate} to find books for a given search query and/or year range.
     *
     * @param search    the search query
     * @param startYear start year filter
     * @param endYear   end year filter
     * @return the predicate
     */
    default Predicate getSearchBooksPredicate(String search, Integer startYear, Integer endYear) {
        final QBook book = QBook.book;

        BooleanBuilder predicate = new BooleanBuilder();

        if (StringUtils.hasText(search)) {
            predicate.and(book.title.containsIgnoreCase(search)
                    .or(book.author.containsIgnoreCase(search))
                    .or(book.isbnCode.containsIgnoreCase(search)));
        }

        if (startYear != null && endYear != null) {
            predicate.and(book.year.between(startYear, endYear));
        } else if (startYear != null) {
            predicate.and(book.year.goe(startYear));
        }

        return predicate;
    }

}

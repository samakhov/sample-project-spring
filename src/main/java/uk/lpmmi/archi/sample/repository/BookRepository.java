package uk.lpmmi.archi.sample.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import uk.lpmmi.archi.sample.data.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByTitle(String title);
	List<Book> findByAuthor(String author);
}

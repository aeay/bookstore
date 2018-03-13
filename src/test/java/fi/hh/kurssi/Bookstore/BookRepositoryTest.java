package fi.hh.kurssi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.kurssi.Bookstore.domain.Book;
import fi.hh.kurssi.Bookstore.domain.BookRepository;
import fi.hh.kurssi.Bookstore.domain.Category;



@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;

	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Keittokirja");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Kokki Kolmonen");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("Testikirja", "Tessa Testaaja", 2018, "1234-567-8", 50.50, new Category("Testi"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		List<Book> books = repository.findByTitle("Testikirja");
		repository.delete(books);
	}
}

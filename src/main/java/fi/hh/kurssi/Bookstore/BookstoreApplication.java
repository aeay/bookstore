package fi.hh.kurssi.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.kurssi.Bookstore.domain.Book;
import fi.hh.kurssi.Bookstore.domain.BookRepository;
import fi.hh.kurssi.Bookstore.domain.Category;
import fi.hh.kurssi.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository catrepository) {
		return (args) -> {
			log.info("department names");
			catrepository.save(new Category("  "));
			catrepository.save(new Category("Science"));
			catrepository.save(new Category("Fiction"));
			catrepository.save(new Category("Cooking"));
			
			log.info("save a couple of books");
			repository.save(new Book("Keittokirja", "Kokki Kolmonen", 2015, "2233-44555-6", 25.50, catrepository.findByName("Cooking").get(0)));
			repository.save(new Book("Lintukirja", "Tiina Titityy", 2016, "2334-11122-4", 15.70, catrepository.findByName("Science").get(0)));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}

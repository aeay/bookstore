package fi.hh.kurssi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.kurssi.Bookstore.domain.CategoryRepository;
import fi.hh.kurssi.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repository;

	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = repository.findByName("Cooking");
		assertThat(categories).hasSize(1);
	}

	@Test
	public void createNewCategory() {
		Category category = new Category("Test");
		repository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		List<Category> categories = repository.findByName("Test");
		repository.delete(categories);
	}
}

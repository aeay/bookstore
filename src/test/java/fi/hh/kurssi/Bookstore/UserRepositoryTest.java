package fi.hh.kurssi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.kurssi.Bookstore.domain.User;
import fi.hh.kurssi.Bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;

	@Test
	public void findByUsernameShouldReturnUser() {
		User user = repository.findByUsername("user1");
		assertThat(user.getEmail()).isEqualTo("user1@users.com");
	}

	@Test
	public void createNewUser() {
		User user = new User("testuser", "testuser", "testuser@users.com", "USER");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteUser() {
		User user = repository.findByUsername("testuser");
		repository.delete(user);
	}

}

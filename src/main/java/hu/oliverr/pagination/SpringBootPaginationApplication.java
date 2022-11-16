package hu.oliverr.pagination;

import com.github.javafaker.Faker;
import hu.oliverr.pagination.model.Author;
import hu.oliverr.pagination.model.Book;
import hu.oliverr.pagination.repository.AuthorRepository;
import hu.oliverr.pagination.repository.BookRepository;
import hu.oliverr.pagination.service.AuthorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class SpringBootPaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPaginationApplication.class, args);
	}

	@Bean
	Faker faker() {
		return new Faker();
	}

	@Bean
	CommandLineRunner init(Faker faker, AuthorRepository authorRepository,
						   AuthorService authorService, BookRepository bookRepository) {
		return args -> {
			authorRepository.saveAll(IntStream.rangeClosed(1, 10)
					.mapToObj(i -> new Author(
							faker.name().firstName(),
							faker.name().lastName()
					))
					.toList());

			bookRepository.saveAll(IntStream.rangeClosed(1, 100)
					.mapToObj(i -> new Book(
							faker.book().title(),
							faker.lorem().characters(20, 100),
							authorService.getAuthor(faker.random().nextInt(1, 10))
					))
					.toList());
		};
	}

}

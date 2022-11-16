package hu.oliverr.pagination;

import hu.oliverr.pagination.model.Author;
import hu.oliverr.pagination.repository.AuthorRepository;
import hu.oliverr.pagination.service.AuthorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringBootPaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPaginationApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AuthorRepository authorRepository) {
		return args -> {
			List<Author> authors = IntStream.rangeClosed(1, 10)
					.mapToObj(i -> new Author())
					.toList();

			authorRepository.saveAll(authors);
		};
	}

}

package hu.oliverr.pagination.service;

import hu.oliverr.pagination.exception.AuthorNotFoundException;
import hu.oliverr.pagination.exception.BadAuthorException;
import hu.oliverr.pagination.model.Author;
import hu.oliverr.pagination.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author getAuthor(long id) {
        return authorRepository
                .findById(id)
                .orElseThrow(AuthorNotFoundException::new);
    }

    @Override
    public Author saveAuthor(Author author) {
        if(author.getFirstName().length() > 64
                || author.getLastName().length() > 64) {
            throw new BadAuthorException();
        }

        return authorRepository.save(author);
    }

}

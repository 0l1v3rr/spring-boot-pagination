package hu.oliverr.pagination.service;

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
        // TODO handle exception
        return authorRepository.findById(id).get();
    }

    @Override
    public Author saveAuthor(Author author) {
        // TODO validate author
        return authorRepository.save(author);
    }

}

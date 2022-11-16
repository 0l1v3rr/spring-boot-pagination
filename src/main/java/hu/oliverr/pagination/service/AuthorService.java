package hu.oliverr.pagination.service;

import hu.oliverr.pagination.model.Author;

public interface AuthorService {
    Author getAuthor(long id);
    Author saveAuthor(Author author);
}

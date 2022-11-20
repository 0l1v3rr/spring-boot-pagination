package hu.oliverr.pagination.service;

import hu.oliverr.pagination.model.Book;
import org.springframework.data.domain.Page;

public interface BookService {
    Page<Book> getPage(int page, int size);
}

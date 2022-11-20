package hu.oliverr.pagination.service;

import hu.oliverr.pagination.exception.IllegalPageException;
import hu.oliverr.pagination.model.Book;
import hu.oliverr.pagination.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Page<Book> getPage(int page, int size) {
        if(page < 1) {
            throw new IllegalPageException();
        }

        PageRequest pr = PageRequest.of(page, size);
        return bookRepository.findAll(pr);
    }

}

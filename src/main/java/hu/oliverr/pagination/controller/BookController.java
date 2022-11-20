package hu.oliverr.pagination.controller;

import hu.oliverr.pagination.model.Book;
import hu.oliverr.pagination.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<Page<Book>> getBooks(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.getPage(page, size));
    }

}

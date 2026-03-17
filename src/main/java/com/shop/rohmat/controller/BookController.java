package com.shop.rohmat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.rohmat.dtos.BookDto;
import com.shop.rohmat.model.Book;
import com.shop.rohmat.repository.BookRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/books")
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping
    public @ResponseBody Iterable<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> new BookDto(book.getId(), book.getTitle(), book.getPrice())).toList();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BookDto> GetBookById(@PathVariable Integer id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        BookDto bookDto = new BookDto(book.getId(), book.getTitle(), book.getPrice());
        return ResponseEntity.ok(bookDto);
    }

    @PostMapping(path = "/add")
    public @ResponseBody String AddNewBook(@RequestParam String title, @RequestParam String author,
            @RequestParam int price, @RequestParam int stok) {
        Book b = new Book();
        b.setAuthor(author);
        b.setTitle(title);
        b.setPrice(price);
        b.setStok(stok);
        bookRepository.save(b);
        return "Saved";
    }

}

package com.library.booktracker.controller;

import com.library.booktracker.entity.Book;
import com.library.booktracker.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*") // Allow frontend access
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PostMapping("/{id}/borrow")
    public ResponseEntity<String> borrowBook(@PathVariable Long id) {
        boolean success = bookService.borrowBook(id);
        if (success) {
            return ResponseEntity.ok("Book borrowed successfully.");
        } else {
            return ResponseEntity.badRequest().body("Book is already borrowed or not found.");
        }
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<String> returnBook(@PathVariable Long id) {
        boolean success = bookService.returnBook(id);
        if (success) {
            return ResponseEntity.ok("Book returned successfully.");
        } else {
            return ResponseEntity.badRequest().body("Book is not borrowed or not found.");
        }
    }
}

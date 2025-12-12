package com.library.booktracker.service;

import com.library.booktracker.entity.Book;
import com.library.booktracker.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public boolean borrowBook(Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            if (!book.isBorrowed()) {
                book.setBorrowed(true);
                bookRepository.save(book);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            if (book.isBorrowed()) {
                book.setBorrowed(false);
                bookRepository.save(book);
                return true;
            }
        }
        return false;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

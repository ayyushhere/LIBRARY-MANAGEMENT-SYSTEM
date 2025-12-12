package com.library.booktracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @org.springframework.context.annotation.Bean
    public org.springframework.boot.CommandLineRunner demo(com.library.booktracker.repository.BookRepository repository) {
        return (args) -> {
            if (repository.count() == 0) {
                repository.save(new com.library.booktracker.entity.Book("The Great Gatsby", "F. Scott Fitzgerald"));
                repository.save(new com.library.booktracker.entity.Book("Clean Code", "Robert C. Martin"));
                repository.save(new com.library.booktracker.entity.Book("The Pragmatic Programmer", "Andrew Hunt"));
                repository.save(new com.library.booktracker.entity.Book("1984", "George Orwell"));
                repository.save(new com.library.booktracker.entity.Book("Design Patterns", "Erich Gamma"));
                System.out.println("Data Seeded");
            } else {
                System.out.println("Data already exists. Skipping seed.");
            }
        };
    }
}

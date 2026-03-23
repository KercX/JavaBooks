package com.javabooks;

import java.util.List;

public interface LibraryService {

    void addBook(Book book);

    void removeBook(String isbn);

    List<Book> listBooks();

    List<Book> searchByTitle(String title);

    List<Book> searchByAuthor(String author);

    Book findByIsbn(String isbn);

    void borrowBook(String isbn);

    void returnBook(String isbn);
}

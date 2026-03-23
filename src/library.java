package com.javabooks;

import java.util.*;
import java.util.stream.Collectors;

public class Library implements LibraryService {

    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(String isbn) {
        books.removeIf(b -> b.getIsbn().equals(isbn));
    }

    @Override
    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Book findByIsbn(String isbn) {
        return books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst().orElse(null);
    }

    @Override
    public void borrowBook(String isbn) {
        Book b = findByIsbn(isbn);
        if (b != null && !b.isBorrowed()) {
            b.borrow();
        }
    }

    @Override
    public void returnBook(String isbn) {
        Book b = findByIsbn(isbn);
        if (b != null && b.isBorrowed()) {
            b.returnBook();
        }
    }
}

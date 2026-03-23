package com.javabooks;

import java.io.*;
import java.util.*;

public class Main {

    private static LibraryService library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        loadFromFile();

        System.out.println("=== JavaBooks PRO System ===");

        while (true) {
            printMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "1": addBook(); break;
                case "2": listBooks(); break;
                case "3": searchMenu(); break;
                case "4": borrowBook(); break;
                case "5": returnBook(); break;
                case "6": removeBook(); break;
                case "7": sortMenu(); break;
                case "8": statistics(); break;
                case "9": saveToFile(); break;
                case "10": loadFromFile(); break;
                case "0": exit(); return;
                default: System.out.println("Invalid option!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Add Book");
        System.out.println("2. List Books");
        System.out.println("3. Search");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Remove Book");
        System.out.println("7. Sort Books");
        System.out.println("8. Statistics");
        System.out.println("9. Save");
        System.out.println("10. Load");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private static void addBook() {
        try {
            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            System.out.print("Year: ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            library.addBook(new Book(title, author, year, isbn));
            System.out.println("Added!");
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    private static void listBooks() {
        List<Book> books = library.listBooks();
        if (books.isEmpty()) {
            System.out.println("Empty library!");
            return;
        }

        System.out.println("\n--- BOOKS ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private static void searchMenu() {
        System.out.println("1. By Title");
        System.out.println("2. By Author");
        String choice = scanner.nextLine();

        System.out.print("Query: ");
        String query = scanner.nextLine();

        List<Book> results;

        if (choice.equals("1")) {
            results = library.searchByTitle(query);
        } else {
            results = library.searchByAuthor(query);
        }

        if (results.isEmpty()) {
            System.out.println("No results.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private static void borrowBook() {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Book b = library.findByIsbn(isbn);

        if (b == null) {
            System.out.println("Not found!");
            return;
        }

        if (b.isBorrowed()) {
            System.out.println("Already borrowed!");
            return;
        }

        library.borrowBook(isbn);
        System.out.println("Borrowed!");
    }

    private static void returnBook() {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Book b = library.findByIsbn(isbn);

        if (b == null) {
            System.out.println("Not found!");
            return;
        }

        if (!b.isBorrowed()) {
            System.out.println("Not borrowed!");
            return;
        }

        library.returnBook(isbn);
        System.out.println("Returned!");
    }

    private static void removeBook() {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        library.removeBook(isbn);
        System.out.println("Removed.");
    }

    private static void sortMenu() {
        List<Book> books = library.listBooks();

        System.out.println("1. By Title");
        System.out.println("2. By Year");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            books.sort(Comparator.comparing(Book::getTitle));
        } else {
            books.sort(Comparator.comparingInt(Book::getYear));
        }

        books.forEach(System.out::println);
    }

    private static void statistics() {
        List<Book> books = library.listBooks();

        long total = books.size();
        long borrowed = books.stream().filter(Book::isBorrowed).count();

        System.out.println("Total books: " + total);
        System.out.println("Borrowed: " + borrowed);
        System.out.println("Available: " + (total - borrowed));
    }

    private static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {
            for (Book b : library.listBooks()) {
                writer.write(b.getTitle() + ";" + b.getAuthor() + ";" + b.getYear() + ";" + b.getIsbn() + ";" + b.isBorrowed());
                writer.newLine();
            }
            System.out.println("Saved!");
        } catch (IOException e) {
            System.out.println("Save error!");
        }
    }

    private static void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] p = line.split(";");
                Book b = new Book(p[0], p[1], Integer.parseInt(p[2]), p[3]);
                if (Boolean.parseBoolean(p[4])) b.borrow();
                library.addBook(b);
            }
            System.out.println("Loaded!");
        } catch (IOException e) {
            System.out.println("No file.");
        }
    }

    private static void exit() {
        saveToFile();
        System.out.println("Goodbye!");
    }
}

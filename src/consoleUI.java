package com.javabooks;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner = new Scanner(System.in);

    public void printMenu(){
        System.out.println("\n====== JavaBooks ======");
        System.out.println("1. Add book");
        System.out.println("2. List books");
        System.out.println("3. Search");
        System.out.println("4. Borrow");
        System.out.println("5. Return");
        System.out.println("6. Remove");
        System.out.println("7. Sort");
        System.out.println("8. Statistics");
        System.out.println("9. Save");
        System.out.println("10. Load");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    public int askInt(String msg){
        System.out.print(msg);
        return Integer.parseInt(scanner.nextLine());
    }

    public String ask(String msg){
        System.out.print(msg);
        return scanner.nextLine();
    }

    public void printBooks(List<Book> books){
        if (books.isEmpty()){
            System.out.println("No books.");
            return;
        }
        books.forEach(System.out::println);
    }
}

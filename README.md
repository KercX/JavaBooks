# JavaBooks 📚

![Build](https://img.shields.io/github/workflow/status/KercX/JavaBooks/Java%20CI?style=flat-square)
![License](https://img.shields.io/github/license/Kercx/JavaBooks?style=flat-square)
![Java Version](https://img.shields.io/badge/Java-17-blue?style=flat-square)
![Open Issues](https://img.shields.io/github/issues/Kercx/JavaBooks?style=flat-square)

> [!WARNING]
>
> ### JUST WARNING
> JavaBooks is in active development.This > APIs may change without notice. Use at > > your own risk.

---

## 📋 Project Overview

JavaBooks is a **Java library** for managing books in console apps, web applications, and games like Minecraft.  
It provides **add/list/search** methods and can be integrated into **Java projects**, including **Spring Boot web apps** and **game mods**.

---

## 📁 Project Structure

JavaBooks/ │ ├─ src/com/javabooks/ │ ├─ model/Book.java │ ├─ service/Library.java │ └─ Main.java │ ├─ misc/ │ ├─ screenshot_console.png │ └─ screenshot_web.png │ ├─ examples/ │ ├─ ExampleConsole.java │ └─ ExampleWeb.java │ ├─ .github/workflows/build.yml ├─ Dockerfile ├─ docker-compose.yml ├─ LICENSE ├─ CONTRIBUTING.md ├─ CODE_OF_CONDUCT.md └─ README.md


---

## 🛠️ Features

- Add books to library  
- List all books  
- Search books by **author** or **title**  
- Ready for integration in **web apps and games**  
- Console demo included for testing  

---

## 🌐 Live Demos

- **GitHub Pages Demo:** [JavaBooks Web Demo](https://kercx.github.io/JavaBooks)  
- **Spring Boot Web Demo:** [JavaBooks API](https://kercx.github.io/JavaBooks/API)  

> ⚠️ Note: Live demos may not contain all features.

---

## 💻 Installation

Clone the repository:

```bash
git clone https://github.com/Kercx/JavaBooks
```

Include the library in your project.
Maven:

<dependency>
    <groupId>com.javabooks</groupId>
    <artifactId>javabooks</artifactId>
    <version>1.0.0</version>
</dependency>

Gradle:
```bash
implementation 'com.javabooks:javabooks:1.0.0'
```


📚 Usage Examples
Console Example
```java
import com.javabooks.model.Book;
import com.javabooks.service.Library;

public class ExampleConsole {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Java Programming", "John Doe", 2022));
        library.addBook(new Book("Minecraft Modding", "Jane Smith", 2023));
        library.listBooks();
        library.searchByAuthor("Jane Smith");
    }
}
```

Web Example (Spring Boot)
```java 
@RestController
@RequestMapping("/books")
public class ExampleWeb {
    private Library library = new Library();

    @GetMapping
    public List to<Book> getAllBooks() {
        return library.getBooks();
    }

    @PostMapping
    public String addBook(@RequestBody Book book) {
        library.addBook(book);
        return "Book added successfully!";
    }
}
```
**⚠️ Warning:** Web example requires Spring Boot dependencies and setup.

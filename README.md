# JavaBooks 📚

![Build](https://img.shields.io/github/workflow/status/KercX/JavaBooks/Java%20CI?style=flat-square)
![License](https://img.shields.io/github/license/Kercx/JavaBooks?style=flat-square)
![Java Version](https://img.shields.io/badge/Java-17-blue?style=flat-square)
![Open Issues](https://img.shields.io/github/issues/Kercx/JavaBooks?style=flat-square)
<!-- SPONSORS / BACKERS BADGES -->

<img src="https://img.shields.io/badge/Sponsors-120-blue?style=for-the-badge">
<img src="https://img.shields.io/badge/Backers-350-orange?style=for-the-badge">
<img src="https://img.shields.io/badge/Donors-80-purple?style=for-the-badge">
<img src="https://img.shields.io/badge/Supporters-500%2B-green?style=for-the-badge">
<img src="https://img.shields.io/badge/Funding-OpenCollective-teal?style=for-the-badge">

> [!WARNING]
>
> ### JUST WARNING
> JavaBooks is in active development.This > APIs may change without notice. Use at > your own risk.

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

> [!CAUTION]
>
> Live demos may not contain
> all  features.

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
>[!WARNING] 
> Web example requires Spring Boot dependencies and setup.

## 🌐 API Endpoints
Method	Endpoint	Description
GET	/books	Get all books
POST	/books	Add book
GET	/books/search	Search

## Docker Install
```bash
docker build -t javabooks .
docker run -p 8080:8080 javabooks
```

## 💛 Sponsors

Thanks to all organizations and individuals supporting **JavaBooks**.

<p align="center">
  <a href="https://github.com">
    <img src="https://avatars.githubusercontent.com/u/9919?s=200" width="80" style="border-radius:50%">
  </a>
  <a href="https://example.com">
    <img src="https://avatars.githubusercontent.com/u/43973682?s=200" width="80" style="border-radius:50%">
  </a>
  <a href="#">
    <img src="https://avatars.githubusercontent.com/u/14101776?s=200" width="80" style="border-radius:50%">
  </a>
</p>


## 🌟 Users & Contributors

Thanks to everyone using **JavaBooks** and contributing to the project.  
Below are amazing GitHub users and contributors!

<p align="center">
  <!-- PROFESSIONAL USERS -->
  <a href="https://github.com/torvalds"><img src="https://avatars.githubusercontent.com/u/1024025?v=4" width="70" style="border-radius:50%" title="Linus Torvalds"></a>
  <a href="https://github.com/mojombo"><img src="https://avatars.githubusercontent.com/u/1?v=4" width="70" style="border-radius:50%" title="Tom Preston-Werner"></a>
  <a href="https://github.com/defunkt"><img src="https://avatars.githubusercontent.com/u/2?v=4" width="70" style="border-radius:50%" title="Chris Wanstrath"></a>
  <a href="https://github.com/pjhyett"><img src="https://avatars.githubusercontent.com/u/3?v=4" width="70" style="border-radius:50%" title="PJ Hyett"></a>
  <a href="https://github.com/wycats"><img src="https://avatars.githubusercontent.com/u/4?v=4" width="70" style="border-radius:50%" title="Yehuda Katz"></a>
  <a href="https://github.com/sindresorhus"><img src="https://avatars.githubusercontent.com/u/170270?v=4" width="70" style="border-radius:50%" title="Sindre Sorhus"></a>
  <a href="https://github.com/yyx990803"><img src="https://avatars.githubusercontent.com/u/499550?v=4" width="70" style="border-radius:50%" title="Evan You"></a>
  <a href="https://github.com/gaearon"><img src="https://avatars.githubusercontent.com/u/810438?v=4" width="70" style="border-radius:50%" title="Dan Abramov"></a>
</p>


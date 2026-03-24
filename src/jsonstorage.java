package com.javabooks;

import java.io.*;
import java.util.*;

public class JsonStorage implements BookStorage {

    @Override
    public void save(List<Book> books) throws IOException {
        BufferedWriter w = new BufferedWriter(new FileWriter("books.json"));
        w.write("[\n");
        for (int i = 0; i < books.size(); i++){
            Book b = books.get(i);
            w.write("  {\n");
            w.write("    \"title\": \"" + b.getTitle() + "\",\n");
            w.write("    \"author\": \"" + b.getAuthor() + "\",\n");
            w.write("    \"year\": " + b.getYear() + ",\n");
            w.write("    \"isbn\": \"" + b.getIsbn() + "\",\n");
            w.write("    \"borrowed\": " + b.isBorrowed() + "\n");
            w.write("  }" + (i < books.size() - 1 ? "," : "") + "\n");
        }
        w.write("]");
        w.close();
    }

    @Override
    public List<Book> load() throws IOException {
        List<Book> list = new ArrayList<>();
        File f = new File("books.json");
        if (!f.exists()) return list;

        BufferedReader r = new BufferedReader(new FileReader(f));
        String json = r.lines().reduce("", (a, b) -> a + b);
        r.close();

        json = json.replace("[", "").replace("]", "");
        String[] entries = json.split("\\},\\{");

        for (String e : entries){
            String clean = e.replace("{", "").replace("}", "");
            String[] parts = clean.split(",");

            Map<String, String> map = new HashMap<>();

            for (String p : parts){
                String[] kv = p.split(":", 2);
                map.put(
                        kv[0].replace("\"", "").trim(),
                        kv[1].replace("\"", "").trim()
                );
            }

            Book b = new Book(
                    map.get("title"),
                    map.get("author"),
                    Integer.parseInt(map.get("year")),
                    map.get("isbn")
            );

            if (Boolean.parseBoolean(map.get("borrowed"))) b.borrow();

            list.add(b);
        }
        return list;
    }
}

package org.example.systemManagment;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Library {

    File file = new File("/Users/atiyemogharnas/Documents/Mahsan/book/src/main/resources/bl.txt");
    int count = 0;

    public List<Book> generateBooksFromFile() {
        List<Book> books = new ArrayList<>();
        if (!file.exists()) {
            throw new RuntimeException("file not found");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = new Book();
                String[] parts = line.split("_");
                if (parts.length < 5) continue;
                book.setId(count++);
                book.setTitle(parts[1].trim());
                book.setAuthor(parts[2].trim());
                book.setYearPublication(LocalDate.parse(parts[3].trim()));
                book.setStatus(Book.Status.valueOf(parts[4].trim()));
                books.add(book);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public void createBook(List<Book> books, String title, String author, LocalDate yearPublication, Book.Status status) {
        if (!books.isEmpty()) {
            count = books.get(books.size() - 1).getId();
        }
        Book book = new Book();
        book.setId(count++);
        book.setTitle(title);
        book.setAuthor(author);
        book.setYearPublication(yearPublication);
        book.setStatus(status);
        books.add(book);
        writeInFile(books);
    }


    public void updateBook(List<Book> books, Integer id, String title, String author, LocalDate yearPublication, Book.Status status) {
        if (books.isEmpty()) {
            throw new RuntimeException("non book for update please add book");
        }
        if (id == null) {
            throw new IllegalArgumentException("Book id cannot be null for update");
        }
        for (Iterator<Book> it = books.iterator(); it.hasNext(); ) {
            Book book = it.next();
            Book lastBook = it.next();
            if (book.getId() == id) {
                book.setTitle(title == null ? book.getTitle() : title);
                book.setAuthor(author == null ? book.getAuthor() : author);
                book.setYearPublication(yearPublication == null ? book.getYearPublication() : yearPublication);
                book.setStatus(status == null ? book.getStatus() : status);
                books.remove(lastBook);
                books.add(book);
            } else {
                throw new RuntimeException("book id does not match");
            }
            writeInFile(books);
        }
    }

    public void deleteBook(List<Book> books, Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Book id cannot be null for delete");
        }
        books.removeIf(book -> book.getId() == id);
        writeInFile(books);
    }

    public void getBooksByTitle(List<Book> books, String title) {
        books.stream().filter(item -> item.getTitle().equals(title)).toList();
        writeInFile(books);

    }

    public void getBooksByAuthor(List<Book> books, String author) {
        books.stream().filter(item -> item.getAuthor().equals(author)).toList();
        writeInFile(books);
    }

    public void sortedByYearPublication(List<Book> books) {
        books.stream().sorted(Comparator.comparing(Book::getYearPublication)).toList();
       writeInFile(books);
    }

    public void writeInFile(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Book book : books) {
                writer.write(String.format("%d_%s_%s_%s_%s\n",
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getYearPublication(),
                        book.getStatus()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

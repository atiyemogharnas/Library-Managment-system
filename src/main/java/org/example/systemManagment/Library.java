package org.example.systemManagment;

import java.time.LocalDate;
import java.util.*;

public class Library {

    public Book createBook(Integer id, String title, String author, LocalDate yearPublication, Book.Status status) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setYearPublication(yearPublication);
        book.setStatus(status);
        return book;
    }

    public void updateBook(Integer id, ArrayList<Book> books, String title, String author, LocalDate yearPublication, Book.Status status) {
        if (books.isEmpty()) {
            throw new RuntimeException("non book for update please add book");
        }
        if (id == null) {
            throw new IllegalArgumentException("Book id cannot be null for update");
        }
        for (Iterator<Book> it = books.iterator(); it.hasNext(); ) {
            Book book = it.next();
            if (book.getId() == id) {
                book.setTitle(title == null ? book.getTitle() : title);
                book.setAuthor(author == null ? book.getAuthor() : author);
                book.setYearPublication(yearPublication == null ? book.getYearPublication() : yearPublication);
                book.setStatus(status == null ? book.getStatus() : status);
                books.add(book);

            } else {
                throw new RuntimeException("book id does not match");
            }
        }
    }

    public void deleteBook(Integer id, ArrayList<Book> books) {
        if (id == null) {
            throw new IllegalArgumentException("Book id cannot be null for delete");
        }
        books.removeIf(book -> book.getId() == id);
    }

    public List<String> getBooksByTitle(String title, ArrayList<Book> books) {
        return books.stream().filter(item -> item.getTitle().equals(title)).map(Book::getAuthor).toList();
    }

    public List<String> getBooksByAuthor(String author, ArrayList<Book> books) {
        return books.stream().filter(item -> item.getAuthor().equals(author)).map(Book::getTitle).toList();
    }

    public List<String> sortedByYearPublication(ArrayList<Book> books) {
        return books.stream().sorted(Comparator.comparing(Book::getYearPublication)).map(Book::getTitle).toList();
    }
}

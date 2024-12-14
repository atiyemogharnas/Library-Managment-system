package com.library.service;

import com.library.model.Book;
import com.library.model.LibraryItem;
import com.library.repository.DTO.LibraryItemRequestDTO;
import com.library.repository.LibraryItemRepository;
import com.library.utils.ConvertDate;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class BookService {

    private final List<LibraryItem> libraryItems;
    private final LibraryItemRepository libraryItemRepository;

    public BookService(LibraryItemRepository libraryItemRepository) {
        this.libraryItemRepository = libraryItemRepository;
        this.libraryItems = libraryItemRepository.getLibraryItems();
    }

    public void borrowingBook(Integer id) {
        Book book = (Book) libraryItemRepository.getLibraryItemById(id);
        Predicate<Book.Status> existBook = bookStatus -> book.getStatus() == Book.Status.EXIST;
        if (existBook.test(book.getStatus())) {
            LibraryItemRequestDTO requestDTO = new LibraryItemRequestDTO();
            requestDTO.setId(id);
            requestDTO.setTitle(book.getTitle());
            requestDTO.setAuthor(book.getAuthor());
            requestDTO.setYear(book.getYear());
            requestDTO.setLibraryItemType(LibraryItem.LibraryItemType.BOOK.name());
            requestDTO.setExtraInfo(Book.Status.BORROWED.name());
            libraryItemRepository.updateLibraryItem(requestDTO, ConvertDate.convertStringToDate("1403-09-25 12:00:00"));
        } else {
            throw new RuntimeException("It is not possible to borrow books");
        }
    }

    public void returnedBook(Integer id) {
        Book book = (Book) libraryItemRepository.getLibraryItemById(id);
        Predicate<Book.Status> borrowedBook = bookStatus -> book.getStatus() == Book.Status.BORROWED;
        if (borrowedBook.test(book.getStatus())) {
            LibraryItemRequestDTO requestDTO = new LibraryItemRequestDTO();
            requestDTO.setId(id);
            requestDTO.setTitle(book.getTitle());
            requestDTO.setAuthor(book.getAuthor());
            requestDTO.setYear(book.getYear());
            requestDTO.setLibraryItemType(LibraryItem.LibraryItemType.BOOK.name());
            requestDTO.setExtraInfo(Book.Status.EXIST.name());
            libraryItemRepository.updateLibraryItem(requestDTO, ConvertDate.convertStringToDate("1403-09-25 12:00:00"));
        } else {
            throw new RuntimeException("This book is not borrowed");
        }
    }

    public String showStatusBook(Integer id) {
        Book book = (Book) libraryItemRepository.getLibraryItemById(id);
        return book.getStatus().name();
    }


    public void showTitleBook() {
        libraryItems.forEach(item -> System.out.println(item.getTitle().toLowerCase()));
    }

    public void ShowBookWithItsCount() {
        libraryItems.forEach(item -> {
            BiConsumer<String, Integer> showDetails = (title, counter) -> {
                if (item.getType().equals(LibraryItem.LibraryItemType.BOOK)) {
                    System.out.println("book title :" + title + " counter:" + counter);
                }
            };
            Book book = (Book) item;
            showDetails.accept(book.getTitle(), book.getNumberOfBook());
        });
    }

}

package org.example.systemManagment.library;

import org.example.systemManagment.entity.Book;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class LibraryService implements Searchable, Sortable {

    List<LibraryItem> libraryItems;
    LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
        libraryItems = libraryRepository.getLibraryItems();
    }

    @Override
    public void searchLibraryItemsByValue(String value) {
        for (LibraryItem item : libraryItems) {
            if (item.getTitle().toLowerCase().contains(value.toLowerCase()) ||
                    item.getAuthor().toLowerCase().contains(value.toLowerCase())) {
                System.out.println(item.getTitle() + " " + item.getAuthor() + " " + item.getYear());
            } else if (item.getYear() == Integer.parseInt(value.trim())) {
                System.out.println(item.getTitle() + " " + item.getAuthor() + " " + item.getYear());
            }
        }
    }

    @Override
    public void sortByKeyword(String sortFiledName) {
        if (Objects.equals(sortFiledName.toLowerCase(), "title")) {
            libraryItems.sort(Comparator.comparing(LibraryItem::getTitle));
        } else if (Objects.equals(sortFiledName.toLowerCase(), "author")) {
            libraryItems.sort(Comparator.comparing(LibraryItem::getAuthor));
        } else {
            libraryItems.sort(Comparator.comparing(LibraryItem::getYear));
        }

        for (LibraryItem item : libraryItems) {
            System.out.println(item.getTitle() + " " + item.getAuthor() + " " + item.getYear());
        }
    }

        public void displayAllLibraryItems() {
        for (LibraryItem item : libraryItems) {
            item.display();
        }
    }

        public void displayItem(int id) {
        LibraryItem item = libraryRepository.getLibraryItemById(id);
        item.display();
    }


    public void BorrowingBook(Integer id) {
        Book book = (Book) libraryRepository.getLibraryItemById(id);
        if (book != null && book.getStatus() == Book.Status.EXIST) {
           libraryRepository.updateLibraryItem(book.getId(), LibraryItem.LibraryItemType.BOOK, Book.Status.BORROWED.name(), null, null, null, null);
        } else {
            throw new RuntimeException("امکان قرض گرفتن کتاب وجود ندارد");
        }
    }

    public void ReturnedBook(Integer id, Integer returnDate) {
        Book book = (Book) libraryRepository.getLibraryItemById(id);
        if (book != null && book.getStatus() == Book.Status.BORROWED) {
            libraryRepository.updateLibraryItem(book.getId(), LibraryItem.LibraryItemType.BOOK, Book.Status.EXIST.name(), returnDate, null, null, null);
        } else {
            throw new RuntimeException("امکان قرض گرفته شده وجود ندارد");
        }
    }

    public String showStatusBook(Integer id) {
        Book book = (Book) libraryRepository.getLibraryItemById(id);
        return book.getStatus().name();
    }


}

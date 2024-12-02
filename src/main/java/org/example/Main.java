package org.example;

import org.example.systemManagment.entity.Book;
import org.example.systemManagment.library.Library;
import org.example.systemManagment.library.LibraryItem;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner in = new Scanner(System.in);
        System.out.println("1. display all item");
        System.out.println("2. search in all item ");
        System.out.println("3. create item ");
        System.out.println("4. delete item ");
        System.out.println("5. update item ");
        System.out.println("6. display item ");
        System.out.println("7. sort items ");
        String choice = in.nextLine();
        do {
            switch (choice) {
                case "1":
                    library.dispalyAllLibraryItems();
                    break;
                case "2":
                    System.out.println("please enter a keyword for search");
                    String keyword = in.nextLine();
                    library.search(keyword);
                    break;
                case "3":
                    System.out.println("please enter a title for create");
                    String title = in.nextLine();
                    System.out.println("please enter a author for create");
                    String author = in.nextLine();
                    System.out.println("please enter a year for create");
                    String year = in.nextLine();
                    System.out.println("please enter a type library for create item");
                    String type = in.nextLine();
                    if (type.equals("book")) {
                        System.out.println("please enter a status for create");
                        String status = in.nextLine();
                        Book book = new Book();
                        book.setTitle(title);
                        book.setAuthor(author);
                        book.setYear(Integer.parseInt(year));
                        book.setType(LibraryItem.LibraryItemType.BOOK);
                        book.setStatus(Book.Status.valueOf(status));
                        library.addLibraryItem(book);
                    }
                    break;
                case "4":
                    System.out.println("please enter a id for delete");
                    int id = in.nextInt();
                    library.deleteLibraryItem(id);
                    break;

                case "5":
                    System.out.println("please enter a id for update");
                    int idForUpdate = in.nextInt();
                    System.out.println("please enter a type library for update item");
                    String typeForUpdate = in.nextLine();
                    if (typeForUpdate.equals("book")) {
                        System.out.println("please enter a status for update");
                        String status = in.nextLine();
                        library.updateLibraryItem(idForUpdate, LibraryItem.LibraryItemType.valueOf(typeForUpdate), status, null, null, null);
                    } else if (typeForUpdate.equals("thesis")) {
                        System.out.println("please enter a university for update");
                        String university = in.nextLine();
                        library.updateLibraryItem(idForUpdate, LibraryItem.LibraryItemType.valueOf(typeForUpdate), null, null, university, null);

                    }
                    break;
                case "6":
                    System.out.println("please enter a id for display");
                    int idForDisplay = in.nextInt();
                    library.displayItem(idForDisplay);
                    break;

                case "7":
                    library.sortList();
                    break;

            }

        } while (Integer.parseInt(choice) != 0);

    }
}
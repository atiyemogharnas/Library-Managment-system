package org.example.systemManagment.library;

import org.example.systemManagment.entity.Book;
import org.example.systemManagment.entity.Magazine;
import org.example.systemManagment.entity.Refrence;
import org.example.systemManagment.entity.Thesis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library implements Comparator<LibraryItem> {

    private List<LibraryItem> libraryItems = new ArrayList<>();

    public Library() {
        libraryItems = readLibrartItemesFromFile();
    }

    public List<LibraryItem> readLibrartItemesFromFile() {
        File file = new File("/Users/atiyemogharnas/Documents/Mahsan/book/src/main/java/resources/book.txt");

        if (!file.exists()) {
            throw new RuntimeException("file not found");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 1;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("_");
                if (parts[3].trim().equals(LibraryItem.LibraryItemType.BOOK.toString())) {
                    Book book = new Book();
                    book.setId(count++);
                    book.setTitle(parts[1].trim());
                    book.setAuthor(parts[2].trim());
                    book.setYear(Integer.parseInt(parts[4].trim()));
                    book.setStatus(Book.Status.valueOf(parts[5].trim()));
                    libraryItems.add(book);
                } else if (parts[3].trim().equals(LibraryItem.LibraryItemType.THESIS.toString())) {
                    Thesis thesis = new Thesis();
                    thesis.setId(count++);
                    thesis.setTitle(parts[1].trim());
                    thesis.setAuthor(parts[2].trim());
                    thesis.setYear(Integer.parseInt(parts[4].trim()));
                    thesis.setUniversity(parts[5].trim());
                    libraryItems.add(thesis);
                } else if (parts[3].trim().equals(LibraryItem.LibraryItemType.MAGAZINE.toString())) {
                    Magazine magazine = new Magazine();
                    magazine.setId(count++);
                    magazine.setTitle(parts[1].trim());
                    magazine.setAuthor(parts[2].trim());
                    magazine.setYear(Integer.parseInt(parts[4].trim()));
                    magazine.setGenre(parts[5].trim());
                    libraryItems.add(magazine);
                } else if (parts[3].trim().equals(LibraryItem.LibraryItemType.REFRENCE.toString())) {
                    Refrence refrence = new Refrence();
                    refrence.setId(count++);
                    refrence.setTitle(parts[1].trim());
                    refrence.setAuthor(parts[2].trim());
                    refrence.setYear(Integer.parseInt(parts[4].trim()));
                    refrence.setRefrenceType(Refrence.RefrenceType.valueOf(parts[5].trim()));
                    libraryItems.add(refrence);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return libraryItems;
    }

    public void addLibraryItem(LibraryItem item) {
        libraryItems.add(item);
    }

    public void deleteLibraryItem(int id) {
        libraryItems.remove(getLibraryItemById(id));
    }

    public void updateLibraryItem(int id, LibraryItem.LibraryItemType type, String status, String genre, String university, String refrenceType) {
        LibraryItem oldItem = getLibraryItemById(id);
        if (type == LibraryItem.LibraryItemType.BOOK) {
            Book book = (Book) oldItem;
            book.setStatus(Book.Status.valueOf(status));
            libraryItems.remove(oldItem);
            libraryItems.add(book);
        } else if (type == LibraryItem.LibraryItemType.THESIS) {
            Thesis thesis = (Thesis) oldItem;
            thesis.setUniversity(university);
            libraryItems.remove(oldItem);
            libraryItems.add(thesis);
        } else if (type == LibraryItem.LibraryItemType.MAGAZINE) {
            Magazine magazine = (Magazine) oldItem;
            magazine.setGenre(genre);
            libraryItems.remove(oldItem);
            libraryItems.add(magazine);
        } else if (type == LibraryItem.LibraryItemType.REFRENCE) {
            Refrence refrence = (Refrence) oldItem;
            refrence.setRefrenceType(Refrence.RefrenceType.valueOf(refrenceType));
            libraryItems.remove(oldItem);
            libraryItems.add(refrence);
        }
    }

    public void displayItem(int id) {
        LibraryItem item = getLibraryItemById(id);
        item.display();
    }

    public LibraryItem getLibraryItemById(int id) {
        return libraryItems.get(id);
    }

    public void search(String keyword) {
        binerySearch(0, libraryItems.size()-1, keyword);
//        for (LibraryItem item : libraryItems) {
//            if (item.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
//                    item.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
//                    item.getYear() == Integer.parseInt(keyword.trim())) {
//                System.out.println(item.getTitle() + " " + item.getAuthor() + " " + item.getYear());
//            }
//        }
    }

    public void dispalyAllLibraryItems() {
        for (LibraryItem item : libraryItems) {
            item.display();
        }
    }

    public void sortList() {
        Comparator<LibraryItem> myComparator = new Library();
        libraryItems.sort(myComparator);
        for (LibraryItem item : libraryItems) {
            item.display();
        }
    }

    @Override
    public int compare(LibraryItem o1, LibraryItem o2) {
        if (o1.getTitle().compareTo(o2.getTitle()) < 0) {
            return 1;
        } else if (o1.getTitle().compareTo(o2.getTitle()) > 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public LibraryItem binerySearch( int first, int end, String key) {
        int mid = (first + end) / 2;
        LibraryItem middleItem = libraryItems.get(mid);
        if (middleItem.getTitle().equalsIgnoreCase(key)) {
          return middleItem;
        }else if(middleItem.getTitle().compareTo(key) > 0) {
            return binerySearch(first, mid - 1, key);
        }else {
            return binerySearch(mid + 1, end, key);
        }
    }
}

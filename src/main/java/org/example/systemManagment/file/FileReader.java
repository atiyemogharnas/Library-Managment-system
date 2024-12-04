package org.example.systemManagment.file;

import org.example.systemManagment.ConvertTime;
import org.example.systemManagment.entity.Book;
import org.example.systemManagment.entity.Magazine;
import org.example.systemManagment.entity.Refrence;
import org.example.systemManagment.entity.Thesis;
import org.example.systemManagment.library.LibraryItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private   List<LibraryItem> libraryItems = new ArrayList<>();

    public  List<LibraryItem> readLibrartItemesFromFile() throws FileNotFoundException {
        File file = new File("D:\\Educational Mahsan\\Library-Managment-system\\src\\main\\java\\resources\\book.txt");

        if (!file.exists()) {
            throw new FileNotFoundException("file not found");
        }

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("_");
                if (parts[3].trim().equals(LibraryItem.LibraryItemType.BOOK.toString())) {
                    Book book = new Book();
                    book.setId(count++);
                    book.setTitle(parts[1].trim());
                    book.setAuthor(parts[2].trim());
                    book.setYear(ConvertTime.convertStringToDate(parts[4].trim()));
                    book.setStatus(Book.Status.valueOf(parts[5].trim()));
                    libraryItems.add(book);
                } else if (parts[3].trim().equals(LibraryItem.LibraryItemType.THESIS.toString())) {
                    Thesis thesis = new Thesis();
                    thesis.setId(count++);
                    thesis.setTitle(parts[1].trim());
                    thesis.setAuthor(parts[2].trim());
                    thesis.setYear(ConvertTime.convertStringToDate(parts[4].trim()));
                    thesis.setUniversity(parts[5].trim());
                    libraryItems.add(thesis);
                } else if (parts[3].trim().equals(LibraryItem.LibraryItemType.MAGAZINE.toString())) {
                    Magazine magazine = new Magazine();
                    magazine.setId(count++);
                    magazine.setTitle(parts[1].trim());
                    magazine.setAuthor(parts[2].trim());
                    magazine.setYear(ConvertTime.convertStringToDate(parts[4].trim()));
                    magazine.setGenre(parts[5].trim());
                    libraryItems.add(magazine);
                } else if (parts[3].trim().equals(LibraryItem.LibraryItemType.REFRENCE.toString())) {
                    Refrence refrence = new Refrence();
                    refrence.setId(count++);
                    refrence.setTitle(parts[1].trim());
                    refrence.setAuthor(parts[2].trim());
                    refrence.setYear(ConvertTime.convertStringToDate(parts[4].trim()));
                    refrence.setRefrenceType(Refrence.RefrenceType.valueOf(parts[5].trim()));
                    libraryItems.add(refrence);
                } else {
                    throw new RuntimeException("نوع مورد نظر قابلیت افزودن ندارد");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return libraryItems;
    }
}

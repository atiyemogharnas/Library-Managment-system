package com.library.utils;

import com.library.model.Book;
import com.library.model.LibraryItem;
import com.library.model.Magazine;
import com.library.model.Thesis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileWriter {

    public static void writeInFile(List<LibraryItem> items) {

        File file = new File("D:\\Educational Mahsan\\Library-Managment-system\\src\\main\\java\\resources\\book.txt");
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file))) {
            for (LibraryItem item : items) {
                if (item instanceof Book book) {
                    writer.write(String.format("%d_%s_%s_%s_%s_%s\n",
                            book.getId(),
                            book.getTitle(),
                            book.getAuthor(),
                            book.getType(),
                            ConvertDate.convertDateToString(book.getYear()),
                            book.getStatus()
                    ));
                } else if (item instanceof Magazine magazine) {
                    writer.write(String.format("%d_%s_%s_%s_%s_%s\n",
                            magazine.getId(),
                            magazine.getTitle(),
                            magazine.getAuthor(),
                            magazine.getType(),
                            ConvertDate.convertDateToString(magazine.getYear()),
                            magazine.getGenre()
                    ));
                } else if (item instanceof Thesis thesis) {
                    writer.write(String.format("%d_%s_%s_%s_%s_%s\n",
                            thesis.getId(),
                            thesis.getTitle(),
                            thesis.getAuthor(),
                            thesis.getType(),
                            ConvertDate.convertDateToString(thesis.getYear()),
                            thesis.getUniversity()
                    ));
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }

    }

}

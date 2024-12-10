package com.library.utils;

import com.library.patterns.factory.LibraryItemFactory;
import com.library.repository.DTO.LibraryItemRequestDTO;
import com.library.model.LibraryItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private static final List<LibraryItem> libraryItems = new ArrayList<>();

    public static List<LibraryItem> readLibraryItemsFromFile() throws FileNotFoundException {
        File file = new File("D:\\Educational Mahsan\\Library-Managment-system\\src\\main\\java\\resources\\book.txt");

        if (!file.exists()) {
            throw new FileNotFoundException("file not found");
        }

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("_");
                LibraryItemRequestDTO requestDTO = new LibraryItemRequestDTO();
                requestDTO.setId(Integer.parseInt(parts[0]));
                requestDTO.setTitle(parts[1].trim());
                requestDTO.setAuthor(parts[2].trim());
                requestDTO.setYear(ConvertDate.convertStringToDate(parts[4].trim()));
                requestDTO.setLibraryItemType(parts[3].trim());
                requestDTO.setExtraInfo(parts[5].trim());
                libraryItems.add(LibraryItemFactory.createItem(parts[3].trim(), requestDTO));
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return libraryItems;
    }

    public static List<LibraryItem> getLibraryItems() throws FileNotFoundException {
        return readLibraryItemsFromFile();
    }
}

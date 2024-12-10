package com.library.patterns.factory;

import com.library.model.LibraryItem;
import com.library.patterns.builder.LibraryItemBuilder;
import com.library.repository.DTO.LibraryItemRequestDTO;

public class LibraryItemFactory {

    public static LibraryItem createItem(String objectType, LibraryItemRequestDTO requestDTO) {
        try {
            return new LibraryItemBuilder()
                    .id(requestDTO.getId())
                    .title(requestDTO.getTitle())
                    .author(requestDTO.getAuthor())
                    .year(requestDTO.getYear())
                    .libraryItemType(objectType)
                    .extraInfo(requestDTO.getExtraInfo())
                    .build();
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}

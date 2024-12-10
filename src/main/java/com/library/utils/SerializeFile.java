package com.library.utils;

import com.library.utils.protoc.LibraryItem;

public class SerializeFile {

    public static void serializeWithProtoc() {
        try {
           LibraryItem item = LibraryItem.newBuilder()
                    .setId(1)
                    .setTitle("test")
                    .setAuthor("George")
                    .setYear("1377-08-01 23:09:43")
                    .setType(LibraryItem.LibraryItemType.BOOK)
                    .build();

            byte[] serializedData = item.toByteArray();

            LibraryItem deserializedItem = LibraryItem.parseFrom(serializedData);

            System.out.println("Title: " + deserializedItem.getTitle());
            System.out.println("Author: " + deserializedItem.getAuthor());
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}

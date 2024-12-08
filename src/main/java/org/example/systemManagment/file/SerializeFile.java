package org.example.systemManagment.file;

import com.google.gson.Gson;
import org.example.systemManagment.entity.Book;
import org.example.systemManagment.library.LibraryItem;
import org.example.systemManagment.library.LibraryRepository;

import java.io.*;

public class SerializeFile {
    LibraryRepository libraryRepository;
    String path = "D:\\Educational Mahsan\\Library-Managment-system\\src\\main\\java\\resources\\serialize.ser";

    public SerializeFile(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }


    public void serializeWithJson(LibraryItem libraryItem) {
        Gson gson = new Gson();
        String json = gson.toJson(libraryItem);
        System.out.println("serialize Object success");
        LibraryItem deserializedObject = gson.fromJson(json, Book.class);
        System.out.println("Deserialization success");
        System.out.println("Deserialization object : " + deserializedObject);
    }

    public void serialize(LibraryItem libraryItem) {
        try (FileOutputStream file = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(file)) {
            out.writeObject(libraryItem);
            System.out.println("Serialization successful");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void deserialize() {
        try {
            System.out.println("Deserialized Object:");
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            LibraryItem item = (LibraryItem) ois.readObject();
            System.out.println("Deserialization success");
            System.out.println(item.getTitle() + " " + item.getAuthor());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void serializeWithProtoc() {
        try {
            org.example.systemManagment.file.LibraryItem item = org.example.systemManagment.file.LibraryItem.newBuilder()
                    .setId(1)
                    .setTitle("test")
                    .setAuthor("George")
                    .setYear("1377-08-01 23:09:43")
                    .build();

            byte[] serializedData = item.toByteArray();

            org.example.systemManagment.file.LibraryItem deserializedItem = org.example.systemManagment.file.LibraryItem.parseFrom(serializedData);

            System.out.println("Title: " + deserializedItem.getTitle());
            System.out.println("Author: " + deserializedItem.getAuthor());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

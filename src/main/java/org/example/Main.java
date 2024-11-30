package org.example;

import org.example.systemManagment.Book;
import org.example.systemManagment.Library;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        Library library = new Library();


        Scanner in = new Scanner(System.in);
        System.out.println("لطفا بگویید چه کاری میخواهید انجام دهید: ۱)ایجاد کتاب ۲) ویرایش کتاب ۳) حذف کتاب ۴) جستجو بر اساس عنوان ۵) جستجو بر اساس نویسنده ۶)مرتب کردن کتاب ها بر اساس سال انتشار لطفا عدد مورد نظر را وارد کنید");
        int number;
        do {
            number = in.nextInt();
            if (number == 1) {
                System.out.println("please enter a title");
                String title = in.next();
                System.out.println("please enter a author");
                String author = in.next();
                System.out.println("please enter a year");
                String year = in.next();
                System.out.println("please enter a status");
                String status = in.next();
                library.createBook(count++, title, author, LocalDate.parse(year), Book.Status.valueOf(status));
            } else if (number == 2) {
                System.out.println("please enter a book id ");
                Integer id = in.nextInt();
                System.out.println("please enter a title");
                String title = in.nextLine();
                System.out.println("please enter a author");
                String author = in.nextLine();
                System.out.println("please enter a year");
                String year = in.nextLine();
                System.out.println("please enter a status");
                String status = in.nextLine();
                library.updateBook(id, title, author, LocalDate.parse(year), Book.Status.valueOf(status));
            } else if (number == 3) {
                System.out.println("please enter a book id ");
                Integer id = in.nextInt();
                library.deleteBook(id);
            } else if (number == 4) {
                System.out.println("please enter a book title");
                String title = in.next();
                System.out.println(library.getBooksByTitle(title));
            } else if (number == 5) {
                System.out.println("please enter a book author");
                String author = in.next();
                System.out.println(library.getBooksByAuthor(author));
            } else if (number == 6) {
                System.out.println(library.sortedByYearPublication());
            }
        } while (number != 0);

    }
}
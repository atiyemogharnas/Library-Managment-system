package org.example;

import org.example.systemManagment.Book;
import org.example.systemManagment.Library;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Library library = new Library();

        List<Book> books = library.generateBooksFromFile();

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
                library.createBook(books, title, author, LocalDate.parse(year), Book.Status.valueOf(status));
                System.out.println("کاربر به فایل افزوده شد");
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
                library.updateBook(books,id, title, author, LocalDate.parse(year), Book.Status.valueOf(status));
                System.out.println("کاربر در فایل آبدیت شد");
            } else if (number == 3) {
                System.out.println("please enter a book id ");
                Integer id = in.nextInt();
                library.deleteBook(books,id);
                System.out.println("کاربر از فایل حذف شد");
            } else if (number == 4) {
                System.out.println("please enter a book title");
                String title = in.next();
                library.getBooksByTitle(books,title);
                System.out.println("فایل بروزرسانی شد");
            } else if (number == 5) {
                System.out.println("please enter a book author");
                String author = in.next();
                library.getBooksByAuthor(books,author);
                System.out.println("فایل بروزرسانی شد");
            } else if (number == 6) {
                library.sortedByYearPublication(books);
                System.out.println("فایل بروزرسانی شد");
            }
        } while (number != 0);

    }
}
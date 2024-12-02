package systemManagment;

import org.example.systemManagment.entity.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LibraryTest {


    List<Book> books = new ArrayList<>();

    @Test
    public void createBook_Test(){
        Book book1 = new Book();
        book1.setTitle("test Title");
        book1.setAuthor("test Author");
        book1.setYear(Integer.parseInt("2020"));
        book1.setStatus(Book.Status.valueOf("EXIST"));

        Book book2 = new Book();
        book2.setTitle("test2 Title");
        book2.setAuthor("test2 Author");
        book2.setYear(Integer.parseInt("2024"));
        book2.setStatus(Book.Status.valueOf("EXIST"));

        books.addAll(Arrays.asList(book1, book2));

        Assert.assertNotNull(books);
        Assert.assertEquals(2, books.size());
    }

    @Test
    public void updateBook_Test(){
        Book book1 = new Book();
        book1.setTitle("test Title");
        book1.setAuthor("test Author");
        book1.setYear(Integer.parseInt("2020"));
        book1.setStatus(Book.Status.valueOf("EXIST"));

        Book book2 = new Book();
        book2.setTitle("test2 Title");
        book2.setAuthor("test2 Author");
        book2.setYear(Integer.parseInt("2024"));
        book2.setStatus(Book.Status.valueOf("EXIST"));
        books.addAll(Arrays.asList(book1, book2));

        Book updatedBook = books.get(1);
        updatedBook.setTitle("test Updated");

        Assert.assertEquals(2, books.size());
        Assert.assertEquals(updatedBook.getTitle(), "test Updated");
    }

    @Test
    public void updateBook_Test_WhenIdNotExist(){
        Book book1 = new Book();
        book1.setTitle("test Title");
        book1.setAuthor("test Author");
        book1.setYear(Integer.parseInt("2020"));
        book1.setStatus(Book.Status.valueOf("EXIST"));

        Book book2 = new Book();
        book2.setTitle("test2 Title");
        book2.setAuthor("test2 Author");
        book2.setYear(Integer.parseInt("2024"));
        book2.setStatus(Book.Status.valueOf("EXIST"));
        books.addAll(Arrays.asList(book1, book2));
        Assert.assertThrows( Exception.class, () -> {books.stream().filter(book -> book.getId() == 3).findFirst().get();});
    }

    @Test
    public void deleteBook_Test(){
        Book book1 = new Book();
        book1.setTitle("test Title");
        book1.setAuthor("test Author");
        book1.setYear(Integer.parseInt("2020"));
        book1.setStatus(Book.Status.valueOf("EXIST"));

        Book book2 = new Book();
        book2.setTitle("test2 Title");
        book2.setAuthor("test2 Author");
        book2.setYear(Integer.parseInt("2024"));
        book2.setStatus(Book.Status.valueOf("EXIST"));
        books.addAll(Arrays.asList(book1, book2));

        books.remove(book1);

        Assert.assertEquals(1, books.size());
    }

    @Test
    public void findBooksByTitle_Test(){
        Book book1 = new Book();
        book1.setTitle("test Title");
        book1.setAuthor("test Author");
        book1.setYear(Integer.parseInt("2020"));
        book1.setStatus(Book.Status.valueOf("EXIST"));

        Book book2 = new Book();
        book2.setTitle("test2 Title");
        book2.setAuthor("test2 Author");
        book2.setYear(Integer.parseInt("2024"));
        book2.setStatus(Book.Status.valueOf("EXIST"));
        books.addAll(Arrays.asList(book1, book2));

        List<String> booksAuthor = books.stream().filter(item -> item.getTitle().equals(book1.getTitle())).map(Book::getAuthor).toList();

        Assert.assertEquals(1, booksAuthor.size());
    }
}

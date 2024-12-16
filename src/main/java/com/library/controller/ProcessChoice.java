package com.library.controller;

import com.library.repository.DTO.LibraryItemRequestDTO;
import com.library.repository.LibraryItemRepository;
import com.library.service.BookService;
import com.library.service.JDBCCrud;
import com.library.service.LibraryItemService;
import com.library.utils.ConvertDate;

import java.util.Date;
import java.util.Scanner;

import static com.library.utils.ConvertDate.convertStringToDate;

public class ProcessChoice {

    private static final LibraryItemRepository repository = new LibraryItemRepository();
    private static final LibraryItemService service = LibraryItemService.getInstance(repository);
    private static final BookService bookservice = new BookService(repository);
    private static final JDBCCrud jdbcCrud = new JDBCCrud();
    private static final LibraryItemController controller = new LibraryItemController(service, bookservice,jdbcCrud);


    public static boolean processChoice(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                controller.createLibraryItem(getTypeFromUserInConsole(scanner), createItemRequestDtoFromConsole(scanner));
                break;
            case 2:
                controller.updateLibraryItem(createItemRequestDtoFromConsole(scanner), ConvertDate.convertStringToDate("1403-09-25 12:00:00"));
                break;
            case 3:
                controller.deleteLibraryItem(getIdFromUserInConsole(scanner));
                break;
            case 4:
                controller.displayLibraryItem(getIdFromUserInConsole(scanner));
                break;
            case 5:
                controller.displayAllLibraryItems();
                break;
            case 6:
                controller.sortLibraryItems(getTypeFromUserInConsole(scanner));
                break;
            case 7:
                controller.searchLibraryItemsByValue(getWordForSearchFromUserInConsole(scanner));
                break;
            case 8:
                controller.borrowingBook(getIdFromUserInConsole(scanner));
                break;
            case 9:
                controller.returningBook(getIdFromUserInConsole(scanner));
                break;
            case 10:
                controller.showStatusBook(getIdFromUserInConsole(scanner));
                break;
            case 11:
                controller.searchByTitle(getYearOrTitleFromUserInConsole(scanner));
                break;
            case 12:
                controller.searchByYear(getYearOrTitleFromUserInConsole(scanner));
                break;
            case 13:
                controller.serializeAndDeserializeLibraryItems();
                break;
            case 14:
                controller.multithreaded();
                break;
            case 15:
                controller.checkUpdateJDBC();
            case 16:
                controller.checkDeleteJDBC();
            case 17:
                controller.checkFetchDataJDBC();
            case 0:
                System.out.println("Exiting...");
                return false;
            default:
                System.out.println("Invalid option. Please try again.");
        }
        return true;
    }

    public static LibraryItemRequestDTO createItemRequestDtoFromConsole(Scanner scanner) {
        String objectType = "";
        while (objectType.isEmpty()) {
            System.out.print("Enter object type (book, magazine, thesis): ");
            objectType = scanner.nextLine().trim();
            if (objectType.isEmpty()) {
                System.out.println("Object type cannot be empty.");
            }
        }

        int id = 0;
        while (id == 0) {
            System.out.print("Enter id: ");
            id = scanner.nextInt();
            if (id == 0) {
                System.out.println("id cannot be zero.");
            }
        }

        String title = "";
        while (title.isEmpty()) {
            System.out.print("Enter title: ");
            title = scanner.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("Title cannot be empty.");
            }
        }

        String author = "";
        while (author.isEmpty()) {
            System.out.print("Enter author: ");
            author = scanner.nextLine().trim();
            if (author.isEmpty()) {
                System.out.println("Author cannot be empty.");
            }
        }

        Date year = null;
        while (year == null) {
            System.out.print("Enter year (yyyy-mm-dd): ");
            String yearString = scanner.nextLine().trim();
            year = convertStringToDate(yearString);
            if (year == null) {
                System.out.println("Invalid date format. Please use yyyy-mm-dd.");
            }
        }

        String extraInfo = "";
        while (extraInfo.isEmpty()) {
            System.out.print("Enter extra info (status for book): ");
            extraInfo = scanner.nextLine().trim();
            if (extraInfo.isEmpty()) {
                System.out.println("Extra info cannot be empty.");
            }
        }

        return new LibraryItemRequestDTO(id,title, author, year, objectType, extraInfo);
    }

    public static Integer getIdFromUserInConsole(Scanner scanner) {
        System.out.print("Enter id of library item: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getTypeFromUserInConsole(Scanner scanner) {
        System.out.print("Enter type of library item: ");
        return scanner.nextLine();
    }

    public static String getWordForSearchFromUserInConsole(Scanner scanner) {
        System.out.print("Enter word for search in items: ");
        return scanner.nextLine();
    }

    public static String getYearOrTitleFromUserInConsole(Scanner scanner) {
        System.out.print("Enter year or title for search in items: ");
        return scanner.nextLine();
    }
}

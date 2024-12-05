
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в программу созданую Максимом и Аркадием одной жаркой ночью..\n Введите число: \n1 - Создание своей библиотеки \n2 - Добавить книгу \n3 - Поиск книги по параметрам \n4 - Удаление книги");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                createLibrary();
                break;
            case 2:
                addBook(scanner);
                break;
            case 3:
                searchBook(scanner);
                break;
            case 4:
                deleteBook(scanner);
                break;
            default:
                System.out.println("Вы ввели неккоректное значение. Попробуйте ввести цифру 1 до 4.");
        }
    }

    private static void createLibrary() {
        try {
            File newFile = new File("Личная библиотека.txt");
            if (newFile.createNewFile()) {
                System.out.println("Вы успешно создали свою личную библиотеку, время заполнить её книгами!");
            } else {
                System.out.println("У вас уже есть своя личная библиотека.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании библиотеки: " + e.getMessage());
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.println("Введите информацию о вашей кНИГЕ:");
        System.out.print("Автор: ");
        String author = scanner.nextLine();
        System.out.print("Название: ");
        String title = scanner.nextLine();
        System.out.print("Издатель: ");
        String publisher = scanner.nextLine();
        System.out.print("Год выпуска: ");
        String year = scanner.nextLine();
        System.out.print("Страна происхождения: ");
        String country = scanner.nextLine();
        System.out.print("Раздел библиотеки: ");
        String librarySection = scanner.nextLine();

        Book newBook = new Book(author, title, publisher, year, country, librarySection);

        try (FileWriter writer = new FileWriter("Личная библиотека.txt", true)) {
            writer.write(newBook.getAuthor() + "|" + newBook.getTitle() + "|" + newBook.getPublisher() + "|" +
                    newBook.getYear() + "|" + newBook.getCountry() + "|" + newBook.getLibrarySection() + "\n");
            System.out.println("кНИГА успешно добавлена!");
        } catch (IOException e) {
            System.out.println("Ошибка при добавлении кНИГИ 0_0: " + e.getMessage());
        }
    }

    private static void searchBook(Scanner scanner) {
        System.out.println("Введите параметр для поиска (Автор, Название, Издатель, Год, Страна, Раздел):");
        String query = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("Личная библиотека.txt"))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(query.toLowerCase())) {
                    System.out.println("Найдена книга: " + line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Книга с таким параметром не найдена.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при поиске книги: " + e.getMessage());
        }
    }

    private static void deleteBook(Scanner scanner) {
        System.out.println("Введите параметр книги, которую хотите удалить:");
        String query = scanner.nextLine();

        List<String> books = new ArrayList<>();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("Личная библиотека.txt"))) {
            String line;


            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(query.toLowerCase())) {
                    found = true;
                    System.out.println("Удалена книга: " + line);
                } else {
                    books.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при удалении книги: " + e.getMessage());
            return;
        }

        if (found) {
            try (FileWriter writer = new FileWriter("Личная библиотека.txt")) {
                for (String book : books) {
                    writer.write(book + "\n");
                }
                System.out.println("Библиотека успешно обновлена.");
            } catch (IOException e) {
                System.out.println("Ошибка при обновлении файла: " + e.getMessage());
            }
        } else {
            System.out.println("Книга с таким параметром не найдена.");
        }
    }
}
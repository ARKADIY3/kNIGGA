import org.example.Category;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
//        Book book1 = new Book ("1", "1", "1", 1, Category.Homestay, "а");
//        System.out.println(book1.toString());
        System.out.println();
        System.out.println("Добро пожаловать в программу созданную Максимом и Аркадием!");
        System.out.println("Наша программа позволяет вам создать свою личную библиотеку uWu");
        System.out.println("Выберите необходимое действие ниже:");
        System.out.println();
        System.out.println("1) Создать свою личную библиотеку");
        System.out.println("2) Добавить книгу в личную библиотеку");
        System.out.println("3) Найти книгу в личной библиотеке");
        System.out.println("4) Удалить книгу из личной библиотеки");
        Scanner input = new Scanner(System.in);
        int inputValue = input.nextInt();
        input.close();

        switch (inputValue) {
            case 1:
                createPersonalLibrary();
                break;
            case 2:
                addBook();
                break;
            case 3:
                readFile();
                break;
            case 4:
                System.out.println("Вы выбрали опцию 4.");
                break;
            default:
                System.out.println("Ошибка ввода. Пожалуйста, введите цифру 1, 2, 3 или 4 и повторите попытку.");
                break;
        }
    }

    private static void createPersonalLibrary() {
        try {
            File newFile = new File("Личная Библиотека.txt");
            if (newFile.createNewFile()) {
                System.out.println("Вы успешно создали свою личную библиотеку, время заполнить её кНигами!");
            } else {
                System.out.println("У вас уже есть своя личная библиотека.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addBook() {
        try {
            FileWriter writer = new FileWriter("Личная Библиотека.txt");
            writer.write("1");
            writer.close();
            System.out.println("Запись данных в файл прошла успешно");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }

    private static void readFile() {
        try (FileReader reader = new FileReader("NewDelftstack.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("Считать файл не получилось");
            e.printStackTrace();
        }
    }
}

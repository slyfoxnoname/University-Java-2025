package HomeWorks.hm05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Book {
    String author;
    String title;
    int year;

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }
}

public class B05_06 {

    public static List<Book> readBooks(String fileName) {
        List<Book> books = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNext()) {
                String author = sc.next();
                String title = sc.next();
                int year = sc.nextInt();
                books.add(new Book(author, title, year));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!");
        }
        return books;
    }

    // (a) Книги за роком
    public static void findByYear(List<Book> books, int year, String outFile) {
        try (PrintWriter pw = new PrintWriter(outFile)) {
            for (Book b : books) {
                if (b.year == year) {
                    pw.println(b.author + " " + b.title + " " + b.year);
                }
            }
            System.out.println("Результат записано у файл: " + outFile);
        } catch (IOException e) {
            System.out.println("Помилка запису у файл.");
        }
    }

    // (b) Кількість книг кожного автора
    public static void countByAuthor(List<Book> books, String outFile) {
        Map<String, Integer> authorCount = new HashMap<>();

        for (Book b : books) {
            authorCount.put(b.author, authorCount.getOrDefault(b.author, 0) + 1);
        }

        try (PrintWriter pw = new PrintWriter(outFile)) {
            for (Map.Entry<String, Integer> entry : authorCount.entrySet()) {
                pw.println(entry.getKey() + " — " + entry.getValue());
            }
            System.out.println("Результат записано у файл: " + outFile);
        } catch (IOException e) {
            System.out.println("Помилка запису у файл.");
        }
    }

    public static void main(String[] args) {
       List<Book> books = readBooks("books.txt");


        int searchYear = 1841;
        findByYear(books, searchYear, "books_by_year.txt");
        countByAuthor(books, "books_by_author.txt");
    }
}

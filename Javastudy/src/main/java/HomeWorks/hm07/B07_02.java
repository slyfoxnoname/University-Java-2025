package HomeWorks.hm07;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class B07_02 {
    // a) створення файлу з іграшками
    public static void createToyFile(String filename, List<Toy> toys) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Toy toy : toys) {
                oos.writeObject(toy);
            }
        }
    }

    // b) зчитування файлу з іграшками
    public static List<Toy> readToyFile(String filename) throws IOException, ClassNotFoundException {
        List<Toy> toys = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Toy toy = (Toy) ois.readObject();
                    toys.add(toy);
                } catch (EOFException e) {
                    break;
                }
            }
        }
        return toys;
    }

    // Запис іграшок, які підходять для дитини певного віку, у новий файл
    public static void writeToysForAge(String sourceFile, String targetFile, int age)
            throws IOException, ClassNotFoundException {

        List<Toy> allToys = readToyFile(sourceFile);
        List<Toy> suitable = new ArrayList<>();

        for (Toy toy : allToys) {
            if (toy.isForAge(age)) suitable.add(toy);
        }

        createToyFile(targetFile, suitable);
    }

    // Демонстрація
    public static void main(String[] args) {
        String fileAll = "ToysAll.dat";
        String fileForAge = "ToysForAge.dat";

        List<Toy> toys = List.of(
                new Toy("М'яч", 150, 3, 10),
                new Toy("Лялька", 250, 4, 8),
                new Toy("Конструктор", 400, 6, 14),
                new Toy("Пірамідка", 100, 1, 3),
                new Toy("Настільна гра", 500, 8, 15)
        );

        try {
            // Створюємо файл з усіма іграшками
            createToyFile(fileAll, toys);

            // Читаємо файл і показуємо
            System.out.println("Усі іграшки:");
            for (Toy t : readToyFile(fileAll)) System.out.println("  " + t);

            // Вибираємо іграшки для дитини 7 років
            int childAge = 7;
            writeToysForAge(fileAll, fileForAge, childAge);

            System.out.println("\nІграшки для дитини " + childAge + " років:");
            for (Toy t : readToyFile(fileForAge)) System.out.println("  " + t);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
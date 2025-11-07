package HomeWorks.hm07;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class B07_01 {
    // Запис прикладу масиву у бінарний файл F (double, послідовно)
    public static void writeSampleFileF(String path, double[] values) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            for (double v : values) dos.writeDouble(v);
        }
    }

    // Зчитати всі дійсні числа з бінарного файлу (послідовні double)
    public static List<Double> readArrayFromFile(String path) throws IOException {
        List<Double> list = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))) {
            while (true) {
                try {
                    double d = dis.readDouble();
                    list.add(d);
                } catch (EOFException eof) {
                    break; // кінець файлу
                }
            }
        }
        return list;
    }

    // Побудувати файл G, що містить лише компоненти > a, збереження порядку
    // Потокова версія (без збереження всього масиву)
    public static void buildFileG(String sourcePath, String targetPath, double a) throws IOException {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(sourcePath)));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(targetPath)))) {
            try {
                while (true) {
                    double v = dis.readDouble();
                    if (v > a) dos.writeDouble(v);
                }
            } catch (EOFException ignored) { }
        }
    }


    // Демонстрація
    public static void main(String[] args) {
        String F = "F.bin";
        String G = "G.bin";
        double[] sample = {3.5, -1.2, 7.0, 4.9999, 5.0, 10.1};

        try {
            // Створюємо файл F з прикладом
            writeSampleFileF(F, sample);

            // Читаємо і показуємо вміст F
            List<Double> fromF = readArrayFromFile(F);
            System.out.println("From F: " + fromF);

            // Будуємо G для a = 5.0
            double a = 5.0;
            buildFileG(F, G, a);

            // Перевіряємо G
            List<Double> fromG = readArrayFromFile(G);
            System.out.println("From G (values > " + a + "): " + fromG);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

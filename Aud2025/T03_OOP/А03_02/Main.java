import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    // Метод для пошуку студентів за факультетом і роком народження
    public static Student[] findStudents(Student[] students, String faculty, int year) {
        ArrayList<Student> result = new ArrayList<>();

        for (Student st : students) {
            if (st.getFaculty().equalsIgnoreCase(faculty) &&
                st.getBirthDate().getYear() > year) {
                result.add(st);
            }
        }

        return result.toArray(new Student[0]); // Повертаємо масив
    }

    public static void main(String[] args) {
        // Створюємо масив студентів
        Student[] students = {
                new Student("Іваненко Петро", LocalDate.of(2003, 5, 12), "Фізико-математичний", 2),
                new Student("Сидоренко Анна", LocalDate.of(2002, 3, 21), "Філологічний", 3),
                new Student("Коваленко Ігор", LocalDate.of(2004, 11, 5), "Фізико-математичний", 1),
                new Student("Мельник Оксана", LocalDate.of(2001, 7, 30), "Юридичний", 4)
        };

        // Знаходимо студентів фізмат факультету, народжених після 2002 року
        Student[] filtered = findStudents(students, "Фізико-математичний", 2002);

        System.out.println("Знайдені студенти:");
        for (Student st : filtered) {
            System.out.println(st);
        }
    }
}
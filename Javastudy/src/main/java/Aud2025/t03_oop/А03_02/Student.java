package Aud2025.t03_oop.А03_02;
import java.time.LocalDate;

public class Student {
    private String fullName;    // ПІБ студента
    private LocalDate birthDate; // Дата народження
    private String faculty;     // Факультет
    private int course;         // Курс

    // Конструктор
    public Student(String fullName, LocalDate birthDate, String faculty, int course) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.faculty = faculty;
        this.course = course;
    }

    // Геттери
    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getCourse() {
        return course;
    }

    // Метод для виводу інформації
    @Override
    public String toString() {
        return "Студент: " + fullName +
                "\nДата народження: " + birthDate +
                "\nФакультет: " + faculty +
                "\nКурс: " + course + "\n";
    }
}
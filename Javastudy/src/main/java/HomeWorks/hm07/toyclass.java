package HomeWorks.hm07;

import java.io.Serializable;

class Toy implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private double price;
    private int ageMin;
    private int ageMax;

    public Toy(String name, double price, int ageMin, int ageMax) {
        this.name = name;
        this.price = price;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
    }

    // Перевірка, чи підходить іграшка для певного віку
    public boolean isForAge(int age) {
        return age >= ageMin && age <= ageMax;
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f грн, %d–%d років)", name, price, ageMin, ageMax);
    }
}
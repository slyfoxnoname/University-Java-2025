import T03_OOP.A03_01.Fraction;


public class Main {
    public static void main(String[] args) {
        // Создаём несколько дробей вручную
        Fraction f1 = new Fraction(1, 2);   // 1/2
        Fraction f2 = new Fraction(3, 4);   // 3/4

        // Складываем их
        Fraction sum = f1.add(f2);
        System.out.println(f1 + " + " + f2 + " = " + sum);

        // Тестируем equals
        System.out.println("f1 equals f2? " + f1.equals(f2));

        // Создаём массив дробей и суммируем
        Fraction[] arr = { new Fraction(1, 3), new Fraction(1, 6), new Fraction(1, 2) };
        Fraction total = Fraction.sum(arr);
        System.out.println("Sum of array = " + total);

        // Генерация случайной дроби
        Fraction randomFraction = Fraction.random();
        System.out.println("Random fraction: " + randomFraction);
    }
}

import java.util.ArrayList;

class Subscriber {
    String name;          // ПІБ
    int credit;           // Кредит
    int callTimeCity;     // Час внутрішньоміських розмов
    int callTimeOutCity;  // Час міжміських розмов

    public Subscriber(String name, int credit, int callTimeCity, int callTimeOutCity) {
        this.name = name;
        this.credit = credit;
        this.callTimeCity = callTimeCity;
        this.callTimeOutCity = callTimeOutCity;
    }

    public static String[] subs(Subscriber[] arr) {
        ArrayList<String> list = new ArrayList<>();
        for (Subscriber sub : arr) {
            if (sub.callTimeCity > sub.credit) {
                list.add(sub.name);
            }
        }
        return list.toArray(new String[0]);
    }


    public static String[] subs2(Subscriber[] arr) {
        ArrayList<String> list = new ArrayList<>();
        for (Subscriber sub : arr) {
            if (sub.callTimeOutCity > 0) {
                list.add(sub.name);
            }
        }
        return list.toArray(new String[0]);
    }
}

public class HW03_3014 {
    public static void main(String[] args) {
        Subscriber[] arr = {
            new Subscriber("1", 10, 15, 5),
            new Subscriber("2", 20, 10, 8),
            new Subscriber("3", 5, 7, 3),
            new Subscriber("4", 1, 0, 0),
            new Subscriber("5", 9, 0, 4),
            new Subscriber("6", 1, 1, 5),
            new Subscriber("7", 5, 9, 1),
        };

        // Виклик стат метода без створення об'єкта
        String[] result = Subscriber.subs(arr);
        String[] result2 = Subscriber.subs2(arr);

        System.out.println("Абоненти у яких кредит спілкування внутрішньоміських розмов перевищує:");
        for (String name : result) {
            System.out.println(name);
        }

        System.out.println("Абоненти які користувалися міжміськими дзвінками:");
        for (String name : result2) {
            System.out.println(name);
        }
    }
}

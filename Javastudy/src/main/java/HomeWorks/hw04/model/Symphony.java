package HomeWorks.hw04.model;
public class Symphony extends Composition {
    private int age;              // вік симфонії (або рік створення)
    private int symphonySize;     // розмір (кількість частин)
    private int orchestraSize;    // кількість музикантів в оркестрі

    // Конструктор
    public Symphony(String name, String author, int songLength, int stars, int age, int symphonySize, int orchestraSize) {
        super(name, author, songLength, stars); // виклик конструктора Composition
        this.age = age;
        this.symphonySize = symphonySize;
        this.orchestraSize = orchestraSize;
    }

    // Геттери
    public int getAge() { return age; }
    public int getSymphonySize() { return symphonySize; }
    public int getOrchestraSize() { return orchestraSize; }

    // Перевизначаємо метод showInfo()
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Вік симфонії: " + age);
        System.out.println("Кількість частин: " + symphonySize);
        System.out.println("Розмір оркестру: " + orchestraSize);
    }
}

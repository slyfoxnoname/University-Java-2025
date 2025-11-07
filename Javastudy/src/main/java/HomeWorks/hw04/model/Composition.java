package HomeWorks.hw04.model;
public abstract class Composition {
    private String name;
    private String author;
    private int songLength;
    private int stars;

    public Composition(String name, String author, int songLength, int stars) {
        this.name = name;
        this.author = author;
        this.songLength = songLength;
        this.stars = stars;
    }

    // геттери (отримати дані)
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getSongLength() {
        return songLength;
    }

    public int getStars() {
        return stars;
    }

    // сеттери (змінити дані)
    public void setStars(int stars) {
        this.stars = stars;
    }

    // метод для показу інформації
    public void showInfo() {
        System.out.println("Назва: " + name + 
                           ", Автор: " + author + 
                           ", Тривалість: " + songLength + 
                           " хв, Оцінка: " + stars + "★");
    }
}

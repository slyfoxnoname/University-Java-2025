public class Song extends Composition {

    private double length;
    private double favorites;

    public Song(String name, String author, int songLength, int stars, double length, double favorites) {
        super(name, author, songLength, stars); // викликає конструктор Composition
        this.length = length;
        this.favorites = favorites;
    }

    public double getLength() {
        return length;
    }

    public double getFavorites() {
        return favorites;
    }

    public void showInfo() {
        super.showInfo(); // покаже базову інформацію з Composition
        System.out.println("Додатково: довжина = " + length + ", вподобань = " + favorites);
    }
}

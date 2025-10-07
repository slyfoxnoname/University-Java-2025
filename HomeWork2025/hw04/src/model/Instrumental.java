public class Instrumental extends Composition {
    private int instrumentsCounter; // кількість інструментів

    public Instrumental(String name, String author, int songLength, int stars, int instrumentsCounter) {
        super(name, author, songLength, stars); // виклик конструктора Composition
        this.instrumentsCounter = instrumentsCounter;
    }

    public int getInstrumentsCounter() {
        return instrumentsCounter;
    }

    public void setInstrumentsCounter(int instrumentsCounter) {
        this.instrumentsCounter = instrumentsCounter;
    }

    @Override
    public void showInfo() {
        super.showInfo(); // показує дані з Composition
        System.out.println("Кількість інструментів: " + instrumentsCounter);
    }
}

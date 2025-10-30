public class PopularityLevel {
    private int listens;      // кількість прослуховувань
    private int likes;        // кількість вподобань
    private int shares;       // кількість поширень

    public PopularityLevel(int listens, int likes, int shares) {
        this.listens = listens;
        this.likes = likes;
        this.shares = shares;
    }

    public int getListens() { return listens; }
    public int getLikes() { return likes; }
    public int getShares() { return shares; }

    // метод для розрахунку "рівня популярності"
    public double getPopularityScore() {
        // проста формула: прослуховування + лайки*2 + поширення*3
        return listens + likes * 2 + shares * 3;
    }

    public void showInfo() {
        System.out.println("Прослуховувань: " + listens);
        System.out.println("Вподобань: " + likes);
        System.out.println("Поширень: " + shares);
        System.out.println("Рівень популярності: " + getPopularityScore());
    }
}

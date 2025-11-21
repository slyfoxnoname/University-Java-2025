package HomeWorks.hm08;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Квадрат відстані до (0,0)
    public int distanceSquared() {
        return x * x + y * y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

package HomeWorks.hw03;
class Interval {
    double left;
    double right;
    boolean leftIncluded;
    boolean rightIncluded;

    public Interval(double left, boolean leftIncluded, double right, boolean rightIncluded) {
        this.left = left;
        this.right = right;
        this.leftIncluded = leftIncluded;
        this.rightIncluded = rightIncluded;
    }

    // довжина інтервалу
    public double length() {
        return right - left;
    }

    // перевірка чи є спільні точки
    public boolean intersects(Interval other) {
        return !(this.right < other.left || other.right < this.left);
    }

    // перетин інтервалів
    public Interval intersection(Interval other) {
        if (!intersects(other)) return null;
        double newLeft = Math.max(this.left, other.left);
        double newRight = Math.min(this.right, other.right);
        return new Interval(newLeft, true, newRight, true);
    }

    // об'єднання інтервалів
    public Interval union(Interval other) {
        if (!intersects(other)) return null;
        double newLeft = Math.min(this.left, other.left);
        double newRight = Math.max(this.right, other.right);
        return new Interval(newLeft, true, newRight, true);
    }

    @Override
    public String toString() {
        return (leftIncluded ? "[" : "(") + left + ", " + right + (rightIncluded ? "]" : ")");
    }
}

public class HW03_3004 {
    public static void main(String[] args) {
        Interval a = new Interval(0, true, 2, false);
        Interval b = new Interval(1, true, 5, true);
        Interval c = new Interval(6, false, 8, true);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        System.out.println("a u b = " + a.intersection(b));
        System.out.println("a U b = " + a.union(b));
        System.out.println("b U c = " + b.union(c)); // null бо не перетинаються

        Interval[] arr = {a, b, c};
        System.out.println("Найбільша довжина: " + maxIntervalSize(arr));
    }

    public static double maxIntervalSize(Interval[] arr) {
        double max = 0;
        for (Interval in : arr) {
            if (in.length() > max) max = in.length();
        }
        return max;
    }
}

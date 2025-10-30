package T03_OOP.A03_01;


public class Fraction {
    private int m; // числитель
    private int n; // знаменатель

    public Fraction(int m, int n) {
        if (n == 0) {
            throw new ArithmeticException("Denominator cannot be zero!");
        }
        if (n < 0) {
            m = -m;
            n = -n;
        }
        this.m = m;
        this.n = n;
        reduce();
    }

    public Fraction() {
        this(0, 1);
    }

    public Fraction(Fraction other) {
        this.m = other.m;
        this.n = other.n;
    }

    private void reduce() {
        int d = gcd(Math.abs(m), Math.abs(n));
        m /= d;
        n /= d;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }
        return a;
    }

    @Override
    public String toString() {
        return m + "/" + n;
    }

    public boolean equals(Fraction other) {
        return m == other.m && n == other.n;
    }

    public Fraction add(Fraction other) {
        int m = this.m * other.n + other.m * this.n;
        int n = this.n * other.n;
        return new Fraction(m, n);
    }

    public static Fraction sum(Fraction[] array) {
        Fraction s = new Fraction();
        for (Fraction fraction : array) {
            s = s.add(fraction);
        }
        return s;
    }

    public static Fraction random() {
        int m = (int) (Math.random() * 201) - 100; // диапазон [-100, 100]
        int n = (int) (Math.random() * 50) + 1;    // диапазон [1, 50]
        return new Fraction(m, n);
    }
}

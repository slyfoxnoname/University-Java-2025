public class HW02_03 {
    public static double seriesSum(double x, double eps) {
        // все ряды сходятся только если |x|<1
        double fx = 0.5 * Math.log((1 + x) / (1 - x));

        double sum = 0; 
        double pow = x; 
        int k = 0;

        while (true) {
            double term = pow / (2 * k + 1);

            if (Math.abs(term) <= eps) {
                break;
            }

            sum = sum + term;

            pow = pow * x * x; 
            k = k + 1;
        }

        return fx - sum;
    }

    public static void main(String[] args) {
        double x = 0.7;
        double eps = 0.0001;
        double result = seriesSum(x, eps);
        System.out.println("Result = " + result);
    }
}

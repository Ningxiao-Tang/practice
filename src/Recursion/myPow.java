package Recursion;

public class myPow {
    public static double myPow(double x, int n) {
        if (n > 0)
            return Pow(x, n);
        else
            return Pow(1.0/x, -n);

    }

    private static double Pow(double x, int n) {
        if (n == 0) return 1;
        double half = Pow(x, n/2);
        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }
}

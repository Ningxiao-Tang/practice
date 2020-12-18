package Recursion;

import java.util.HashMap;

public class Fibonacci {
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static int fib(int N) { // N < 30, f(0) = 0, f(1) = 1;
        if (N == 1)
            return 1;
        if (N == 0)
            return 0;
        return fib(N-1) + fib(N-2);
    }

    public static int fibonacci(int n) { //n < 2^32, f(1) = 0, f(2) = 1;
        if (n == 1){
            map.put(1,0);
        }
        if (n == 2)
            map.put(2,1);
        if (map.containsKey(n))
            return map.get(n);
        map.put(n,fibonacci(n-1)+fibonacci(n-2));
        return map.get(n);

    }

    public static void main(String[] args) {
        //System.out.println(fib(3));
        System.out.println(fibonacci(4));
    }
}

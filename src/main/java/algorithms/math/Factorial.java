package algorithms.math;

import java.util.Scanner;

public class Factorial {

    public static int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n * factorial(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n < 0) break;
            int res = factorial(n);
            System.out.println("Factorial of " + n + ": " + res);
        }
        sc.close();
    }
}
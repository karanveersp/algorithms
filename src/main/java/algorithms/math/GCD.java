package algorithms.math;

import java.util.Scanner;

public class GCD {

    // cannot instantiate class
    private GCD() {
    }

    /**
     * Euclid Algorithm to find the Greatest Common Divisor.
     * Recursive version
     */
    public static int euclidAlgorithm(int m, int n) {
        if (m == 0 | n == 0)
            return 0;
        if (m < n) {
            int t= m;
            m = n;
            n = t;
        }
        if (m % n == 0)
            return n;
        else 
            return euclidAlgorithm(n, m % n);
    }

    /**
     * Euclid Algorithm to find the Greatest Common Divisor: 
     * 0. [m < n?] If so, swap m <--> n.
     * 1. [Find remainder.] Divide m by n and let r be the remainder. 
     * 2. [Is it zero?] If r = 0, the algorithm terminates; n is the answer. 
     * 3. [Reduce.] Set m <-- n, n <-- r and go back to step 1.
     */
    public static int euclidAlgorithmLoopVersion(int m, int n) {
        if (m == 0 | n == 0)
            return 0;
        if (m < n) {
            int t = m;
            m = n;
            n = t;
        }
        while (true) {
            int r = m % n;
            if (r == 0) 
                break;
            else {
                m = n;
                n = r;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;

        while (true) {
            System.out.print("Enter m: ");
            m = Math.abs(sc.nextInt());
            System.out.print("Ender n: ");
            n = Math.abs(sc.nextInt());

            System.out.println("GCD: " + GCD.euclidAlgorithm(m, n));
            System.out.print("Enter 0 to exit or 1 to try again: ");
            int exit = sc.nextInt();
            if (exit == 0) break;
        }
        sc.close();
    }
}
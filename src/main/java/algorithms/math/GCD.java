package algorithms.math;

import java.util.Scanner;

public class GCD {

    // cannot instantiate class
    private GCD() {
    }

    /**
     * Euclid Algorithm to find the Greatest Common Divisor.
     * Recursive version
     * Algorithm from Sedgewick's book:
     * Compute the gcd of two nonnegative integers p and q as follows:
     * If q is 0, the answer is p. If not, divide p by q and take the remainder
     * r. The answer is the gcd of q and r.
     */
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
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

            System.out.println("GCD: " + GCD.gcd(m, n));
            System.out.print("Enter 0 to exit or 1 to try again: ");
            int exit = sc.nextInt();
            if (exit == 0) break;
        }
        sc.close();
    }
}
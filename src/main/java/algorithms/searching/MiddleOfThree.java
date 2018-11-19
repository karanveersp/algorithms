package algorithms.searching;

import java.util.Scanner;

public class MiddleOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if ((a > b && a < c) | (a > c && a < b)) {
                System.out.println(a);
            } else if ((b > a && b < c) | (b > c && b < a)) {
                System.out.println(b);
            } else
                System.out.println(c);

            System.out.println(MiddleOfThree.middle(a, b, c));

        }

        sc.close();
    }

    public static int middle(int a, int b, int c) {
        if (a < b)
            return (b < c) ? b : Math.max(a, c); 
        return (a < c) ? a : Math.max(b, c);
    }
    /*
        if (a < b) 
            // we know a is not max
            if (b < c)
                return b                            // a is smaller, c is greater
            else 
                return max(a,c)                     // highest of the two remaining now when b is max
        // we reached this point, we know a > b
        if (a < c)
            return a                                // b is smaller, c is greater
        else
            return max(b,c)                         // highest of the two remaining now when a is mqx
    */
}

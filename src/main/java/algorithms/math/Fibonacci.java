package algorithms.math;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.stream.IntStream;

import algorithms.util.BigNumber;

public class Fibonacci {

    private BigNumber minus1;
    private BigNumber minus2;
    private BigNumber fibNumber;

    public Fibonacci() {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        Fibonacci fibo = new Fibonacci();
        do {
            System.out.printf("%nEnter n: (-1 to end program) ");
            n = sc.nextInt();
            if (n <= 0)
                continue;
    
            String result = fibo.compareRuntimesNthFibonacci(n);
            System.out.printf("%nThe %dth Fibonacci number is: %s%n", n, result);

        } while (n > 0);
        sc.close();
        
    }


    public String compareRuntimesNthFibonacci(int n) {
        minus1 = new BigNumber(0);
        minus2 = new BigNumber(1);

        // using stream
        Instant start = Instant.now();
        IntStream.rangeClosed(1, n)
                 .parallel()
                 .forEach(i -> {
            fibNumber = BigNumber.sum(minus1, minus2);
            minus2 = minus1;
            minus1 = fibNumber;
        });
        Instant end = Instant.now();

        System.out.println("Streams: " + Duration.between(start, end).toMillis() + " milliseconds");
        
        // reset vars
        minus1 = new BigNumber(0);
        minus2 = new BigNumber(1);

        // using loop
        start = Instant.now();
        for (int i = 1; i <= n; i++) {
            fibNumber = BigNumber.sum(minus1, minus2);
            minus2 = minus1;
            minus1 = fibNumber;
        }
        end = Instant.now();

        System.out.println("Loop: " + Duration.between(start, end).toMillis() + " milliseconds");
        return fibNumber.getAsString();
    }

    /**
     * Calculates nth Fibonacci number and returns the result as a String
     * @param n nth fibonacci number
     * @param printValues boolean value to indicate whether f(n) upto nth value should be printed to console
     * @return String result
     */
    public String calculateNthFibonacci(int n, boolean printValues) {
        
        minus1 = new BigNumber(0);
        minus2 = new BigNumber(1);

        IntStream.rangeClosed(1, n)
                 .parallel()
                 .forEach(i -> {
            fibNumber = BigNumber.sum(minus1, minus2);

            if (printValues)
                System.out.printf("f(%d): %s%n", i, fibNumber.getAsString());
            minus2 = minus1;
            minus1 = fibNumber;
        });
        return fibNumber.getAsString();
    }
}

package algorithms.searching;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import algorithms.util.ArrayGenerator;

public class MinMax {

    public static void main(String[] args) {
        int[] arr = ArrayGenerator.generateRandomArray(100_000_000); // 1 hundred million random ints
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        System.out.printf("Random array length: %d%n%n", arr.length);

        Instant start = Instant.now();
        // perform standard 2n algorithm approach on single thread
        for (int i = 0; i < arr.length; i++) {
            min = (arr[i] < min) ? arr[i] : min;
            max = (arr[i] > max) ? arr[i] : max;
        }
        Instant end = Instant.now();

        System.out.printf("Min: %d, Max: %d%n", min, max);
        System.out.printf("Time for 2n loop in milliseconds: %d%n%n", Duration.between(start , end).toMillis());


        // compiler complains if I access min,max variables within
        // the stream forEach loop, but works when I use an array object
        int[] minmax = new int[2]; 

        start = Instant.now();
        // use stream api
        Arrays.stream(arr).forEach(i -> { 
            minmax[0] = i < minmax[0] ? i : minmax[0];  // perform min comparison
            minmax[1] = i > minmax[1] ? i : minmax[1];  // perform max comparison
        });
        end = Instant.now();

        System.out.printf("Min: %d, Max: %d%n", minmax[0], minmax[1]);
        System.out.printf("Time for streams approach in milliseconds: %d%n%n", Duration.between(start , end).toMillis());
    }
}

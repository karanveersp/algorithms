package algorithms.util;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class ArrayGenerator {

    /**
     * Generates an int[] of random numbers of length N. The random numbers will be
     * [1, N] inclusive. Duplicates may occur.
     * 
     * @param N the length of array and upper bound of random integers
     * @return int[] with random ints
     */
    public static int[] generateRandomArray(int N) {
        if (N <= 0)
            return null;
        Random random = new Random();
        IntStream randInts = random.ints(N, 1, N + 1);
        return randInts.toArray();
    }

    /**
     * Generates an int[] of random numbers of length N. The random numbers will be
     * [1, N] inclusive. No duplicates.
     * 
     * @param N the length of array and upper bound of random integers
     * @return int[] with random ints
     */
    public static int[] generateRandomArrayNoDuplicates(int N) {
        if (N <= 0)
            return null;
        ArrayList<Integer> values = new ArrayList<>();
        Random random = new Random();

        do {
            Integer randInt = random.nextInt(N) + 1;
            if (!values.contains(randInt))
                values.add(randInt);
        } while (values.size() < N);

        int[] retValues = new int[values.size()];
        for (int i = 0; i < N; i++) {
            retValues[i] = values.get(i);
        }
        return retValues;
    }
}
package algorithms.sorting;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * This class implements the Selection Sort algorithm. To see the algorithm in
 * action on a real random integer array, run the main method.
 * 
 * The complexity of Selection Sort is O(N^2) since it has a loop within a loop structure
 * where the inner loop runs for every value of the outer loop. The inner loop length shrinks by 1
 * every interation of the outer loop so the summation is:
 * N-1 + N-2 + N-3...2 + 1 = N(N - 1)/2 
 * This has the order of N^2 so the complexity is O(N^2)
 * 
 * See the sort() method for details.
 */
public class SelectionSort {

    /**
     * Generates an int[] of random numbers of length N. The random numbers will be
     * [1, N] inclusive. Duplicates may occur.
     * 
     * @param N the length of array and upper bound of random integers
     * @return int[] with random ints
     */
    public static int[] generateRandomArray(int N) {
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

    /**
     * Static method that prints the given array in the console.
     * @param array int[]
     */
    public static void printArray(int[] array) {
        System.out.println("\n");
        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "] : " + array[i]);
        }
        System.out.println("\n");
    }

    /**
     * Static method that prints the given array with extra information
     * regarding the sorting status.
     * @param array int[]
     */
    public static void demoPrintArray(int[] array, int x) {
        System.out.println("\n");
        for (int i = 0; i < array.length; i++) {
            if (i <= x) {
                System.out.println("array[" + i + "] : " + array[i] + " <-- sorted element");
            } else if (i == x + 1) {
                System.out.println("array[" + i + "] : " + array[i] + " <-- i");
            } else {
                System.out.println("array[" + i + "] : " + array[i] + " <-- unsorted");
            }
        }
        System.out.println("\n");
    }

    /**
     * Performs selection sort on a generated random array without duplicates of
     * length 10. It uses the printSort method which prints the contents of the
     * array and which values are being swapped. A good way to visualize how the
     * algorithm works.
     */
    public static void demo() {
        System.out.println("\nWelcome to the selection sort demo!\n");

        int[] values = SelectionSort.generateRandomArrayNoDuplicates(10);
        System.out.println("Our input array is of length 10 with random ints [1, 10] inclusive without duplicates:");
        SelectionSort.printSort(values);
    }

    /**
     * Static method to perform selection sort on given input int array. This method
     * prints which values are about to be swapped and prints the array after the
     * swap is performed to see the change.
     * 
     * Use it to walk through the algorithm step by step. You can remove the 'if'
     * enclosure around the swap to get the unoptimized version where duplicates are
     * swapped with each other, which is unnecessary.
     * 
     * No return value because sort is performed on referenced object
     * 
     * @param input int[]
     */
    public static void printSort(int[] input) {
        Scanner scanner = new Scanner(System.in);
        int swaps = 0;

        SelectionSort.demoPrintArray(input, -1);

        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i;

            // traverse the unsorted part of array
            for (int j = minIndex + 1; j < input.length; j++) {
                if (input[j] < input[minIndex])
                    minIndex = j; // catch the index for smallest value in unsorted array
            }

            // swap minIndex value with i'th value
            if (input[i] != input[minIndex]) {
                System.out.println("Now swapping input[" + i + "] : " + input[i] + " with input[" + minIndex + "] : "
                        + input[minIndex]);
                scanner.nextLine();
                int temp = input[i];
                input[i] = input[minIndex];
                input[minIndex] = temp;
                swaps++;
            }
            SelectionSort.demoPrintArray(input, i);
        } // end for i

        System.out.println("Swaps : " + swaps);
        scanner.close();
    }

    /**
     * Static method to perform selection sort on given input int array.
     * 
     * No return value because sort is performed on referenced object
     * 
     * @param input int[]
     */
    public static void sort(int[] input) {
        int swaps = 0;

        // i from [0 - length-1]
        // At every iteration, the sorted part of array grows by 1
        // and the unsorted part shrinks by 1
        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i;

            // traverse the unsorted part of array
            for (int j = minIndex + 1; j < input.length; j++) {
                if (input[j] < input[minIndex])
                    minIndex = j; // catch the index for smallest value in unsorted array
            }

            // swap minIndex value with i'th value
            if (input[i] != input[minIndex]) {
                int temp = input[i];
                input[i] = input[minIndex];
                input[minIndex] = temp;
                swaps++;
            }
        } // end for i
        System.out.println("Swaps : " + swaps);
    }

    public static void main(String[] args) {
        SelectionSort.demo();
    }
}
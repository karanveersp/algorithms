package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

import algorithms.util.ArrayGenerator;

/**
 * This class implements the Bubble sort algorithm.
 * 
 * It runs in worst case O(N^2) time.
 * 
 * We have a loop within a loop. The outer loop i runs till n-1. The inner loop
 * j runs till n-1-i. This is an optimization prevents repetitious comparisons
 * of the values which have 'bubbled' to the right (the i'th largest value).
 * 
 * The inner loop j compares arr[j] with arr[j+1]. If the jth value is smaller,
 * a swap is performed. Else we move on.
 * 
 * Another optimization is used where if the inner loop is traversed without
 * making any swaps, we break out of the outer loop since the array is sorted.
 * 
 * See the sort() method for details.
 */
public class BubbleSort {

    /**
     * Sorts the given array in-place using the bubble sort alorithm.
     * 
     * @param arr int array
     */
    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    /**
     * Prints output and stops at every step to show how the sort is going. When the
     * user presses enter, the next step is performed and shown.
     * 
     * @param arr
     */
    public static void sortDemo(int[] arr) {
        int n = arr.length;
        Scanner sc = new Scanner(System.in);
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            int swapCount = 0;
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.println();
                count++;
                if (arr[j] > arr[j + 1]) {
                    System.out.println("Swapping " + arr[j] + " with " + arr[j + 1]);
                    // swap
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    swapCount++;
                } else {
                    System.out.println("No swap necessary with " + arr[j] + " and " + arr[j + 1]);
                }
                System.out.println(Arrays.toString(arr));
                sc.nextLine();
            }
            if (swapCount == 0)
                break;
        }
        System.out.println("Total comparisons: " + count);
        sc.close();
    }

    public static void main(String[] args) {
        int[] arr = ArrayGenerator.generateRandomArrayNoDuplicates(100);
        System.out.println(Arrays.toString(arr));
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
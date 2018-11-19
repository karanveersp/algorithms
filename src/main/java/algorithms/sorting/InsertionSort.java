package algorithms.sorting;

import java.util.Arrays;

import algorithms.util.ArrayGenerator;

/**
 * This class implements the Insertion Sort algorithm.
 * 
 * Sorting is done in-place.
 * 
 * 1. [ from x = [1, N) ] Outer loop increments till N.
 * 2. [ from y = [x, 0) ] Inner loop decrements till 0.
 * 3. [ arr[y-1] > arr[y]? ] If left value is greater, swap. Else break.
 */
public class InsertionSort {

    /**
     * Sorts given array in place. 
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j-1] > arr[j]){
                    // swap
                    int t = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = t;
                }
                else
                    break; // an optimization to stop comparisons with values already sorted
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = ArrayGenerator.generateRandomArrayNoDuplicates(10);
        System.out.println(Arrays.toString(arr));
        InsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
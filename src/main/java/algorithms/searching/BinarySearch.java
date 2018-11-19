package algorithms.searching;

import java.util.Random;
import java.util.Scanner;

import algorithms.sorting.SelectionSort;
import algorithms.util.ArrayGenerator;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = ArrayGenerator.generateRandomArrayNoDuplicates(100);
        SelectionSort.sort(arr);

        Scanner sc = new Scanner(System.in);
        String in = "";

        while (in.isEmpty()) {
            // System.out.println(i);
            Random random = new Random();
            int target = arr[random.nextInt(100)];

            System.out.println("Target: " + target);
            int result = BinarySearch.indexOf(arr, target);
            System.out.println(
                    (result < 0) ? "Target not found: " + result : "Found at arr[" + result + "] = " + arr[result]);
            in = sc.nextLine();
        }
        sc.close();

    }

    /**
     * Returns index of specified key in the specified array. If not found, returns -1
     * 
     * @param a the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        int mid = 0;
        boolean found = false;
        while (!found && lo <= hi) {
            mid = lo + (hi - lo) / 2;
            // If target is greater, ignore left half, else ignore right half
            if      (key > a[mid]) lo = mid + 1;
            else if (key < a[mid]) hi = mid - 1;
            else    found = true;
        }
        if (!found) mid = -1;
        return mid; // only 1 return statement
    }

    public static int recursiveSearch(int[] arr, int lo, int hi, int key) {
        if (lo > hi) // pointers moved past each other, there are no more elements to search
            return -1;

        int mid = lo + (hi - lo) / 2;

        if (key < arr[mid])
            return recursiveSearch(arr, lo, mid - 1, key);
        else if (key > arr[mid])
            return recursiveSearch(arr, mid + 1, hi, key);
        else
            return mid;

    }
}

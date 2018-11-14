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
            int result = BinarySearch.recursiveSearch(arr, 0, arr.length, target);
            System.out.println((result < 0) ? "Target not found: " + result : "Found at arr[" + result + "] = " + arr[result]);
            in = sc.nextLine();
        }
        sc.close();

    }

    /**
     * Returns index of target x in array.
     * If not found, returns -1
     */
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        boolean found = false;

        while (left <= right && !found) {
            mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target)
                found = true;

            // If target is greater, ignore left half, else ignore right half
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        if (!found) 
            mid = -1;

        return mid; // only 1 return statement 
    }


    public static int recursiveSearch(int[] arr, int left, int right, int x) {
        if (right < left) // pointers moved past each other, there are no more elements to search
            return -1;
        else {
            int mid = left + (right-left)/2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x)
                return recursiveSearch(arr, left, mid-1, x);
            else
                return recursiveSearch(arr, mid+1, right, x);
        }
    }
}
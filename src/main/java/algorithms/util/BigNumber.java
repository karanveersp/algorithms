package algorithms.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class is used to create a data structure that represents
 * numbers where each digit is stored as an ArrayList element.
 * 
 * This allows one to freely compute sums, and multiplications and divisions
 * of numbers that would otherwise overflow.
 * 
 * You can initialize a digit list object by passing it a long or any value
 * that autocasts to a long. The digits of that long are then stored as ints
 * in a list called 'digits'.
 * 
 * You can see the whole number by calling ObjectName.getAsString() to return
 * the cumulative number represened by each digit.
 */
public class BigNumber {
    private List<Integer> digits;

    /**
     * Parameterized constructor from primitive long
     * @param i long or any autocast type (byte, short, int)
     */
    public BigNumber(long i) {
        // construct from long
        this.digits = new ArrayList<>();
        
        String[] sa = Long.toString(i).split("");

        Stream.of(sa).map(Integer::valueOf).forEach(e -> this.digits.add(e));
    }
   
    /** 
     * Creates a new BigNumber object from another BigNumber object - a copy or clone
     * @param d another BigNumber object
     */
    public BigNumber(BigNumber d) {
        this.digits = new ArrayList<>();
        d.digits.stream().forEach( e -> this.digits.add(e));
    }

    /**
     * Parameterized constructor that accepts a list of integers to initialize from
     * @param list
     */
    public BigNumber(List<Integer> list) {
        this.digits = new ArrayList<>();
        list.stream().forEach(e -> this.digits.add(e));
    }

    /**
     * Returns the number of digits
     * @return size of digits list
     */
    public int size() {
        return this.digits.size();
    }

        /**
     * Default constructor - private use only by the class for building results
     * of calculations
     */
    private BigNumber() {
        this.digits = new ArrayList<>();
    }

    /**
     * Simulates a stack
     * if digits = [], and I add 5, digits list becomes [5].
     * then I add 1, digits list becomes [1, 5] because ArrayList.add(index, value) inserts value at index
     * and shifts current value at that index to the right. 
     * If then I add 2, digits list becomes [2, 1, 5] representing 215 and so on.
     * @param n digit to add
     */
    private void push(int n) {
        if (this.digits.isEmpty())
            digits.add(n);
        else
            digits.add(0, n); 
    }

    /**
     * Static method that returns a BigNumber object
     * that is the sum of adding BigNumber a and BigNumber b. 
     * @param a BigNumber
     * @param b BigNumber
     * @return BigNumber sum of a and b
     */
    public static BigNumber sum(BigNumber a, BigNumber b) {
        // create new objects from parameters
        // in case swap needs to be performed.
        // The number with more digits runs
        // along the outer loop.
        // to simulate :
        //      100  (A)
        //     +  3  (B)
        //      ---
        //      103  (result) where the 1 and 0 are just copied over from A
        //
        BigNumber A = new BigNumber(a);
        BigNumber B = new BigNumber(b);

        if (A.size() < B.size()){
            // swap
            BigNumber t = A;
            A = B;
            B = t;
        }

        BigNumber result = new BigNumber();
        int sum;
        boolean carryOverOne = false;
        int j = B.size() - 1;

        for (int i = A.size() - 1; i >= 0; i--) {

            if (j < 0) {
                sum = A.digits.get(i);
            }
            else {
                sum = A.digits.get(i) + B.digits.get(j);  
                j--;              
            }

            if (carryOverOne) {
                sum++;
                carryOverOne = false;
            }

            if (sum / 10 != 0) {
                carryOverOne = true;
                sum = sum % 10; // set to units digit
            }

            result.push(sum);
            
            if (i - 1 < 0 && carryOverOne) {
                result.push(1);
            }
        }
        return result;
    }

    /**
     * Return digits list
     */
    public List<Integer> getDigits() {
        return this.digits;
    }

    /**
     * Return whole number represented by the list as a string
     * @return whole number string
     */
    public String getAsString() {
        return this.digits.stream().map(String::valueOf).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        // Test the BigNumber class here
        BigNumber a = new BigNumber(Integer.MAX_VALUE);
        BigNumber b = new BigNumber(Integer.MAX_VALUE);

        System.out.println(a.getAsString());
        System.out.println(b.getAsString());
        System.out.println(BigNumber.sum(a, b).getAsString());
    }

}

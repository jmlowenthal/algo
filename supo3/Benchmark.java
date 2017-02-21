package algo.supo3;

import java.util.*;

public class Benchmark {

    /**
     * Calculated the time taken to create a linked list with n items and then
     * read every value.
     * @param numItems the number of items to include in a linked list.
     * @return The time taken to create and walk a linked list
     */
    public static int benchmarkList(int numItems) {
        long start = System.nanoTime();
        List<Integer> list = new LinkedList<Integer>();
        int sum = 0;
        for (int i = 0; i < numItems; ++i) list.add(i);
        for (int i = 0; i < numItems; ++i) sum += list.get(i);
        return (int)(System.nanoTime() - start);
    }

    /**
     * Same for an array
     */
    public static int benchmarkArray(int numItems) {
        long start = System.nanoTime();
        Integer[] arr = new Integer[numItems];
        int sum = 0;
        for (int i = 0; i < numItems; ++i) arr[i] = i;
        for (int i = 0; i < numItems; ++i) sum += arr[i];
        return (int)(System.nanoTime() - start);
    }

    public static void main(String[] args) {
        // Feel free to change the bounds if your computer can/can't cope.
        for (int i = 0; i < 7; i++) {
            System.out.println("Linked list 10^" + i + " items:\t\t" +
                    benchmarkList((int)Math.pow(10, i)));
            System.out.println("Array 10^" + i + " items:\t\t" +
                    benchmarkArray((int)Math.pow(10,i)));
        }
    }

}


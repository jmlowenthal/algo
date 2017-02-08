package algo.supo1;

import java.util.*;

public class Tester {
	public static void main(String[] args) {
		List<Integer> original = new ArrayList<>();
		for (int i = 0; i < 100; ++i) {
			original.add(i + 1);
		}

		List<Integer> random = new ArrayList<>(original);
		Collections.shuffle(random);

		List<Integer> reversed = new ArrayList<>(original);
		Collections.reverse(reversed);

		System.out.println("Initial:");
		System.out.println("Sorted:\t\t" + original);
		System.out.println("Random:\t\t" + random);
		System.out.println("Reversed:\t" + reversed);
		System.out.println();

		System.out.println("Bubblesort:");
		BubbleSort<Integer> bubble = new BubbleSort<>();
		System.out.println("Sorted:\t\t" + bubble.sort(original));
		System.out.println("Random:\t\t" + bubble.sort(random));
		System.out.println("Reversed:\t" + bubble.sort(reversed));
		System.out.println();

		System.out.println("Insertion sort:");
		InsertionSort<Integer> insert = new InsertionSort<>();
		System.out.println("Sorted:\t\t" + insert.sort(original));
		System.out.println("Random:\t\t" + insert.sort(random));
		System.out.println("Reversed:\t" + insert.sort(reversed));
		System.out.println();

		System.out.println("Mergesort:");
		MergeSort<Integer> merge = new MergeSort<>();
		System.out.println("Sorted:\t\t" + merge.sort(original));
		System.out.println("Random:\t\t" + merge.sort(random));
		System.out.println("Reversed:\t" + merge.sort(reversed));
		System.out.println();

		System.out.println("Quicksort:");
		QuickSort<Integer> quick = new QuickSort<>();
		System.out.println("Sorted:\t\t" + quick.sort(original));
		System.out.println("Random:\t\t" + quick.sort(random));
		System.out.println("Reversed:\t" + quick.sort(reversed));
		System.out.println();
	}
}
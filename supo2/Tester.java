package algo.supo2;

import java.util.*;

public class Tester {
	public static void main(String[] args) {
		List<Character> original = new ArrayList<>();
		for (int i = 64; i < 74; ++i) {
			original.add((char)(i + 1));
		}

		List<Character> random = new ArrayList<>(original);
		Collections.shuffle(random);

		List<Character> reversed = new ArrayList<>(original);
		Collections.reverse(reversed);

		System.out.println("Initial:");
		System.out.println("Sorted:\t\t" + original);
		System.out.println("Random:\t\t" + random);
		System.out.println("Reversed:\t" + reversed);
		System.out.println();

		System.out.println("CharHeapSort:");
		CharHeapSort bubble = new CharHeapSort();
		System.out.println("Sorted:\t\t" + bubble.sort(original));
		System.out.println("Random:\t\t" + bubble.sort(random));
		System.out.println("Reversed:\t" + bubble.sort(reversed));
		System.out.println();
	}
}
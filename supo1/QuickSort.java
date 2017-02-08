package algo.supo1;

import uk.ac.cam.cl.algorithms.sup1.*;

import java.util.List;
import java.util.ArrayList;

public class QuickSort<T extends Comparable> implements SortingAlgorithm<T> {
	public List<T> sort(List<T> input) {
		if (input.size() == 0) return new ArrayList<>();
		// Let index 0 be pivot
		T pivot = input.get(0);
		
		List<T> left = new ArrayList<>();
		List<T> right = new ArrayList<>();

		for (int i = 1; i < input.size(); ++i) {
			T item = input.get(i);
			if (item.compareTo(pivot) < 0) {
				left.add(item);
			}
			else {
				right.add(item);
			}
		}

		left = sort(left);
		right = sort(right);

		return append(left, pivot, right);
	}

	private List<T> append(List<T> left, T pivot, List<T> right) {
		List<T> output = new ArrayList<>(left);
		output.add(pivot);
		output.addAll(right);
		return output;
	}
}
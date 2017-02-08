package algo.supo1;

import uk.ac.cam.cl.algorithms.sup1.*;

import java.util.List;
import java.util.ArrayList;

public class MergeSort<T extends Comparable> implements SortingAlgorithm<T> {
	public List<T> sort(List<T> input) {
		if (input.size() == 0) return new ArrayList<T>();
		if (input.size() == 1) return new ArrayList<>(input);

		int p = input.size() / 2;
		List<T> left = sort(input.subList(0, p));
		List<T> right = sort(input.subList(p, input.size()));
		return merge(left, right);
	}

	public List<T> merge(List<T> a, List<T> b) {
		List<T> output = new ArrayList<>(a.size() + b.size());
		int i = 0, j = 0;
		while (i < a.size() && j < b.size()) {
			if (a.get(i).compareTo(b.get(j)) > 0) {
				output.add(b.get(j++));
			}
			else {
				output.add(a.get(i++));
			}
		}

		while (i < a.size()) {
			output.add(a.get(i++));
		}

		while (j < b.size()) {
			output.add(b.get(j++));
		}

		return output;
	}
}
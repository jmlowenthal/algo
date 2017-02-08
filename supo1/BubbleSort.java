package algo.supo1;

import uk.ac.cam.cl.algorithms.sup1.*;

import java.util.List;
import java.util.ArrayList;

public class BubbleSort<T extends Comparable> implements SortingAlgorithm<T> {
    public List<T> sort(List<T> input) {
		List<T> output = new ArrayList<>(input);
		int size = output.size();

		int swaps;
        do {
			swaps = 0;
			for (int i = 1; i < size; ++i) {
				if (output.get(i - 1).compareTo(output.get(i)) > 0) {
					T tmp = output.get(i);
					output.set(i, output.get(i - 1));
					output.set(i - 1, tmp);
					++swaps;
				}
			}
			--size;
		} while (swaps > 0);
		return output;
    }
}
package algo.supo1;

import uk.ac.cam.cl.algorithms.sup1.*;

import java.util.List;
import java.util.ArrayList;

public class InsertionSort<T extends Comparable> implements SortingAlgorithm<T> {
    public List<T> sort(List<T> input) {
        List<T> output = new ArrayList<>(input);
		int size = output.size();
		for (int i = 1; i < size; ++i) {
			T curr = output.get(i);
			int j = i - 1;
			while (j > -1 && output.get(j).compareTo(curr) > 0) {
				output.set(j + 1, output.get(j));
				--j;
			}
			output.set(j + 1, curr);
		}
		return output;
    }
}
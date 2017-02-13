package algo.supo2;

import uk.ac.cam.cl.algorithms.sup1.*;
import uk.ac.cam.cl.algorithms.sup2.maxheap.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CharHeapSort implements SortingAlgorithm<Character> {
    public List<Character> sort(List<Character> input) {
		MaxHeapInterface<Character> heap = new MaxCharHeap(input.stream().map(e->e.toString()).reduce((acc, e) -> acc + e).get());
		List<Character> result = new ArrayList<>(input.size());

		try {
			for (int i = 0; i < input.size(); ++i)
				result.add(heap.getMax());
		}
		catch (EmptyHeapException e) {};
		
		Collections.reverse(result);
		return result;
	}
}
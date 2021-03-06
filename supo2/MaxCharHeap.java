package algo.supo2;

import uk.ac.cam.cl.algorithms.sup2.maxheap.*;

import java.util.List;
import java.util.ArrayList;

public class MaxCharHeap implements MaxHeapInterface<Character> {
    char[] data = new char[1];
    int size = 0;

    public MaxCharHeap() {

    }

    public MaxCharHeap(String s) {
        data = s.toLowerCase().toCharArray();
        for (size = 1; size < data.length; ++size) {
            resolveUpward(size, data[size]);
        }
        /*for (char c : s.toLowerCase().toCharArray()) {
            insert(c);
        }*/
    }

    public Character getMax() throws EmptyHeapException { //aka pop
        if (getLength() < 1) throw new EmptyHeapException();

        char ans = data[0];
        data[0] = data[--size];
        resolveDownward(0, data[0]);

        if (size * 2 < data.length) {
            char[] arr = new char[size];
            for (int i = 0; i < size; ++i) {
                arr[i] = data[i];
            }
            data = arr;
        }
        
        return ans;
    }

    public void insert(Character val) {
        val = Character.toLowerCase(val);

        // Determine end location, parent and increment size (!)
        int index = size++; // post-increment
        //int parent = (index - 1) / 2;

        // Expand the data store if required
        if (data.length < size) {
            char[] arr = new char[data.length == 0 ? size : data.length * 2];
            for (int i = 0; i < data.length; ++i) {
                arr[i] = data[i];
            }
            data = arr;
        }

        resolveUpward(index, val);
    }

    public int getLength() {
        return size;
    }

    // Assumes the max-heap is valid, except the node corresponding to `index`
    private void resolveUpward(int index, char val) {
        // Wiggle up the tree
        int parent = (index - 1) / 2;
        while (index > 0 && data[parent] < val) {
            data[index] = data[parent];
            index = parent;
            parent = (index - 1) / 2;
        }
        data[index] = val;
    }

    private void resolveDownward(int index, char val) {
        while (index < size) {
            int li = index * 2 + 1;
            int ri = index * 2 + 2;
            if (li >= size) break;

            int child = ri < size ? (data[li] > data[ri] ? li : ri) : li;

            if (data[child] > val) {
                data[index] = data[child];
                index = child;
            }
            else {
                break;
            }
        }
        data[index] = val;
    }

    @Override
    public String toString() {
        String s = "";
        int w = 1;
        for (int i = 0, n = 0; i < data.length; ++i) {
            s += (i < size) ? data[i] : "_";
            if (++n == w) {
                s += "\n";
                w *= 2;
                n = 0;
            }
        }
        return s;
    }
}
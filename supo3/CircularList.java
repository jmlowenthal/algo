package algo.supo3;

import java.util.*;

public class CircularList<T> {

    private class Node<T> {
        T val;
        Node<T> next;

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node<T> head;

    public T get(int i) {
        Node<T> current = head;
        while (i-- > 0) {
            current = current.next;
        }
        return current.val;
    }

    public int size() throws CycleFoundException {
        int i = 0;
        Set<Node<T>> history = new HashSet<>();
        Node<T> current = head;
        while (current.next != null) {
            ++i;
            history.add(current);
            current = current.next;
            if (history.contains(current)) 
                throw new CycleFoundException();
        }
        return i;
    }

    public void add(T val) throws CycleFoundException {
        if (head == null) {
            head = new Node<T>(val, null);
        }
        else {
            Set<Node<T>> history = new HashSet<>();
            Node<T> current = head;
            while (current.next != null) {
                history.add(current);
                current = current.next;
                if (history.contains(current))
                    throw new CycleFoundException();
            }
            
            Node<T> next = new Node<T>(val, null);
            current.next = next;
        }
    }

    public void createCycle(int i) throws IndexOutOfBoundsException {
        // Considers an element with .next == null or the last element before a
        // repeat to be the end of the list to join to node at index i
        if (head == null) return;

        Set<Node<T>> history = new HashSet<>();
        Node<T> previous = head;
        Node<T> current = head.next;
        Node<T> nodeI = null;
        while (current != null && !history.contains(current)) {
            previous = current;
            current = current.next;
            if (--i == 0) nodeI = previous;
        }

        if (nodeI == null) {
            throw new IndexOutOfBoundsException();
        }

        previous.next = nodeI;
    }

    /**
     * Circular list lists you build a linked list that is circular. That is,
     * by following pointers you go back to a previous element. Note that this
     * need not be the first element. Eg A-B-C-D-E-C-D-E.
     *
     * This method finds the element that is at the start of the circle. For
     * the above string it should return C.
     */
    public T findStartOfCircle() {
        Set<Node<T>> history = new HashSet<>();
        Node<T> current = head;
        while (current.next != null) {
            history.add(current);
            current = current.next;
            if (history.contains(current)) return current.val;
        }
        return null;
    }

    public static void main(String[] args) throws CycleFoundException {
        CircularList<Character> chars = new CircularList<>();
        chars.add('A');
        chars.add('B');
        chars.add('C');
        chars.add('D');
        chars.add('E');
        chars.createCycle(2);
        
        for (int i = 0; i < 10; ++i) {
            System.out.print(chars.get(i));
        }
        System.out.println();

        System.out.println(chars.findStartOfCircle());
    }
}

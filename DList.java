/*************
 * A simple Doubly Linked List
 * Compilation: javac DList
 *************/

/**
 * <i>DList</i>. This class is short for Doubly Linked List and provides basic
 * lists
 * methods. All methods needed from a Linked List in CSC172 are included
 * <p>
 * The methods are only tested in CSC172 Spring 2023, use at your own risk.
 * EX: The output format may not be exact for an assignment of different year
 * Simply calling the {@code printList} method may requires additional testing.
 *
 * @author Weile Zheng
 */
public class DList<E> {

    // The first element, if it exists, is at sentinel.next. The last element, at
    // sentinel.prev.
    private node sentinel;
    private int size;

    private class node {
        E value;
        node next;
        node prev;

        node(E value, node next, node prev) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }

    /**
     * Construct an empty DList
     */
    public DList() {
        size = 0;
        sentinel = new node(null, null, null); // Create a dummy first node;
    }

    /**
     * @return the {@code size} of the list
     */
    public int size() {
        return size;
    }

    /**
     * Add an element to the end of the list. (append)
     * 
     * @param value element to be added
     */
    public void addLast(E value) {
        node curr = sentinel;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new node(value, null, curr); // The new node have a prev of current node.
        // Point the sentinel to the last node. However, since we are not trying to make
        // a circularly linked list
        // we do not assign the new node next to sentinel. Thus, it is a one direction
        // link from sentinel to last node.
        sentinel.prev = curr.next;
        size++;
    }

    /**
     * Print out all elements in the list.
     */
    public void printList() {
        if (size == 0) {
        }

        else {
            node curr = sentinel.next; // Do not print out sentinel value
            while (curr != null) {
                System.out.print(curr.value);
                curr = curr.next;
            }
        }
        System.out.println();

    }

    /**
     * Iterate through the list and return an array of all elements in the list
     * 
     * @return an array of all elements in the list
     */
    @SuppressWarnings("unchecked")
    public E[] returnList() { // Return an array of the elements in the list
        E[] arr = (E[]) new Object[size];
        node curr = sentinel.next; // Do not print out sentinel value
        int i = 0;
        while (curr != null) {
            arr[i++] = curr.value;
            curr = curr.next;
        }
        return arr;
    }

    /**
     * Print all element of the list backward
     */
    public void printListBackward() {
        if (size == 0)
            System.out.println("List is Empty");
        else {
            node curr = sentinel.prev; // Do not print out sentinel value
            for (int i = 0; i < size; i++) {
                System.out.print(curr.value);
                curr = curr.prev;
            }
        }
    }

    /**
     * Clear/Empty the list
     */
    public void clear() {
        sentinel = new node(null, null, null);
        size = 0;
    }

}

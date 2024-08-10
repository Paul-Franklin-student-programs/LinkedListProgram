import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * functions by facilitating the creation of a LinkedList,
 * nodes therein, and further changes to LinkedList
 */
public class CustomLinkedList {
    private Node head;

    /**
     * creates a new node in the LinkedList that 
     * contains specified data
     * @param data
     */
    public void insert(int data) {
        Node myNode = new Node(data);
        if (head == null) {
            head = myNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = myNode;
        }
    }

    /**
     * deletes a specified node from the LinkedList
     * @param data
     */
    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        System.out.println("This value was not found in the list. No value deleted.");
    }

    /**
     * creates and returns iterator to traverse LinkedList
     * @return
     */
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    /**
     * reads Integers from an external file and adds
     * them as nodes to the LinkedList
     * @param filename
     */
    public void fileReadIntegers(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int data = Integer.parseInt(line.trim());
                    insert(data);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid integer format in file: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * allows for the instantiation of new nodes within a
     * created LinkedList
     */
    private class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * executes the traversal of the LinkedList which
     * is employed by the main method to print the contents
     * of the LinkedList
     */
    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        /**
         * determines if there is a node after the
         * current node
         * @return
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * returns the data from the subsequent node
         * in the LinkedList
         * @return
         */
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }
}




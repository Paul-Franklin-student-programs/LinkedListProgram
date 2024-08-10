import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the CustomLinkedList class.
 */
public class LinkedListJUnitTester {
    /**
     * Tests the insert method of CustomLinkedList.
     */
    @Test
    public void testInsert() {
        CustomLinkedList list = new CustomLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);

        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    /**
     * Tests the delete method of CustomLinkedList.
     */
    @Test
    public void testDelete() {
        CustomLinkedList list = new CustomLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);

        list.delete(2);
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());

        list.delete(1);
        iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());

        list.delete(3);
        iterator = list.iterator();
        assertFalse(iterator.hasNext());
    }

    /**
     * Tests the iterator of CustomLinkedList.
     */
    @Test
    public void testIterator() {
        CustomLinkedList list = new CustomLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);

        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            iterator.next();
        });
        assertEquals(NoSuchElementException.class, exception.getClass());
    }
}

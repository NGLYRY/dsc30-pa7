import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class dHeapTester {
    @Test
    public void testAdd() {
        dHeap heap = new dHeap(3, 6, true);
        heap.add(2);
        assertEquals(2, heap.element());
        heap.add(3);
        heap.add(1);
        assertEquals(3, heap.size());
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.remove();
        assertEquals(6, heap.element());
        Assertions.assertThrows(NullPointerException.class, () -> {
            heap.add(null);
        });
    }
    @Test
    public void testAddDescent() {
        dHeap heap = new dHeap(4, 6, false);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
        heap.remove();
        });
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        assertEquals(4, heap.remove());
        assertEquals(5, heap.remove());
        assertEquals(6, heap.remove());
        assertEquals(7, heap.remove());
    }
    @Test
    public void testSize() {
        dHeap heap = new dHeap(6);
        assertEquals(0, heap.size());
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        assertEquals(4, heap.size());
        heap.clear();
        assertEquals(0, heap.size());
    }

    @Test
    public void testClear() {
        dHeap heap = new dHeap(6);
        heap.clear();
        heap.clear();
        heap.clear();
        heap.clear();
        assertEquals(0, heap.size());
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.clear();
        assertEquals(0, heap.size());
        heap.add(7);
        heap.remove();
        heap.clear();
        assertEquals(0, heap.size());
    }
    @Test
    public void testElement() {
        dHeap heap = new dHeap(6);
        heap.add(1);
        assertEquals(1, heap.element());
        heap.add(2);
        assertEquals(2, heap.element());
        heap.remove();
        assertEquals(1, heap.element());
        heap.clear();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            heap.element();
        });
    }
}
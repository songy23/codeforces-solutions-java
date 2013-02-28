package coursera.algo1.week5;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * @author Grigorev Alexey
 */
public class HeapTest {

    @Test
    public void extractMin() {
        Heap<String, Integer> h = new Heap<String, Integer>();
        h.insert("eighth", 8);
        h.insert("seventh", 7);
        h.insert("sixth", 6);
        h.insert("fith", 5);
        h.insert("forth", 4);
        h.insert("third", 3);
        h.insert("second", 2);
        h.insert("first", 1);

        assertEquals(h.pop(), "first");
        assertEquals(h.pop(), "second");
        assertEquals(h.pop(), "third");
        assertEquals(h.pop(), "forth");
        assertEquals(h.pop(), "fith");
        assertEquals(h.pop(), "sixth");
        assertEquals(h.pop(), "seventh");
        assertEquals(h.pop(), "eighth");
        assertTrue(h.isEmpty());
    }

    @Test
    public void extractMinOne() {
        Heap<String, Integer> h = new Heap<String, Integer>();
        h.insert("first", 1);

        String first = h.pop();
        assertEquals(first, "first");
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void extractMinNone() {
        Heap<String, Integer> h = new Heap<String, Integer>();
        h.extractMin();
    }
}

package coursera.algo1.week5;

import java.util.Collections;
import java.util.List;

import org.testng.collections.Lists;

/**
 * Implementation is based on http://algorithms.soc.srcf.net/notes/dijkstra_with_heaps.pdf
 * 
 * @author Grigorev Alexey
 */
public class Heap<E, K extends Comparable<K>> {

    private final List<HeapNode<E, K>> heap;

    public Heap() {
        this.heap = Lists.newArrayList();
    }

    public HeapNode<E, K> insert(E o, K key) {
        HeapNode<E, K> node = new HeapNode<E, K>(o, key, heap.size());
        heap.add(node);
        decreaseKey(node, key);
        return node;
    }

    public E pop() {
        return extractMin().getValue();
    }

    public HeapNode<E, K> extractMin() {
        ensureNotEmpty();

        int lastIndex = heap.size() - 1;
        HeapNode<E, K> last = heap.get(lastIndex);
        HeapNode<E, K> first = heap.get(0);

        swap(first, last);
        heap.remove(lastIndex);

        increaseKey(last, last.getKey());

        return first;
    }

    private void ensureNotEmpty() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("the heap is empty, cannot extract min");
        }
    }

    public void decreaseKey(HeapNode<E, K> node, K newKey) {
        node.setKey(newKey);

        while (node.hasParent() && lessThen(newKey, parent(node).getKey())) {
            swap(node, parent(node));
        }
    }

    private HeapNode<E, K> parent(HeapNode<E, K> node) {
        return heap.get(node.parent());
    }

    public void increaseKey(HeapNode<E, K> node, K newKey) {
        node.setKey(newKey);

        while (isNotLeaf(node)) {
            HeapNode<E, K> minNode = minChildNode(node);

            if (minNode != null) {
                swap(node, minNode);
            } else {
                break;
            }
        }
    }

    private HeapNode<E, K> minChildNode(HeapNode<E, K> node) {
        HeapNode<E, K> minNode = null;
        K minKey = node.getKey();

        if (hasLeft(node)) {
            HeapNode<E, K> left = left(node);
            if (lessThen(left.getKey(), minKey)) {
                minNode = left;
                minKey = minNode.getKey();
            }
        }

        if (hasRigth(node)) {
            HeapNode<E, K> rigth = rigth(node);
            if (lessThen(rigth.getKey(), minKey)) {
                minNode = rigth;
                minKey = minNode.getKey();
            }
        }

        return minNode;
    }

    private boolean lessThen(K left, K rigth) {
        return left.compareTo(rigth) < 0;
    }

    private void swap(HeapNode<E, K> node1, HeapNode<E, K> node2) {
        int node1Index = node1.getIndex();
        int node2Index = node2.getIndex();
        node1.setIndex(node2Index);
        node2.setIndex(node1Index);
        Collections.swap(heap, node1Index, node2Index);
    }

    public int size() {
        return heap.size();
    }

    public boolean isNotLeaf(HeapNode<E, K> node) {
        return node.left() < heap.size();
    }

    private boolean hasLeft(HeapNode<E, K> node) {
        return node.left() < heap.size();
    }

    private HeapNode<E, K> left(HeapNode<E, K> node) {
        return heap.get(node.left());
    }

    private boolean hasRigth(HeapNode<E, K> node) {
        return node.right() < heap.size();
    }

    private HeapNode<E, K> rigth(HeapNode<E, K> node) {
        return heap.get(node.right());
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    /**
     * 
     * @author Grigorev Alexey
     *
     * @param <E>
     * @param <K>
     */
    public static class HeapNode<E, K> {

        private final E value;
        private K key;
        private int index;

        public HeapNode(E value, K key, int index) {
            this.value = value;
            this.key = key;
            this.index = index;
        }

        private int parent() {
            return (index - 1) / 2;
        }

        private int left() {
            return 2 * index + 1;
        }

        private int right() {
            return 2 * (index + 1);
        }

        private boolean hasParent() {
            return index != 0;
        }

        public E getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        private void setKey(K key) {
            this.key = key;
        }

        public int getIndex() {
            return index;
        }

        private void setIndex(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "HeapNode [value=" + value + ", key=" + key + ", index=" + index + "]";
        }
    }
}


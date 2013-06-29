package optimization.knapsack;

import java.util.Arrays;
import java.util.ListIterator;

public class Cons<E> {
    private final E head;
    private final Cons<E> tail;

    public static <E> Cons<E> cons(E head, Cons<E> tail) {
        return new Cons<E>(head, tail);
    }

    public Cons(E head, Cons<E> tail) {
        if (head == null) {
            throw new NullPointerException();
        }
        this.head = head;
        this.tail = tail;
    }

    public Cons<E> tail() {
        return tail;
    }

    public E head() {
        return head;
    }

    public static <E> Cons<E> from(E... items) {
        return from(Arrays.asList(items).listIterator(items.length));
    }

    private static <E> Cons<E> from(ListIterator<E> items) {
        Cons<E> head = null;
        while (items.hasPrevious()) {
            E prev = items.previous();
            head = new Cons<E>(prev, head);
        }
        return head;
    }

    public Cons<E> reverse() {
        return reverse(this, null);
    }

    private static <E> Cons<E> reverse(Cons<E> list, Cons<E> acc) {
        if (list == null) {
            return acc;
        } else {
            return reverse(list.tail, cons(list.head, acc));
        }
    }

    public Cons<E> append(Cons<E> list2) {
        return append(this, list2);
    }

    private static <E> Cons<E> append(Cons<E> list1, Cons<E> list2) {
        if (list1 == null) {
            return list2;
        }
        return cons(list1.head, append(list1.tail, list2));
    }

    @Override
    public String toString() {
        return "[" + join(", ") + "]";
    }

    public String join(String joiner) {
        if (tail == null) {
            return head.toString();
        }

        return head.toString() + joiner + tail.join(joiner);
    }

}
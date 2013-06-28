package optimization.knapsack;

import java.util.Arrays;
import java.util.BitSet;

public class DynamicOptimized {

    protected final int capacity;
    protected final Knapsack.Item[] items;

    public DynamicOptimized(int capacity, Knapsack.Item[] items) {
        this.capacity = capacity;
        this.items = items;
    }

    public Knapsack.KnapsackResult solve() {
        // http://0agr.ru/blog/2011/04/17/Задача-об-упаковке-рюкзака/
        Cell[] line = new Cell[capacity + 1];
        Arrays.fill(line, Cell.FIRST);

        for (Knapsack.Item item : items) {
            int weight = item.weight;
            if (weight > capacity) {
                continue;
            }
            int value = item.value;
            int number = item.number;

            for (int k = capacity; k >= weight; k--) {
                int without = line[k].value;
                int with = line[k - weight].value + value;
                if (with > without) {
                    line[k] = Cell.flyweight(with, line[k - weight], number);
                }
            }
        }

        BitSet res = new BitSet(items.length);
        Cell cell = line[capacity];
        int optimalSolution = cell.value;
        while (cell.isNotFirst()) {
            res.set(cell.itemNumber);
            cell = cell.previous;
        }

        return new Knapsack.KnapsackResult(optimalSolution, res, items.length);
    }

    private static class Cell {
        private static final Cell FIRST = new Cell(0, null, -1);

        protected final int value;
        protected final Cell previous;
        protected final int itemNumber;

        public boolean isNotFirst() {
            return this != FIRST;
        }

        public static Cell flyweight(int value, Cell cell, int number) {
            // caching?
            return new Cell(value, cell, number);
        }

        private Cell(int value, Cell previous, int itemNumber) {
            this.value = value;
            this.previous = previous;
            this.itemNumber = itemNumber;
        }

        @Override
        public String toString() {
            return "(" + value + ", list: " + list() + ")";
        }

        private String list() {
            return itemNumber + (previous != null ? "," + previous.list() : "");
        }
    }
}

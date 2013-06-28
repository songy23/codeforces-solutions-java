package optimization.knapsack;

import java.util.BitSet;


public class KnapsackClassic extends Knapsack {

    public KnapsackClassic(int capacity, Item[] items) {
        super(capacity, items);
    }

    @Override
    public KnapsackResult solve() {
        return dynamic();
    }

    @Override
    public KnapsackResult dynamic() {
        int[][] table = calcTable();
        BitSet res = backtrack(table);

        return new KnapsackResult(table[items.length][capacity], res, items.length);
    }

    private int[][] calcTable() {
        int size = items.length;
        int[][] table = new int[size + 1][capacity + 1];

        for (Item item : items) {
            int weight = item.weight;
            int value = item.value;
            int[] prevRow = table[item.number];
            int[] currentRow = table[item.number + 1];

            for (int k = 1; k <= capacity; k++) {
                currentRow[k] = prevRow[k];
                if (weight <= k) {
                    int with = prevRow[k - weight] + value;
                    int without = prevRow[k];
                    if (without < with) {
                        currentRow[k] = with;
                    }
                }
            }
        }

        return table;
    }

    private BitSet backtrack(int[][] table) {
        int size = items.length;
        BitSet res = new BitSet(size);

        int k = capacity;
        for (int item = size; item > 0; item--) {
            if (table[item][k] != table[item - 1][k]) {
                res.set(item - 1);
                int weight = items[item - 1].weight;
                k = k - weight;
            }
        }

        return res;
    }

}

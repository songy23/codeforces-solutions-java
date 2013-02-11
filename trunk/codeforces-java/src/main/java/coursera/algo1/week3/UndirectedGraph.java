package coursera.algo1.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grigorev Alexey
 */
public class UndirectedGraph {
    private final int n;
    private final List<List<Integer>> adj;

    public UndirectedGraph(int n) {
        this.n = n;
        this.adj = createAdjacentList(n);
    }

    private static List<List<Integer>> createAdjacentList(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(n);

        while (n > 0) {
            res.add(new ArrayList<Integer>());
            n--;
        }

        return res;
    }

    public void addEdge(int v, int u) {
        adj.get(v).add(u);
    }

    public Iterable<Integer> adjacentTo(int v) {
        return adj.get(v);
    }

    public int getN() {
        return n;
    }
}

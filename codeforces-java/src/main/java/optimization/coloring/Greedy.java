package optimization.coloring;

import java.util.*;

import optimization.coloring.Graph.Edge;

public class Greedy {

    public void Solve(Graph graph) {
        List<List<Integer>> g = createAdjacentList(graph.getN());

        for (Edge e : graph.getEdges()) {
            g.get(e.from).add(e.to);
            g.get(e.to).add(e.from);
        }
        
        ArrayList<List<Integer>> copy = new ArrayList<List<Integer>>(g);
        Collections.sort(copy, new Comparator<List<Integer>> () {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return -(o1.size() - o2.size());
            }
        });
        
        
    }

    private static ArrayList<List<Integer>> createAdjacentList(int n) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>(n);

        int i = 0;
        while (i < n) {
            res.add(new LinkedList<Integer>());
            i++;
        }

        return res;
    }

}

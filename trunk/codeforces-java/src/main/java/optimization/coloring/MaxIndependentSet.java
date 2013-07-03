package optimization.coloring;

import graphs.maxindset.Graph;
import graphs.maxindset.RandomizedBBSearch;

import java.util.Set;

public class MaxIndependentSet {

    public Result solve(Graph graph) {

        int[] colors = new int[graph.size()];
        int c = 0;

        Graph g = graph.copy();

        while (g.size() != 0) {
            Set<Integer> indSet = RandomizedBBSearch.solve(g);
            for (int i : indSet) {
                colors[i] = c;
            }

            g = g.removeVertices(indSet);
            c++;
        }

        return new Result(c, false, colors);
    }

}

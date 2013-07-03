package graphs.maxindset;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import com.google.common.collect.Sets;

public class RandomizedBBSearch {

    private int max = -1;

    private RandomizedBBSearch() {
    }

    public static Set<Integer> solve(Graph graph) {
        return trySolve(graph, 5);
    }

    private static Set<Integer> trySolve(Graph graph, int trials) {
        int c = trials;
        Set<Integer> best = Collections.emptySet();

        while (c > 0) {
            RandomizedBBSearch solver = new RandomizedBBSearch();
            Set<Integer> result = solver.solveInner(graph, new LinkedHashSet<Integer>());
            if (result.size() > best.size()) {
                best = result;
            }
            c--;
        }

        return best;
    }

    public Set<Integer> solveInner(Graph graph, Set<Integer> solution) {
        if (solution.size() <= max) {
            return Collections.emptySet();
        }

        if (graph.size() == 0) {
            max = solution.size();
            return solution;
        }

        int v = graph.randomVertex();

        // taking the vertex
        Graph g2 = graph.removeVertexWithAdjacent(v);
        Set<Integer> newSolution = Sets.newLinkedHashSet(solution);
        newSolution.add(v);
        Set<Integer> right = solveInner(g2, newSolution);

        // not taking the vertex
        Graph g1 = graph.removeVertex(v);
        Set<Integer> left = solveInner(g1, solution);

        if (left.size() > right.size()) {
            return left;
        } else {
            return right;
        }
    }

}

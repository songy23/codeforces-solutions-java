package optimization.coloring;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import optimization.coloring.Graph2.Vertex;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class MaxIndependentSet {

    public void solve(Graph2 graph) {

        Set<Vertex> all = Sets.newLinkedHashSet(graph.allVerticies());

        int[] colors = new int[all.size()];

    }

    public int solve1(Set<Vertex> all, int color, int[] colors) {
        if (all.isEmpty()) {
            return color;
        }

        Set<Vertex> s = selectMax(all);
        for (Vertex v : s) {
            colors[v.number] = color;
        }

        Set<Vertex> difference = difference(all, s);

        return solve1(difference, color + 1, colors);
    }

    private Set<Vertex> difference(Set<Vertex> all, Set<Vertex> s) {
        LinkedHashSet<Vertex> diff = Sets.newLinkedHashSet(all);

        for (Vertex v : s) {
            for (Vertex u : v.adjacent) {
                Set<Vertex> ad = Sets.newLinkedHashSet(u.adjacent);
                ad.remove(v);
                Vertex nu = new Vertex(u.number, ad);
                diff.add(nu);
            }

            diff.remove(v);
        }

        return diff;
    }

    private Set<Vertex> selectMax(Set<Vertex> all) {
        int k = 0;

        List<Set<Vertex>> S = null;
        List<Set<Vertex>> q_minus = null;
        List<Set<Vertex>> q_plus = null;

        // TODO Auto-generated method stub
        return null;
    }
}

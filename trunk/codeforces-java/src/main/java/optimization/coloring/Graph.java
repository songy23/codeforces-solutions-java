package optimization.coloring;

import java.util.*;

/**
 * @author Grigorev Alexey
 */
public class Graph {
    private int n;
    private final ArrayList<Edge> edges;

    public Graph(int n) {
        this.n = n;
        this.edges = new ArrayList<Edge>();
    }

    /**
     * Adds a directed edge from vertex v to vertex u
     * 
     * @param v vertex from
     * @param u vertex to
     */
    public void addEdge(int v, int u) {
        Edge edge = new Edge(-1, v, u);
        edges.add(edge);
    }

    public int getN() {
        return n;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public static class Edge {
        int color;
        int from;
        int to;

        public Edge(int color, int from, int to) {
            this.color = color;
            this.from = from;
            this.to = to;
        }

    }
}

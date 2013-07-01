package optimization.coloring;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int n;
    private final List<Vertex> vertices;

    public Graph(int n) {
        this.n = n;
        this.vertices = createAdjacencyList(n);
    }

    private static List<Vertex> createAdjacencyList(int n) {
        List<Vertex> res = new ArrayList<Vertex>(n);

        int i = 0;
        while (i < n) {
            res.add(new Vertex(i));
            i++;
        }

        return res;
    }

    public void addEdge(int from, int to) {
        Vertex vertex1 = vertices.get(from);
        Vertex vertex2 = vertices.get(to);
        vertex1.addNodeTo(vertex2);
        vertex2.addNodeTo(vertex1);
    }

    public int getN() {
        return n;
    }

    public List<Vertex> allVerticies() {
        return new ArrayList<Vertex>(vertices);
    }

    public int[] colors() {
        int[] colors = new int[n];
        for (Vertex v : vertices) {
            colors[v.number] = v.color;
        }
        return colors;
    }

    public void outoutTo(int optValue, boolean optimal, PrintWriter out) {
        out.print(optValue);
        out.print(' ');
        out.print(optimal ? 1 : 0);
        out.println();

        int[] colors = colors();
        for (int i = 0; i < n; i++) {
            out.print(colors[i]);
            out.print(' ');
        }
        out.flush();
    }

    public static class Vertex {
        int color = -1;
        final int number;
        final List<Vertex> adjacent = new LinkedList<Vertex>();

        public Vertex(int from) {
            this.number = from;
        }

        public void addNodeTo(Vertex to) {
            adjacent.add(to);
        }
    }

}

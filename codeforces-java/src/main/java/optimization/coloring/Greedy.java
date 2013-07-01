package optimization.coloring;

import java.io.PrintWriter;
import java.util.*;

import optimization.coloring.Graph.Vertex;

/**
 * Новиков - дискретная математика для программистов, последняя глава
 * 
 * @author Grigorev Alexey
 * 
 */
public class Greedy {

    public void solve(Graph graph, PrintWriter out) {
        List<Vertex> allVerticies = prepare(graph);
        int color = color(allVerticies);
        graph.outoutTo(color, false, out);
    }

    private List<Vertex> prepare(Graph graph) {
        List<Vertex> allVerticies = graph.allVerticies();

        Collections.sort(allVerticies, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o2.adjacent.size() - o1.adjacent.size();
            }
        });

        return new LinkedList<Vertex>(allVerticies);
    }

    private int color(List<Vertex> allVerticies) {
        int color = 0;

        while (!allVerticies.isEmpty()) {
            Iterator<Vertex> iterator = allVerticies.iterator();

            while (iterator.hasNext()) {
                Vertex current = iterator.next();

                boolean allGood = true;
                for (Vertex to : current.adjacent) {
                    if (to.color == color) {
                        allGood = false;
                        break;
                    }
                }
                if (allGood) {
                    current.color = color;
                    iterator.remove();
                }
            }
            color++;
        }
        return color;
    }

}

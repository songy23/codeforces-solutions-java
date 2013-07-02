package optimization.coloring;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import optimization.coloring.Graph2.Vertex;

/**
 * Новиков - дискретная математика для программистов, последняя глава
 * 
 * @author Grigorev Alexey
 * 
 */
public class Greedy {

    public Result solve(Graph2 graph) {
        int[] colors = colorsArray(graph.getN());
        List<Vertex> allVerticies = prepare(graph);
        int solution = color(allVerticies, colors);
        return new Result(solution, false, colors);
    }

    private static int[] colorsArray(int n) {
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        return colors;
    }

    private List<Vertex> prepare(Graph2 graph) {
        List<Vertex> allVerticies = graph.allVerticies();

        Collections.sort(allVerticies, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o2.adjacent.size() - o1.adjacent.size();
            }
        });

        return new LinkedList<Vertex>(allVerticies);
    }

    private int color(List<Vertex> allVerticies, int[] colors) {
        int color = 0;

        while (!allVerticies.isEmpty()) {
            Iterator<Vertex> iterator = allVerticies.iterator();

            while (iterator.hasNext()) {
                Vertex current = iterator.next();

                boolean allGood = true;
                for (Vertex to : current.adjacent) {
                    if (colors[to.number] == color) {
                        allGood = false;
                        break;
                    }
                }
                if (allGood) {
                    colors[current.number] = color;
                    iterator.remove();
                }
            }
            color++;
        }
        return color;
    }

}

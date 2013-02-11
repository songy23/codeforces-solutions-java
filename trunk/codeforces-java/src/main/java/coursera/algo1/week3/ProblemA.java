package coursera.algo1.week3;


import notsandbox.Problem;
import notsandbox.Utils;

public class ProblemA extends Problem {


    @Override
    public void run() {
        readGraph(200);
    }

    public UndirectedGraph readGraph(int n) {
        UndirectedGraph graph = new UndirectedGraph(n);

        for (int i = 0; i < n - 1; i++) {
            String nextLine = scanner.nextLine();
            int[] line = Utils.parseIntArray(nextLine.split("\\s+"));

            int v = line[0];

            for (int j = 1; j < line.length; j++) {
                int u = line[j];
                graph.addEdge(v - 1, u - 1);
            }
        }

        return graph;
    }

}

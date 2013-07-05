package optimization.coloring;

import graphs.maxindset.Graph;
import notsandbox.Problem;

public class GreedySolver extends Problem {

    @Override
    public void run() {
        Graph graph = readInput();
        new Greedy().solve(graph).outputTo(out);
    }

    public Graph readInput() {
        int n = scanner.nextInt();
        int e = scanner.nextInt();

        Graph graph = new Graph(n);
        for (int i = 0; i < e; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            graph.addEdge(u, v);
        }

        return graph;
    }

    public static void main(String[] args) {
        new GreedySolver().setInput(System.in).run();
    }

}
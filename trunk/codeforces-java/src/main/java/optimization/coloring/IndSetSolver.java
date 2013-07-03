package optimization.coloring;

import notsandbox.Problem;
import graphs.maxindset.Graph;

public class IndSetSolver extends Problem {

    @Override
    public void run() {
        Graph graph = readInput();
        MaxIndependentSet mis = new MaxIndependentSet();
        mis.solve(graph).outputTo(out);
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
        new IndSetSolver().setInput(System.in).run();
    }

}

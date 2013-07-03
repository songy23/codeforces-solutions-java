package optimization.coloring;

import notsandbox.Problem;

public class GreedySolver extends Problem {

    @Override
    public void run() {
        Graph2 graph = readInput();
        new Greedy().solve(graph).outputTo(out);
    }

    public Graph2 readInput() {
        int n = scanner.nextInt();
        int e = scanner.nextInt();

        Graph2 graph = new Graph2(n);
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

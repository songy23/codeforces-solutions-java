package optimization.coloring;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solver implements Runnable {

    protected PrintWriter out = new PrintWriter(System.out, true);
    protected Scanner scanner;

    @Override
    public void run() {
        Graph graph = readInput();
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

    public Solver setInput(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
        return this;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public static void main(String[] args) {
        new Solver().setInput(System.in).run();
    }

}

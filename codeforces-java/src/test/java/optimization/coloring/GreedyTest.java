package optimization.coloring;

import org.testng.annotations.Test;

import coursera.ProblemRunner;

public class GreedyTest {
    @Test
    public void gc_4_1_greedy() {
        Solver solver = new Solver();
        ProblemRunner test = new ProblemRunner(solver);
        test.inputFromFile("gc_4_1");
        Graph graph = solver.readInput();

        new Greedy().solve(graph, test.outputStream());

        System.out.println(test.capturedOutput());
    }
}

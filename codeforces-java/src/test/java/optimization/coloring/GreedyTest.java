package optimization.coloring;

import org.testng.annotations.Test;

import coursera.ProblemRunner;
import static org.testng.Assert.*;

public class GreedyTest {
    @Test
    public void gc_250_9_greedy() {
        Solver solver = new Solver();
        ProblemRunner test = new ProblemRunner(solver);
        test.inputFromFile("gc_250_9");
        Graph2 graph = solver.readInput();

        Result result = new Greedy().solve(graph);
        assertTrue(result.getSolution() <= 97);
        
        result.outputTo(test.outputStream());
        System.out.println(test.capturedOutput());
    }
}

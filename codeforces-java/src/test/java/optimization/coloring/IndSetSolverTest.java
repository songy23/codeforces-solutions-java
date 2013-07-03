package optimization.coloring;

import graphs.maxindset.Graph;
import org.testng.annotations.Test;

import coursera.ProblemRunner;
import static org.testng.Assert.*;

public class IndSetSolverTest {
    @Test
    public void f() {
        IndSetSolver solver = new IndSetSolver();
        ProblemRunner test = new ProblemRunner(solver);
        test.inputFromFile("gc_250_9");
        Graph graph = solver.readInput();

        MaxIndependentSet s = new MaxIndependentSet();
        Result solve = s.solve(graph);
        solve.outputTo(test.outputStream());
        
        boolean legible = solve.checkAgainst(graph);
        assertTrue(legible);
        System.out.println(test.capturedOutput());
    }
}

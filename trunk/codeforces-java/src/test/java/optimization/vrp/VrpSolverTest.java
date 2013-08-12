package optimization.vrp;

import org.testng.annotations.Test;

import coursera.ProblemRunner;

public class VrpSolverTest {

    @Test
    public void solveNaiveGreedy() {
        Solver solver = new Solver("naivegreedy");
        ProblemRunner test = new ProblemRunner(solver);
        test.inputFromFile("vrp_16_3_1");
        Result result = solver.solve();

        result.visualizeTo("vrp_16_3_1.svg");

        String output = test.getOutput();
        System.out.println(output);
    }
}

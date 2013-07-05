package optimization.tsm;

import org.testng.annotations.Test;

import coursera.ProblemRunner;

public class SolverTest {

    @Test
    public void ensureDataRead() {

        Solver solver = new Solver();
        ProblemRunner test = new ProblemRunner(solver);
        test.inputFromFile("tsp_2103_1");
        test.run();

        String output = test.getOutput();
        System.out.println(output);

        // tsp_2103_1
    }
}

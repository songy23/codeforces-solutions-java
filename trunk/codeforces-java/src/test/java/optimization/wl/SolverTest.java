package optimization.wl;

import org.testng.annotations.Test;

import coursera.ProblemRunner;

public class SolverTest {

    @Test
    public void greedyRunner() {
        Solver solver = new Solver("stupid");
        ProblemRunner test = new ProblemRunner(solver).noDebuggingStdOutput();
        test.inputFromFile("wl_100_1");
        test.run();

        String output = test.getOutput();
        System.out.println(output);
    }

}

package coursera.algo1.week2;

import org.testng.annotations.Test;

import coursera.ProblemRunner;

public class ProgrammingAssignment2 {
    @Test
    public void problemA() {
        ProblemRunner test = new ProblemRunner(new ProblemA());

        test.inputFromFile("QuickSort.txt");
        test.run();

        System.out.println(test.getOutput());
    }

    @Test
    public void problemB() {
        ProblemRunner test = new ProblemRunner(new ProblemB());

        test.inputFromFile("QuickSort.txt");
        test.run();

        System.out.println(test.getOutput());
    }

    @Test
    public void problemC() {
        ProblemRunner test = new ProblemRunner(new ProblemC());

        test.inputFromFile("QuickSort.txt");
        test.run();

        System.out.println(test.getOutput());
    }
}

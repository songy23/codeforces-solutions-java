package coursera.algo1.week2;

public class ProblemB extends ProblemA {

    @Override
    public void pivotIndex(int[] input, int left, int right) {
        swap(input, left, right - 1);
    }

}

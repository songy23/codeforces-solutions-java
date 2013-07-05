package optimization.tsm;

import java.util.List;

import com.google.common.collect.Lists;

import notsandbox.Problem;

public class Solver extends Problem {

    @Override
    public void run() {
        List<Point> points = readData();
        Result result = new Greedy().solve(points);
        result.outputTo(out);
    }

    public List<Point> readData() {
        int n = scanner.nextInt();

        List<Point> points = Lists.newArrayListWithCapacity(n);

        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();

            Point point = new Point(i, x, y);
            points.add(point);
        }
        return points;
    }

    public static void main(String[] args) {
        new Solver().setInput(System.in).run();
    }

}
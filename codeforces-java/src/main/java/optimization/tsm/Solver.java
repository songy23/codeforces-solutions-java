package optimization.tsm;

import java.util.List;

import optimization.tsm.mst.MST;

import com.google.common.collect.Lists;

import notsandbox.Problem;

public class Solver extends Problem {

    private final String algo;

    public Solver(String algorithm) {
        this.algo = algorithm;
    }

    @Override
    public void run() {
        List<Point> points = readData();
        Result result = null;
        if ("greedy".equals(algo)) {
            result = new Greedy().solve(points);
        } else if ("greedy2".equals(algo)) {
            result = new Greedy2().solve(points);
        } else if ("mst".equals(algo)) {
            result = new MST().solve(points);
        } else {
            throw new IllegalArgumentException("not valid algorithm argument");
        }
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
        new Solver(args[0]).setInput(System.in).run();
    }

}
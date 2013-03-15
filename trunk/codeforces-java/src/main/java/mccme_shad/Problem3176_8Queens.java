package mccme_shad;

import java.io.*;
import java.util.*;

/**
 * http://informatics.mccme.ru/moodle/mod/statements/view3.php?id=2741&chapterid=3176
 * 
 * @author Grigorev Alexey
 */
public class Problem3176_8Queens implements Runnable {

    private PrintWriter out = new PrintWriter(System.out, true);
    private Scanner scanner;

    @Override
    public void run() {
        List<QueenPosition> queens = readData();

        boolean res = solve(queens);

        out.print(res ? "YES" : "NO");
        out.flush();
    }

    public boolean solve(List<QueenPosition> queens) {
        return new QueensBoard(queens).solve();
    }

    private List<QueenPosition> readData() {
        List<QueenPosition> queens = new ArrayList<QueenPosition>(8);
        while (scanner.hasNext()) {
            String next = scanner.next();
            String[] input = next.split("\\s+");
            int x = Integer.parseInt(input[0]) - 1;
            int y = Integer.parseInt(input[0]) - 1;
            queens.add(new QueenPosition(x, y));
        }
        return queens;
    }

    public Problem3176_8Queens setInput(InputStream inputStream) {
        this.scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        return this;
    }

    public static void main(String[] args) {
        new Problem3176_8Queens().setInput(System.in).run();
    }
}

class QueensBoard {

    private final List<QueenPosition> queens;
    private final boolean horisontal[];
    private final boolean vertical[];

    public QueensBoard(List<QueenPosition> queens) {
        this.queens = queens;
        this.horisontal = new boolean[queens.size()];
        this.vertical = new boolean[queens.size()];
    }

    public boolean solve() {
        for (QueenPosition queen : queens) {
            if (horisontal[queen.getY()]) {
                return false;
            }

            if (vertical[queen.getY()]) {
                return false;
            }
        }
        return true;
    }
}

class QueenPosition {
    private final int x;
    private final int y;

    public QueenPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
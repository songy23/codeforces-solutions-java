package notsandbox;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Problem implements Runnable {
    protected PrintWriter out = new PrintWriter(System.out, true);
    protected Scanner scanner;

    public Problem setInput(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
        return this;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }
}

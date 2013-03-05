package coursera.algo1.week5;

/**
 * A weighted edge for {@link UndirectedWeightedGraph}
 * 
 * @author Grigorev Alexey
 */
public class Edge {

    private final int to;
    private final int weight;

    public Edge(int to, int weigth) {
        this.to = to;
        this.weight = weigth;
    }

    public int getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge [to=" + to + ", weight=" + weight + "]";
    }

}
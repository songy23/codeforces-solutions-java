package graphs.maxindset;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GraphTest {

    @Test
    public void removeVertex() {
        Graph graph = new Graph(5);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        assertEquals(graph.size(), 5);

        Graph newGraph = graph.removeVertex(4);
        assertEquals(newGraph.size(), 4);
        assertEquals(newGraph.adjacent(0).size(), 0);
        assertEquals(newGraph.adjacent(1).size(), 0);
        assertEquals(newGraph.adjacent(2).size(), 0);
        assertEquals(newGraph.adjacent(3).size(), 0);
    }

    @Test
    public void removeVertex2() {
        Graph graph = new Graph(5);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        assertEquals(graph.size(), 5);

        Graph newGraph = graph.removeVertex(4);
        assertEquals(newGraph.size(), 4);
        assertEquals(newGraph.adjacent(0).size(), 2);
        assertEquals(newGraph.adjacent(1).size(), 2);
        assertEquals(newGraph.adjacent(2).size(), 2);
        assertEquals(newGraph.adjacent(3).size(), 2);
    }

    @Test
    public void removeAdjacent() {
        Graph graph = new Graph(5);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        assertEquals(graph.size(), 5);

        Graph newGraph = graph.removeAllAdjacentTo(4);
        assertEquals(newGraph.size(), 1);
        assertEquals(newGraph.adjacent(4).size(), 0);

    }

}

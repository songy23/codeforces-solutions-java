package graphs.maxindset;

import java.util.*;

import org.apache.commons.lang3.Validate;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Graph {

    private static final Random RANDOM = new Random();

    private final Map<Integer, List<Integer>> vertices;

    public Graph(int n) {
        this.vertices = createAdjacencyList(n);
    }

    private Graph(Map<Integer, List<Integer>> vertices) {
        this.vertices = vertices;
    }

    private static Map<Integer, List<Integer>> createAdjacencyList(int n) {
        Map<Integer, List<Integer>> res = Maps.newHashMap();

        int i = 0;
        while (i < n) {
            res.put(i, new LinkedList<Integer>());
            i++;
        }

        return res;
    }

    public Graph removeVertex(int v) {
        checkVertex(v);
        Map<Integer, List<Integer>> copy = copyVertices();
        removeVertexInternal(v, copy);
        return new Graph(copy);
    }

    private Map<Integer, List<Integer>> copyVertices() {
        return Maps.newHashMap(vertices);
    }

    private Map<Integer, List<Integer>> removeVertexInternal(Integer v, Map<Integer, List<Integer>> copy) {
        // TODO: may be optimized
        List<Integer> adjV = copy.get(v);
        for (Integer u : adjV) {
            List<Integer> adjU = Lists.newLinkedList(copy.get(u));
            adjU.remove(v);
            copy.put(u, adjU);
        }
        copy.remove(v);
        return copy;
    }

    public Graph removeVertexWithAdjacent(int v) {
        checkVertex(v);
        Map<Integer, List<Integer>> copy = copyVertices();
        List<Integer> adjacent = copy.get(v);
        for (Integer u : adjacent) {
            removeVertexInternal(u, copy);
        }
        copy.remove(v);
        return new Graph(copy);
    }

    public Graph removeAllAdjacentTo(int v) {
        checkVertex(v);
        Map<Integer, List<Integer>> copy = copyVertices();
        List<Integer> adjacent = copy.get(v);
        for (Integer u : adjacent) {
            removeVertexInternal(u, copy);
        }
        return new Graph(copy);
    }

    public int randomVertex() {
        // ArrayList<Integer> keys = Lists.newArrayList(vertices.keySet());
        // int item = RANDOM.nextInt(keys.size());
        // return keys.get(item);
        return vertices.keySet().iterator().next();
    }

    public List<Integer> allVertices() {
        return Lists.newArrayList(vertices.keySet());
    }

    public int size() {
        return vertices.size();
    }

    public void addEdge(int from, int to) {
        checkVertex(from);
        checkVertex(to);
        vertices.get(from).add(to);
        vertices.get(to).add(from);
    }

    public Collection<Integer> adjacent(int i) {
        checkVertex(i);
        return vertices.get(i);
    }

    private void checkVertex(int i) {
        Validate.isTrue(vertices.containsKey(i));
    }

}

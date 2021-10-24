package structures.graph.naive;

import java.util.*;
import java.util.stream.Collectors;

import static util.Utils.newHashSet;

public class Graph {

    private final Map<Vertex, Set<Edge>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    public Graph add(String first, String second, int weight) {
        return add(new Vertex(first), new Vertex(second), weight);
    }

    public Graph add(Vertex first, Vertex second, int weight) {
        var edge = new Edge(first, second, weight);
        if (graph.containsKey(first)) {
            graph.get(first).add(edge);
            if (graph.containsKey(second)) {
                graph.get(second).add(edge);
            } else {
                graph.put(second, newHashSet(edge));
            }
        } else {
            graph.put(first, newHashSet(edge));
            graph.put(second, newHashSet(edge));
        }
        return this;
    }

    public boolean isEmpty() {
        return graph.isEmpty();
    }

    public Set<Vertex> vertexes() {
        return new HashSet<>(graph.keySet());
    }

    public Iterator<Vertex> iterator() {
        return graph.keySet().iterator();
    }

    public Set<Edge> getEdges(Vertex vertex) {
        return graph.get(vertex);
    }

    public Set<Vector> getVectors(Vertex from) {
        var edges = getEdges(from);

        return edges.stream()
                .map(edge -> {
                    Vertex to = edge.getOppositeTo(from);
                    return new Vector(from, to, edge.getWeight());
                })
                .collect(Collectors.toSet());
    }

    public Map<Vertex, Set<Edge>> getAsMap() {
        return this.graph;
    }

}

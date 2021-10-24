package structures.graph.naive;

import java.util.Objects;
import java.util.Set;

import static util.Utils.notEquals;

public class Edge {

    private final Vertex from;
    private final Vertex to;
    private final Set<Vertex> unorderedVertexes;
    private final int weight;

    public Edge(Vertex from, Vertex to, int weight) {
        this.weight = weight;
        this.from = from;
        this.to = to;
        this.unorderedVertexes = Set.of(from, to);
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getOppositeTo(Vertex vertex) {
        if (notEquals(vertex, from) && notEquals(vertex, to)) {
            throw new IllegalArgumentException(vertex + " does not belong to " + this);
        }
        return Objects.equals(vertex, from) ? to : from;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return weight == edge.weight &&
                Objects.equals(unorderedVertexes, edge.unorderedVertexes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unorderedVertexes, weight);
    }

    @Override
    public String toString() {
        return unorderedVertexes + " w=" + weight;
    }
}

package structures.graph.naive;

import java.util.Objects;

public class Vector {

    private final Vertex from;
    private final Vertex to;
    private final int weight;

    public Vector(Vertex from, Vertex to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return weight == vector.weight &&
                Objects.equals(from, vector.from) &&
                Objects.equals(to, vector.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, weight);
    }

    @Override
    public String toString() {
        return from + " -> " + to + " [" + weight + "]";
    }

}

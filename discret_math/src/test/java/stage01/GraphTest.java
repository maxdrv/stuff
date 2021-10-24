package stage01;

import org.junit.jupiter.api.Test;
import structures.graph.naive.Edge;
import structures.graph.naive.Graph;
import structures.graph.naive.Vertex;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static util.Utils.newHashSet;

public class GraphTest {

    @Test
    void graphCreation() {

        Graph graph = new Graph()
                .add("A", "B", 3)
                .add("A", "F", 2)
                .add("B", "G", 6)
                .add("B", "C", 3);

        var expected = Map.of(
                new Vertex("A"), newHashSet(
                        new Edge(new Vertex("A"), new Vertex("B"), 3),
                        new Edge(new Vertex("A"), new Vertex("F"), 2)
                ),
                new Vertex("B"), newHashSet(
                        new Edge(new Vertex("B"), new Vertex("G"), 6),
                        new Edge(new Vertex("B"), new Vertex("C"), 3),
                        new Edge(new Vertex("A"), new Vertex("B"), 3)
                ),
                new Vertex("C"), newHashSet(
                        new Edge(new Vertex("B"), new Vertex("C"), 3)
                ),
                new Vertex("F"), newHashSet(
                        new Edge(new Vertex("A"), new Vertex("F"), 2)
                ),
                new Vertex("G"), newHashSet(
                        new Edge(new Vertex("B"), new Vertex("G"), 6)
                )
        );

        assertThat(graph.getAsMap()).isEqualTo(expected);
    }
}

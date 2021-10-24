package stage01;

import org.junit.jupiter.api.Test;
import stage01.prim.PrimAlgo;
import structures.graph.naive.Graph;
import structures.graph.naive.Vertex;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Алгорити Прима
 * 1. Выберите произвольную вершину и ребро, соединяющее её с ближайшим (по весу) соседом
 * 2. Найдите не присоединенную (еще) вершуину, ближе всего лежащую к одной из присоединенных и соедините с ней
 * 3. Повторяте шаг 2 до тех пор пока все вершины не будут присоединены
 */
public class PrimAlgoTest {

    @Test
    void graph1() {
        Graph graph = new Graph()
                .add("A", "B", 3)
                .add("A", "F", 2)
                .add("B", "G", 6)
                .add("B", "C", 3)
                .add("C", "G", 1)
                .add("C", "E", 2)
                .add("C", "D", 3)
                .add("D", "E", 5)
                .add("E", "G", 3)
                .add("E", "F", 4)
                .add("F", "G", 3);

        List<Vertex> changeHistory = new ArrayList<>();
        PrimAlgo.run(graph, changeHistory::add);

        assertThat(changeHistory)
                .containsExactly(
                        new Vertex("A"),
                        new Vertex("F"),
                        new Vertex("B"),
                        new Vertex("C"),
                        new Vertex("G"),
                        new Vertex("E"),
                        new Vertex("D")
                );
    }

    @Test
    void graph2() {
        Graph graph = new Graph()
                .add("A", "B", 4)
                .add("A", "C", 3)
                .add("B", "F", 5)
                .add("B", "E", 12)
                .add("F", "Z", 16)
                .add("Z", "E", 5)
                .add("C", "E", 10)
                .add("C", "D", 7)
                .add("E", "D", 2);

        List<Vertex> changeHistory = new ArrayList<>();
        PrimAlgo.run(graph, changeHistory::add);

        assertThat(changeHistory)
                .containsExactly(
                        new Vertex("A"),
                        new Vertex("C"),
                        new Vertex("B"),
                        new Vertex("F"),
                        new Vertex("D"),
                        new Vertex("E"),
                        new Vertex("Z")
                );
    }
}

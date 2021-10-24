package stage01.prim;

import structures.graph.naive.Graph;
import structures.graph.naive.Vector;
import structures.graph.naive.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class PrimAlgo {

    public static void run(Graph graph, Consumer<Vertex> onVisitNext) {
        var iterator = graph.iterator();
        if (iterator.hasNext()) {
            Set<Vertex> notVisited = graph.vertexes();
            Set<Vertex> visited = new HashSet<>();
            Vertex any = iterator.next();
            visited.add(any);
            onVisitNext.accept(any);
            notVisited.remove(any);

            Set<Vector> vectorsToTest = graph.getVectors(any);
            var accessible = new HashMap<Vertex, Integer>();
            vectorsToTest.forEach(vector -> accessible.put(vector.getTo(), vector.getWeight()));

            var closest = findClosest(accessible);
            visited.add(closest);
            onVisitNext.accept(closest);
            notVisited.remove(closest);
            accessible.remove(closest);

            updateAccessible(accessible, graph.getVectors(closest), visited);

            while (!notVisited.isEmpty()) {
                closest = findClosest(accessible);
                visited.add(closest);
                onVisitNext.accept(closest);
                notVisited.remove(closest);
                accessible.remove(closest);

                updateAccessible(accessible, graph.getVectors(closest), visited);
            }
        }
    }

    private static Vertex findClosest(Map<Vertex, Integer> accessibleVertexes) {
        return accessibleVertexes.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();
    }

    private static void updateAccessible(Map<Vertex, Integer> accessible, Set<Vector> newVectors, Set<Vertex> visited) {
        for (Vector vector : newVectors) {
            Vertex possible = vector.getTo();
            if (!visited.contains(possible)) {
                if (accessible.containsKey(possible)) {
                    int curMinWeight = accessible.get(possible);
                    if (curMinWeight > vector.getWeight()) {
                        accessible.put(possible, vector.getWeight());
                    }
                } else {
                    accessible.put(possible, vector.getWeight());
                }
            }
        }
    }
}

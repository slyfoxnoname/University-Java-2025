package HomeWorks.hm08;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B08_03<T> {

    private Map<T, Set<T>> adjacencyList;

    public B08_03() {
        adjacencyList = new HashMap<>();
    }

    // Додавання вершини
    public void addVertex(T vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    // Видалення вершини
    public void removeVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) return;

        // Видаляємо вершину з множини суміжних у інших вершин
        for (T neighbor : adjacencyList.get(vertex)) {
            adjacencyList.get(neighbor).remove(vertex);
        }

        adjacencyList.remove(vertex); // Видаляємо саму вершину
    }

    // Додавання ребра (неорієнтоване)
    public void addEdge(T v1, T v2) {
        addVertex(v1);
        addVertex(v2);

        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
    }

    // Видалення ребра
    public void removeEdge(T v1, T v2) {
        if (adjacencyList.containsKey(v1)) {
            adjacencyList.get(v1).remove(v2);
        }
        if (adjacencyList.containsKey(v2)) {
            adjacencyList.get(v2).remove(v1);
        }
    }

    // Виведення графа
    public void printGraph() {
        for (var entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Отримати сусідів вершини
    public Set<T> getNeighbors(T vertex) {
        return adjacencyList.getOrDefault(vertex, new HashSet<>());
    }

    // Перевірка існування вершини
    public boolean containsVertex(T vertex) {
        return adjacencyList.containsKey(vertex);
    }

    // Перевірка існування ребра
    public boolean containsEdge(T v1, T v2) {
        return adjacencyList.containsKey(v1) && adjacencyList.get(v1).contains(v2);
    }


    public static void main(String[] args) {
        B08_03<String> graph = new B08_03<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");

        System.out.println("Граф після додавання вершин і ребер:");
        graph.printGraph();

        graph.removeEdge("A", "B");
        System.out.println("\nПісля видалення ребра A-B:");
        graph.printGraph();

        graph.removeVertex("C");
        System.out.println("\nПісля видалення вершини C:");
        graph.printGraph();
    }
}

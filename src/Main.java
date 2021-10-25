public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(5);
        graph.addVertex(8);
        graph.addVertex(3);
        graph.addVertex(2);
        graph.addEdge(5, 2);
        graph.addEdge(5, 8);
        graph.addEdge(5, 3);
        graph.addEdge(2, 8);
        graph.print();
        System.out.println(graph.bfs(10, 5));

        graph.removeVertex(5);
        graph.print();
        System.out.println(graph.bfs(5, 5));
    }
}

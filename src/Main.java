public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex(5);
        graph.addVertex(8);
        graph.addVertex(3);
        graph.addVertex(2);
        graph.addEdge(5, 2, 8);
        graph.addEdge(5, 8, 5);
        graph.addEdge(5, 3, 9);
        graph.addEdge(2, 8, 12);

        System.out.println(graph.getVertexes());

        graph.prims();
    }
}

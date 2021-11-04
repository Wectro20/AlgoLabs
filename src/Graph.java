import java.util.*;

public class Graph {
    int res = 0;

    public int getRes() {
        return res;
    }

    private Map<Integer, List<Edge>> vertexes;

    public Map<Integer, List<Edge>> getVertexes() {
        return vertexes;
    }

    public Graph() {
        this.vertexes = new HashMap<>();
    }

    public void addVertex(Integer vertex) {
        vertexes.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Integer vertex1, Integer vertex2, Integer weight) {
        Edge edge = new Edge(vertex1, vertex2, weight);
        vertexes.get(vertex1).add(edge);
        vertexes.get(vertex2).add(edge);
    }

    public void print() {
        for (Integer vertex : vertexes.keySet()) {
            System.out.print(" Vertex: " + vertex + " Edges: " + vertexes.get(vertex) + "\n");
        }
    }

    public void prims () {
        List<Edge> preEdge = new ArrayList<>();
        List<Integer> preVertex = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        for (Integer vertex: vertexes.keySet()) {
            for (Edge edge: vertexes.get(vertex)) {
                if (!edges.contains(edge)) {
                    edges.add(edge);
                }
            }
        }
        edges.sort((edge1, edge2) -> edge1.getWeigth().compareTo(edge2.getWeigth()));
        preVertex.add(edges.get(0).getLeft());
        preVertex.add(edges.get(0).getRight());
        preEdge.add(edges.get(0));
        edges.remove(edges.get(0));
        int i = 0;
        while (i != edges.size()){
            Edge current = edges.get(i);
            Integer right = current.getRight();
            Integer left = current.getLeft();
            if (preVertex.contains(left) && !preVertex.contains(right)) {
                preVertex.add(right);
                preEdge.add(current);
                edges.remove(current);
                i = 0;
                continue;
            }
            if (!preVertex.contains(left) && preVertex.contains(right)) {
                preVertex.add(left);
                preEdge.add(current);
                edges.remove(current);
                i = 0;
                continue;
            }
            i++;
        }
        for (Edge e : preEdge) {
            res += e.getWeigth();
        }
        System.out.println("Weight of MST: "+ res);
    }

}



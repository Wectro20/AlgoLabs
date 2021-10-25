import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> vertexes;

    public Graph() {
        this.vertexes = new HashMap<>();
    }

    public void addVertex(Integer vertex) {
        vertexes.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Integer vertex1, Integer vertex2) {
        vertexes.get(vertex1).add(vertex2);
        vertexes.get(vertex2).add(vertex1);
    }

    public void removeVertex(Integer vertex) {
        for (Map.Entry<Integer, List<Integer>> entry : vertexes.entrySet()) {
            if (entry.getKey() != vertex) {
                entry.getValue().remove(vertex);
            }
        }
        vertexes.remove(vertex);
    }

    public void removeEdge(Integer vertex1, Integer vertex2) {
        vertexes.get(vertex2).remove(vertex1);
        vertexes.get(vertex1).remove(vertex2);
    }

    public void print() {
        for (Integer vertex : vertexes.keySet()) {
            System.out.print(" Vertex: " + vertex + " Edges: " + vertexes.get(vertex) + "\n");
        }
    }

    public boolean bfs(Integer vertexStart, Integer vertexGoal) {
        if (vertexes.get(vertexStart) == null){
            return false;
        }

        int maxVertex = 0;
        for (Map.Entry<Integer, List<Integer>> entry : vertexes.entrySet()) {
            if (entry.getKey() > maxVertex) {
                maxVertex = entry.getKey();
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        boolean [] isVisited = new boolean[maxVertex + 1];
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }
        queue.add(vertexStart);
        isVisited[vertexStart] = true;
        while (!queue.isEmpty()) {
            Integer vertex = queue.pop();
            if (vertex == vertexGoal) {
                return true;
            }
            for (Integer edgeVertex : vertexes.get(vertexStart)) {
                if (isVisited[edgeVertex] == false) {
                    queue.add(edgeVertex);
                    isVisited[edgeVertex] = true;
                }
            }
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Integer vertex : vertexes.keySet()) {
            sb.append(vertex + "" +vertexes.get(vertex));
        }
        return sb.toString();
    }
}

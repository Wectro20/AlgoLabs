import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

public class TestGraph {
    public Graph graph;

    @Before
    public void init() {
        graph = new Graph();
        graph.addVertex(5);
        graph.addVertex(8);
        graph.addVertex(3);
        graph.addVertex(2);
        graph.addEdge(5, 2, 8);
        graph.addEdge(5, 8, 5);
        graph.addEdge(5, 3, 9);
        graph.addEdge(2, 8, 12);
    }

    @Test
    public void addVertex() {
        Assert.assertEquals("{2=[ { 5 <--> 2 -> weight: 8},  { 2 <--> 8 -> weight: 12}], " +
                                     "3=[ { 5 <--> 3 -> weight: 9}], " +
                                     "5=[ { 5 <--> 2 -> weight: 8},  { 5 <--> 8 -> weight: 5},  { 5 <--> 3 -> weight: 9}], " +
                                     "8=[ { 5 <--> 8 -> weight: 5},  { 2 <--> 8 -> weight: 12}]}", graph.getVertexes().toString());
    }

    @Test
    public void testPrima() {
        graph.prims();
        Assert.assertEquals(22, graph.getRes());
    }
}

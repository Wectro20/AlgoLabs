import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphTest {
    public Graph graph;

    @Before
    public void init() {
        graph = new Graph();
        graph.addVertex(5);
        graph.addVertex(8);
        graph.addVertex(3);
        graph.addVertex(2);
        graph.addEdge(5, 2);
        graph.addEdge(5, 8);
        graph.addEdge(5, 3);
        graph.addEdge(2, 8);
    }

    @Test
    public void testAddVertex() {
        Assert.assertEquals("2[5, 8]3[5]5[2, 8, 3]8[5, 2]", graph.toString());
    }

    @Test
    public void testRemoveVertex() {
        graph.removeVertex(5);
        Assert.assertEquals("2[8]3[]8[2]", graph.toString());
    }

    @Test
    public void testBFSFalseCase() {
        Assert.assertFalse(graph.bfs(10, 5));
    }

    @Test
    public void testBFSTrueCase() {
        Assert.assertTrue(graph.bfs(2, 8));
    }
}

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PriorityQueueTest {
    private PriorityQueue<Integer> pq;

    @Before
    public void init() {
        pq = new PriorityQueue<>();
    }

    @Test
    public void testAddHead() {
        pq.add(21,20);
        Assert.assertEquals(20 , pq.getHeadPriority());
    }

    @Test
    public void testAddTail() {
        pq.add(21,20);
        Assert.assertEquals(20 , pq.getTailPriority());
    }

    @Test
    public void testGetSize() {
        pq.add(21,20);
        Assert.assertEquals(1 , pq.getSize());
    }

    @Test
    public void testPeek() {
        Node<Integer> temp = new Node<>(21,20);
        pq.add(21,20);
        Assert.assertEquals(temp.value , pq.peek().value);
        Assert.assertEquals(temp.priority , pq.peek().priority);
    }

    @Test
    public void testPop() {
        pq.add(21,20);
        pq.add(22,21);
        Assert.assertEquals(pq.peek() , pq.pop());
        Assert.assertEquals(1 , pq.getSize());
    }

    @Test
    public void testPriority() {
        boolean isPriority = true;
        pq.add(1,1);
        pq.add(2,2);
        pq.add(0,0);
        pq.add(5,5);
        pq.add(3,3);
        Node<Integer> current = pq.peek();
        while (current != null) {
            if(current.next != null){
                if (current.priority < current.next.priority) {
                    isPriority = false;
                }
            }
            current = current.next;
        }
        Assert.assertTrue(isPriority);
    }

}


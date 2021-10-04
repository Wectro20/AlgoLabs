import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

public class BananasTest {
    public Bananas bananas;

    public final int[] test1Input = {3,6,7,11};
    public final int[] test2Input = {30,11,23,4,20};
    public final int[] test3Input = {30,11,23,4,20};

    public int test1Hours = 8;
    public int test2Hours = 5;
    public int test3Hours = 6;

    @Before
    public void init() {
        bananas = new Bananas();
    }

    @Test
    public void testFindK1() {
        bananas.setPiles(test1Input);
        bananas.setHours(test1Hours);
        bananas.comparsion();
        Assert.assertEquals(4, bananas.getK());
    }

    @Test
    public void testFindK2() {
        bananas.setPiles(test2Input);
        bananas.setHours(test2Hours);
        bananas.comparsion();
        Assert.assertEquals(30, bananas.getK());
    }

    @Test
    public void testFindK3() {
        bananas.setPiles(test3Input);
        bananas.setHours(test3Hours);
        bananas.comparsion();
        Assert.assertEquals(23, bananas.getK());
    }
}

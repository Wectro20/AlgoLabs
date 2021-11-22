import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFantz {
    private Fantz fantz;

    @Before
    public void init() {
        fantz = new Fantz();
    }

    @Test
    public void firstValueTest() {
        Assert.assertEquals(3, fantz.findMinBin("101101101", 5));
    }

    @Test
    public void secondValueTest() {
        Assert.assertEquals(1, fantz.findMinBin("1111101", 5));
    }

    @Test
    public void thirdValueTest() {
        Assert.assertEquals(3, fantz.findMinBin("110011011", 5));
    }

    @Test
    public void fourthValuetest() {
        Assert.assertEquals(4, fantz.findMinBin("111110001101010111100101100001", 7));
    }
}

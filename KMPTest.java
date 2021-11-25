import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KMPTest {
    KMP kmp = new KMP();

    @Before
    public void init() {
        kmp = new KMP();
    }

    @Test
    public void firstValueTest() {
        Assert.assertEquals("[10]", kmp.KMPsearch("ABABDABACDABABCABAB", "ABABCABAB").toString());
    }

    @Test
    public void secondValueTest() {
        Assert.assertEquals("[49]", kmp.KMPsearch("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789", "xyz0123").toString());
    }

    @Test
    public void thirdValueTest() {
        Assert.assertEquals("[7, 36]", kmp.KMPsearch("23112311144538813288132481321812494211445311", "114453").toString());
    }

    @Test
    public void fourthValueTest() {
        Assert.assertEquals("[33]", kmp.KMPsearch("#%6o98unytv26f3544278)('1``:LM<mionm*$!@htf5dcvvdv4_--=9997", "onm*$!@htf5").toString());
    }
}

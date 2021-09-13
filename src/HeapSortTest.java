import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeapSortTest {
    public HeapSort heapSort;
    public int[] testArr = new int[] {1,2,56,45,-9,78,11,1,24,43434,535,55,35,5,3,8,7,5,3,2,-3,-4};
    public int[] descArr = new int[] {43434,535,78,56,55,45,35,24,11,8,7,5,5,3,3,2,2,1,1,-3,-4,-9};
    public int[] ascArr = new int[] {-9,-4,-3,1,1,2,2,3,3,5,5,7,8,11,24,35,45,55,56,78,535,43434};


    @Before
    public void init() {
        heapSort = new HeapSort();
    }

    @Test
    public void testSortInDesc() {
        heapSort.setOutArr(testArr);
        heapSort.sort((int a, int b) -> a < b);
        Assert.assertArrayEquals(descArr, heapSort.getOutArr());
    }

    @Test
    public void testSortInAsc() {
        heapSort.setOutArr(testArr);
        heapSort.sort((int a, int b) -> a > b);
        Assert.assertArrayEquals(ascArr, heapSort.getOutArr());
    }


}
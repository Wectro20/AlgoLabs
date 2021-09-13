import java.util.Arrays;
import java.util.stream.Stream;

public class HeapSort {
    private String sortBy;
    private int[] inputArr;
    private int[] outArr;
    private int comparison = 0;
    private int swaps = 0;
    private long execTime = 0L;

    public void setOutArr(int[] outArr) {
        this.outArr = outArr;
    }

    public int[] getOutArr() {
        return outArr;
    }

    public int getComparison() {
        return comparison;
    }

    public int getSwaps() {
        return swaps;
    }

    HeapSort () {}

    HeapSort (String[] input) {
        getInput(input);

        long startTime = System.nanoTime();

        if(sortBy.equals("desc")){
            sort((int a , int b) -> a < b);
        }else {
            sort((int a , int b) -> a > b);
        }
        execTime = System.nanoTime() - startTime;
        printRes();
    }

    private void printRes() {
        System.out.println("Method of sort: HEAP SORT");
        System.out.println("Swap: " + swaps);
        System.out.println("Comparison: " + comparison);
        System.out.println("Execution time: " + execTime + " nano sec");
        System.out.println("Execution time: " + execTime/1000000 + " milli sec");
        System.out.println("input arr: " + Arrays.toString(inputArr));
        System.out.println("sorted arr: " + Arrays.toString(outArr));
    }

    public void getInput(String[] input) {
        try {
            if (input[0].equals("asc")) {
                sortBy = "asc";
            } else if (input[0].equals("desc")) {
                sortBy = "desc";
            }else {
                System.out.println("invalid sort by");
                System.exit(0);
            }
            makeIntArrayOfString(input[1]);
            if (input[2].equals("hs")) {
                return;
            } else {
                System.out.println("it`s only HeapSort");
                System.exit(0);
            }
        } catch(Exception e) {
            System.out.println("Invalid input!!!");
            System.exit(0);
        }
    }

    private void makeIntArrayOfString(String input) {
        String[] arrTemp = input.split(",");
        try {
            inputArr = Stream.of(arrTemp).mapToInt(Integer::parseInt).toArray();
            outArr = Arrays.copyOf(inputArr,inputArr.length);
        } catch (NumberFormatException e){
            System.out.println("invalid numbers");
            System.exit(0);
        }
    }

    private void shuffle() {
        for (int i = 0; i < outArr.length / 2 - 1; i++) {
            if (i % 2 == 0) {
                swap(outArr, i , i+1);
            }
        }
    }

    public void sort(SortComparator comparator) {
        shuffle();

        int arrLength = outArr.length;
        buildMaxHeap(outArr, arrLength, comparator);

        for (int i = arrLength - 1; i > 0; i--) {
            if(comparator.compare(outArr[0], outArr[i])){
                swap(outArr, 0, i);
            }
            heapify(outArr, i, 0, comparator);
        }

    }

    private void buildMaxHeap(int[] arr, int length, SortComparator comparator) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i, comparator);
        }
    }

    public void heapify(int[] arr, int arrLength, int i, SortComparator comparator) {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int maxAsRoot = i;

        if(left < arrLength && comparator.compare(arr[left], arr[maxAsRoot]) ) {
            comparison++;
            maxAsRoot = left;
        }

        if(right < arrLength && comparator.compare(arr[right], arr[maxAsRoot]) ) {
            comparison++;
            maxAsRoot = right;
        }

        if(maxAsRoot != i) {
            comparison++;
            swap(arr, maxAsRoot, i);
            heapify(arr, arrLength , maxAsRoot, comparator);
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        swaps++;
        int tmp  = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}

class Main {
    public static void main(String[] args) {
        System.out.println(21/5);
        HeapSort heapSort = new HeapSort(args);
    }
}

interface SortComparator{
    boolean compare(int a, int b);
}




// desc 1,2,56,45,-9,78,11,1,24,43434,535,55,35,5,3,8,7,5,3,2,-3,-4 ms
// desc 43434,535,78,56,55,45,35,24,11,8,7,5,5,3,3,2,2,1,1,-3,-4,-9 qs
// desc -9,-4,-3,1,1,2,2,3,3,5,5,7,8,11,24,35,45,55,56,78,535,43434 qs
// asc -9,-4,-3,1,1,2,2,3,3,5,5,7,8,11,24,35,45,55,56,78,535,43434 qs

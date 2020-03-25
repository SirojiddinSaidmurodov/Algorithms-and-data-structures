package QuickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr = {7, 5, 3, 9, 4, 1, 8, 6, 2, 0};
        ArrayList p = new ArrayList();
        p.add(new Pair(0, arr.length - 1));
        QuickSort.QuickSort(arr, p);
        System.out.println(Arrays.toString(arr));
    }
}

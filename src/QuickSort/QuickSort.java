package QuickSort;

import java.util.ArrayList;

public class QuickSort {
    public static void QuickSort(int[] array, ArrayList<Pair> pairs) {
        while (pairs.size() != 0) {
            for (int i = 0; i < pairs.size(); i++) {
                Pair pair = pairs.get(i);
                if (pair.left == pair.right) {
                    pairs.remove(i);
                    return;
                } else {
//                  int base = ArrayChunk(array, left, right);
//                  QuickSort(array, left, base - 1);
//                  QuickSort(array, base + 1, right);
                    int base = ArrayChunk(array, pair.left, pair.right);
                    Pair next = new Pair(base + 1, pair.right);
                    pair.right = base - 1;
                    pairs.add(i + 1, next);
                    i++;
                }
            }
        }
    }

    private static int ArrayChunk(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int index = (left + right) / 2;
        int frame = array[index];
        int temp;
        boolean goTo = false;
        while (true) {
            if (goTo) {
                i = left;
                j = right;
                index = (left + right) / 2;
                frame = array[index];
                goTo = false;
            }
            while (array[i] < frame) {
                i++;
            }
            while (array[j] > frame) {
                j--;
            }
            if ((i == (j - 1)) && (array[i] > array[j])) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (array[i] == frame) {
                    index = i;
                } else if (array[j] == frame) {
                    index = j;
                }
                goTo = true;
            } else if ((i == j) || ((array[i] < array[j]) && i == j - 1)) {
                return index;
            } else {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (array[i] == frame) {
                    index = i;
                } else if (array[j] == frame) {
                    index = j;
                }
            }
        }
    }
}

class Pair {
    int right;
    int left;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
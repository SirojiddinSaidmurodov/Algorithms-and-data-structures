package DynArray;

import java.lang.reflect.Array;

public class DynArray<T> {
    private T[] array;
    private int count;
    private int capacity;
    private Class clazz;

    public DynArray(Class clz) {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);
        count = 0;
        makeArray(16);
    }

    private void makeArray(int new_capacity) {
        if (array == null) {
            array = (T[]) Array.newInstance(clazz, new_capacity);
            capacity = new_capacity;
        } else {
            T[] buffer = (T[]) Array.newInstance(clazz, new_capacity);
            if (count - 1 >= 0) System.arraycopy(array, 0, buffer, 0, count - 1);
            array = buffer;
            capacity = new_capacity;
        }
    }

    public T getItem(int index) throws Exception {
        if (index < count && index >= 0) {
            return array[index];
        }
        throw new IndexOutOfBoundsException();
    }

    public void append(T itm) {
        if (count == capacity) {
            makeArray(capacity * 2);
        }
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        if (count == capacity) {
            makeArray(capacity * 2);
        }
        for (int i = count; i >= index; i--) {
            if (i > index) {
                array[i] = array[i - 1];
            } else {
                array[i] = itm;
            }
        }
        count++;
    }

    public void remove(int index) {
        if ((count - 1) < (capacity / 2)) {
            makeArray(Math.max((int) (capacity / 1.5), 16));
        }
        count--;
    }
}
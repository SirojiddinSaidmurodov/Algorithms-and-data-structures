package OrderedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OrderedListTest {
    OrderedList<Integer> IntList;
    OrderedList<Integer> IntListDes;
    OrderedList<String> StrList;
    OrderedList<String> StrListDes;

    @BeforeEach
    void start() {
        IntList = new OrderedList<Integer>(true);
        IntListDes = new OrderedList<Integer>(false);
        StrList = new OrderedList<String>(true);
        StrListDes = new OrderedList<String>(false);
    }

    @Test
    void compare() {
        assertEquals(-1, IntList.compare(0, 1));
        assertEquals(0, IntList.compare(0, 0));
        assertEquals(1, IntList.compare(1, 0));
        assertEquals(-1, StrList.compare("abc", "xyz"));
        assertEquals(0, StrList.compare("abc", "abc"));
        assertEquals(1, StrList.compare("xyz", "abc"));
    }

    @Test
    void add() {
        IntListDes.add(4500);
        IntListDes.add(450);
        IntListDes.add(45);
        IntListDes.add(4);
        System.out.println(IntListDes.getAll());
        assertEquals(4, IntListDes.count());
        IntList.add(4500);
        IntList.add(450);
        IntList.add(45);
        IntList.add(4);
        System.out.print(IntList.getAll());
        assertEquals(4, IntList.count());
    }

    @Test
    void find() {
        IntList.add(4500);
        IntList.add(450);
        IntList.add(45);
        IntList.add(4);
        assertNull(IntList.find(25));
        assertEquals(45, IntList.find(45).value);
    }

    @Test
    void delete() {
        IntList.add(4500);
        IntList.delete(4500);
        assertEquals(0, IntList.count());
        assertNull(IntList.head);
        assertNull(IntList.tail);
        IntList.add(450);
        IntList.add(45);
        IntList.add(4);
        IntList.delete(45);
        assertEquals(2, IntList.count());
        IntList.add(45);
        System.out.println(IntList.getAll());
        assertEquals(3, IntList.count());
        IntList.delete(450);
        assertEquals(2, IntList.count());
        IntList.delete(4);
        assertEquals(1, IntList.count());
        IntList.delete(45);
        assertEquals(0, IntList.count());
        assertNull(IntList.head);
        assertNull(IntList.tail);
    }

    @Test
    void clear() {
        IntListDes.add(4500);
        IntListDes.add(450);
        IntListDes.add(45);
        IntListDes.add(4);
        System.out.println(IntListDes.getAll());
        IntListDes.clear(true);
        System.out.println(IntListDes.getAll());
        assertEquals(0, IntListDes.count());
        assertNull(IntListDes.head);
        assertNull(IntListDes.tail);
    }

    @Test
    void count() {
        IntListDes.add(4500);
        IntListDes.add(450);
        IntListDes.add(45);
        IntListDes.add(4);
        assertEquals(4, IntListDes.count());
    }

    @Test
    void getAll() {
    }
}
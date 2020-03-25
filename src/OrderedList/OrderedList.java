package OrderedList;

import java.util.ArrayList;

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T value) {
        this.value = value;
        next = null;
        prev = null;
    }

    @Override
    public String toString() {
        return "Node{" + value + '}';
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean ascending;

    public OrderedList(boolean ascending) {
        head = null;
        tail = null;
        this.ascending = ascending;
    }

    public int compare(T v1, T v2) {
        if (v1 instanceof Integer) {
            int a = (int) v1;
            int b = (int) v2;
            return Integer.compare(a, b);
        }
        if (v1 instanceof String) {
            String a = (String) v1;
            String b = (String) v2;
            int diff = a.compareTo(b);
            return Integer.compare(diff, 0);
        }
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
        return 0;
    }

    public void add(T value) {
        Node<T> input = new Node<>(value);
        if (head != null) {
            Node<T> current = head;
            while (current != null) {
                int diff;
                if (ascending) diff = compare(value, current.value);
                else diff = compare(current.value, value);
                if (diff != 1) {
                    input.prev = current.prev;
                    input.next = current;
                    current.prev = input;
                    if (current != head) {
                        input.prev.next = input;
                        return;
                    }
                    head = input;
                    return;
                }
                current = current.next;
            }
            input.prev = tail;
            tail.next = input;
        } else {
            head = input;
        }
        tail = input;
    }

    public Node<T> find(T value) {
        if (head != null) {
            Node<T> current = head;
            int diff;
            while (current != null) {
                if (ascending) diff = compare(value, current.value);
                else diff = compare(current.value, value);
                if (diff == -1) {
                    break;
                } else if (diff == 0) {
                    return current;
                }
                current = current.next;
            }
        }
        return null;
    }

    public void delete(T value) {
        Node<T> found = find(value);
        if (found != null) {
            boolean isDeleted = false;
            if (found == head) {
                head = found.next;
                if (head != null) head.prev = null;
                isDeleted = true;
            }
            if (found == tail) {
                tail = found.prev;
                if (tail != null) tail.next = null;
                isDeleted = true;
            }
            if (!isDeleted) {
                found.next.prev = found.prev;
                found.prev.next = found.next;
            }
        }
    }

    public void clear(boolean asc) {
        ascending = asc;
        head = tail = null;
    }

    public int count() {
        int count = 0;
        Node<T> node = head;
        if (node != null) {
            while (node != null) {
                count++;
                node = node.next;
            }
        }
        return count;
    }

    ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}


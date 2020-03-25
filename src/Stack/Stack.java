package Stack;

public class Stack<T> {
    private Node<T> head;
    private int size;

    public Stack() {
        head = null;
        size = 0;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
        size++;
    }

    public T pop() {
        if (head.next != null) {
            Node<T> node = head;
            head = node.next;
            size--;
            return node.value;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public T top() {
        return head.value;
    }

    static private class Node<T> {
        private T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
            next = null;
        }
    }
}

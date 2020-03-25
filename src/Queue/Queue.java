package Queue;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(T item) {
        if (head == null) {
            head = new Node<>(item);
            tail = head;
        } else {
            head.previous = new Node<>(item);
            head = head.previous;
        }
        size++;
    }

    public T dequeue() {
        if (size > 0) {
            Node<T> node = tail;
            tail = tail.previous;
            size--;
            if (size == 0) {
                tail = head = null;
            }
            return node.value;
        }
        return null; // null если очередь пустая
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T top() {
        return tail.value;
    }

    public int size() {
        return size; // размер очереди
    }

    private class Node<T> {
        private T value;
        private Node<T> previous;

        private Node(T value) {
            this.value = value;
        }
    }
}
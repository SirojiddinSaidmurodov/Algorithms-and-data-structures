package Deque;

public class Deque<Type> {
    private Node<Type> head;
    private Node<Type> tail;

    public Deque() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void pushBack(Type value) {
        if (isEmpty()) {
            tail = head = new Node<>(value);
        } else {
            Node<Type> node = new Node<>(value);
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void pushFront(Type value) {
        if (isEmpty()) {
            tail = head = new Node<Type>(value);
        } else {
            Node<Type> node = new Node<>(value);
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    public Type popBack() {
        if (isEmpty()) {
            return null;
        } else {
            tail = tail.prev;
            Node<Type> node = tail.next;
            tail.next = null;
            return node.value;
        }
    }

    public Type popFront() {
        if (isEmpty()) {
            return null;
        } else {
            head = head.next;
            Node<Type> node = head.prev;
            head.prev = null;
            return node.value;
        }
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        private Node(T value) {
            this.value = value;
        }
    }

}

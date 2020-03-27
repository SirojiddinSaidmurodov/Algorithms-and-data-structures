package LinkedList;

import java.util.ArrayList;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    private LinkedList() {
        head = null;
        tail = null;
    }

    void addInTail(T item) {
        Node<T> node = new Node<>(item);
        if (head == null)
            head = node;
        else
            tail.next = node;
        tail = node;
    }

    public Node<T> find(T value) {
        Node<T> node = head;
        while (node != null) {
            if (node.value.equals(value))
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node<T>> findAll(T _value) {
        ArrayList<Node<T>> nodes = new ArrayList<>();
        Node<T> node = head;
        while (node != null) {
            if (node.value.equals(_value)) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(T value) {
        Node<T> node = head;
        Node<T> previous = head;
        while (node != null) {
            if (node.value.equals(value)) {
                if (node == head) {
                    head = node.next;
                    if (node.next == null) {
                        tail = null;
                    }
                } else {
                    if (node.next == null) {
                        tail = previous;
                    }
                    previous.next = node.next;
                }
                return true;
            }
            previous = node;
            node = node.next;
        }
        return false;
    }

    public void removeAll(T value) {//код удаления всех узлов по заданному значению
        Node<T> node = head;
        Node<T> previous = head;
        while (node != null) {
            if (node.value.equals(value)) {
                if (node == head) {//когда удаляемый элемент в начале листа
                    head = node.next;
                    if (node == tail) {//когда в листе один элемент
                        tail = null;
                    }
                    node = node.next;
                } else if (node == tail) {//Когда элемент в конце листа
                    tail = previous;
                    previous.next = null;
                } else {//Когда элемент находится между другими элементами
                    previous.next = node.next;
                    Node<T> buffer = node.next;
                    node.next = null;
                    node = buffer;
                }
            } else {
                previous = node;
                node = node.next;
            }
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        Node<T> node = head;
        int counter = 0;
        while (node != null) {
            counter++;
            node = node.next;
        }
        return counter;
    }

    public void insertAfter(Node<T> _nodeAfter, Node<T> _nodeToInsert) {
        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            if (this.tail == null) {
                this.tail = _nodeToInsert;
            }
        } else {
            boolean isInserted = false;
            Node<T> node = this.head;
            while (!isInserted) {
                if (_nodeAfter == node) {
                    if (_nodeAfter.next == null) {
                        _nodeAfter.next = _nodeToInsert;
                        _nodeToInsert.next = null;
                        this.tail = _nodeToInsert;
                        isInserted = true;
                    } else {
                        Node<T> buffer = _nodeAfter.next;
                        _nodeAfter.next = _nodeToInsert;
                        _nodeToInsert.next = buffer;
                        isInserted = true;
                    }
                } else {
                    node = node.next;
                }
            }
        }
    }

    public void printList() {
        Node<T> node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
    static class Node<Type> {
        Type value;
        Node<Type> next;

        Node(Type _value) {
            value = _value;
            next = null;
        }
    }
}

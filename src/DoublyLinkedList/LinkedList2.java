package DoublyLinkedList;

import java.util.ArrayList;

public class LinkedList2<Type> {
    private Node<Type> head;
    private Node<Type> tail;

    LinkedList2() {
        head = null;
        tail = null;
    }

    void addInTail(Node<Type> _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    Node<Type> find(int _value) {
        Node<Type> node = head;
        while (node != null) {
            if (node.value.equals(_value)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node<Type>> findAll(int _value) {
        ArrayList<Node<Type>> nodes = new ArrayList<Node<Type>>();
        Node<Type> node = head;
        while (node != null) {
            if (node.value.equals(_value)) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    boolean remove(int _value) {
        Node<Type> node = head;
        while (node != null) {
            if (node.value.equals(_value)) {
                if (node == head) {
                    head = node.next;
                    if (tail != node) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                    return true;
                } else if (node == tail) {
                    tail = node.prev;
                    tail.next = null;
                    return true;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    return true;
                }
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node<Type> node = head;
        while (node != null) {
            if (node.value.equals(_value)) {
                if (node == head) {
                    head = node.next;
                    if (tail != node) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (node == tail) {
                    tail = node.prev;
                    tail.next = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
            }
            node = node.next;
        }
    }

    public void clear() {
        head = tail = null;
    }

    public int count() {
        Node<Type> node = head;
        int counter = 0;
        while (node != null) {
            counter++;
            node = node.next;
        }
        return counter;
    }

    public void insertAfter(Node<Type> _nodeAfter, Node<Type> _nodeToInsert) {
        if (_nodeAfter == null) {
            if (head == null) {
                head = tail = _nodeToInsert;
                _nodeToInsert.next = _nodeToInsert.prev = null;
            } else {
                _nodeToInsert.next = head;
                head.prev = _nodeToInsert;
                head = _nodeToInsert;
            }
        } else {
            _nodeToInsert.prev = _nodeAfter;
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
            if (_nodeAfter != tail) {
                _nodeToInsert.next.prev = _nodeToInsert;
            } else {
                tail = _nodeToInsert;
                tail.next = null;
            }
        }
    }

    void print() {
        Node<Type> node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value) {
            this.value = value;
        }
    }
}

package LinkedList;

import java.util.ArrayList;

public class LinkedList<Type> {
    private Node<Type> head;
    private Node<Type> tail;

    private LinkedList() {
        head = null;
        tail = null;
    }

    void addInTail(Type item) {
        Node<Type> node = new Node<Type>(item);
        if (this.head == null)
            this.head = node;
        else
            this.tail.next = node;
        this.tail = node;
    }

    public Node find(Type value) {
        Node node = this.head;
        while (node != null) {
            if (node.value.equals(value))
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(Type _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node<Type> node = this.head;
        while (node != null) {
            if (node.value.equals(_value)) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(Type value) {
        Node<Type> node = this.head;
        Node<Type> previous = this.head;
        while (node != null) {
            if (node.value.equals(value)) {
                if (node == this.head) {
                    this.head = node.next;
                    if (node.next == null) {
                        tail = null;
                    }
                    return true; // если узел был удалён
                } else {
                    if (node.next == null) {
                        tail = previous;
                    }
                    previous.next = node.next;
                    return true; // если узел был удалён
                }
            }
            previous = node;
            node = node.next;
        }
        return false;
    }

    public void removeAll(Type value) {//код удаления всех узлов по заданному значению
        Node<Type> node = head;
        Node<Type> previous = head;
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
                    Node<Type> buffer = node.next;
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
        // здесь будет ваш код очистки всего списка
        this.head = null;
        this.tail = null;
    }

    public int count() {
        // здесь будет ваш код подсчёта количества элементов в списке
        Node node = head;
        int counter = 0;
        while (node != null) {
            counter++;
            node = node.next;
        }
        return counter;
    }

    public void insertAfter(Node<Type> _nodeAfter, Node<Type> _nodeToInsert) {
        // здесь будет ваш код вставки узла после заданного
        // если _nodeAfter = null ,
        // добавьте новый элемент первым в списке
        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            if (this.tail == null) {
                this.tail = _nodeToInsert;
            }
        } else {
            boolean isInserted = false;
            Node node = this.head;
            while (!isInserted) {
                if (_nodeAfter == node) {
                    if (_nodeAfter.next == null) {
                        _nodeAfter.next = _nodeToInsert;
                        _nodeToInsert.next = null;
                        this.tail = _nodeToInsert;
                        isInserted = true;
                    } else {
                        Node<Type> buffer = _nodeAfter.next;
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
        Node<Type> node = head;
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

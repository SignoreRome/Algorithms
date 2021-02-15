package com.company.DataStructure.LinkedList;

public class LinkedList<T> {
    private Node<T> head;

    public void addFirst(T t) {
        Node<T> node = new Node<>(t);
        node.next = head;
        head = node;

    }

    public void addLast(T t) {
        if (head == null) {
            head = new Node<>(t);
            return;
        }

        Node<T> node = head;
        while (node.next != null)
            node = node.next;

        node.next = new Node<>(t);
    }

    public int get(T t) {
        if (head == null)
            return -1;

        if (head.value.equals(t))
            return 0;

        Node<T> node = head;
        int index = 0;
        while (node.next != null) {
            ++index;
            if (node.next.value.equals(t))
                return index;
            node = node.next;
        }
        return -1;
    }

    public void remove(T t) {
        if (head == null)
            return;

        if (head.value.equals(t))
            head = head.next;

        Node<T> node = head;
        while (node.next != null){
            if (node.next.value.equals(t)) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                '}';
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}

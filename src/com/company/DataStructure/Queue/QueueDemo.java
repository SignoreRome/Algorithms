package com.company.DataStructure.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");

        System.out.println(queue.peek());

        queue.dequeue();

        System.out.println(queue.peek());

        queue.dequeue();

        System.out.println(queue.peek());

        queue.dequeue();

        System.out.println(queue.peek());

        queue.dequeue();
    }
}

package com.company.DataStructure.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        list.addFirst("A");

        System.out.println(list.toString());

        System.out.println(list.get("C"));

        list.remove("D");

        System.out.println(list.toString());


    }
}

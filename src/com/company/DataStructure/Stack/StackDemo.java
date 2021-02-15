package com.company.DataStructure.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        System.out.println(stack.toString());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.pop();
        System.out.println(stack.toString());
    }
}

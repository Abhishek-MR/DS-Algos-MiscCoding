package com.example.testprogs.algos.ds.stacks;

import java.util.Stack;

public class MinElementInStack {
    public static class MyStack {
        private Stack<Integer> stack;
        Integer minElement;

        public MyStack() {
            stack= new Stack<>();
            minElement = null;
        }

        void push(int x) {
            if(stack.size()==0) {
                stack.push(x);
                minElement = x;
            }
            else {
                if(x>=minElement) {
                    stack.push(x);
                }else {
                    stack.push(2*x-minElement);
                    minElement = x;
                }
            }
        }

        Integer pop(){
            if(stack.size() == 0) {
                return -1;
            }else {
                if (stack.peek() < minElement) {
                    minElement = 2 * minElement - stack.peek();
                }
                return stack.pop();
            }
        }

        Integer top() {
            if(stack.size() == 0) return -1;
            else {
                if (stack.peek() >= minElement) {
                    return stack.peek();
                }
                else {
                    return minElement;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(5);
        System.out.println(myStack.minElement);
        myStack.push(1);
        System.out.println(myStack.minElement);
        myStack.push(0);
        System.out.println(myStack.minElement);
        myStack.push(3);
        System.out.println(myStack.minElement);
        myStack.push(5);
        System.out.println(myStack.minElement);
     }
}

package com.example.testprogs.algos.ds.linkedlist;

public class FindStartOfLoop {

    public static Node root = new Node(0);

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public Node addNode(Node node) {
        Node temp = root;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return node;
    }

    public Node addNode(int val) {
        Node temp = root;
        while(temp.next != null) {
            temp = temp.next;
        }
        Node node = new Node(val);
        temp.next = node;
        return node;
    }

    public static boolean isLoopPresent(Node root) {
        Node slow = root;
        Node fast = root;

        while(slow!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                System.out.println(slow.val);
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        FindStartOfLoop linkedList = new FindStartOfLoop();
        linkedList.addNode(1);
        Node startOfLoop = linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(startOfLoop);
        System.out.println(isLoopPresent(root));

    }
}

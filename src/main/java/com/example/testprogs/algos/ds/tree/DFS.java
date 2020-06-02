package com.example.testprogs.algos.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DFS {

    //dfs in binary tree
    //this is not dfs!!!

    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left=left;
            this.right=right;
        }
    }

    public static void dfs(Node node) {
        if(node==null) return;
        dfs(node.left);
        System.out.print(node.val);
        dfs(node.right);
    }

    public static void main(String[] args) {
        Node node6 = new Node(6,null,null);
        Node node5 = new Node(5,null,null);
        Node node4 = new Node(4,null,null);
        Node node3 = new Node(3,null,null);
        Node node2 = new Node(2,node5,node6);
        Node node1 = new Node(1,node3,node4);
        Node node = new Node(0,node1,node2);

        Queue<Integer> queue = new LinkedList<>();
        dfs(node);
    }


}

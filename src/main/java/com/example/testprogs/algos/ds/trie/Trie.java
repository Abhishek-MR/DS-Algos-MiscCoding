package com.example.testprogs.algos.ds.trie;

import java.util.HashMap;

//Find if string exists or else find strings that match, match length, in recent order

public class Trie {

    Node root;

    public Trie() {
        root = new Node('\0');
    }

    static class Node {
        boolean isLastNode;
        char c;
        HashMap<Character,Node> nodes;

        public Node(char c) {
            this.isLastNode = false;
            this.c = c;
            this.nodes = new HashMap<>();
        }
    }

    public void insert(String s) {
        Node temp = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(temp.nodes.containsKey(c)) {
                temp = temp.nodes.get(c);
            }
            else {
                Node newNode = new Node(c);
                temp.nodes.put(c,newNode);
                temp = newNode;
            }
        }
    }

    public boolean find(String s) {
        Node temp = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (temp.nodes.containsKey(c)) {
                temp = temp.nodes.get(c);
            } else {
                return false;
            }
        }
        return true;
    }

    public int findCount(String s) {
        Node temp = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (temp.nodes.containsKey(c)) {
                temp = temp.nodes.get(c);
            } else {
                return i;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abcd");
        trie.insert("abc");
        System.out.println(trie.findCount("abc"));
    }
}

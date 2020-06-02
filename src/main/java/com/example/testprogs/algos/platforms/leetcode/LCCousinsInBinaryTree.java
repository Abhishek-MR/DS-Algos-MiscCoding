package com.example.testprogs.algos.platforms.leetcode;


import javafx.util.Pair;

public class LCCousinsInBinaryTree {

    static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) { this(val,null,null);}
        public TreeNode(int val, TreeNode left, TreeNode right) { this.val=val; this.left=left; this.right=right;}

    }

    //in bin tree root is at depth 0, children of depth k are at depth k+1
    //two nodes are cousins if they are at the same depth but have differnet parents
    // return true if A and B are cousins


    static public Pair<Integer,TreeNode> depth(TreeNode parent, TreeNode node, int val, int depth) {
        if(node == null) return new Pair<>(-1,null);
        if(node.val == val) new Pair<>(depth,parent);
        Pair<Integer,TreeNode> left =  depth(node,node.left,val,depth+1);
        Pair<Integer,TreeNode> right =  depth(node,node.right,val,depth+1);
        if(left.getKey() == -1 && right.getKey() == -1) new Pair<>(-1,null);
        return new Pair<Integer,TreeNode>(Math.max(left.getKey(),right.getKey()),parent);
    }
    public static boolean solve(TreeNode root, int x, int y) {
        if(root == null) return false;

        Pair<Integer,TreeNode> xDepth = depth(null,root,x,0);
        Pair<Integer,TreeNode> yDepth = depth(null,root,y,0);

        if(xDepth.getKey() == -1 ||yDepth.getKey() == -1) return false;
        if(xDepth == yDepth && xDepth.getValue() != null && yDepth.getValue()!=null && !xDepth.getValue().val.equals(yDepth.getValue().val)) return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3,null,five);
        TreeNode two = new TreeNode(2,null,four);
        TreeNode root = new TreeNode(1,two,three);

        int x = 4;
        int y = 5;

        System.out.println(solve(root,x,y));

    }

}

package org.blind75.model;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode<T> {
    T value;
    TreeNode<T> left, right;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
    @Override
    public String toString(){
        return String.format("[value = %s]", this.value);
    }
    public static TreeNode<Integer> createTree(){
        var root = new TreeNode<Integer>(1);
        root.setLeft(new TreeNode<Integer>(2));
        root.setRight(new TreeNode<Integer>(3));
        root.getLeft().setLeft(new TreeNode<Integer>(4));
        root.getLeft().setRight(new TreeNode<Integer>(5));
        root.getRight().setLeft(new TreeNode<Integer>(6));
        root.getRight().setRight(new TreeNode<Integer>(7));
        root.getRight().getRight().setRight(new TreeNode<Integer>(11));
        return root;
    }

    public static TreeNode<Integer> createTreeFromArray(Integer[] arr){
        if(arr.length ==0) return null;
        int i=0;
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        var root = new TreeNode<>(arr[0]);
        q.offer(root);
        while(i < arr.length){
            if(arr[i] != null) {
                var temp = q.poll();
                int r = 2 * (i + 1);
                int l = 2 * (i + 1) - 1;
                if (l < arr.length && arr[l] != null) {
                    var left = new TreeNode<>(arr[l]);
                    q.offer(left);
                    temp.setLeft(left);
                }
                if (r < arr.length && arr[r] != null) {
                    var right = new TreeNode<>(arr[r]);
                    q.offer(right);
                    temp.setRight(right);
                }
            }
            i++;
        }
        return root;
    }
    private static TreeNode<Integer> createTreeDfs(Integer[] arr, Integer i){
        if(arr.length == 0 || arr[i] == null) return null;
        var node = new TreeNode<Integer>(arr[i]);
        node.setLeft(createTreeDfs(arr, ++i));
        node.setRight(createTreeDfs(arr, ++i));
        return node;
    }
    // 1 2 3, n, n, 5, 6
    // 1 2 n, n 3, 5, 6
}

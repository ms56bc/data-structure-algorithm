package org.blind75;

import org.blind75.model.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MaxDepthTree {
    public static void main(String[] args) {
        var m = new MaxDepthTree();
        //var root = TreeNode.createTree();
        var root = TreeNode.createTreeFromArray(new Integer[]{1, 2, 3, null, null, 5, 6});
       // System.out.println(m.dfs(root));
       // m.invert(root);
        System.out.println(m.bfsLevel(root));
    }

    private int dfs(TreeNode<Integer> root){
        if(root == null) return 0;
        return 1 + Integer.max(dfs(root.getLeft()), dfs(root.getRight()));
    }

    private boolean isSame(TreeNode<Integer> a, TreeNode<Integer> b){
        if(a==null && b==null) return true;
        if(a==null || b==null) return false;
        return a.getValue() == b.getValue() && isSame(a.getLeft(), b.getLeft()) && isSame(a.getRight(), b.getRight());
    }

    private int bfsLevel(TreeNode<Integer> root){
        if(root == null) return 0;
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            int  i = q.size();
            while(i > 0){
                var c = q.poll();
                System.out.println(c.getValue());
                if(c.getLeft() != null) q.offer(c.getLeft());
                if(c.getRight() != null) q.offer(c.getRight());
                i--;
            }
            level++;
            System.out.println("level:------------"+level);
        }
        return level;
    }

    private void invert(TreeNode<Integer> root){
        if(root == null) return;
        var temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        invert(root.getLeft());
        invert(root.getRight());
    }
}

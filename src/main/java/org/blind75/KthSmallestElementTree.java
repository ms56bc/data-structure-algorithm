package org.blind75;

import org.blind75.model.TreeNode;

import java.util.Stack;

public class KthSmallestElementTree {
    public static void main(String[] args) {
        var s = new KthSmallestElementTree();
        var root = TreeNode.createTreeFromArray(new Integer[]{4, 3, 6 , 1, 2, 5, 7});
        System.out.println(s.smallest(root, 3));
        System.out.println(s.smallest(root, 5));
    }

    private int smallest(TreeNode<Integer> root, int k){
        if(root == null) return -1;
        var s = new Stack<TreeNode<Integer>>();
        s.push(root);
        int visited = 0;
        TreeNode<Integer> temp = root;
        while(!s.isEmpty()){
            while(temp != null) {
                s.push(temp);
                temp = temp.getLeft();
            }
            temp = s.pop();
            visited++;
            System.out.println("visited"+visited+"  :node: "+temp.getValue());
            if(visited == k) return temp.getValue();
            temp = temp.getRight();
        }
        return -1;
    }

    private void preOrderStack(TreeNode<Integer> root){}
    private void inOrderStack(TreeNode<Integer> root){}
    private void postOrderStack(TreeNode<Integer> root){}
}

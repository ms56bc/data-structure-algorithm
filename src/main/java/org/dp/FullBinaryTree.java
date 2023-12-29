package org.dp;

import org.blind75.TreeTraversal;
import org.blind75.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class FullBinaryTree {
    public static void main(String[] args) {
        var res = new FullBinaryTree().createFullBinaryTrees(7);
        System.out.println(res.size());
        res.forEach(TreeTraversal::levelOrderPrint);
    }
    public List<TreeNode<Integer>> createFullBinaryTrees(int n) {
        if(n ==0) return List.of();
        if(n ==1) return List.of(new TreeNode<Integer>(0));
        var res = new LinkedList<TreeNode<Integer>>();
        for(int i = 0 ; i <n; i++){
            var left = createFullBinaryTrees(i);
            var right = createFullBinaryTrees(n-i-1);
            for(var l: left){
                for(var r: right){
                    var root = new TreeNode<Integer>(0);
                    root.setLeft(l);
                    root.setRight(r);
                    res.add(root);
                }
            }
        }
        return res;
    }
}

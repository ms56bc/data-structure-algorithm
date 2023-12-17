package org.blind75;

import org.blind75.model.TreeNode;

public class LowestCommonAncestors {
    public static void main(String[] args) {
        var lca = new LowestCommonAncestors();
        //          4
        //      2       6
        //   1    3   5   7
        var root = TreeNode.createTreeFromArray(new Integer[]{4, 2, 6 , 1, 3, 5, 7, null, null, null, null});
        System.out.println(lca.findCommonAncestors(root, 3, 2));
        System.out.println(lca.findCommonAncestors(root, 5, 6));
        System.out.println(lca.findCommonAncestors(root, 4, 8));
    }

    TreeNode<Integer> findCommonAncestors(TreeNode<Integer> root, int a, int b){
        if(root == null ) return null;
        if(a < root.getValue() && b < root.getValue()){
            return findCommonAncestors(root.getLeft(), a, b);
        } else if(a > root.getValue() && b > root.getValue()){
            return findCommonAncestors(root.getRight(), a, b);
        } else {
            return root;
        }
    }
}

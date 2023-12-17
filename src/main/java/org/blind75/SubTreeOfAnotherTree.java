package org.blind75;

import org.blind75.model.TreeNode;

import java.util.Objects;

public class SubTreeOfAnotherTree {
    public static void main(String[] args) {
        var s = new SubTreeOfAnotherTree();
        var a = TreeNode.createTreeFromArray(new Integer[]{1, 2, 3,4, 5,6, 7});
        var b = TreeNode.createTreeFromArray(new Integer[]{});
        System.out.println(s.isSubTree(a, b));
        a = TreeNode.createTreeFromArray(new Integer[]{2,1});
        b = TreeNode.createTreeFromArray(new Integer[]{1});
        System.out.println(s.isSubTree(a, b));
        //System.out.println(s.isSubTree(a, b));
    }

    private boolean isSubTree(TreeNode<Integer> a, TreeNode<Integer> b){
        if(a == null && b == null) return true;
        if(b == null) return true;
        if(a == null) return false;
        System.out.println(a.getValue() +"::::"+b.getValue());
        if(isSameTree(a, b)) return true;
        return isSubTree(a.getLeft(), b) || isSubTree(a.getRight(), a);
    }
    private boolean isSameTree(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        return Objects.equals(root1.getValue(), root2.getValue()) &&
                isSameTree(root1.getLeft(), root2.getLeft()) &&
                isSameTree(root1.getRight(), root2.getRight());
    }
}

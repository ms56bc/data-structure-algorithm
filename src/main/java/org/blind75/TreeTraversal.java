package org.blind75;

import org.blind75.model.TreeNode;

import java.util.Stack;

public class TreeTraversal {
    public static void main(String[] args) {
        var root = TreeNode.createTreeFromArray(new Integer[]{4, 2, 6 , 1, 3, 5, 7});
        //          4
        //      2       6
        //   1    3   5   7
        System.out.println("in-order");
        TreeTraversal.inOrder(root);
        System.out.println("dfs");
        TreeTraversal.inOrderDfs(root);

        System.out.println("pre-order");
        TreeTraversal.preOrder(root);
        System.out.println("dfs");
        TreeTraversal.preOrderDfs(root);

        System.out.println("post-order");
        TreeTraversal.postOrder(root);
        System.out.println("dfs");
        TreeTraversal.postOrderDfs(root);
    }

    public static void preOrder(TreeNode<Integer> root){
        if(root == null) return;
        var s = new Stack<TreeNode<Integer>>();
        s.push(root);
        while(!s.isEmpty()){
            var curr = s.pop();
            System.out.print(curr.getValue()+" ");
            if(curr.getRight() != null) s.push(curr.getRight());
            if(curr.getLeft() != null) s.push(curr.getLeft());
        }
    }
    public static void postOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode<Integer>> stack1 = new Stack<>();
        Stack<TreeNode<Integer>> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode<Integer> current = stack1.pop();
            stack2.push(current);

            if (current.getLeft() != null) {
                stack1.push(current.getLeft());
            }

            if (current.getRight() != null) {
                stack1.push(current.getRight());
            }
        }

        // Process nodes in stack2 to get post-order traversal
        while (!stack2.isEmpty()) {
            var node = stack2.pop();
            System.out.print(node.getValue() + " ");
        }
    }
    public static void inOrder(TreeNode<Integer> root){
        if(root == null) return;
        var stack = new Stack<TreeNode<Integer>>();
        TreeNode<Integer> current  = root;
        while (current != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

            // Process the current node
            current = stack.pop();
            System.out.print(current.getValue() + " ");

            // Move to the right subtree
            current = current.getRight();
        }
    }

    static void inOrderDfs(TreeNode<Integer> root){
        if(root == null) return;
        inOrderDfs(root.getLeft());
        System.out.print(root.getValue()+" ");
        inOrderDfs(root.getRight());
    }

    static void preOrderDfs(TreeNode<Integer> root){
        if(root == null) return;
        System.out.print(root.getValue()+" ");
        preOrderDfs(root.getLeft());
        preOrderDfs(root.getRight());
    }

    static void postOrderDfs(TreeNode<Integer> root){
        if(root == null) return;
        postOrderDfs(root.getLeft());
        postOrderDfs(root.getRight());
        System.out.print(root.getValue()+" ");
    }

    public static void levelOrderPrint(TreeNode<Integer> root){
        if(root == null) return;
        var q = new Stack<TreeNode<Integer>>();
        q.push(root);
        int level = 0;
        int spaces = 5;
        printSpaces(spaces - level);
        System.out.print(root.getValue()+" ");
        System.out.println();

        while(!q.isEmpty()){
            level++;
            var curr = q.pop();
            System.out.print("level: "+level+ "    ");
            if(curr.getLeft() != null){
                System.out.print("left:"+curr.getLeft().getValue());
                printSpaces(spaces - level);
                q.push(curr.getLeft());
            }
            if(curr.getRight() != null){
                printSpaces(spaces + level);
                System.out.print("right"+curr.getRight().getValue());
                q.push(curr.getRight());
            }
            System.out.println();
           // level++;
        }
    }
    static void printSpaces(int n){
        while(n > 0){
            System.out.print(" ");
            n--;
        }
    }
}

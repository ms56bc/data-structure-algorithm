package org.blind75;

import org.blind75.model.TreeNode;

import java.util.LinkedList;

// TODO this is missing
public class ConstructTreeFromInorderAndPreOrder {
    record Tuple(Integer[] l, Integer[] r){};
    public static void main(String[] args) {

    }

    private TreeNode<Integer> construct(int[] p, int [] i){
        return null;
    }

    private Tuple split(int[] p, int i){

        var l = new LinkedList<Integer>();
        var r = new LinkedList<Integer>();
        boolean split = false;
        for(int k : p){
            if(i == k){
                split =true;
                continue;
            }
            if(split) r.add(k);
            else l.add(k);
        }
        return new Tuple(l.toArray(new Integer[0]), r.toArray(new Integer[0]));
    }
}

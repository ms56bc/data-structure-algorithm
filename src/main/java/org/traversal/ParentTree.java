package org.traversal;

public class ParentTree {
    public static void main(String[] args) {
        int[] tree = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int n = tree.length;

        System.out.println(willPlay(tree, 2, 5));
    }

    private static int willPlay(int [] tree, int m, int n){
        int maxRounds = maxRounds(tree.length);
        System.out.println("maxRounds: "+ maxRounds);
        int round = -1;
        while(maxRounds-- > 0){
            m = m /2;
            n = n /2;
            System.out.println("m: "+ m + " n: "+ n);
            if(m == n) {
                round = maxRounds;
                break;
            }
        }
        return round;
    }
    private static int maxRounds(int maxElements){
        return (int) Math.floor(Math.log(maxElements) / Math.log(2));
    }

    private static int printParent(int[] tree, int n) {
        if(n >0 && n < tree.length){
            int parentIndex = parentIndex(n);
            System.out.println("Parent of "+ n + " is " + parentIndex);
            return tree[parentIndex(n)];
        }
        throw new IllegalArgumentException("Invalid index"+ n);
    }

    private static int parentIndex(int n){
        return isOdd(n) ? n / 2 : n / 2 -1;
    }
    private static boolean isOdd(int n) {
        return n % 2 != 0;
    }
}

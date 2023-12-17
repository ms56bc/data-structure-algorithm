package org.example.recursion;

import java.util.stream.IntStream;

/***
 * 0
 * 1,0  n=2, k=2 => 2, 1, =1
 * 01,10 -> 3, 4 =? 4, 2
 * 0110,1001 -> 4 m =4
 */
public class KthGrammer {
    public int solve(int n, int k){
        System.out.print("n:" + (n) +" k:"+ k+"-->");
        if(n == 1 && k == 1) return 0;
        int mid = (int)(Math.pow(2, n-1) /2);
        if(k <= mid){
            return solve(n -1, k);
        }
        else {
            return solve(n-1, k - mid) == 0 ? 1: 0;
        }
    }

    public static void main(String[] args) {
        KthGrammer k = new KthGrammer();
        IntStream.range(1, 5)
                .forEach(j ->
                        IntStream.range(1, (int)Math.pow(2, j-1)+1)
                                .forEach(i->System.out.println(k.solve(j, i)))
                );
    }
}

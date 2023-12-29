package org.dp;

import java.util.Arrays;

public class PascalTriangle {
    public static void main(String[] args) {
        var ps = new PascalTriangle();
        Arrays.stream(ps.createTriangle(5))
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
    private  int[][] createTriangle(int n){
        var res = new int[n][];
        res[0] = new int[]{1};
        for(int i = 1; i < n; i++){
            var col = new int[i +1];
            for(int j = 0; j <= i; j++){
                col[j] = getValue(res, i-1, j-1) + getValue(res, i-1, j);
            }
            res[i] = col;
        }
    return res;
    }

    private int getValue(int[][] res, int i, int j){
        return j < 0 || j >= res[i].length ? 0 : res[i][j];
    }
}

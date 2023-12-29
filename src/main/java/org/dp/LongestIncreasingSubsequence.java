package org.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        var lis = new LongestIncreasingSubsequence();
        var res = lis.findSolution(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(res);
        res = lis.findSolution(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(res);
    }
    private int findSolution(int[] a){
        return lcsDfs(a, 0, Integer.MAX_VALUE);
    }
    private int[] lcq(int[] a) {
        List<Integer> longest = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int curr = a[i];
            List<Integer> temp = new ArrayList<>();
            temp.add(curr);
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < curr) {
                    temp.add(a[j]);
                    curr = a[j];
                }
            }
            if (temp.size() > longest.size()) {
                longest = temp;
            }
        }
        return longest.stream().mapToInt(i -> i).toArray();
    }

    private int lcsDfs(int[] a, int idx, int prev){
        if(idx == a.length) return 0;
        int max = Integer.MIN_VALUE;
        if(prev > a[idx]){
            max = Integer.max(max, 1 + lcsDfs(a, idx + 1, a[idx]));
        }
        return Integer.max(max, lcsDfs(a, idx + 1, prev));
    }
}//    10, 9, 2, 5, 3, 7, 101, 18
// 0   3,   2,  2,  1    ,   1  ,  1
// 1   1, 1,  1, 1
// 2   1, 1,
// 3   1,

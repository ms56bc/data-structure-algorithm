package org.blind75;

import java.util.LinkedList;
import java.util.List;

public class JumpGame {
    private List<Integer> ans;

    public static void main(String[] args) {
        var jump  = new JumpGame();
        System.out.println(jump.findWays(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump.findWays(new int[]{2, 1, 0, 1}));
    }

    private boolean findWays(int[] arr) {
         ans = new LinkedList<Integer>();
        findWaysDfs(arr, 0, 0);
        return !ans.isEmpty();
    }

    private void findWaysDfs(int[] arr, int idx, int d) {
        if (arr.length - 1 == idx) {
            ans.add(d);
            return;
        }
        if (arr.length <= idx) {
            return;
        }
        for (int j = arr[idx]; j > 0 ; j--) {
            findWaysDfs(arr, idx + j, d + 1);
        }
    }
}

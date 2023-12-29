package org.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        c.dfs(List.of(4, 3, 6, 7, 3, 2), new ArrayList<>(), 8, 0);
        res.forEach(System.out::println);
    }

    private void dfs(List<Integer> in, List<Integer> curr, int rem, int index) {
        if (rem == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (in.size() == index) {
            return;
        }
        int c = in.get(index);
        curr.add(c);
        if (rem >= c) dfs(in, curr, rem - c, index);
        curr.remove(curr.size() -1);
        dfs(in, curr, rem, index + 1);
    }
}

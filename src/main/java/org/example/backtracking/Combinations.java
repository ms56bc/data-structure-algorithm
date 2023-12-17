package org.example.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private final List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        Combinations c = new Combinations();
        c.dfs(List.of(4, 3, 6), new ArrayList<>(), 0, 2);
        c.res.forEach(System.out::println);
    }
    private void dfs(List<Integer> in, List<Integer> curr, int idx, int rem) {
        if(rem == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(idx == in.size()) return;
        for(int i = idx; i< in.size(); i++){
            curr.add(in.get(i));
            dfs(in, curr, i + 1,rem -1);
            curr.remove(curr.size() -1);
        }
    }
}

package org.example.backtracking;

import java.util.HashSet;
import java.util.Set;

public class UniqueBinaryString {
    Set<String> given = new HashSet<>();
    public static void main(String[] args) {
        UniqueBinaryString u = new UniqueBinaryString();
        u.given.add("010");
        u.given.add("000");
        u.dfs(3, "");
    }

    private boolean dfs(int rem, String curr){
        if(rem == 0){
            if(!given.contains(curr)) {
                System.out.println(curr);
                return true;
            }
            return false;
        }
        if(dfs(rem -1, curr + "0")) return true;
        if(dfs(rem -1, curr + "1")) return true;
        return false;
    }
}

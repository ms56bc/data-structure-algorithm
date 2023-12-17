package org.example.backtracking;

import java.util.ArrayList;
import java.util.List;

public class IpAddress {
    private final List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        IpAddress ip = new IpAddress();
        var in = "25525511135";
        ip.dfs(in, new ArrayList<>(), 4);
        //ip.res.forEach(System.out::println);
        in = "0000";
       ip.dfs(in, new ArrayList<>(), 4);
        ip.res.forEach(System.out::println);
    }

    private void dfs(String in, List<String> out, int rem){
        if(rem == 0 && in.isEmpty()){
            res.add(String.join(".", out));
            return;
        }
        if(in.isEmpty() || rem ==0) return;

        for(int i = 1; i <= Integer.min(in.length(),3); i++){
            String curr  = in.substring(0, i);
            if(isValid(curr)) {
                out.add(curr);
                dfs(in.substring(i), out, rem - 1);
                out.remove(out.size() - 1);
            }
        }
    }
    private boolean isValid(String curr){
        var value = Integer.parseInt(curr);
        return value >= 0 && value <= 255;
    }
}

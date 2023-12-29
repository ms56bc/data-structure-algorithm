package org.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public void permute(String input, String out){
        if(input.isEmpty()) {
            System.out.println(out);
            return;
        }
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            permute(input.substring(0, i) + input.substring(i+1), out+(c));
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        //System.out.println("input".substring(0, 0) +"input".substring(1));
        //p.permute("abcdef", "");
        System.out.println("----");
        var input = new ArrayList<>(List.of(1,1,3));
        Collections.sort(input);
        p.permuteBacktracking(input, new ArrayList<>()).forEach(System.out::println);
    }

    public List<List<Integer>> permuteBacktracking(List<Integer> input, List<Integer> out){
        if(input.size() == 1) {
            var result = new ArrayList<List<Integer>>();
            var l = new ArrayList<Integer>();
            l.add(out.get(0));
            result.add(l);
            return result;
        }
        var result = new ArrayList<List<Integer>>();
        for(int i = 0; i < input.size(); i++){
            if(i > 0 && input.get(i).equals(input.get(i -1))) continue;
            var c = input.remove(i);
            out.add(c);
            var perms = permuteBacktracking(input, out);
            for(List<Integer> p: perms){
                p.add(c);
                result.add(p);
            }
            out.remove(out.size() -1);
            input.add(i, c);
        }
        return result;
    }
}

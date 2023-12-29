package org.recursion;

import java.util.HashSet;
import java.util.Set;

public class Subsets {
    private Set<String> unique = new HashSet<>();
    public void subsets(String in, String out) {
        if (in.isEmpty()) {
            System.out.println("set: "+out);
            return;
        }
        subsets(in.substring(1), out + in.charAt(0));
        subsets(in.substring(1), out);
    }
    public void uniqueSubsets(String in, String out) {
        if (in.isEmpty()) {
            if(!unique.contains(out)) {
                System.out.println("set: " + out);
                unique.add(out);
            }
            return;
        }
        uniqueSubsets(in.substring(1), out + in.charAt(0));
        uniqueSubsets(in.substring(1), out);
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        s.uniqueSubsets("abc", "");
    }
}

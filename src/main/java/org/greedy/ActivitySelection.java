package org.greedy;

import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        int n = start.length;
        var out = printMaxActivities(start, finish, n);
        char c = 'a';
        String.valueOf(c);
        System.out.print(out);
    }

    private static int printMaxActivities(int[] start, int[] finish, int n) {
        Arrays.sort(finish);
        int activities = 1;
        int currentIndex = 0;
        for (int i = 1; i < finish.length; i++) {
            if (start[i] >= finish[currentIndex]) {
                activities++;
                currentIndex = i;
            }
        }
        return activities;
    }
}

class Solution {
    Map<String, Set<String>> dp  = new HashMap<>();
    public List<String> find_permutation(String S) {
        return new ArrayList<>(findPermutation(S));

    }
    private Set<String> findPermutation(String s){
        Set<String> permutation = new HashSet<>();
        if(s.length() == 1){
            permutation.add(s);
            return permutation;
        }

        for(int i = 0; i< s.length(); i++){
            char current = s.charAt(i);
            Set<String> pLocal;
            if(dp.containsKey(s))
                pLocal = dp.get(s);
            else
                pLocal =  findPermutation(s.substring(0, i) + s.substring(i+1));
            pLocal = pLocal
                    .stream()
                    .map(pt -> String.valueOf(current) + pt)
                    .collect(java.util.stream.Collectors.toSet());
            permutation.addAll(pLocal);
        }
        var ss = new ArrayList<>();
        ;
        dp.put(s, permutation);
        return permutation;
    }

}

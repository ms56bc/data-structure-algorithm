package org.example.recursion;


import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(List<Integer> candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Collections.sort(candidates); // Sort the array to handle non-descending order
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public static List<List<Integer>> combinationSumB(List<Integer> candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Collections.sort(candidates); // Sort the array to handle non-descending order
        backtrackB(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, List<Integer> candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.size(); i++) {
                if (i > start && Objects.equals(candidates.get(i), candidates.get(i - 1))) {
                    // the reason for duplicate in output is the presence of duplicates in input array
                    continue; // Skip duplicates
                }
                tempList.add(candidates.get(i));
                backtrack(result, tempList, candidates, remain - candidates.get(i), i); // Allow reuse of the same element
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private static void backtrackB(List<List<Integer>> result, List<Integer> tempList, List<Integer> candidates, int remain, int start) {
        if (remain < 0 ||start >= candidates.size()) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        } else {

                tempList.add(candidates.get(start));
                backtrackB(result, tempList, candidates, remain - candidates.get(start), start); // Allow reuse of the same element
                tempList.remove(tempList.size() - 1);

            //while(start > 0 && start < candidates.size() && Objects.equals(candidates.get(start), candidates.get(start - 1))) start++;
            backtrackB(result, tempList, candidates, remain, start+1); // Allow reuse of the same element
        }
    }

    public static void main(String[] args) {
        List<Integer> candidates = new LinkedList<>(List.of(8, 1, 8, 6, 6, 8));
        int target = 12;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
        result = combinationSumB(candidates, target);
        System.out.println(result);
    }
}


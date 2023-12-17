package org.example.dp;

import java.util.*;

/**
 * Given a set of positive integers, find all its subsets.
 * Given a String, find all its substring.
 * complexity 2^n, which is also 1 << n (bit shift 1 n times)
 */
public class SubsetSums {
    private static void generatePermutation(List<Character> arr, int index, String currentSum, List<String> result) {
        if (index == arr.size()) {
            Stack<Character> stack = new Stack<>();

            result.add(currentSum); // Add the current sum to the result
            return;
        }

        // Include the current element in the subset
        generatePermutation(arr, index + 1, currentSum + arr.get(index), result);

        // Exclude the current element from the subset
        generatePermutation(arr, index + 1, currentSum, result);
    }

    private static void generateSubsetsSums(List<Integer> arr, int i, int currentSum, List<Integer> subsets) {
        if (i == arr.size()) {
            subsets.add(currentSum); // Add the current sum to the result
            return;
        }
        generateSubsetsSums(arr, i + 1, currentSum + arr.get(i), subsets);
        generateSubsetsSums(arr, i + 1, currentSum, subsets);
    }

    private static void generateSubsets(List<Integer> arr, int i, List<Integer> currentSubset, List<List<Integer>> subsets) {
        if (i == arr.size()) {
            subsets.add(List.copyOf(currentSubset));
            return;
        }
        currentSubset.add(arr.get(i));
        generateSubsets(arr, i + 1, currentSubset, subsets);
        currentSubset.remove(currentSubset.size() - 1);
        generateSubsets(arr, i + 1, currentSubset, subsets);
    }

    private static void generateSubsetsTargetSum(List<Integer> arr, int i, int remaining, List<Integer> currentSubset, List<List<Integer>> subsets) {
        if(remaining == 0) {
            subsets.add(List.copyOf(currentSubset));
            return;
        }
        if (i == arr.size()) {
         //   subsets.add(List.copyOf(currentSubset));
            return;
        }
        if(i== 0 || !Objects.equals(arr.get(i), arr.get(i - 1))) {
            if (remaining >= arr.get(i)) {
                currentSubset.add(arr.get(i));
                generateSubsetsTargetSum(arr, i, remaining - arr.get(i), currentSubset, subsets);
                currentSubset.remove(currentSubset.size() - 1);

            }
        }
        generateSubsetsTargetSum(arr, i + 1, remaining, currentSubset, subsets);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(1);
        var a = new ArrayList<String>();
        generatePermutation(List.of('a', 'b', 'c'), 0, "", a);
        var r = new ArrayList<Integer>();
        generateSubsetsSums(arr, 0, 3, r);
        System.out.println(a);
        System.out.println(r);
        var subsets = new ArrayList<List<Integer>>();
        generateSubsets(arr, 0, new ArrayList<>(), subsets);
        System.out.println(subsets);
        subsets = new ArrayList<List<Integer>>();
        Collections.sort(arr);
        generateSubsetsTargetSum(arr, 0, 5, new ArrayList<>(), subsets);
        System.out.println(subsets);
    }
}

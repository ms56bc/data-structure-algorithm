package org.backtracking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Partition to K Equal Sum Subsets - Backtracking - Leetcode 698 - Python
// return true if tit is possible to divide this i to k subsets whose sum is equal
public class SubsetSum {
    private List<Integer> in;
    private final List<List<Integer>> subsets;
    private Set<Integer> used;
    private int maxSum;
    private int maxSet;

    public SubsetSum(List<Integer> in, int maxSet) {
        this.in = in;
        this.used  = new HashSet<>();
        this.subsets = new ArrayList<>();
        addSubset();
        int sum = in.stream().reduce(0, Integer::sum);
        this.maxSum = sum / maxSet ;
        this.maxSet = maxSet;
    }

    public static void main(String[] args) {
        var in = List.of(4, 3, 2, 3, 5, 2, 1);
        SubsetSum s = new SubsetSum(in, 4);
        // 1, 2, 2, 3, 3, 4, 5 (7 - 4) = (1, 3 +1)
        // 1
        System.out.println(s.canPartitionKSubsets(in, 4));
        System.out.println(s.subsets);
    }
    private boolean canPartitionKSubsets(List<Integer> in, int k){
        return canPartitionKSubsetsX( 0, 0, 0);
    }

    private boolean canPartitionKSubsetsX(int k, int currSum, int idx){
        if(k == this.maxSet){
            return true;
        }
        // this allow us to reuse the algo gain again on the same input
        // used is a set of indexes to avoid using the same index twice
        if(currSum == maxSum){
            addSubset();
            return canPartitionKSubsetsX(k+1, 0, 0);
        }

        if(idx == in.size()) return false;

        var elem = in.get(idx);
        if(!used.contains(idx) && currSum + elem <= maxSum){
            List<Integer> cs = this.subsets.get(k);
            cs.add(elem);
            used.add(idx);
            if(canPartitionKSubsetsX(k, currSum +elem, idx +1))
                return true;
            cs.remove(cs.size() -1);
            used.remove(idx);
        }
        return canPartitionKSubsetsX(k, currSum, idx +1);
    }
    private void addSubset(){
        subsets.add(new ArrayList<>());
    }
    private int sum(List<Integer> subsets){
        return subsets.stream().reduce(0, Integer::sum);
    }
}

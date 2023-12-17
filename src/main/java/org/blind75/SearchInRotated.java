package org.blind75;

public class SearchInRotated {
    public static void main(String[] args) {
        var s = new SearchInRotated();
        var a = s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(a);
    }
    private int search(int[] nums, int target) {
        return searchDfs(nums, target, 0, nums.length - 1);
    }

    private int searchDfs(int[] nums, int target, int m, int n) {
        System.out.println(m + " " + n);
        if (m > n) return -1;
        int mid = (m + n) / 2;
        if (target == nums[mid]) return mid;
        if (nums[m] > target) {
            return searchDfs(nums, target, m + 1, n);
        } else {
            return searchDfs(nums, target, m, mid - 1);
        }
    }
}

package org.blind75;

public class MinRotated {
    public static void main(String[] args) {
        var s = new MinRotated();
        var a = s.search(new int[]{4, 5, 6, 7, 0, 1, 2});
        System.out.println(a);
        a = s.search(new int[]{4, 5, 6, 7, 8, 9});
        System.out.println(a);
    }

    private int search(int[] nums) {
        return searchDfs(nums, 0, nums.length - 1);
    }

    private int searchDfs(int[] nums, int m, int n) {
        int mid = (m + n) / 2;
        if (isMin(nums, mid)) return mid;
        if (nums[n] < nums[m]) {
            return searchDfs(nums, m + 1, n);
        } else {
            return searchDfs(nums, m, mid - 1);
        }
    }

    private boolean isMin(int[] nums, int idx) {
        int l = idx == 0 ? nums.length - 1 : idx - 1;
        int r = idx == nums.length - 1 ? 0 : idx + 1;
        return nums[idx] < nums[l] && nums[idx] < nums[r];
    }
}

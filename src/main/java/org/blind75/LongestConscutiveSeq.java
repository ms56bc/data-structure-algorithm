package org.blind75;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConscutiveSeq {
    public static void main(String[] args) {
        var a = new LongestConscutiveSeq();
        System.out.println(a.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(a.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    private int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        var set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) continue;
            int curr = nums[i];
            int count = 1;
            while (set.contains(curr + 1)) {
                curr++;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}

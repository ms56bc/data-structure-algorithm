package org.blind75;

public class MissingNumber {
    public static void main(String[] args) {
        var s = new MissingNumber();
        var a = s.missingNumber(new int[]{3, 0, 1});
        System.out.println(a);
        a = s.missingNumber(new int[]{0, 1});
        System.out.println(a);
    }
    private int missingNumber(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i: nums){
            max = Math.max(max, i);
            sum += i;
        }
        int  actualSum = (max * (max + 1) / 2);
        return actualSum == sum ? max + 1 : actualSum - sum;
    }
}

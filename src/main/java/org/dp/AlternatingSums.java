package org.dp;

public class AlternatingSums {
    public static void main(String[] args) {
        int[] a = {50, 60, 60, 45, 70};
        System.out.println(new AlternatingSums().alternatingSums(a));
    }
    //
    int alternatingSums(int[] nums) {
        int even =0, odd=0;
        // 70, 0 => 70
        // 70, 25 => 70
        //
        for(int i = nums.length -1; i >=0; i++){
             var tempEven = Integer.max(even, odd + nums[i]);
             var tempOdd = Integer.max(odd, even  - nums[i]);
             even = tempEven;
             odd = tempOdd;
        }
        return even;
    }
}

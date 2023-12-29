package org.slidingwindow;

import java.util.LinkedList;
import java.util.List;

public class LargestSubarrayWithSumK {
    public List<int[]> calc(int  [] arr, int sum){
        int currSum = 0;
        List<int[]> lst = new LinkedList<>();
        for(int  i = 0, j =0 ; j < arr.length; j ++){
            currSum += arr[j];
            if(currSum > sum){
                while (currSum > sum) {
                    currSum-= arr[i];
                    i++;
                }
            }
            if(currSum == sum) {
                //max = Integer.max(j - i, max);
                int [] index = {j, i};
                lst.add(index);
            }
        }
        return lst;
    }
}
// {1, 2, 3, 4, 1, 1, 1, 2, 2};
//j++

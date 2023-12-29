package org.slidingwindow;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * 1, 5, 3, 2, 4, 3, 6, k = 3
 * 5, 5, 4, 4, 6
 */
public class MaxInSubarray {
    public List<Integer> calculateMax(int [] arr, int k){
        List<Integer> ans = new LinkedList<>();
        Queue<Integer> maxQ = new LinkedList<>();
        for(int i = 0, j=0; j < arr.length; j++){
            while(!maxQ.isEmpty() && maxQ.peek() <= arr[j]) maxQ.poll();
            maxQ.offer(arr[j]);
            if(j - i +1 == k){
                int max = maxQ.peek();
                ans.add(max);
                if(max == arr[i]) maxQ.poll();
                i++;
            }
        }
        return ans;
    }
}

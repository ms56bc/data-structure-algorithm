package org.example.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

/***
 * first negatice integer in  a windown of sice k;
 * 1, 2, -1, -4 , 4, -5, 6, 5
 *
 */
public class FirstNegative {
    Queue<Integer> indexQueue = new LinkedList<>();

    public int [] findNegative(int [] arr, int windowSize){
        int [] ans = new int [arr.length - windowSize +1];
        for(int  i = 0, j =0 ; j < arr.length; j ++){
            if(arr[j] < 0) indexQueue.offer(j);

            if(j -i +1 == windowSize){
                Integer index = indexQueue.peek();
                ans[i] = index == null ? 0 : arr[index];
                if(index != null && i == index) indexQueue.poll();
                i++;
            }
        }
        return ans;
    }
}

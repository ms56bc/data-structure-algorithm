package org.example.slidingwindow;

/***
 * max sum in a window of size k
 * 1,
 */
public class MaxSum {
    public int calculateMaxSum(int[] array, int windowSize) {
        int maxSum = 0;
        int currSum = 0;

        for (int i = 0, j = 0; j < array.length; j++) {
            currSum += array[j];
            if (j - i + 1 == windowSize) {
                maxSum = Integer.max(maxSum, currSum);
                currSum = currSum - array[i];
                i++;
            }
        }
        return maxSum;
    }
}

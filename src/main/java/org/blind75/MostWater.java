package org.blind75;

public class MostWater {
    public static void main(String[] args) {

    }
    int maxArea(int[] height){
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        return max;
    }

    int maxAreaBf(int[] height){
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        for(int i = 0; i < height.length; i++){
            for(int j = i+1; j < height.length; j++){
                max = Integer.max(max, (j-i) * Integer.min(height[i], height[j]));
            }
        }
        return max;
    }
}

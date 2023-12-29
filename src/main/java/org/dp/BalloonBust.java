package org.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BalloonBust {
    public static void main(String[] args) {
        List<Integer> balloons = new ArrayList<>();
        balloons.add(3);
        balloons.add(1);
        balloons.add(5);
        balloons.add(8);
        System.out.println(new BalloonBust().maxCoinsDfs(balloons));
    }
    private int maxCoinsDp(int[] ballons, int i, int j){
        return 0;

    }

    private int maxCoinsDfs(List<Integer> ballons){
        if(ballons.size() == 1) return getScore(ballons, 0);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< ballons.size(); i++) {
            var s = getScore(ballons, i);
            var rem = ballons.remove(i);
            max = Integer.max(s + maxCoinsDfs(new LinkedList<>(ballons)), max);
            ballons.add(i, rem);
        }
        return max;
    }

    private int getScore(List<Integer> ballons, int i){
        int l = i -1 >=0 ? ballons.get(i-1):1;
        int r = i+1 <= ballons.size() -1? ballons.get(i+1) : 1;
        return l * ballons.get(i) * r;
    }
}

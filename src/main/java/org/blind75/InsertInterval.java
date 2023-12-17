package org.blind75;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        var insert = new InsertInterval();
        var ans = insert.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        Arrays.stream(ans).forEach(a -> System.out.print(Arrays.toString(a)));
        System.out.println(" ");

        ans = insert.insert(new int[][]{{1, 3},{4, 5}, {6, 9}}, new int[]{2, 7});
        Arrays.stream(ans).forEach(a -> System.out.print(Arrays.toString(a)));
        System.out.println(" ");

        ans = insert.insert(new int[][]{{1, 3},{4, 5}, {6, 9}}, new int[]{10, 11});
        Arrays.stream(ans).forEach(a -> System.out.print(Arrays.toString(a)));
    }
    private int [][] insert(int [][] intevals, int [] newInterval){
        List<int[]> ans = new LinkedList<>();
        boolean isMerged = false;
        for(int [] interval : intevals){
            if(newInterval[1] < interval[0]) {
                ans.add(newInterval);
                isMerged = true;
            }
            else if(newInterval[0] > interval[1])
                ans.add(interval);
            else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if(!isMerged) ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }

    private boolean isOverlapping(int [] interval1, int [] interval2){
        return interval1[0] <= interval2[1] && interval1[1] >= interval2[0];
    }
}

package org.blind75;

import java.util.*;

public class CourseSchdule {
    public static void main(String[] args) {
        var s = new CourseSchdule();
        System.out.println(s.canFinish(2, new int[][]{{1,0}}));
        System.out.println(s.canFinish(3, new int[][]{{1,0}, {2,1}}));
        System.out.println(s.canFinish(3, new int[][]{{1,0}, {2,1}, {0,2}}));
    }
    private boolean canFinish(int n, int[][] dep){
        var depg = new HashMap<Integer, List<Integer>>();
        var first = new HashSet<Integer>();
        var rem = new HashSet<>();
        for(int i= 0; i < n; i++){
            first.add(i);
        }
        for(int[] a: dep){
            var lst = depg.getOrDefault(a[1], new ArrayList<>());
            lst.add(a[0]);
            depg.put(a[1], lst);
            first.remove(a[0]);
        }
        if(first.isEmpty()) return false;

        Queue<Integer> q = new LinkedList<>(first);

        while (!q.isEmpty()){
            var curr = q.poll();
            if(!rem.contains(curr)) {
                var d = depg.get(curr);
                if(d != null)q.addAll(d);
                rem.add(curr);
            }
        }
        return rem.size() == n;
    }
}

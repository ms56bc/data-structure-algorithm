package org.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class NetworkDelay {
    record Dest(int t, int time){}
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{2,4,2}, {3,5,3}, {4,5,1}};
        int n = 5, k = 2;
        System.out.println(new NetworkDelay().networkDelayTime(times, n, k));
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        var graph = new HashMap<Integer, LinkedList<Dest>>();
        for(int[] time: times){
            graph.putIfAbsent(time[0], new LinkedList<>());
            graph.get(time[0]).add(new Dest(time[1], time[2]));
        }
        var pq = new PriorityQueue<Dest>(Comparator.comparingInt(Dest::time));
        var visited = new boolean[n+1];
        pq.add(new Dest(k, 0));
        int max = 0;
        while(!pq.isEmpty()){
            var dest = pq.poll();
            System.out.println(dest);
            if(visited[dest.t()]) continue;
            visited[dest.t()] = true;
            max = dest.time();
            if(graph.containsKey(dest.t())){
                for(var d: graph.get(dest.t())){
                    if(!visited[d.t()]){
                        pq.add(new Dest(d.t(), d.time() + dest.time()));
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++){
            if(!visited[i]) return -1;
        }
        return max;
    }

}

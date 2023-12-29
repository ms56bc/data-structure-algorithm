package org.blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule2 {
    public static void main(String[] args) {
        var s = new CourseSchedule2();
        s.findOrder(6, new int[][]{{4, 0}, {5, 0}, {0, 1}, {1, 2}, {3, 1}, {3, 2}}).forEach(System.out::println);
        //printArray(s.findOrder(2, new int[][]{{1,0}}));
    }

    private static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }

    private List<Integer> findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        var adjList = new HashMap<Integer, List<Integer>>();
        for(int[] a: prerequisites){
            var lst = adjList.getOrDefault(a[0], new LinkedList<Integer>());
            lst.add(a[1]);
            adjList.put(a[0], lst);
        }

        var order = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, order, adjList);
            }
        }
        return order;
    }

    private void dfs(int i, int[] visited, List<Integer> order, HashMap<Integer, List<Integer>> adjList) {
        if (visited[i] == 1) return;
        visited[i] = 1;
        for(int a : adjList.getOrDefault(i, List.of())) {
            dfs(a, visited, order, adjList);
        }
        order.add(i);
    }
}

package org.recursion;

import java.util.ArrayList;
import java.util.List;

public class GraphCycleDetection {
    public static boolean hasCycle(List<List<Integer>> adjList) {
        int numNodes = adjList.size();
        boolean[] visited = new boolean[numNodes];

        for (int i = 0; i < numNodes; i++) {
            if (!visited[i] && hasCycleDFS(adjList, i, -1, visited)) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasCycleDFS(List<List<Integer>> adjList, int currentNode, int parent, boolean[] visited) {
        visited[currentNode] = true;

        for (int neighbor : adjList.get(currentNode)) {
            if (!visited[neighbor]) {
                if (hasCycleDFS(adjList, neighbor, currentNode, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(List.of(1));
        adjList.add(List.of(0, 2, 4));
        adjList.add(List.of(1, 3));
        adjList.add(List.of(2, 4));
        adjList.add(List.of(1, 3));

        if (hasCycle(adjList)) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
        }
    }
}


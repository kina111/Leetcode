/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

import java.util.ArrayList;
import java.util.List;

/**
Task: return the arrangement to take all of subjects.
 */
public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //build graph
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        //solve
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, visited, onPath, result)) {
                return new int[0];
            }
        }

        //convert to result if satisfy
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    private boolean dfs(List<Integer>[] graph, int v, boolean[] visited, boolean[] onPath, List<Integer> result) {
        if (onPath[v]) {
            return false;
        }
        if (visited[v]) {
            return true;
        }

        onPath[v] = true;
        visited[v] = true;
        
        for (int neighbor : graph[v]) {
            if (!dfs(graph, neighbor, visited, onPath, result)) {
                return false;
            }
        }
        
        //if scan all its neighbor and there is no circle at point V
        result.add(v);
        onPath[v] = false;
        return true;
    }
}

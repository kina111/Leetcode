/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Task: There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
* You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
* input: numCourses = 2, prerequisites = [[1,0],[0,1]]
* output: false
* 
* 
*/
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++){
            graph.putIfAbsent(prerequisites[i][0], new ArrayList<>());
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        for (int v = 0; v < numCourses; v++){
            if (!dfs(graph, v, visited, onPath)){
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int v, boolean[] visited, boolean[] onPath){
        if (onPath[v]) return false;//if v is currently on path
        if (visited[v]) return true;
        
        visited[v] = true;
        onPath[v] = true;//mark v is on path
        if (graph.containsKey(v)){
            for (Integer neighbor : graph.get(v)){
                if (!dfs(graph, neighbor, visited, onPath)){
                    return false;
                }
            }
        }
        onPath[v] = false;//set onPath = false if there is no circle at point V
        return true;
    }
}

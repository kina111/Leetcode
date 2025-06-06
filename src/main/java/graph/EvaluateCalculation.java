/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Task: eg : equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries =
 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]] -->
 * [6.00000,0.50000,-1.00000,1.00000,-1.00000] Note: The input is always valid.
 * You may assume that evaluating the queries will not result in division by
 * zero and that there is no contradiction. Note: The variables that do not
 * occur in the list of equations are undefined, so the answer cannot be
 * determined for them.
 *
 * Sol: Consider as a graph and using dfs/bfs to solve each queries
 */
public class EvaluateCalculation {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int resultSize = queries.size();
        double[] result = new double[resultSize];

        //build graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        buildGraph(equations, values, graph);

        //update result for each queries
        for (int i = 0; i < resultSize; i++) {
            result[i] = findPath(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());
        }
        return result;
    }

    private void buildGraph(List<List<String>> equations, double[] values, Map<String, Map<String, Double>> graph) {
        for (int i = 0; i < values.length; i++) {
            String key1 = equations.get(i).get(0);
            String key2 = equations.get(i).get(1);
            graph.putIfAbsent(key1, new HashMap<>());
            graph.putIfAbsent(key2, new HashMap<>());
            graph.get(key1).put(key2, values[i]);
            graph.get(key2).put(key1, 1.0 / values[i]);
        }
    }

    private double findPath(String start, String end, Map<String, Map<String, Double>> graph, Set<String> visited) {
        //base case
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1;
        }
        if (start.equals(end)) {
            return 1;
        }

        //mark visited to avoid infinite loop
        visited.add(start);

        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double product = findPath(neighbor.getKey(), end, graph, visited);//
                if (product != -1) {
                    return neighbor.getValue() * product;//if find path, immediately return
                }
            }
        }

        return -1;//if not find any path
    }
}

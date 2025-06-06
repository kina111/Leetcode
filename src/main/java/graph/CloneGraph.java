/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

/*
Task: Create a deep copy of a graph that 
    For simplicity, each node's value is the same as the node's index (1-indexed).
Sol: Using dfs + HashMap (to save cloned node)
 */
public class CloneGraph {

    HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        //if node was cloned successfully.
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        //if not, create a new one, put into map and create its neighbors.
        Node cloneNode = new Node(node.val);
        map.put(node.val, cloneNode);
        for (Node n : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(n));
        }
        return cloneNode;
    }
}

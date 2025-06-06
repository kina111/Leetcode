/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

import java.util.Stack;


/*
Task: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    Implement the MinStack class:
        + MinStack() initializes the stack object.
        + void push(int val) pushes the element val onto the stack.
        + void pop() removes the element on the top of the stack.
        + int top() gets the top element of the stack.
        + int getMin() retrieves the minimum element in the stack.
    You must implement a solution with O(1) time complexity for each function.
Sol: Using a stack<int[]> storing a pair [value, minValue] that minValue is the minimum value at that time.

Note: Stack is efficient to track a specific characteristic (like minValue, maxValue, AvgValue, etc) at a specific time, so would be useful in couple with greedy method.
*/

public class MinStack {
    Stack<int[]> stack = new Stack<>();
    int minValue;
    public MinStack() {
        stack = new Stack<>();
        minValue = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (stack.isEmpty()) minValue = val;
        else if (val < minValue) minValue = val;
        stack.push(new int[]{val, minValue});
    }
 
    public void pop() {
        minValue = stack.pop()[1];
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
    
}


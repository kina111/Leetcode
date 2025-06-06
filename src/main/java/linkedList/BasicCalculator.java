/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

import java.util.Stack;

/**
 *
 * @author FPT
 */
public class BasicCalculator {

    public BasicCalculator() {
    }

//    public int calculate(String s) {
//        Stack<Character> operators = new Stack<>();
//        Stack<Integer> numbers = new Stack<>();
//        int idx = 0;
//        while (idx < s.length()) {
//            if (s.charAt(idx) == '-') {
//                if (s.charAt(idx - 1) < '0' || s.charAt(idx - 1) > '9') {                   
//                    numbers.push(0);
//                }
//                operators.push('-');
//                idx++;
//            } else if (s.charAt(idx) == '+') {
//                operators.push('+');
//                idx++;
//            } else if (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
//                StringBuilder sb = new StringBuilder();
//                while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
//                    sb.append(s.charAt(idx));
//                    idx++;
//                }
//                int newNum = Integer.parseInt(sb.toString());
//                if (operators.isEmpty()) {
//                    numbers.push(newNum);
//                } else if (operators.peek() == '+') {
//                    int temp = numbers.push(numbers.pop() + newNum);
//                    operators.pop();
//                } else if (operators.peek() == '-') {
//                    numbers.push(-newNum + numbers.pop());
//                    operators.pop();
//                } else {
//                    numbers.push(newNum);
//                }
//            } else if (s.charAt(idx) == ')') {
//                while (operators.peek() != '(') {
//                    if (operators.peek() == '+') {
//                        int temp = numbers.push(numbers.pop() + numbers.pop());
//                        operators.pop();
//                    } else if (operators.peek() == '-') {
//                        numbers.push(-numbers.pop() + numbers.pop());
//                        operators.pop();
//                    }
//                }
//                operators.pop();
//                idx++;
//            } else if (s.charAt(idx) == '(') {
//                operators.push('(');
//                idx++;
//            } else {
//                idx++;
//            }
//        }
//        while (!operators.isEmpty()) {
//            if (operators.pop() == '+') {
//                numbers.push(numbers.pop() + numbers.pop());
//            } else {
//                numbers.push(-numbers.pop() + numbers.pop());
//            }
//        }
//        int res = numbers.pop();
//        while (!numbers.isEmpty()) res += numbers.pop();
//        return res;
//    }
    
    public int calculate(String s) {
        
    }
    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        String s = " 2-1 + 2 ";
        System.out.println(bc.calculate(s));
    }
}

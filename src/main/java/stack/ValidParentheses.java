/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author FPT
 */
public class ValidParentheses {

    public ValidParentheses() {
    }

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //if current char is open bracket
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                st.add(s.charAt(i));
            //if current char is close bracket
            } else {
                // if not match or is a redundant close bracket
                if (st.isEmpty() || map.get(s.charAt(i)) != st.peek()) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty(); //no redundant open bracket
    }
    
    //cleaner approach
    public boolean isValid2(String s){
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()){
            switch (c) {
                case '(':
                    st.push(')');
                    break;
                case '[':
                    st.push(']');
                    break;
                case '{':
                    st.push('}');
                    break;
                default:
                    if (st.isEmpty() || st.pop() != c){
                        return false;
                    }   break;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String s = "({";
        System.out.println(vp.isValid2(s));
    }
}

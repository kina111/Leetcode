/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

import java.util.Stack;
/*
Note: 
1. if (token.matches(regex) --> cham hon (do bien dich regex moi lan)
   switch (token)  --> nhanh hon (do dung Hash Look Up, Jump Table)
--> switch/case tot hon cho kiem tra don gian. (vd: trong bai toan: 400ms --> 50ms)
2. Luon uu tien int thay vi Integer, tru khi can luu null hoac lam viec voi Collections
*/
public class EvaluateReversePolishNotation {

    public EvaluateReversePolishNotation() {
    }

    
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            switch (token){
                case "+":
                    st.push(st.pop() + st.pop());
                    break;
                case "*": 
                    st.push(st.pop() * st.pop());
                    break;
                case "/":
                    int b = st.pop(), a = st.pop();
                    st.push(a / b);
                    break;
                case "-":
                    int d = st.pop(), c = st.pop();
                    st.push(c - d);
                    break;
                default: 
                        st.push(Integer.valueOf(token));
            }
        }
        return st.pop();
    }
    
    public static void main(String[] args) {
        EvaluateReversePolishNotation helper = new EvaluateReversePolishNotation();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(helper.evalRPN(tokens));
    }
}

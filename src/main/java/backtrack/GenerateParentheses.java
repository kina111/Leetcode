/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backtrack;

import java.util.ArrayList;
import java.util.List;

/*
Task: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
eg: Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
*/
public class GenerateParentheses {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(sb, n * 2, 0);
        return result;
    }

    private void backtrack(StringBuilder sb, int nofLeft, int gap) {
        if (gap < 0 || gap > nofLeft) {
            return;
        }
        if (gap == 0 && nofLeft == 0) {
            result.add(sb.toString());
            return;
        }
        sb.append('(');
        backtrack(sb, nofLeft - 1, gap + 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        backtrack(sb, nofLeft - 1, gap - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}

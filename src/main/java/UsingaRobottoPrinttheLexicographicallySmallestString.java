
import java.util.Stack;


/*
Task: You are given a string s and a robot that currently holds an empty string t.
Apply one of the following operations until s and t are both empty:
    Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
    Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
Return the lexicographically smallest string that can be written on the paper.


*/
public class UsingaRobottoPrinttheLexicographicallySmallestString {

    //Complex: O(n) O(n)
    public String robotWithString(String s) {
        int n = s.length();
        char[] smallestSuffix = new char[n];
        char minChar = 'z';

        // Lưu ký tự nhỏ nhất từ phải sang trái
        for (int i = n - 1; i >= 0; i--) {
            minChar = (char) Math.min(minChar, s.charAt(i));
            smallestSuffix[i] = minChar;
        }

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        stack.push('~'); // Sentinel: lớn hơn mọi ký tự từ a-z

        for (int i = 0; i < n; i++) {
            while (smallestSuffix[i] >= stack.peek()) {
                result.append(stack.pop());
            }

            char current = s.charAt(i);
            if (current == smallestSuffix[i]) {
                result.append(current);
            } else {
                stack.push(current);
            }
        }

        while (stack.size() > 1) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}

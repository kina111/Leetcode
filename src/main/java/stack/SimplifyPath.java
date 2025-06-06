/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

import java.util.Stack;

/*
Task: You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. 
Transform this absolute path into its simplified canonical path.
Sol: 
*/
public class SimplifyPath {

    public SimplifyPath() {
    }

    public String simplifyPath(String path) {
        Stack<String> st = new Stack();
        int idx = 0;
        StringBuilder sb;
        while (idx < path.length()) {
            //skip consecutive slashes
            while (idx < path.length() && path.charAt(idx) == '/') {
                idx++;
            }
            //extract directory
            sb = new StringBuilder("/");
            while (idx < path.length() && path.charAt(idx) != '/') {
                sb.append(path.charAt(idx));
                idx++;
            }
            //process with the extracted dir
            String dir = sb.toString();
            if (dir.equals("/..")){
                if (!st.isEmpty()) st.pop();
            }else if (!dir.equals("/.") && !dir.equals("/")){
                st.push(dir);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String s : st){
            result.append(s);
        }
        return result.toString().isEmpty() ? "/" : result.toString();
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        String path = "/../";
        System.out.println(sp.simplifyPath(path));
    }
}

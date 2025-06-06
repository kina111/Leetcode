/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backtrack;

import java.util.ArrayList;
import java.util.List;

/*
Task: With the default keypad below, generate all possibility of a Input string
eg: 23 ---> {ad, ae,af,bd,be,bf, cd,ce,cf}
//  [1: ○◯ ]  [2: abc ]  [3: def ]
//  [4: ghi]  [5: jkl ]  [6: mno ]
//  [7: pqrs] [8: tuv ]  [9: wxyz]
//  [*: *+  ] [0: ⏎  ]  [#: ⇧   ]

*/
public class LetterCombinationOfPhoneNumber {
    static char[][] keyboard = {
                        {}, {}, 
                        {'a', 'b', 'c'},
                        {'d', 'e', 'f'},
                        {'g', 'h', 'i'},
                        {'j', 'k', 'l'},
                        {'m', 'n', 'o'},
                        {'p', 'q', 'r', 's'}, 
                        {'t', 'u', 'v'},
                        {'w', 'x', 'y', 'z'}
                        };

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        
        int phoneLength = digits.length();
        StringBuilder sb = new StringBuilder();
        backtrack(sb, 0, digits, keyboard);
        return result;
    }

    public void backtrack(StringBuilder curr, int idx, String input, char[][] keyboard) {
        if (idx == input.length()) {
            result.add(curr.toString());
            return;
        }
        int currDigit = input.charAt(idx) - 48;
        for (int i = 0; i < keyboard[currDigit].length; i++) {
            curr.append(keyboard[currDigit][i]);
            backtrack(curr, idx + 1, input, keyboard);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}

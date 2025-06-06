/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.ArrayList;
import java.util.List;

/*["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]
                    [Science  is  what we]
                    [understand      well]
                    [enough to explain to]
                    [a  computer.  Art is]
                    [everything  else  we]
                    [do                  ]


Task: Text Justification as above (hard because many edge cases)
Sol: 1. Step by step, mark the head word and tail word for each line and add space approciately
        Time: O(n) Space: 

 */
public class TextJustification {

    public TextJustification() {
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int cntWord = 0;
        List<String> result = new ArrayList<>();
        int len = words.length;
        int head, tail, currentLen;
        while (cntWord < len) {
            head = cntWord;
            tail = cntWord + 1;
            currentLen = words[head].length();
            while (tail < len && (currentLen + 1 + words[tail].length() <= maxWidth)) {
                currentLen += (1 + words[tail].length());
                tail++;
            }

            cntWord = tail;
            tail--;
            int numOfWords = tail - head + 1;
            String spaces;
            StringBuilder sb = new StringBuilder();
            //if it is last line, left-justified
            if (cntWord == len) {
                int lastLineLength = 0;
                for (int i = head; i <= tail; i++) {
                    lastLineLength += words[i].length();
                    sb.append(words[i]);
                    if (lastLineLength + 1 <= maxWidth) {
                        sb.append(" ");
                        lastLineLength++;
                    }
                }
                spaces = " ".repeat(maxWidth - lastLineLength);
                sb.append(spaces);
                result.add(sb.toString());
                return result;
            }
            //if only one word in line
            if (numOfWords == 1) {
                spaces = " ".repeat(maxWidth - words[tail].length());
                sb.append(words[tail]).append(spaces);
            //else, it is the normal line
            } else {
                currentLen -= (numOfWords - 1);
                int roomForSpace = maxWidth - currentLen;
                int defaultSpace = roomForSpace / (numOfWords - 1);
                int remainSpace = roomForSpace % (numOfWords - 1);
                for (int i = 0; i < remainSpace; i++) {
                    spaces = " ".repeat(defaultSpace + 1);
                    sb.append(words[head++]).append(spaces);
                }
                while (head < tail) {
                    spaces = " ".repeat(defaultSpace);
                    sb.append(String.format("%s%s", words[head++], spaces));
                }
                sb.append(words[tail]);
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        TextJustification helper = new TextJustification();
        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth = 20;
        List<String> result = helper.fullJustify(words, maxWidth);
        for (String s : result) {
            System.out.println(String.format("[%s]", s));
        }
    }
}

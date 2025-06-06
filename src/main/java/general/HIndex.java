/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
Task: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers 
that have each been cited at least h times.
Sol: 1. Sorting ---> Time: O(nlogn) Space: O(n)/O(1)

*/
public class HIndex {
    public static int hIndex(int[] citations) {
        List<Integer> citation = new ArrayList<>();
        for (int i = 0; i < citations.length; i++){
            citation.add(citations[i]);
        }
        Collections.sort(citation);
        int result = 0;
        int numberRemain = citation.size();
        for (int i = 0; i < citation.size(); i++){
            result = Integer.max(result, Integer.min(numberRemain, citation.get(i)));
            numberRemain--;
            
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] citations = {1};
        System.out.println(hIndex(citations));
    }
}

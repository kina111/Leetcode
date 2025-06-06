/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/**
 *
 * @author FPT
 */
public class FirstOccurenceInAString {

    public FirstOccurenceInAString() {
    }
    
//    
    public int strStr(String haystack, String needle) {
    int patternLength = needle.length();
    if (patternLength == 0) return 0; // Trường hợp needle rỗng

    // Bước 1: Tạo mảng LPS (Longest Prefix Suffix)
    int[] LPS = new int[patternLength];
    int i = 0; // Chỉ số theo dõi tiền tố
    for (int j = 1; j < patternLength; j++) {
        while (i > 0 && needle.charAt(j) != needle.charAt(i)) {
            i = LPS[i - 1];
        }
        if (needle.charAt(j) == needle.charAt(i)) {
            i++;
        }
        LPS[j] = i;
    }

    // Bước 2: Duyệt haystack để tìm needle
    int stringPointer = 0, patternPointer = 0;
    while (stringPointer < haystack.length()) {
        if (haystack.charAt(stringPointer) == needle.charAt(patternPointer)) {
            stringPointer++;
            patternPointer++;
            if (patternPointer == patternLength) { 
                return stringPointer - patternLength; // Tìm thấy needle trong haystack
            }
        } else {
            if (patternPointer > 0) {
                patternPointer = LPS[patternPointer - 1];
            } else {
                stringPointer++; // Nếu không có tiền tố để quay lại, chỉ tăng stringPointer
            }
        }
    }
    return -1; // Không tìm thấy needle trong haystack
}

    
    public static void main(String[] args) {
        FirstOccurenceInAString helper = new FirstOccurenceInAString();
        String haystack = "abxabcabcaby";
        String needle = "abcaby";
        System.out.println(helper.strStr(haystack, needle));
    }
}

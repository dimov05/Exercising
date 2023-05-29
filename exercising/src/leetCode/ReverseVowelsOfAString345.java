package leetCode;

//Given a string s, reverse only all the vowels in the string and return it.
//
//        The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
//
//
//
//        Example 1:
//
//        Input: s = "hello"
//        Output: "holle"
//        Example 2:
//
//        Input: s = "leetcode"
//        Output: "leotcede"

import java.util.ArrayList;

public class ReverseVowelsOfAString345 {
    public String reverseVowels(String s) {
        ArrayList<Character> vows = new ArrayList<>();
        vows.add('a');
        vows.add('A');
        vows.add('e');
        vows.add('E');
        vows.add('i');
        vows.add('I');
        vows.add('o');
        vows.add('O');
        vows.add('u');
        vows.add('U');
        int start = 0;
        int end = s.length() - 1;
        char[] sArray = s.toCharArray();
        while (start < end) {
            if (!vows.contains(sArray[start])) {
                start++;
            }
            if (!vows.contains(sArray[end])) {
                end--;
            }
            if (vows.contains(sArray[start]) && vows.contains(sArray[end])) {
                char temp = sArray[start];
                sArray[start] = sArray[end];
                sArray[end] = temp;
                start++;
                end--;
            }
        }
        return new String(sArray);

    }
}

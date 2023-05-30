package leetCode;

//Given a string s consisting of words and spaces, return the length of the last word in the string.
//
//        A word is a maximal
//        substring
//        consisting of non-space characters only.
//
//
//
//        Example 1:
//
//        Input: s = "Hello World"
//        Output: 5
//        Explanation: The last word is "World" with length 5.

public class LengthOfLastWord58 {
    public int lengthOfLastWord(String s) {
        int len = 0;
        s = s.trim();
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            len++;
        }
        return len;
    }
}

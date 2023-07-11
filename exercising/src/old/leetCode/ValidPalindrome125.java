package old.leetCode;

//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
//
//
//
//Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if (!Character.isLetterOrDigit(startChar)) {
                start++;
            } else if (!Character.isLetterOrDigit(endChar)) {
                end--;
            } else {
                if (Character.toLowerCase(startChar) != Character.toLowerCase(endChar)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}

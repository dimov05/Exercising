package leetCode;

// Given an integer x, return true if x is a palindrome, and false otherwise.

public class IsPalindrome9 {
    public boolean isPalindrome(int x) {
        int palindrome = 0;
        int p = 0;
        int calc = x;
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        while (calc > 0) {
            int remain = calc % 10;
            calc = calc / 10;
            palindrome = 10 * palindrome + remain;
        }
        return x == palindrome;
    }

}

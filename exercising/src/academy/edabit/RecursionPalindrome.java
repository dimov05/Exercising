package academy.edabit;

public class RecursionPalindrome {
    public static boolean isPalindrome(String wrd) {
        // your recursive solution here
        int n = wrd.length();
        if (n == 0) {
            return true;
        }
        return isPalindromeRecursion(wrd, 0, n - 1);
    }

    public static boolean isPalindromeRecursion(String wrd, int start, int end) {
        if (start == end) {
            return true;
        }
        if (wrd.charAt(start) != wrd.charAt(end)) {
            return false;
        }
        if (start < end + 1) {
            return isPalindromeRecursion(wrd, start + 1, end - 1);
        }
        return true;
    }
}

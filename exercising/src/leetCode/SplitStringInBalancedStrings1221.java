package leetCode;

//Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
//
//        Given a balanced string s, split it into some number of substrings such that:
//
//        Each substring is balanced.
//        Return the maximum number of balanced strings you can obtain.

public class SplitStringInBalancedStrings1221 {
    public int balancedStringSplit(String s) {
        int count = 0;
        int ls = 0;
        int rs = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                rs++;
            } else if (s.charAt(i) == 'L') {
                ls++;
            }
            if (rs > 0 && ls > 0 && ls == rs) {
                count++;
                ls = 0;
                rs = 0;
            }
        }
        return count;
    }
}

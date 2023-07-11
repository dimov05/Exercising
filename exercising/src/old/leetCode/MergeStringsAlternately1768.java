package old.leetCode;

//          You are given two strings word1 and word2.
//          Merge the strings by adding letters in alternating order, starting with word1.
//          If a string is longer than the other, append the additional letters onto the end of the merged string.
//
//        Return the merged string.
//
//        Example 1:
//
//        Input: word1 = "abc", word2 = "pqr"
//        Output: "apbqcr"
//        Explanation: The merged string will be merged as so:
//        word1:  a   b   c
//        word2:    p   q   r
//        merged: a p b q c r

public class MergeStringsAlternately1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int w1 = 0;
        int w2 = 0;

        while (w1 < word1.length() || w2 < word2.length()) {
            if (w1 < word1.length()) {
                res.append(word1.charAt(w1));
                w1++;
            }
            if (w2 < word2.length()) {
                res.append(word2.charAt(w2));
                w2++;
            }
        }
        return res.toString();
    }
}

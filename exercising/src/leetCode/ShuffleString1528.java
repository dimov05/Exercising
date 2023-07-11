package leetCode;

//You are given a string s and an integer array indices of the same length. The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
//
//        Return the shuffled string.


public class ShuffleString1528 {
    public String restoreString(String s, int[] indices) {
        char[] res = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            char letter = s.charAt(i);
            int index = indices[i];
            res[index] = letter;
        }
        return String.valueOf(res);
    }
}

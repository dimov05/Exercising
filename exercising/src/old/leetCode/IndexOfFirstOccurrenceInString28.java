package old.leetCode;

//Given two strings needle and haystack,
// return the index of the first occurrence of needle in haystack,
// or -1 if needle is not part of haystack.

public class IndexOfFirstOccurrenceInString28 {
    public int strStr(String haystack, String needle) {
        int lengthNeedle = needle.length();
        for (int i = 0; i <= haystack.length() - lengthNeedle; i++) {
            String toCheck = haystack.substring(i, i + lengthNeedle);
            if (toCheck.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

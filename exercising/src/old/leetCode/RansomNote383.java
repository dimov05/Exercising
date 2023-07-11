package old.leetCode;

//Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
//Each letter in magazine can only be used once in ransomNote.
//
//
//
//Example 1:
//
//Input: ransomNote = "a", magazine = "b"
//Output: false
//Example 2:
//
//Input: ransomNote = "aa", magazine = "ab"
//Output: false

import java.util.HashMap;

public class RansomNote383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> dict = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            if (dict.containsKey(ch)) {
                dict.put(ch, dict.get(ch) + 1);
            } else {
                dict.put(ch, 1);
            }
        }
        for (char ch : ransomNote.toCharArray()) {
            if (dict.containsKey(ch)) {
                dict.put(ch, dict.get(ch) - 1);
                if (dict.get(ch) == 0) {
                    dict.remove(ch);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}

package academy.algorithms.problems;

import java.util.HashMap;
import java.util.Map;

//Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just 1 character at 1 index in the string, and the remaining characters will occur the same number of times. Given a string str, determine if it is valid. If so, return "YES", otherwise return "NO".
//
//        For example, If str = "abc", the string is valid because the frequencies of characters are all the same. If str = "abcc", the string is also valid, because we can remove 1 "c" and have one of each character remaining in the string. However, if str = "abccc", the string is not valid, because removing one character does not result in the same frequency of characters.
//
//        Examples
//        isValid("aabbcd") ➞ "NO"
//// We would need to remove two characters, both c and d  -> aabb or a and b -> abcd, to make it valid.
//// We are limited to removing only one character, so it is invalid.
//
//        isValid("aabbccddeefghi") ➞ "NO"
//// Frequency counts for the letters are as follows:
//// {"a": 2, "b": 2, "c": 2, "d": 2, "e": 2, "f": 1, "g": 1, "h": 1, "i": 1}
//// There are two ways to make the valid string:
//// Remove 4 characters with a frequency of 1: {f, g, h, i}.
//// Remove 5 characters of frequency 2: {a, b, c, d, e}.
//// Neither of these is an option.
//
//        isValid("abcdefghhgfedecba") ➞ "YES"
// All characters occur twice except for e which occurs 3 times.
// We can delete one instance of e to have a valid string.
public class SherlockAndTheValidString {
    public static void main(String[] args) {
        String input = "abcdefghhgfedecba";
        if (isValidString(input)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        System.out.println(isValidString(input));
    }

    private static boolean isValidString(String input) {
        Map<Character, Integer> counterOfChars = new HashMap<>();
        for (char ch : input.toCharArray()) {
            if (counterOfChars.containsKey(ch)) {
                counterOfChars.put(ch, counterOfChars.get(ch) + 1);
            } else {
                counterOfChars.put(ch, 1);
            }
        }
        int countOfDiffChars = 0;
        int countOfChars = counterOfChars.get(input.charAt(0));
        for (Map.Entry<Character, Integer> entry : counterOfChars.entrySet()) {
            if (entry.getValue() != countOfChars) {
                countOfDiffChars += Math.abs(countOfChars - entry.getValue());
                if (countOfDiffChars > 1) {
                    return false;
                }
            }
        }
        return true;


    }
}

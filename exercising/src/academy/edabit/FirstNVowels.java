package academy.edabit;

//Write a function that returns the first n vowels of a string.
//
//        Examples
//        firstNVowels("sharpening skills", 3) ➞ "aei"
//
//        firstNVowels("major league", 5) ➞ "aoeau"
//
//        firstNVowels("hostess", 5) ➞ "invalid"

public class FirstNVowels {
    public static String firstNVowels(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                sb.append(ch);
            }
            if (sb.length() == n) {
                return sb.toString();
            }
        }
        return "invalid";
    }
}

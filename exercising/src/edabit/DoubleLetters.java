package edabit;
//
//Create a function that takes a word and returns true if the word has two consecutive identical letters.
//
//        Examples
//        doubleLetters("loop") ➞ true
//
//        doubleLetters("yummy") ➞ true
//
//        doubleLetters("orange") ➞ false
//
//        doubleLetters("munchkin") ➞ false

public class DoubleLetters {
    public static boolean doubleLetters(String word) {
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            if (i < word.length() - 1 && temp == word.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}

package edabit;

//Write a function that changes every letter to the next letter:
//
//        "a" becomes "b"
//        "b" becomes "c"
//        "d" becomes "e"
//        and so on ...
public class ChangeEveryLetterToNextLetter {
    public static String move(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            int charInt = currChar;
            charInt++;
            char newChar = (char) charInt;
            sb.append(newChar);
        }
        return sb.toString();
    }
}

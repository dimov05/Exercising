package academy.edabit;

//Given a string, reverse all the words which have odd length. The even length words are not changed.
//
//        Examples
//        reverseOdd("Bananas") ➞ "sananaB"
//
//        reverseOdd("One two three four") ➞ "enO owt eerht four"
//
//        reverseOdd("Make sure uoy only esrever sdrow of ddo length")
//        ➞ "Make sure you only reverse words of odd length"
public class ReverseTheOddLengthWords {
    public static String reverseOdd(String str) {
        String[] words = str.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() % 2 == 1) {
                StringBuilder sb = new StringBuilder(words[i]);
                words[i] = sb.reverse().toString();
            }
        }
        return String.join(" ", words);
    }
}

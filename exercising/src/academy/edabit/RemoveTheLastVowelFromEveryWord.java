package academy.edabit;

//Write a function that removes the last vowel in each word in a sentence.
//
//        Examples
//        removeLastVowel("Those who dare to fail miserably can achieve greatly.")
//        ➞ "Thos wh dar t fal miserbly cn achiev gretly."
//
//        removeLastVowel("Love is a serious mental disease.")
//        ➞ "Lov s  serios mentl diseas"
//
//        removeLastVowel("Get busy living or get busy dying.")
//        ➞ "Gt bsy livng r gt bsy dyng"
//        Notes
//        Vowels are: a, e, i, o, u (both upper and lowercase).

public class RemoveTheLastVowelFromEveryWord {
    public static String removeLastVowel(String str) {
        String[] words = str.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            int indexToRemove = -1;
            String word = words[i];
            for (int j = word.length() - 1; j >= 0; j--) {
                char ch = word.toLowerCase().charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'o' || ch == 'u' || ch == 'i') {
                    indexToRemove = j;
                    break;
                }
            }
            String toReplace = words[i];
            if (indexToRemove != -1) {
                if (indexToRemove < word.length() - 1) {
                    toReplace = word.substring(0, indexToRemove)
                            + word.substring(indexToRemove + 1, word.length());
                } else {
                    toReplace = word.substring(0, indexToRemove);
                }
            }
            words[i] = toReplace;
        }
        return String.join(" ", words);
    }
}

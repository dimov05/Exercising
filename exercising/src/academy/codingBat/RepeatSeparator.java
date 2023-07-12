package academy.codingBat;

//Given two strings, word and a separator sep, return a big string made of count occurrences of the word, separated by the separator string.
//
//
//        repeatSeparator("Word", "X", 3) → "WordXWordXWord"
//        repeatSeparator("This", "And", 2) → "ThisAndThis"
//        repeatSeparator("This", "And", 1) → "This"

public class RepeatSeparator {
    public String repeatSeparator(String word, String sep, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i == count - 1) {
                sb.append(word);
            } else {
                sb.append(word)
                        .append(sep);
            }
        }
        return sb.toString();
    }

}

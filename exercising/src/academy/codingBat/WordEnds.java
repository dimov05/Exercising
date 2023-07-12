package academy.codingBat;

public class WordEnds {
    public String wordEnds(String str, String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length() - word.length() + 1; i++) {
            String tempWord = str.substring(i, i + word.length());
            if (i > 0 && tempWord.equals(word)) {
                sb.append(str.charAt(i - 1));
            }
            if (i < str.length() - word.length() && tempWord.equals(word)) {
                sb.append(str, i + word.length(), i + word.length() + 1);
            }
        }
        return sb.toString();
    }

}

package academy.codingBat;

//Given a string and a non-empty word string, return a version of the original String where all chars have been replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged.
//
//
//        plusOut("12xy34", "xy") → "++xy++"
//        plusOut("12xy34", "1") → "1+++++"
//        plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"
public class PlusOut {
    public String plusOut(String str, String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i).startsWith(word)) {
                i += word.length() - 1;
                sb.append(word);
            } else {
                sb.append("+");
            }
        }
        return sb.toString();
    }

}

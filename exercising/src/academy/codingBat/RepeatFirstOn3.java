package academy.codingBat;

//Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields "bca". Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group of fewer than 3 chars at the end.
//
//
//        oneTwo("abc") → "bca"
//        oneTwo("tca") → "cat"
//        oneTwo("tcagdo") → "catdog"

public class RepeatFirstOn3 {
    public String oneTwo(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length() - 2) {
            sb.append(str.charAt(i + 1))
                    .append(str.charAt(i + 2))
                    .append(str.charAt(i));
            i += 3;
        }
        return sb.toString();
    }


}

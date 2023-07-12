package academy.codingBat;

//Return a version of the given string, where for every star (*) in the string the star and the chars immediately to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
//
//
//        starOut("ab*cd") → "ad"
//        starOut("ab**cd") → "ad"
//        starOut("sm*eilly") → "silly"

public class StarOut {
    public String starOut(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) != '*') {
                sb.append(str.charAt(i));
            } else if (i > 0 && str.charAt(i) != '*' && str.charAt(i - 1) != '*') {
                sb.append(str.charAt(i));
            } else if (i > 0 && str.charAt(i) == '*' && str.charAt(i - 1) != '*') {
                sb = new StringBuilder(sb.substring(0, sb.length() - 1));
            }
        }
        return sb.toString();
    }

}

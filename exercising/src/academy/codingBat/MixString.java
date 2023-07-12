package academy.codingBat;

//Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second char of a, the second char of b, and so on. Any leftover chars go at the end of the result.
//
//
//        mixString("abc", "xyz") → "axbycz"
//        mixString("Hi", "There") → "HTihere"
//        mixString("xxxx", "There") → "xTxhxexre"

public class MixString {
    public String mixString(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            sb.append(a.charAt(i))
                    .append(b.charAt(i));
        }
        if (a.length() > b.length()) {
            sb.append(a.substring(b.length()));
        } else {
            sb.append(b.substring(a.length()));
        }
        return sb.toString();

    }

}

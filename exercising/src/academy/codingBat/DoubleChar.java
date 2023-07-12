package academy.codingBat;

//Given a string, return a string where for every char in the original, there are two chars.
//
//
//        doubleChar("The") → "TThhee"
//        doubleChar("AAbb") → "AAAAbbbb"
//        doubleChar("Hi-There") → "HHii--TThheerree"

public class DoubleChar {
    public String doubleChar(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i)).append(str.charAt(i));
        }
        return sb.toString();
    }

}

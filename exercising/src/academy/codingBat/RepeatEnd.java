package academy.codingBat;

//Given a string and an int n, return a string made of n repetitions of the last n characters of the string. You may assume that n is between 0 and the length of the string, inclusive.
//
//
//        repeatEnd("Hello", 3) → "llollollo"
//        repeatEnd("Hello", 2) → "lolo"
//        repeatEnd("Hello", 1) → "o"

public class RepeatEnd {
    public String repeatEnd(String str, int n) {
        StringBuilder sb = new StringBuilder();
        String end = str.substring(str.length() - n, str.length());
        sb.append(end.repeat(Math.max(0, n)));
        return sb.toString();
    }

}

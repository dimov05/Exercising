package academy.edabit;

//Create a function that takes a string and returns a new string with its first and last characters swapped, except under two conditions:
//
//        If the length of the string is less than two, return "Incompatible.".
//        If the first and last characters are the same, return "Two's a pair.".

public class Switcharoo {
    public static String flipEndChars(String s) {
        StringBuilder sb = new StringBuilder();
        if(s.length() < 2){
            return "Incompatible.";
        } else {
            char first = s.charAt(0);
            char last = s.charAt(s.length()-1);
            if(first == last){
                return "Two's a pair.";
            } else {
                sb.append(last)
                        .append(s.substring(1,s.length()-1))
                        .append(first);
            }
        }
        return sb.toString();
    }
}
